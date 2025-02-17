/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VemployeedepartmentViewRepoImpl extends VemployeedepartmentViewRepo {
  override def select: SelectBuilder[VemployeedepartmentViewFields, VemployeedepartmentViewRow] = {
    SelectBuilderSql("humanresources.vemployeedepartment", VemployeedepartmentViewFields, VemployeedepartmentViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VemployeedepartmentViewRow] = {
    sql"select businessentityid, title, firstname, middlename, lastname, suffix, jobtitle, department, groupname, startdate::text from humanresources.vemployeedepartment".query(VemployeedepartmentViewRow.read).stream
  }
}
