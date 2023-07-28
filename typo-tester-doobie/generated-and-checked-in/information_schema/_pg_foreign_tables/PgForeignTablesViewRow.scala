/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_tables`

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgForeignTablesViewRow(
  foreignTableCatalog: Option[SqlIdentifier],
  foreignTableSchema: Option[SqlIdentifier],
  foreignTableName: Option[SqlIdentifier],
  ftoptions: Option[Array[String]],
  foreignServerCatalog: Option[SqlIdentifier],
  foreignServerName: Option[SqlIdentifier],
  authorizationIdentifier: Option[SqlIdentifier]
)

object PgForeignTablesViewRow {
  implicit val decoder: Decoder[PgForeignTablesViewRow] = Decoder.forProduct7[PgForeignTablesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[Array[String]], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "ftoptions", "foreign_server_catalog", "foreign_server_name", "authorization_identifier")(PgForeignTablesViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[PgForeignTablesViewRow] = Encoder.forProduct7[PgForeignTablesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[Array[String]], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "ftoptions", "foreign_server_catalog", "foreign_server_name", "authorization_identifier")(x => (x.foreignTableCatalog, x.foreignTableSchema, x.foreignTableName, x.ftoptions, x.foreignServerCatalog, x.foreignServerName, x.authorizationIdentifier))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[PgForeignTablesViewRow] = new Read[PgForeignTablesViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgForeignTablesViewRow(
      foreignTableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      foreignTableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      foreignTableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      ftoptions = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 3),
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      foreignServerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      authorizationIdentifier = SqlIdentifier.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
