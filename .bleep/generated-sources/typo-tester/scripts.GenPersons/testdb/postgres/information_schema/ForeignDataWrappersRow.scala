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

case class ForeignDataWrappersRow(
  foreignDataWrapperCatalog: Option[String],
  foreignDataWrapperName: Option[String],
  authorizationIdentifier: Option[String],
  libraryName: Option[String],
  foreignDataWrapperLanguage: Option[String]
)

object ForeignDataWrappersRow {
  def rowParser(prefix: String): RowParser[ForeignDataWrappersRow] = { row =>
    Success(
      ForeignDataWrappersRow(
        foreignDataWrapperCatalog = row[Option[String]](prefix + "foreign_data_wrapper_catalog"),
        foreignDataWrapperName = row[Option[String]](prefix + "foreign_data_wrapper_name"),
        authorizationIdentifier = row[Option[String]](prefix + "authorization_identifier"),
        libraryName = row[Option[String]](prefix + "library_name"),
        foreignDataWrapperLanguage = row[Option[String]](prefix + "foreign_data_wrapper_language")
      )
    )
  }

  implicit val oFormat: OFormat[ForeignDataWrappersRow] = new OFormat[ForeignDataWrappersRow]{
    override def writes(o: ForeignDataWrappersRow): JsObject =
      Json.obj(
        "foreign_data_wrapper_catalog" -> o.foreignDataWrapperCatalog,
      "foreign_data_wrapper_name" -> o.foreignDataWrapperName,
      "authorization_identifier" -> o.authorizationIdentifier,
      "library_name" -> o.libraryName,
      "foreign_data_wrapper_language" -> o.foreignDataWrapperLanguage
      )

    override def reads(json: JsValue): JsResult[ForeignDataWrappersRow] = {
      JsResult.fromTry(
        Try(
          ForeignDataWrappersRow(
            foreignDataWrapperCatalog = json.\("foreign_data_wrapper_catalog").toOption.map(_.as[String]),
            foreignDataWrapperName = json.\("foreign_data_wrapper_name").toOption.map(_.as[String]),
            authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as[String]),
            libraryName = json.\("library_name").toOption.map(_.as[String]),
            foreignDataWrapperLanguage = json.\("foreign_data_wrapper_language").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
