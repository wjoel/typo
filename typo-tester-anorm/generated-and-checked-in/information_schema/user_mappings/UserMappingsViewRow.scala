/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_mappings

import adventureworks.information_schema.SqlIdentifier
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

case class UserMappingsViewRow(
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[SqlIdentifier],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier]
)

object UserMappingsViewRow {
  implicit val reads: Reads[UserMappingsViewRow] = Reads[UserMappingsViewRow](json => JsResult.fromTry(
      Try(
        UserMappingsViewRow(
          authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as(SqlIdentifier.reads)),
          foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          foreignServerName = json.\("foreign_server_name").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[UserMappingsViewRow] = RowParser[UserMappingsViewRow] { row =>
    Success(
      UserMappingsViewRow(
        authorizationIdentifier = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        foreignServerCatalog = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        foreignServerName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit val writes: OWrites[UserMappingsViewRow] = OWrites[UserMappingsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "authorization_identifier" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.authorizationIdentifier),
      "foreign_server_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignServerCatalog),
      "foreign_server_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignServerName)
    ))
  )
}
