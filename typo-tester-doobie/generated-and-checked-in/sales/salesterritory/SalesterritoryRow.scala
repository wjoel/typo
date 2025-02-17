/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SalesterritoryRow(
  /** Primary key for SalesTerritory records. */
  territoryid: SalesterritoryId,
  /** Sales territory description */
  name: Name,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Geographic area to which the sales territory belong. */
  group: /* max 50 chars */ String,
  /** Sales in the territory year to date. */
  salesytd: BigDecimal,
  /** Sales in the territory the previous year. */
  saleslastyear: BigDecimal,
  /** Business costs in the territory year to date. */
  costytd: BigDecimal,
  /** Business costs in the territory the previous year. */
  costlastyear: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object SalesterritoryRow {
  implicit val decoder: Decoder[SalesterritoryRow] = Decoder.forProduct10[SalesterritoryRow, SalesterritoryId, Name, CountryregionId, /* max 50 chars */ String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(SalesterritoryRow.apply)(SalesterritoryId.decoder, Name.decoder, CountryregionId.decoder, Decoder.decodeString, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit val encoder: Encoder[SalesterritoryRow] = Encoder.forProduct10[SalesterritoryRow, SalesterritoryId, Name, CountryregionId, /* max 50 chars */ String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(x => (x.territoryid, x.name, x.countryregioncode, x.group, x.salesytd, x.saleslastyear, x.costytd, x.costlastyear, x.rowguid, x.modifieddate))(SalesterritoryId.encoder, Name.encoder, CountryregionId.encoder, Encoder.encodeString, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit val read: Read[SalesterritoryRow] = new Read[SalesterritoryRow](
    gets = List(
      (SalesterritoryId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (CountryregionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesterritoryRow(
      territoryid = SalesterritoryId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      countryregioncode = CountryregionId.get.unsafeGetNonNullable(rs, i + 2),
      group = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      salesytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      saleslastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      costytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      costlastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
