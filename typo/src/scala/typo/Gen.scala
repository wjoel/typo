package typo

import typo.sc.syntax.*

import java.nio.file.{Files, Path}

object Gen {

  def stringEnumClass(pkg: sc.QIdent, `enum`: db.Type.StringEnum, dbLib: DbLib, jsonLib: JsonLib): sc.File = {
    val qident = names.EnumName(pkg, `enum`.name)
    val EnumType = sc.Type.Qualified(qident)

    val members = `enum`.values.map { value =>
      val name = names.enumValue(value)
      name -> code"case object $name extends ${qident.last}(${sc.StrLit(value)})"
    }
    val ByName = sc.Ident("ByName")
    val str =
      code"""sealed abstract class ${qident.last}(val value: ${sc.Type.String})
            |object ${qident.last} {
            |  ${members.map { case (_, definition) => definition }.mkCode("\n  ")}
            |
            |  val All: ${sc.Type.List(EnumType)} = ${sc.Type.ListName}(${members.map { case (ident, _) => ident.code }.mkCode(", ")})
            |  val Names: ${sc.Type.String} = All.map(_.value).mkString(", ")
            |  val ByName: ${sc.Type.Map(sc.Type.String, EnumType)} = All.map(x => (x.value, x)).toMap
            |
            |  ${dbLib.stringEnumInstances(EnumType, sc.Type.String, lookup = ByName).mkCode("\n  ")}
            |  ${jsonLib.stringEnumInstances(EnumType, sc.Type.String, lookup = ByName).mkCode("\n  ")}
            |}
            |""".stripMargin

    sc.File(EnumType, str)
  }

  def genDefaultFile(jsonLib: JsonLib, pkg: sc.QIdent): sc.File = {
    val Defaulted = pkg / sc.Ident("Defaulted")
    val Provided = Defaulted / sc.Ident("Provided")
    val UseDefault = Defaulted / sc.Ident("UseDefault")
    val contents =
      code"""
/**
 * This signals a value where if you don't provide it, postgres will generate it for you
 */
sealed trait ${Defaulted.last}[+T]

object ${Defaulted.last} {
  case class ${Provided.last}[T](value: T) extends $Defaulted[T]
  case object ${UseDefault.last} extends $Defaulted[Nothing]
  ${jsonLib.defaultedInstance(Defaulted, Provided, UseDefault).mkCode("\n  ")}
}
"""
    sc.File(sc.Type.Qualified(Defaulted), contents)
  }


  def allTables(pkg: sc.QIdent, tables: List[db.Table], jsonLib: JsonLib, dbLib: DbLib): List[sc.File] = {
    val enums: List[db.Type.StringEnum] =
      tables.flatMap(_.cols.map(_.tpe)).collect { case x: db.Type.StringEnum => x }.distinct

    val defaultFile = genDefaultFile(jsonLib, pkg)
    val enumFiles: List[sc.File] =
      enums.map(stringEnumClass(pkg, _, dbLib, jsonLib))
    val tableFiles: List[sc.File] =
      tables.flatMap(table => TableFiles(TableComputed(pkg, defaultFile, table), dbLib, jsonLib).all)
    val allFiles: List[sc.File] =
      List(defaultFile) ++ enumFiles ++ tableFiles

    val knownNames = allFiles.map { f => (f.name, f.tpe.value) }.toMap

    allFiles.map(file => addPackageAndImports(pkg, knownNames, file))
  }
}
