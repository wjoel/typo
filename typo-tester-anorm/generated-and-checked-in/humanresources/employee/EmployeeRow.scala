/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

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

case class EmployeeRow(
  /** Primary key for Employee records.  Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Unique national identification number such as a social security number. */
  nationalidnumber: /* max 15 chars */ String,
  /** Network login. */
  loginid: /* max 256 chars */ String,
  /** Work title such as Buyer or Sales Representative. */
  jobtitle: /* max 50 chars */ String,
  /** Date of birth. */
  birthdate: TypoLocalDate,
  /** M = Married, S = Single */
  maritalstatus: /* bpchar */ String,
  /** M = Male, F = Female */
  gender: /* bpchar */ String,
  /** Employee hired on this date. */
  hiredate: TypoLocalDate,
  /** Job classification. 0 = Hourly, not exempt from collective bargaining. 1 = Salaried, exempt from collective bargaining. */
  salariedflag: Flag,
  /** Number of available vacation hours. */
  vacationhours: Int,
  /** Number of available sick leave hours. */
  sickleavehours: Int,
  /** 0 = Inactive, 1 = Active */
  currentflag: Flag,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime,
  /** Where the employee is located in corporate hierarchy. */
  organizationnode: Option[String]
)

object EmployeeRow {
  implicit lazy val reads: Reads[EmployeeRow] = Reads[EmployeeRow](json => JsResult.fromTry(
      Try(
        EmployeeRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          nationalidnumber = json.\("nationalidnumber").as(Reads.StringReads),
          loginid = json.\("loginid").as(Reads.StringReads),
          jobtitle = json.\("jobtitle").as(Reads.StringReads),
          birthdate = json.\("birthdate").as(TypoLocalDate.reads),
          maritalstatus = json.\("maritalstatus").as(Reads.StringReads),
          gender = json.\("gender").as(Reads.StringReads),
          hiredate = json.\("hiredate").as(TypoLocalDate.reads),
          salariedflag = json.\("salariedflag").as(Flag.reads),
          vacationhours = json.\("vacationhours").as(Reads.IntReads),
          sickleavehours = json.\("sickleavehours").as(Reads.IntReads),
          currentflag = json.\("currentflag").as(Flag.reads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads),
          organizationnode = json.\("organizationnode").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EmployeeRow] = RowParser[EmployeeRow] { row =>
    Success(
      EmployeeRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        nationalidnumber = row(idx + 1)(Column.columnToString),
        loginid = row(idx + 2)(Column.columnToString),
        jobtitle = row(idx + 3)(Column.columnToString),
        birthdate = row(idx + 4)(TypoLocalDate.column),
        maritalstatus = row(idx + 5)(Column.columnToString),
        gender = row(idx + 6)(Column.columnToString),
        hiredate = row(idx + 7)(TypoLocalDate.column),
        salariedflag = row(idx + 8)(Flag.column),
        vacationhours = row(idx + 9)(Column.columnToInt),
        sickleavehours = row(idx + 10)(Column.columnToInt),
        currentflag = row(idx + 11)(Flag.column),
        rowguid = row(idx + 12)(Column.columnToUUID),
        modifieddate = row(idx + 13)(TypoLocalDateTime.column),
        organizationnode = row(idx + 14)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[EmployeeRow] = OWrites[EmployeeRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "nationalidnumber" -> Writes.StringWrites.writes(o.nationalidnumber),
      "loginid" -> Writes.StringWrites.writes(o.loginid),
      "jobtitle" -> Writes.StringWrites.writes(o.jobtitle),
      "birthdate" -> TypoLocalDate.writes.writes(o.birthdate),
      "maritalstatus" -> Writes.StringWrites.writes(o.maritalstatus),
      "gender" -> Writes.StringWrites.writes(o.gender),
      "hiredate" -> TypoLocalDate.writes.writes(o.hiredate),
      "salariedflag" -> Flag.writes.writes(o.salariedflag),
      "vacationhours" -> Writes.IntWrites.writes(o.vacationhours),
      "sickleavehours" -> Writes.IntWrites.writes(o.sickleavehours),
      "currentflag" -> Flag.writes.writes(o.currentflag),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate),
      "organizationnode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.organizationnode)
    ))
  )
}
