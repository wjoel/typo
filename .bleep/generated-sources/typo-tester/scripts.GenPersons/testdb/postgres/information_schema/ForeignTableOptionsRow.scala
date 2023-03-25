/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ForeignTableOptionsRow(
  foreignTableCatalog: Option[String],
  foreignTableSchema: Option[String],
  foreignTableName: Option[String],
  optionName: Option[String],
  optionValue: Option[String]
)

object ForeignTableOptionsRow {
  def rowParser(prefix: String): RowParser[ForeignTableOptionsRow] = { row =>
    Success(
      ForeignTableOptionsRow(
        foreignTableCatalog = row[Option[String]](prefix + "foreign_table_catalog"),
        foreignTableSchema = row[Option[String]](prefix + "foreign_table_schema"),
        foreignTableName = row[Option[String]](prefix + "foreign_table_name"),
        optionName = row[Option[String]](prefix + "option_name"),
        optionValue = row[Option[String]](prefix + "option_value")
      )
    )
  }

  implicit val oFormat: OFormat[ForeignTableOptionsRow] = new OFormat[ForeignTableOptionsRow]{
    override def writes(o: ForeignTableOptionsRow): JsObject =
      Json.obj(
        "foreign_table_catalog" -> o.foreignTableCatalog,
      "foreign_table_schema" -> o.foreignTableSchema,
      "foreign_table_name" -> o.foreignTableName,
      "option_name" -> o.optionName,
      "option_value" -> o.optionValue
      )

    override def reads(json: JsValue): JsResult[ForeignTableOptionsRow] = {
      JsResult.fromTry(
        Try(
          ForeignTableOptionsRow(
            foreignTableCatalog = json.\("foreign_table_catalog").toOption.map(_.as[String]),
            foreignTableSchema = json.\("foreign_table_schema").toOption.map(_.as[String]),
            foreignTableName = json.\("foreign_table_name").toOption.map(_.as[String]),
            optionName = json.\("option_name").toOption.map(_.as[String]),
            optionValue = json.\("option_value").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
