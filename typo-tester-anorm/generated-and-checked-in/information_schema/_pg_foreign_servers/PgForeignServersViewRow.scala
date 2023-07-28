/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_servers`

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

case class PgForeignServersViewRow(
  oid: Option[/* oid */ Long],
  srvoptions: Option[Array[String]],
  foreignServerCatalog: Option[SqlIdentifier],
  foreignServerName: Option[SqlIdentifier],
  foreignDataWrapperCatalog: Option[SqlIdentifier],
  foreignDataWrapperName: Option[SqlIdentifier],
  foreignServerType: Option[CharacterData],
  foreignServerVersion: Option[CharacterData],
  authorizationIdentifier: Option[SqlIdentifier]
)

object PgForeignServersViewRow {
  implicit val reads: Reads[PgForeignServersViewRow] = Reads[PgForeignServersViewRow](json => JsResult.fromTry(
      Try(
        PgForeignServersViewRow(
          oid = json.\("oid").toOption.map(_.as(Reads.LongReads)),
          srvoptions = json.\("srvoptions").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          foreignServerName = json.\("foreign_server_name").toOption.map(_.as(SqlIdentifier.reads)),
          foreignDataWrapperCatalog = json.\("foreign_data_wrapper_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          foreignDataWrapperName = json.\("foreign_data_wrapper_name").toOption.map(_.as(SqlIdentifier.reads)),
          foreignServerType = json.\("foreign_server_type").toOption.map(_.as(CharacterData.reads)),
          foreignServerVersion = json.\("foreign_server_version").toOption.map(_.as(CharacterData.reads)),
          authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgForeignServersViewRow] = RowParser[PgForeignServersViewRow] { row =>
    Success(
      PgForeignServersViewRow(
        oid = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        srvoptions = row(idx + 1)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        foreignServerCatalog = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        foreignServerName = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        foreignDataWrapperCatalog = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        foreignDataWrapperName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        foreignServerType = row(idx + 6)(Column.columnToOption(CharacterData.column)),
        foreignServerVersion = row(idx + 7)(Column.columnToOption(CharacterData.column)),
        authorizationIdentifier = row(idx + 8)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit val writes: OWrites[PgForeignServersViewRow] = OWrites[PgForeignServersViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.oid),
      "srvoptions" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.srvoptions),
      "foreign_server_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignServerCatalog),
      "foreign_server_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignServerName),
      "foreign_data_wrapper_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignDataWrapperCatalog),
      "foreign_data_wrapper_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignDataWrapperName),
      "foreign_server_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.foreignServerType),
      "foreign_server_version" -> Writes.OptionWrites(CharacterData.writes).writes(o.foreignServerVersion),
      "authorization_identifier" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.authorizationIdentifier)
    ))
  )
}
