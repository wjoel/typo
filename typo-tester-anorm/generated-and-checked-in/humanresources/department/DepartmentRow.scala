/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class DepartmentRow(
  /** Primary key for Department records. */
  departmentid: DepartmentId,
  /** Name of the department. */
  name: Name,
  /** Name of the group to which the department belongs. */
  groupname: Name,
  modifieddate: TypoLocalDateTime
)

object DepartmentRow {
  implicit lazy val reads: Reads[DepartmentRow] = Reads[DepartmentRow](json => JsResult.fromTry(
      Try(
        DepartmentRow(
          departmentid = json.\("departmentid").as(DepartmentId.reads),
          name = json.\("name").as(Name.reads),
          groupname = json.\("groupname").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DepartmentRow] = RowParser[DepartmentRow] { row =>
    Success(
      DepartmentRow(
        departmentid = row(idx + 0)(DepartmentId.column),
        name = row(idx + 1)(Name.column),
        groupname = row(idx + 2)(Name.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[DepartmentRow] = OWrites[DepartmentRow](o =>
    new JsObject(ListMap[String, JsValue](
      "departmentid" -> DepartmentId.writes.writes(o.departmentid),
      "name" -> Name.writes.writes(o.name),
      "groupname" -> Name.writes.writes(o.groupname),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
