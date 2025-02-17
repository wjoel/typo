/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_routine_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class RoutineRoutineUsageViewRow(
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier],
  routineCatalog: Option[SqlIdentifier],
  routineSchema: Option[SqlIdentifier],
  routineName: Option[SqlIdentifier]
)

object RoutineRoutineUsageViewRow {
  implicit val decoder: Decoder[RoutineRoutineUsageViewRow] = Decoder.forProduct6[RoutineRoutineUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name")(RoutineRoutineUsageViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[RoutineRoutineUsageViewRow] = Encoder.forProduct6[RoutineRoutineUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name")(x => (x.specificCatalog, x.specificSchema, x.specificName, x.routineCatalog, x.routineSchema, x.routineName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[RoutineRoutineUsageViewRow] = new Read[RoutineRoutineUsageViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => RoutineRoutineUsageViewRow(
      specificCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      specificSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      specificName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      routineCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      routineSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      routineName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
