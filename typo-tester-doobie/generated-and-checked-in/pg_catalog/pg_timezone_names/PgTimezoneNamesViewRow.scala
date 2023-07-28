/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_names

import adventureworks.TypoInterval
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgTimezoneNamesViewRow(
  name: Option[String],
  abbrev: Option[String],
  utcOffset: Option[TypoInterval],
  isDst: Option[Boolean]
)

object PgTimezoneNamesViewRow {
  implicit val decoder: Decoder[PgTimezoneNamesViewRow] = Decoder.forProduct4[PgTimezoneNamesViewRow, Option[String], Option[String], Option[TypoInterval], Option[Boolean]]("name", "abbrev", "utc_offset", "is_dst")(PgTimezoneNamesViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoInterval.decoder), Decoder.decodeOption(Decoder.decodeBoolean))
  implicit val encoder: Encoder[PgTimezoneNamesViewRow] = Encoder.forProduct4[PgTimezoneNamesViewRow, Option[String], Option[String], Option[TypoInterval], Option[Boolean]]("name", "abbrev", "utc_offset", "is_dst")(x => (x.name, x.abbrev, x.utcOffset, x.isDst))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoInterval.encoder), Encoder.encodeOption(Encoder.encodeBoolean))
  implicit val read: Read[PgTimezoneNamesViewRow] = new Read[PgTimezoneNamesViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoInterval.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgTimezoneNamesViewRow(
      name = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      abbrev = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      utcOffset = TypoInterval.get.unsafeGetNullable(rs, i + 2),
      isDst = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
