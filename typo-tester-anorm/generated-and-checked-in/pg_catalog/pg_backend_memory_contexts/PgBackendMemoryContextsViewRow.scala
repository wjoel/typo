/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgBackendMemoryContextsViewRow(
  name: Option[String],
  ident: Option[String],
  parent: Option[String],
  level: Option[Int],
  totalBytes: Option[Long],
  totalNblocks: Option[Long],
  freeBytes: Option[Long],
  freeChunks: Option[Long],
  usedBytes: Option[Long]
)

object PgBackendMemoryContextsViewRow {
  implicit lazy val reads: Reads[PgBackendMemoryContextsViewRow] = Reads[PgBackendMemoryContextsViewRow](json => JsResult.fromTry(
      Try(
        PgBackendMemoryContextsViewRow(
          name = json.\("name").toOption.map(_.as(Reads.StringReads)),
          ident = json.\("ident").toOption.map(_.as(Reads.StringReads)),
          parent = json.\("parent").toOption.map(_.as(Reads.StringReads)),
          level = json.\("level").toOption.map(_.as(Reads.IntReads)),
          totalBytes = json.\("total_bytes").toOption.map(_.as(Reads.LongReads)),
          totalNblocks = json.\("total_nblocks").toOption.map(_.as(Reads.LongReads)),
          freeBytes = json.\("free_bytes").toOption.map(_.as(Reads.LongReads)),
          freeChunks = json.\("free_chunks").toOption.map(_.as(Reads.LongReads)),
          usedBytes = json.\("used_bytes").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgBackendMemoryContextsViewRow] = RowParser[PgBackendMemoryContextsViewRow] { row =>
    Success(
      PgBackendMemoryContextsViewRow(
        name = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        ident = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        parent = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        level = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        totalBytes = row(idx + 4)(Column.columnToOption(Column.columnToLong)),
        totalNblocks = row(idx + 5)(Column.columnToOption(Column.columnToLong)),
        freeBytes = row(idx + 6)(Column.columnToOption(Column.columnToLong)),
        freeChunks = row(idx + 7)(Column.columnToOption(Column.columnToLong)),
        usedBytes = row(idx + 8)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit lazy val writes: OWrites[PgBackendMemoryContextsViewRow] = OWrites[PgBackendMemoryContextsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.name),
      "ident" -> Writes.OptionWrites(Writes.StringWrites).writes(o.ident),
      "parent" -> Writes.OptionWrites(Writes.StringWrites).writes(o.parent),
      "level" -> Writes.OptionWrites(Writes.IntWrites).writes(o.level),
      "total_bytes" -> Writes.OptionWrites(Writes.LongWrites).writes(o.totalBytes),
      "total_nblocks" -> Writes.OptionWrites(Writes.LongWrites).writes(o.totalNblocks),
      "free_bytes" -> Writes.OptionWrites(Writes.LongWrites).writes(o.freeBytes),
      "free_chunks" -> Writes.OptionWrites(Writes.LongWrites).writes(o.freeChunks),
      "used_bytes" -> Writes.OptionWrites(Writes.LongWrites).writes(o.usedBytes)
    ))
  )
}
