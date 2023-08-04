/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_routine_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ViewRoutineUsageViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier]
)

object ViewRoutineUsageViewRow {
  implicit val decoder: Decoder[ViewRoutineUsageViewRow] = Decoder.forProduct6[ViewRoutineUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("table_catalog", "table_schema", "table_name", "specific_catalog", "specific_schema", "specific_name")(ViewRoutineUsageViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[ViewRoutineUsageViewRow] = Encoder.forProduct6[ViewRoutineUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("table_catalog", "table_schema", "table_name", "specific_catalog", "specific_schema", "specific_name")(x => (x.tableCatalog, x.tableSchema, x.tableName, x.specificCatalog, x.specificSchema, x.specificName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[ViewRoutineUsageViewRow] = new Read[ViewRoutineUsageViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ViewRoutineUsageViewRow(
      tableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      tableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      tableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      specificCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      specificSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      specificName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5)
    )
  )
}