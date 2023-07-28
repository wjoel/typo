/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_domain_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ColumnDomainUsageViewRow(
  domainCatalog: Option[SqlIdentifier],
  domainSchema: Option[SqlIdentifier],
  domainName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier]
)

object ColumnDomainUsageViewRow {
  implicit val decoder: Decoder[ColumnDomainUsageViewRow] = Decoder.forProduct7[ColumnDomainUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("domain_catalog", "domain_schema", "domain_name", "table_catalog", "table_schema", "table_name", "column_name")(ColumnDomainUsageViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[ColumnDomainUsageViewRow] = Encoder.forProduct7[ColumnDomainUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("domain_catalog", "domain_schema", "domain_name", "table_catalog", "table_schema", "table_name", "column_name")(x => (x.domainCatalog, x.domainSchema, x.domainName, x.tableCatalog, x.tableSchema, x.tableName, x.columnName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[ColumnDomainUsageViewRow] = new Read[ColumnDomainUsageViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ColumnDomainUsageViewRow(
      domainCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      domainSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      domainName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      tableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      tableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      tableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      columnName = SqlIdentifier.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
