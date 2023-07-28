/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import adventureworks.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VemployeedepartmenthistoryViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
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
  shift: Option[Name],
  department: Option[Name],
  /** Points to [[department.DepartmentRow.groupname]] */
  groupname: Option[Name],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: Option[TypoLocalDate],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.enddate]] */
  enddate: Option[TypoLocalDate]
)

object VemployeedepartmenthistoryViewRow {
  implicit val decoder: Decoder[VemployeedepartmenthistoryViewRow] = Decoder.forProduct11[VemployeedepartmenthistoryViewRow, Option[BusinessentityId], Option[/* max 8 chars */ String], Option[Name], Option[Name], Option[Name], Option[/* max 10 chars */ String], Option[Name], Option[Name], Option[Name], Option[TypoLocalDate], Option[TypoLocalDate]]("businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "shift", "department", "groupname", "startdate", "enddate")(VemployeedepartmenthistoryViewRow.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDate.decoder))
  implicit val encoder: Encoder[VemployeedepartmenthistoryViewRow] = Encoder.forProduct11[VemployeedepartmenthistoryViewRow, Option[BusinessentityId], Option[/* max 8 chars */ String], Option[Name], Option[Name], Option[Name], Option[/* max 10 chars */ String], Option[Name], Option[Name], Option[Name], Option[TypoLocalDate], Option[TypoLocalDate]]("businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "shift", "department", "groupname", "startdate", "enddate")(x => (x.businessentityid, x.title, x.firstname, x.middlename, x.lastname, x.suffix, x.shift, x.department, x.groupname, x.startdate, x.enddate))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDate.encoder))
  implicit val read: Read[VemployeedepartmenthistoryViewRow] = new Read[VemployeedepartmenthistoryViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VemployeedepartmenthistoryViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 0),
      title = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      firstname = Name.get.unsafeGetNullable(rs, i + 2),
      middlename = Name.get.unsafeGetNullable(rs, i + 3),
      lastname = Name.get.unsafeGetNullable(rs, i + 4),
      suffix = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      shift = Name.get.unsafeGetNullable(rs, i + 6),
      department = Name.get.unsafeGetNullable(rs, i + 7),
      groupname = Name.get.unsafeGetNullable(rs, i + 8),
      startdate = TypoLocalDate.get.unsafeGetNullable(rs, i + 9),
      enddate = TypoLocalDate.get.unsafeGetNullable(rs, i + 10)
    )
  )
}
