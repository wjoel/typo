/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.TypoLocalDate
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `humanresources.employeedepartmenthistory` */
case class EmployeedepartmenthistoryId(businessentityid: BusinessentityId, startdate: TypoLocalDate, departmentid: DepartmentId, shiftid: ShiftId)
object EmployeedepartmenthistoryId {
  implicit def ordering(implicit O0: Ordering[TypoLocalDate]): Ordering[EmployeedepartmenthistoryId] = Ordering.by(x => (x.businessentityid, x.startdate, x.departmentid, x.shiftid))
  implicit lazy val reads: Reads[EmployeedepartmenthistoryId] = Reads[EmployeedepartmenthistoryId](json => JsResult.fromTry(
      Try(
        EmployeedepartmenthistoryId(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          startdate = json.\("startdate").as(TypoLocalDate.reads),
          departmentid = json.\("departmentid").as(DepartmentId.reads),
          shiftid = json.\("shiftid").as(ShiftId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[EmployeedepartmenthistoryId] = OWrites[EmployeedepartmenthistoryId](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "startdate" -> TypoLocalDate.writes.writes(o.startdate),
      "departmentid" -> DepartmentId.writes.writes(o.departmentid),
      "shiftid" -> ShiftId.writes.writes(o.shiftid)
    ))
  )
}
