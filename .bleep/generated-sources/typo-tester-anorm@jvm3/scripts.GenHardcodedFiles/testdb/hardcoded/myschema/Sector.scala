/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema

import anorm.Column
import anorm.ParameterMetaData
import anorm.SqlMappingError
import anorm.ToStatement
import play.api.libs.json.JsError
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsValue
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Enum `myschema.sector`
  *  - PUBLIC
  *  - PRIVATE
  *  - OTHER
  */
sealed abstract class Sector(val value: String)

object Sector {
  case object `_public` extends Sector("PUBLIC")
  case object `_private` extends Sector("PRIVATE")
  case object `_other` extends Sector("OTHER")
  val All: List[Sector] = List(`_public`, `_private`, `_other`)
  val Names: String = All.map(_.value).mkString(", ")
  val ByName: Map[String, Sector] = All.map(x => (x.value, x)).toMap
              
  implicit lazy val arrayColumn: Column[Array[Sector]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[Sector]] = implicitly[ToStatement[Array[String]]].contramap(_.map(_.value))
  implicit lazy val column: Column[Sector] = implicitly[Column[String]].mapResult { str => ByName.get(str).toRight(SqlMappingError(s"$str was not among ${ByName.keys}")) }
  implicit lazy val parameterMetadata: ParameterMetaData[Sector] = new ParameterMetaData[Sector] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }
  implicit lazy val reads: Reads[Sector] = Reads[Sector]((value: JsValue) =>
    value.validate(Reads.StringReads).flatMap { str =>
      ByName.get(str) match {
        case Some(value) => JsSuccess(value)
        case None => JsError(s"'$str' does not match any of the following legal values: $Names")
      }
    }
  )
  implicit lazy val toStatement: ToStatement[Sector] = implicitly[ToStatement[String]].contramap(_.value)
  implicit lazy val writes: Writes[Sector] = Writes[Sector](value => Writes.StringWrites.writes(value.value))
}
