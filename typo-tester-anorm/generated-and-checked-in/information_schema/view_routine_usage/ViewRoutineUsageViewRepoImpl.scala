/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_routine_usage

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ViewRoutineUsageViewRepoImpl extends ViewRoutineUsageViewRepo {
  override def select: SelectBuilder[ViewRoutineUsageViewFields, ViewRoutineUsageViewRow] = {
    SelectBuilderSql("information_schema.view_routine_usage", ViewRoutineUsageViewFields, ViewRoutineUsageViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ViewRoutineUsageViewRow] = {
    SQL"""select table_catalog, table_schema, "table_name", specific_catalog, specific_schema, "specific_name"
          from information_schema.view_routine_usage
       """.as(ViewRoutineUsageViewRow.rowParser(1).*)
  }
}
