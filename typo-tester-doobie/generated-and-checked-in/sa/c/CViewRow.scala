/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class CViewRow(
  id: Option[Int],
  /** Points to [[sales.customer.CustomerRow.customerid]] */
  customerid: Option[CustomerId],
  /** Points to [[sales.customer.CustomerRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.storeid]] */
  storeid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.customer.CustomerRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.customer.CustomerRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CViewRow {
  implicit val decoder: Decoder[CViewRow] = Decoder.forProduct7[CViewRow, Option[Int], Option[CustomerId], Option[BusinessentityId], Option[BusinessentityId], Option[SalesterritoryId], Option[UUID], Option[TypoLocalDateTime]]("id", "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")(CViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(CustomerId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(SalesterritoryId.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[CViewRow] = Encoder.forProduct7[CViewRow, Option[Int], Option[CustomerId], Option[BusinessentityId], Option[BusinessentityId], Option[SalesterritoryId], Option[UUID], Option[TypoLocalDateTime]]("id", "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")(x => (x.id, x.customerid, x.personid, x.storeid, x.territoryid, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(CustomerId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(SalesterritoryId.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[CViewRow] = new Read[CViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (CustomerId.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (SalesterritoryId.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      customerid = CustomerId.get.unsafeGetNullable(rs, i + 1),
      personid = BusinessentityId.get.unsafeGetNullable(rs, i + 2),
      storeid = BusinessentityId.get.unsafeGetNullable(rs, i + 3),
      territoryid = SalesterritoryId.get.unsafeGetNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
