/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SpViewRow(
  id: Option[Int],
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: Option[StateprovinceId],
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovincecode]] */
  stateprovincecode: Option[/* bpchar */ String],
  /** Points to [[person.stateprovince.StateprovinceRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[person.stateprovince.StateprovinceRow.isonlystateprovinceflag]] */
  isonlystateprovinceflag: Flag,
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  name: Option[Name],
  /** Points to [[person.stateprovince.StateprovinceRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[person.stateprovince.StateprovinceRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.stateprovince.StateprovinceRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SpViewRow {
  implicit val decoder: Decoder[SpViewRow] = Decoder.forProduct9[SpViewRow, Option[Int], Option[StateprovinceId], Option[/* bpchar */ String], Option[CountryregionId], Flag, Option[Name], Option[SalesterritoryId], Option[UUID], Option[TypoLocalDateTime]]("id", "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate")(SpViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(StateprovinceId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(CountryregionId.decoder), Flag.decoder, Decoder.decodeOption(Name.decoder), Decoder.decodeOption(SalesterritoryId.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[SpViewRow] = Encoder.forProduct9[SpViewRow, Option[Int], Option[StateprovinceId], Option[/* bpchar */ String], Option[CountryregionId], Flag, Option[Name], Option[SalesterritoryId], Option[UUID], Option[TypoLocalDateTime]]("id", "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate")(x => (x.id, x.stateprovinceid, x.stateprovincecode, x.countryregioncode, x.isonlystateprovinceflag, x.name, x.territoryid, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(StateprovinceId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(CountryregionId.encoder), Flag.encoder, Encoder.encodeOption(Name.encoder), Encoder.encodeOption(SalesterritoryId.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[SpViewRow] = new Read[SpViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (StateprovinceId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (CountryregionId.get, Nullability.Nullable),
      (Flag.get, Nullability.NoNulls),
      (Name.get, Nullability.Nullable),
      (SalesterritoryId.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SpViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      stateprovinceid = StateprovinceId.get.unsafeGetNullable(rs, i + 1),
      stateprovincecode = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      countryregioncode = CountryregionId.get.unsafeGetNullable(rs, i + 3),
      isonlystateprovinceflag = Flag.get.unsafeGetNonNullable(rs, i + 4),
      name = Name.get.unsafeGetNullable(rs, i + 5),
      territoryid = SalesterritoryId.get.unsafeGetNullable(rs, i + 6),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
