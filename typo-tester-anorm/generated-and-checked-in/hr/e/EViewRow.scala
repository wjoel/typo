/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import adventureworks.TypoLocalDate
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class EViewRow(
  id: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.employee.EmployeeRow.nationalidnumber]] */
  nationalidnumber: Option[/* max 15 chars */ String],
  /** Points to [[humanresources.employee.EmployeeRow.loginid]] */
  loginid: Option[/* max 256 chars */ String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[/* max 50 chars */ String],
  /** Points to [[humanresources.employee.EmployeeRow.birthdate]] */
  birthdate: Option[TypoLocalDate],
  /** Points to [[humanresources.employee.EmployeeRow.maritalstatus]] */
  maritalstatus: Option[/* bpchar */ String],
  /** Points to [[humanresources.employee.EmployeeRow.gender]] */
  gender: Option[/* bpchar */ String],
  /** Points to [[humanresources.employee.EmployeeRow.hiredate]] */
  hiredate: Option[TypoLocalDate],
  /** Points to [[humanresources.employee.EmployeeRow.salariedflag]] */
  salariedflag: Flag,
  /** Points to [[humanresources.employee.EmployeeRow.vacationhours]] */
  vacationhours: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.sickleavehours]] */
  sickleavehours: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.currentflag]] */
  currentflag: Flag,
  /** Points to [[humanresources.employee.EmployeeRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[humanresources.employee.EmployeeRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime],
  /** Points to [[humanresources.employee.EmployeeRow.organizationnode]] */
  organizationnode: Option[String]
)

object EViewRow {
  implicit lazy val reads: Reads[EViewRow] = Reads[EViewRow](json => JsResult.fromTry(
      Try(
        EViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          nationalidnumber = json.\("nationalidnumber").toOption.map(_.as(Reads.StringReads)),
          loginid = json.\("loginid").toOption.map(_.as(Reads.StringReads)),
          jobtitle = json.\("jobtitle").toOption.map(_.as(Reads.StringReads)),
          birthdate = json.\("birthdate").toOption.map(_.as(TypoLocalDate.reads)),
          maritalstatus = json.\("maritalstatus").toOption.map(_.as(Reads.StringReads)),
          gender = json.\("gender").toOption.map(_.as(Reads.StringReads)),
          hiredate = json.\("hiredate").toOption.map(_.as(TypoLocalDate.reads)),
          salariedflag = json.\("salariedflag").as(Flag.reads),
          vacationhours = json.\("vacationhours").toOption.map(_.as(Reads.IntReads)),
          sickleavehours = json.\("sickleavehours").toOption.map(_.as(Reads.IntReads)),
          currentflag = json.\("currentflag").as(Flag.reads),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          organizationnode = json.\("organizationnode").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EViewRow] = RowParser[EViewRow] { row =>
    Success(
      EViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        nationalidnumber = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        loginid = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        jobtitle = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        birthdate = row(idx + 5)(Column.columnToOption(TypoLocalDate.column)),
        maritalstatus = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        gender = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        hiredate = row(idx + 8)(Column.columnToOption(TypoLocalDate.column)),
        salariedflag = row(idx + 9)(Flag.column),
        vacationhours = row(idx + 10)(Column.columnToOption(Column.columnToInt)),
        sickleavehours = row(idx + 11)(Column.columnToOption(Column.columnToInt)),
        currentflag = row(idx + 12)(Flag.column),
        rowguid = row(idx + 13)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 14)(Column.columnToOption(TypoLocalDateTime.column)),
        organizationnode = row(idx + 15)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[EViewRow] = OWrites[EViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "nationalidnumber" -> Writes.OptionWrites(Writes.StringWrites).writes(o.nationalidnumber),
      "loginid" -> Writes.OptionWrites(Writes.StringWrites).writes(o.loginid),
      "jobtitle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.jobtitle),
      "birthdate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.birthdate),
      "maritalstatus" -> Writes.OptionWrites(Writes.StringWrites).writes(o.maritalstatus),
      "gender" -> Writes.OptionWrites(Writes.StringWrites).writes(o.gender),
      "hiredate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.hiredate),
      "salariedflag" -> Flag.writes.writes(o.salariedflag),
      "vacationhours" -> Writes.OptionWrites(Writes.IntWrites).writes(o.vacationhours),
      "sickleavehours" -> Writes.OptionWrites(Writes.IntWrites).writes(o.sickleavehours),
      "currentflag" -> Flag.writes.writes(o.currentflag),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate),
      "organizationnode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.organizationnode)
    ))
  )
}
