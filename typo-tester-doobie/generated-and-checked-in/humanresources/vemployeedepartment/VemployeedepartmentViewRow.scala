/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.time.LocalDate

case class VemployeedepartmentViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[String],
  /** Points to [[employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[String],
  department: Option[Name],
  /** Points to [[department.DepartmentRow.groupname]] */
  groupname: Option[Name],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: Option[LocalDate]
)


