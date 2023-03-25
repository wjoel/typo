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

case class UserMappingsRow(
  authorizationIdentifier: Option[String],
  foreignServerCatalog: Option[String],
  foreignServerName: Option[String]
)

object UserMappingsRow {
  def rowParser(prefix: String): RowParser[UserMappingsRow] = { row =>
    Success(
      UserMappingsRow(
        authorizationIdentifier = row[Option[String]](prefix + "authorization_identifier"),
        foreignServerCatalog = row[Option[String]](prefix + "foreign_server_catalog"),
        foreignServerName = row[Option[String]](prefix + "foreign_server_name")
      )
    )
  }

  implicit val oFormat: OFormat[UserMappingsRow] = new OFormat[UserMappingsRow]{
    override def writes(o: UserMappingsRow): JsObject =
      Json.obj(
        "authorization_identifier" -> o.authorizationIdentifier,
      "foreign_server_catalog" -> o.foreignServerCatalog,
      "foreign_server_name" -> o.foreignServerName
      )

    override def reads(json: JsValue): JsResult[UserMappingsRow] = {
      JsResult.fromTry(
        Try(
          UserMappingsRow(
            authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as[String]),
            foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as[String]),
            foreignServerName = json.\("foreign_server_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
