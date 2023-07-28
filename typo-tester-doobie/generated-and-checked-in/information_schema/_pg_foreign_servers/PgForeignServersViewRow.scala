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
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

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
  implicit val decoder: Decoder[PgForeignServersViewRow] = Decoder.forProduct9[PgForeignServersViewRow, Option[/* oid */ Long], Option[Array[String]], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[CharacterData], Option[SqlIdentifier]]("oid", "srvoptions", "foreign_server_catalog", "foreign_server_name", "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "foreign_server_type", "foreign_server_version", "authorization_identifier")(PgForeignServersViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[PgForeignServersViewRow] = Encoder.forProduct9[PgForeignServersViewRow, Option[/* oid */ Long], Option[Array[String]], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[CharacterData], Option[SqlIdentifier]]("oid", "srvoptions", "foreign_server_catalog", "foreign_server_name", "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "foreign_server_type", "foreign_server_version", "authorization_identifier")(x => (x.oid, x.srvoptions, x.foreignServerCatalog, x.foreignServerName, x.foreignDataWrapperCatalog, x.foreignDataWrapperName, x.foreignServerType, x.foreignServerVersion, x.authorizationIdentifier))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[PgForeignServersViewRow] = new Read[PgForeignServersViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgForeignServersViewRow(
      oid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      srvoptions = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 1),
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      foreignServerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      foreignDataWrapperCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      foreignDataWrapperName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      foreignServerType = CharacterData.get.unsafeGetNullable(rs, i + 6),
      foreignServerVersion = CharacterData.get.unsafeGetNullable(rs, i + 7),
      authorizationIdentifier = SqlIdentifier.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
