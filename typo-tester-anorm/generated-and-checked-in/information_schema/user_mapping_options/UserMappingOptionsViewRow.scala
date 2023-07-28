/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_mapping_options

import adventureworks.information_schema.CharacterData
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

case class UserMappingOptionsViewRow(
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[SqlIdentifier],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier],
  optionName: Option[SqlIdentifier],
  optionValue: Option[CharacterData]
)

object UserMappingOptionsViewRow {
  implicit val reads: Reads[UserMappingOptionsViewRow] = Reads[UserMappingOptionsViewRow](json => JsResult.fromTry(
      Try(
        UserMappingOptionsViewRow(
          authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as(SqlIdentifier.reads)),
          foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          foreignServerName = json.\("foreign_server_name").toOption.map(_.as(SqlIdentifier.reads)),
          optionName = json.\("option_name").toOption.map(_.as(SqlIdentifier.reads)),
          optionValue = json.\("option_value").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[UserMappingOptionsViewRow] = RowParser[UserMappingOptionsViewRow] { row =>
    Success(
      UserMappingOptionsViewRow(
        authorizationIdentifier = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        foreignServerCatalog = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        foreignServerName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        optionName = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        optionValue = row(idx + 4)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit val writes: OWrites[UserMappingOptionsViewRow] = OWrites[UserMappingOptionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "authorization_identifier" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.authorizationIdentifier),
      "foreign_server_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignServerCatalog),
      "foreign_server_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignServerName),
      "option_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.optionName),
      "option_value" -> Writes.OptionWrites(CharacterData.writes).writes(o.optionValue)
    ))
  )
}
