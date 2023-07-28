/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VvendorwithcontactsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.contacttype.ContacttypeRow.name]] */
  name: Option[Name],
  contacttype: Option[Name],
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int]
)

object VvendorwithcontactsViewRow {
  implicit val decoder: Decoder[VvendorwithcontactsViewRow] = Decoder.forProduct12[VvendorwithcontactsViewRow, Option[BusinessentityId], Option[Name], Option[Name], Option[/* max 8 chars */ String], Option[Name], Option[Name], Option[Name], Option[/* max 10 chars */ String], Option[Phone], Option[Name], Option[/* max 50 chars */ String], Option[Int]]("businessentityid", "name", "contacttype", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion")(VvendorwithcontactsViewRow.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Phone.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt))
  implicit val encoder: Encoder[VvendorwithcontactsViewRow] = Encoder.forProduct12[VvendorwithcontactsViewRow, Option[BusinessentityId], Option[Name], Option[Name], Option[/* max 8 chars */ String], Option[Name], Option[Name], Option[Name], Option[/* max 10 chars */ String], Option[Phone], Option[Name], Option[/* max 50 chars */ String], Option[Int]]("businessentityid", "name", "contacttype", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion")(x => (x.businessentityid, x.name, x.contacttype, x.title, x.firstname, x.middlename, x.lastname, x.suffix, x.phonenumber, x.phonenumbertype, x.emailaddress, x.emailpromotion))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Phone.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt))
  implicit val read: Read[VvendorwithcontactsViewRow] = new Read[VvendorwithcontactsViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Phone.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VvendorwithcontactsViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 0),
      name = Name.get.unsafeGetNullable(rs, i + 1),
      contacttype = Name.get.unsafeGetNullable(rs, i + 2),
      title = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      firstname = Name.get.unsafeGetNullable(rs, i + 4),
      middlename = Name.get.unsafeGetNullable(rs, i + 5),
      lastname = Name.get.unsafeGetNullable(rs, i + 6),
      suffix = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      phonenumber = Phone.get.unsafeGetNullable(rs, i + 8),
      phonenumbertype = Name.get.unsafeGetNullable(rs, i + 9),
      emailaddress = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10),
      emailpromotion = Meta.IntMeta.get.unsafeGetNullable(rs, i + 11)
    )
  )
}
