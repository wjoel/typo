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

case class ForeignServerOptionsRow(
  foreignServerCatalog: Option[String],
  foreignServerName: Option[String],
  optionName: Option[String],
  optionValue: Option[String]
)

object ForeignServerOptionsRow {
  def rowParser(prefix: String): RowParser[ForeignServerOptionsRow] = { row =>
    Success(
      ForeignServerOptionsRow(
        foreignServerCatalog = row[Option[String]](prefix + "foreign_server_catalog"),
        foreignServerName = row[Option[String]](prefix + "foreign_server_name"),
        optionName = row[Option[String]](prefix + "option_name"),
        optionValue = row[Option[String]](prefix + "option_value")
      )
    )
  }

  implicit val oFormat: OFormat[ForeignServerOptionsRow] = new OFormat[ForeignServerOptionsRow]{
    override def writes(o: ForeignServerOptionsRow): JsObject =
      Json.obj(
        "foreign_server_catalog" -> o.foreignServerCatalog,
      "foreign_server_name" -> o.foreignServerName,
      "option_name" -> o.optionName,
      "option_value" -> o.optionValue
      )

    override def reads(json: JsValue): JsResult[ForeignServerOptionsRow] = {
      JsResult.fromTry(
        Try(
          ForeignServerOptionsRow(
            foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as[String]),
            foreignServerName = json.\("foreign_server_name").toOption.map(_.as[String]),
            optionName = json.\("option_name").toOption.map(_.as[String]),
            optionValue = json.\("option_value").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
