/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class StViewRow(
  id: Option[Int],
  /** Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.salesterritory.SalesterritoryRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salesterritory.SalesterritoryRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[sales.salesterritory.SalesterritoryRow.group]] */
  group: Option[/* max 50 chars */ String],
  /** Points to [[sales.salesterritory.SalesterritoryRow.salesytd]] */
  salesytd: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.saleslastyear]] */
  saleslastyear: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.costytd]] */
  costytd: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.costlastyear]] */
  costlastyear: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salesterritory.SalesterritoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object StViewRow {
  implicit val decoder: Decoder[StViewRow] = Decoder.forProduct11[StViewRow, Option[Int], Option[SalesterritoryId], Option[Name], Option[CountryregionId], Option[/* max 50 chars */ String], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[UUID], Option[TypoLocalDateTime]]("id", "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(StViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(SalesterritoryId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(CountryregionId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[StViewRow] = Encoder.forProduct11[StViewRow, Option[Int], Option[SalesterritoryId], Option[Name], Option[CountryregionId], Option[/* max 50 chars */ String], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[UUID], Option[TypoLocalDateTime]]("id", "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(x => (x.id, x.territoryid, x.name, x.countryregioncode, x.group, x.salesytd, x.saleslastyear, x.costytd, x.costlastyear, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(SalesterritoryId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(CountryregionId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[StViewRow] = new Read[StViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (SalesterritoryId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (CountryregionId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => StViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      territoryid = SalesterritoryId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      countryregioncode = CountryregionId.get.unsafeGetNullable(rs, i + 3),
      group = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      salesytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 5),
      saleslastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 6),
      costytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 7),
      costlastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 8),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 9),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 10)
    )
  )
}
