/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SmViewRow(
  id: Option[Int],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: Option[ShipmethodId],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.name]] */
  name: Option[Name],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipbase]] */
  shipbase: Option[BigDecimal],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shiprate]] */
  shiprate: Option[BigDecimal],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SmViewRow {
  implicit val decoder: Decoder[SmViewRow] = Decoder.forProduct7[SmViewRow, Option[Int], Option[ShipmethodId], Option[Name], Option[BigDecimal], Option[BigDecimal], Option[UUID], Option[TypoLocalDateTime]]("id", "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")(SmViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ShipmethodId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[SmViewRow] = Encoder.forProduct7[SmViewRow, Option[Int], Option[ShipmethodId], Option[Name], Option[BigDecimal], Option[BigDecimal], Option[UUID], Option[TypoLocalDateTime]]("id", "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")(x => (x.id, x.shipmethodid, x.name, x.shipbase, x.shiprate, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ShipmethodId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[SmViewRow] = new Read[SmViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ShipmethodId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SmViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      shipmethodid = ShipmethodId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      shipbase = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 3),
      shiprate = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
