/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDate
import java.time.LocalDateTime

sealed abstract class EmployeedepartmenthistoryFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class EmployeedepartmenthistoryFieldValue[T](name: String, value: T) extends EmployeedepartmenthistoryFieldOrIdValue(name, value)

object EmployeedepartmenthistoryFieldValue {
  case class businessentityid(override val value: BusinessentityId) extends EmployeedepartmenthistoryFieldOrIdValue("businessentityid", value)
  case class departmentid(override val value: DepartmentId) extends EmployeedepartmenthistoryFieldOrIdValue("departmentid", value)
  case class shiftid(override val value: ShiftId) extends EmployeedepartmenthistoryFieldOrIdValue("shiftid", value)
  case class startdate(override val value: LocalDate) extends EmployeedepartmenthistoryFieldOrIdValue("startdate", value)
  case class enddate(override val value: Option[LocalDate]) extends EmployeedepartmenthistoryFieldValue("enddate", value)
  case class modifieddate(override val value: LocalDateTime) extends EmployeedepartmenthistoryFieldValue("modifieddate", value)
}
