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
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDate

object VemployeedepartmentViewRepoImpl extends VemployeedepartmentViewRepo {
  override def selectAll: Stream[ConnectionIO, VemployeedepartmentViewRow] = {
    sql"select businessentityid, title, firstname, middlename, lastname, suffix, jobtitle, department, groupname, startdate from humanresources.vemployeedepartment".query[VemployeedepartmentViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[VemployeedepartmentViewFieldOrIdValue[_]]): Stream[ConnectionIO, VemployeedepartmentViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case VemployeedepartmentViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case VemployeedepartmentViewFieldValue.title(value) => fr"title = $value"
        case VemployeedepartmentViewFieldValue.firstname(value) => fr"firstname = $value"
        case VemployeedepartmentViewFieldValue.middlename(value) => fr"middlename = $value"
        case VemployeedepartmentViewFieldValue.lastname(value) => fr"lastname = $value"
        case VemployeedepartmentViewFieldValue.suffix(value) => fr"suffix = $value"
        case VemployeedepartmentViewFieldValue.jobtitle(value) => fr"jobtitle = $value"
        case VemployeedepartmentViewFieldValue.department(value) => fr"department = $value"
        case VemployeedepartmentViewFieldValue.groupname(value) => fr"groupname = $value"
        case VemployeedepartmentViewFieldValue.startdate(value) => fr"startdate = $value"
      } :_*
    )
    sql"select * from humanresources.vemployeedepartment $where".query[VemployeedepartmentViewRow].stream
  
  }
  implicit val read: Read[VemployeedepartmentViewRow] =
    new Read[VemployeedepartmentViewRow](
      gets = List(
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VemployeedepartmentViewRow(
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 0),
        title = Get[String].unsafeGetNullable(rs, i + 1),
        firstname = Get[Name].unsafeGetNullable(rs, i + 2),
        middlename = Get[Name].unsafeGetNullable(rs, i + 3),
        lastname = Get[Name].unsafeGetNullable(rs, i + 4),
        suffix = Get[String].unsafeGetNullable(rs, i + 5),
        jobtitle = Get[String].unsafeGetNullable(rs, i + 6),
        department = Get[Name].unsafeGetNullable(rs, i + 7),
        groupname = Get[Name].unsafeGetNullable(rs, i + 8),
        startdate = Get[LocalDate].unsafeGetNullable(rs, i + 9)
      )
    )
  

}
