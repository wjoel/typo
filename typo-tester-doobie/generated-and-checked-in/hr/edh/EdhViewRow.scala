/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package edh

import adventureworks.TypoLocalDate
import adventureworks.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class EdhViewRow(
  id: Option[Int],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.departmentid]] */
  departmentid: Option[DepartmentId],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.shiftid]] */
  shiftid: Option[ShiftId],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: Option[TypoLocalDate],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.enddate]] */
  enddate: Option[TypoLocalDate],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object EdhViewRow {
  implicit val decoder: Decoder[EdhViewRow] = Decoder.forProduct7[EdhViewRow, Option[Int], Option[BusinessentityId], Option[DepartmentId], Option[ShiftId], Option[TypoLocalDate], Option[TypoLocalDate], Option[TypoLocalDateTime]]("id", "businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")(EdhViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(DepartmentId.decoder), Decoder.decodeOption(ShiftId.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[EdhViewRow] = Encoder.forProduct7[EdhViewRow, Option[Int], Option[BusinessentityId], Option[DepartmentId], Option[ShiftId], Option[TypoLocalDate], Option[TypoLocalDate], Option[TypoLocalDateTime]]("id", "businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")(x => (x.id, x.businessentityid, x.departmentid, x.shiftid, x.startdate, x.enddate, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(DepartmentId.encoder), Encoder.encodeOption(ShiftId.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[EdhViewRow] = new Read[EdhViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (DepartmentId.get, Nullability.Nullable),
      (ShiftId.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => EdhViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      departmentid = DepartmentId.get.unsafeGetNullable(rs, i + 2),
      shiftid = ShiftId.get.unsafeGetNullable(rs, i + 3),
      startdate = TypoLocalDate.get.unsafeGetNullable(rs, i + 4),
      enddate = TypoLocalDate.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
