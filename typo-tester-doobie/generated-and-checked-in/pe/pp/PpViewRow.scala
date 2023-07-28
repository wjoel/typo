/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pp

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PpViewRow(
  id: Option[Int],
  /** Points to [[person.personphone.PersonphoneRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  /** Points to [[person.personphone.PersonphoneRow.phonenumbertypeid]] */
  phonenumbertypeid: Option[PhonenumbertypeId],
  /** Points to [[person.personphone.PersonphoneRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PpViewRow {
  implicit val decoder: Decoder[PpViewRow] = Decoder.forProduct5[PpViewRow, Option[Int], Option[BusinessentityId], Option[Phone], Option[PhonenumbertypeId], Option[TypoLocalDateTime]]("id", "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(PpViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(Phone.decoder), Decoder.decodeOption(PhonenumbertypeId.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[PpViewRow] = Encoder.forProduct5[PpViewRow, Option[Int], Option[BusinessentityId], Option[Phone], Option[PhonenumbertypeId], Option[TypoLocalDateTime]]("id", "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(x => (x.id, x.businessentityid, x.phonenumber, x.phonenumbertypeid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(Phone.encoder), Encoder.encodeOption(PhonenumbertypeId.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[PpViewRow] = new Read[PpViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (Phone.get, Nullability.Nullable),
      (PhonenumbertypeId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PpViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      phonenumber = Phone.get.unsafeGetNullable(rs, i + 2),
      phonenumbertypeid = PhonenumbertypeId.get.unsafeGetNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
