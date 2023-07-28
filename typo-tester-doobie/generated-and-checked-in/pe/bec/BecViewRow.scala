/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class BecViewRow(
  id: Option[Int],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.contacttypeid]] */
  contacttypeid: Option[ContacttypeId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object BecViewRow {
  implicit val decoder: Decoder[BecViewRow] = Decoder.forProduct6[BecViewRow, Option[Int], Option[BusinessentityId], Option[BusinessentityId], Option[ContacttypeId], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")(BecViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(ContacttypeId.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[BecViewRow] = Encoder.forProduct6[BecViewRow, Option[Int], Option[BusinessentityId], Option[BusinessentityId], Option[ContacttypeId], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.personid, x.contacttypeid, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(ContacttypeId.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[BecViewRow] = new Read[BecViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (ContacttypeId.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BecViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      personid = BusinessentityId.get.unsafeGetNullable(rs, i + 2),
      contacttypeid = ContacttypeId.get.unsafeGetNullable(rs, i + 3),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
