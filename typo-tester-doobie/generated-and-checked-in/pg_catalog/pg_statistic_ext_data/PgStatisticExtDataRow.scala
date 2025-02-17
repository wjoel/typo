/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext_data

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatisticExtDataRow(
  stxoid: PgStatisticExtDataId,
  stxdndistinct: Option[String],
  stxddependencies: Option[String],
  stxdmcv: Option[String],
  stxdexpr: Option[String]
)

object PgStatisticExtDataRow {
  implicit val decoder: Decoder[PgStatisticExtDataRow] = Decoder.forProduct5[PgStatisticExtDataRow, PgStatisticExtDataId, Option[String], Option[String], Option[String], Option[String]]("stxoid", "stxdndistinct", "stxddependencies", "stxdmcv", "stxdexpr")(PgStatisticExtDataRow.apply)(PgStatisticExtDataId.decoder, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit val encoder: Encoder[PgStatisticExtDataRow] = Encoder.forProduct5[PgStatisticExtDataRow, PgStatisticExtDataId, Option[String], Option[String], Option[String], Option[String]]("stxoid", "stxdndistinct", "stxddependencies", "stxdmcv", "stxdexpr")(x => (x.stxoid, x.stxdndistinct, x.stxddependencies, x.stxdmcv, x.stxdexpr))(PgStatisticExtDataId.encoder, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit val read: Read[PgStatisticExtDataRow] = new Read[PgStatisticExtDataRow](
    gets = List(
      (PgStatisticExtDataId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatisticExtDataRow(
      stxoid = PgStatisticExtDataId.get.unsafeGetNonNullable(rs, i + 0),
      stxdndistinct = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      stxddependencies = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      stxdmcv = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      stxdexpr = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
