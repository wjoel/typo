/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import adventureworks.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VemployeedepartmentViewRow(
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
  /** Points to [[employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[/* max 50 chars */ String],
  department: Option[Name],
  /** Points to [[department.DepartmentRow.groupname]] */
  groupname: Option[Name],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: Option[TypoLocalDate]
)

object VemployeedepartmentViewRow {
  implicit lazy val reads: Reads[VemployeedepartmentViewRow] = Reads[VemployeedepartmentViewRow](json => JsResult.fromTry(
      Try(
        VemployeedepartmentViewRow(
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").toOption.map(_.as(Name.reads)),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").toOption.map(_.as(Name.reads)),
          suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
          jobtitle = json.\("jobtitle").toOption.map(_.as(Reads.StringReads)),
          department = json.\("department").toOption.map(_.as(Name.reads)),
          groupname = json.\("groupname").toOption.map(_.as(Name.reads)),
          startdate = json.\("startdate").toOption.map(_.as(TypoLocalDate.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VemployeedepartmentViewRow] = RowParser[VemployeedepartmentViewRow] { row =>
    Success(
      VemployeedepartmentViewRow(
        businessentityid = row(idx + 0)(Column.columnToOption(BusinessentityId.column)),
        title = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 2)(Column.columnToOption(Name.column)),
        middlename = row(idx + 3)(Column.columnToOption(Name.column)),
        lastname = row(idx + 4)(Column.columnToOption(Name.column)),
        suffix = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        jobtitle = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        department = row(idx + 7)(Column.columnToOption(Name.column)),
        groupname = row(idx + 8)(Column.columnToOption(Name.column)),
        startdate = row(idx + 9)(Column.columnToOption(TypoLocalDate.column))
      )
    )
  }
  implicit lazy val writes: OWrites[VemployeedepartmentViewRow] = OWrites[VemployeedepartmentViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> Writes.OptionWrites(Name.writes).writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Writes.OptionWrites(Name.writes).writes(o.lastname),
      "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
      "jobtitle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.jobtitle),
      "department" -> Writes.OptionWrites(Name.writes).writes(o.department),
      "groupname" -> Writes.OptionWrites(Name.writes).writes(o.groupname),
      "startdate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.startdate)
    ))
  )
}
