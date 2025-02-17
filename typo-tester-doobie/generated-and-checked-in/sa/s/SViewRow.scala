/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package s

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SViewRow(
  id: Option[Int],
  /** Points to [[sales.store.StoreRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.store.StoreRow.name]] */
  name: Option[Name],
  /** Points to [[sales.store.StoreRow.salespersonid]] */
  salespersonid: Option[BusinessentityId],
  /** Points to [[sales.store.StoreRow.demographics]] */
  demographics: Option[TypoXml],
  /** Points to [[sales.store.StoreRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.store.StoreRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SViewRow {
  implicit val decoder: Decoder[SViewRow] = Decoder.forProduct7[SViewRow, Option[Int], Option[BusinessentityId], Option[Name], Option[BusinessentityId], Option[TypoXml], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")(SViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[SViewRow] = Encoder.forProduct7[SViewRow, Option[Int], Option[BusinessentityId], Option[Name], Option[BusinessentityId], Option[TypoXml], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.name, x.salespersonid, x.demographics, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[SViewRow] = new Read[SViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      salespersonid = BusinessentityId.get.unsafeGetNullable(rs, i + 3),
      demographics = TypoXml.get.unsafeGetNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
