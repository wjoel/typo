/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

import java.sql.Connection
import typo.dsl.SelectBuilder

trait DataTypePrivilegesViewRepo {
  def select: SelectBuilder[DataTypePrivilegesViewFields, DataTypePrivilegesViewRow]
  def selectAll(implicit c: Connection): List[DataTypePrivilegesViewRow]
}
