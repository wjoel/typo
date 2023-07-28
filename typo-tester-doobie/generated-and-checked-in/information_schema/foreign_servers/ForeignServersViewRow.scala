/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_servers

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ForeignServersViewRow(
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerType]] */
  foreignServerType: Option[CharacterData],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerVersion]] */
  foreignServerVersion: Option[CharacterData],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[SqlIdentifier]
)

object ForeignServersViewRow {
  implicit val decoder: Decoder[ForeignServersViewRow] = Decoder.forProduct7[ForeignServersViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[CharacterData], Option[SqlIdentifier]]("foreign_server_catalog", "foreign_server_name", "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "foreign_server_type", "foreign_server_version", "authorization_identifier")(ForeignServersViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[ForeignServersViewRow] = Encoder.forProduct7[ForeignServersViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[CharacterData], Option[SqlIdentifier]]("foreign_server_catalog", "foreign_server_name", "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "foreign_server_type", "foreign_server_version", "authorization_identifier")(x => (x.foreignServerCatalog, x.foreignServerName, x.foreignDataWrapperCatalog, x.foreignDataWrapperName, x.foreignServerType, x.foreignServerVersion, x.authorizationIdentifier))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[ForeignServersViewRow] = new Read[ForeignServersViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ForeignServersViewRow(
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      foreignServerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      foreignDataWrapperCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      foreignDataWrapperName = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      foreignServerType = CharacterData.get.unsafeGetNullable(rs, i + 4),
      foreignServerVersion = CharacterData.get.unsafeGetNullable(rs, i + 5),
      authorizationIdentifier = SqlIdentifier.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
