/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_user_functions

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatXactUserFunctionsViewRepoImpl extends PgStatXactUserFunctionsViewRepo {
  override def select: SelectBuilder[PgStatXactUserFunctionsViewFields, PgStatXactUserFunctionsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_xact_user_functions", PgStatXactUserFunctionsViewFields, PgStatXactUserFunctionsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatXactUserFunctionsViewRow] = {
    SQL"""select funcid, schemaname, funcname, calls, total_time, self_time
          from pg_catalog.pg_stat_xact_user_functions
       """.as(PgStatXactUserFunctionsViewRow.rowParser(1).*)
  }
}
