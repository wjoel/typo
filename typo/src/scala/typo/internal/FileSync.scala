package typo
package internal

import typo.RelPath.PathOps

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, StandardOpenOption}
import java.util

object FileSync {
  sealed trait Synced

  object Synced {
    case object New extends Synced
    case object Changed extends Synced
    case object Unchanged extends Synced
    case object Deleted extends Synced
  }

  sealed trait DeleteUnknowns

  object DeleteUnknowns {
    case object No extends DeleteUnknowns
    case class Yes(maxDepth: Option[Int]) extends DeleteUnknowns
  }

  def syncPaths(folder: Path, fileMap: Map[Path, String], deleteUnknowns: DeleteUnknowns, soft: Boolean): Map[Path, Synced] = {
    val fileRelMap = fileMap.map { case (path, content) =>
      require(path.startsWith(folder), s"$path not within $folder")
      RelPath.relativeTo(folder, path) -> content
    }
    syncStrings(folder, fileRelMap, deleteUnknowns, soft)
  }

  /** @param soft
    *   compare to existing content in order to not change timestamps. tooling may care a lot about this
    */
  def syncStrings(folder: Path, fileRelMap: Map[RelPath, String], deleteUnknowns: DeleteUnknowns, soft: Boolean): Map[Path, Synced] =
    syncBytes(folder, fileRelMap.map { case (k, v) => (k, v.getBytes(StandardCharsets.UTF_8)) }, deleteUnknowns, soft)

  val longestFirst: Ordering[Path] = Ordering.by[Path, Int](_.getNameCount).reverse

  /** @param soft
    *   compare to existing content in order to not change timestamps. tooling may care a lot about this
    */
  def syncBytes(folder: Path, fileRelMap: Map[RelPath, Array[Byte]], deleteUnknowns: DeleteUnknowns, soft: Boolean): Map[Path, Synced] = {
    val ret = scala.collection.mutable.Map.empty[Path, Synced]
    val fileMap = fileRelMap.map { case (relPath, content) => (folder / relPath, content) }

    deleteUnknowns match {
      case DeleteUnknowns.Yes(maybeMaxDepth) if folder.toFile.exists() =>
        val stream = maybeMaxDepth match {
          case Some(maxDepth) => Files.walk(folder, maxDepth)
          case None           => Files.walk(folder)
        }

        stream.sorted(longestFirst).forEach {
          case p if Files.isRegularFile(p) && !fileMap.contains(p) =>
            Files.delete(p)
            ret(p) = Synced.Deleted
          case p if Files.isDirectory(p) && !fileMap.keys.exists(_.startsWith(p)) =>
            try Files.delete(p)
            catch {
              case _: java.nio.file.DirectoryNotEmptyException => ()
            }
          case _ => ()
        }

      case _ => ()
    }

    fileMap.foreach { case (file, bytes) =>
      val synced =
        if (soft) softWriteBytes(file, bytes)
        else {
          writeBytes(file, bytes)
          Synced.New
        }
      ret(file) = synced
    }

    ret.toMap
  }

  def softWriteBytes(path: Path, newContent: Array[Byte]): Synced =
    if (path.toFile.exists()) {
      val existingContent = Files.readAllBytes(path)
      if (util.Arrays.equals(existingContent, newContent)) Synced.Unchanged
      else {
        writeBytes(path, newContent)
        Synced.Changed
      }
    } else {
      writeBytes(path, newContent)
      Synced.New
    }

  def writeBytes(path: Path, newContent: Array[Byte]): Unit = {
    Files.createDirectories(path.getParent)
    Files.write(path, newContent, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
    ()
  }

}
