/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_udt_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ColumnUdtUsageViewRow(
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier]
)

object ColumnUdtUsageViewRow {
  implicit val decoder: Decoder[ColumnUdtUsageViewRow] = Decoder.forProduct7[ColumnUdtUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("udt_catalog", "udt_schema", "udt_name", "table_catalog", "table_schema", "table_name", "column_name")(ColumnUdtUsageViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[ColumnUdtUsageViewRow] = Encoder.forProduct7[ColumnUdtUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("udt_catalog", "udt_schema", "udt_name", "table_catalog", "table_schema", "table_name", "column_name")(x => (x.udtCatalog, x.udtSchema, x.udtName, x.tableCatalog, x.tableSchema, x.tableName, x.columnName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[ColumnUdtUsageViewRow] = new Read[ColumnUdtUsageViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ColumnUdtUsageViewRow(
      udtCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      udtSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      udtName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      tableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      tableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      tableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      columnName = SqlIdentifier.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
