/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class LViewRow(
  id: Option[Int],
  /** Points to [[production.location.LocationRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.location.LocationRow.name]] */
  name: Option[Name],
  /** Points to [[production.location.LocationRow.costrate]] */
  costrate: Option[BigDecimal],
  /** Points to [[production.location.LocationRow.availability]] */
  availability: Option[BigDecimal],
  /** Points to [[production.location.LocationRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object LViewRow {
  implicit val decoder: Decoder[LViewRow] = Decoder.forProduct6[LViewRow, Option[Int], Option[LocationId], Option[Name], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "locationid", "name", "costrate", "availability", "modifieddate")(LViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(LocationId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[LViewRow] = Encoder.forProduct6[LViewRow, Option[Int], Option[LocationId], Option[Name], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "locationid", "name", "costrate", "availability", "modifieddate")(x => (x.id, x.locationid, x.name, x.costrate, x.availability, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(LocationId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[LViewRow] = new Read[LViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (LocationId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => LViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      locationid = LocationId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      costrate = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 3),
      availability = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
