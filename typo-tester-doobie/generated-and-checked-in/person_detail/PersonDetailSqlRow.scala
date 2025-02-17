/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_detail

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PersonDetailSqlRow(
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Name,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String
)

object PersonDetailSqlRow {
  implicit val decoder: Decoder[PersonDetailSqlRow] = Decoder.forProduct9[PersonDetailSqlRow, BusinessentityId, Option[/* max 8 chars */ String], Name, Option[Name], Name, /* max 50 chars */ String, /* max 60 chars */ String, /* max 30 chars */ String, /* max 15 chars */ String]("businessentityid", "title", "firstname", "middlename", "lastname", "jobtitle", "addressline1", "city", "postalcode")(PersonDetailSqlRow.apply)(BusinessentityId.decoder, Decoder.decodeOption(Decoder.decodeString), Name.decoder, Decoder.decodeOption(Name.decoder), Name.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeString, Decoder.decodeString)
  implicit val encoder: Encoder[PersonDetailSqlRow] = Encoder.forProduct9[PersonDetailSqlRow, BusinessentityId, Option[/* max 8 chars */ String], Name, Option[Name], Name, /* max 50 chars */ String, /* max 60 chars */ String, /* max 30 chars */ String, /* max 15 chars */ String]("businessentityid", "title", "firstname", "middlename", "lastname", "jobtitle", "addressline1", "city", "postalcode")(x => (x.businessentityid, x.title, x.firstname, x.middlename, x.lastname, x.jobtitle, x.addressline1, x.city, x.postalcode))(BusinessentityId.encoder, Encoder.encodeOption(Encoder.encodeString), Name.encoder, Encoder.encodeOption(Name.encoder), Name.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeString, Encoder.encodeString)
  implicit val read: Read[PersonDetailSqlRow] = new Read[PersonDetailSqlRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Name.get, Nullability.NoNulls),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PersonDetailSqlRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      title = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      firstname = Name.get.unsafeGetNonNullable(rs, i + 2),
      middlename = Name.get.unsafeGetNullable(rs, i + 3),
      lastname = Name.get.unsafeGetNonNullable(rs, i + 4),
      jobtitle = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      addressline1 = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      city = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 7),
      postalcode = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
