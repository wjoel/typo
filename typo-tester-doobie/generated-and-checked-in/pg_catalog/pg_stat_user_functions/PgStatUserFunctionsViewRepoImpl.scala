/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_functions

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatUserFunctionsViewRepoImpl extends PgStatUserFunctionsViewRepo {
  override def select: SelectBuilder[PgStatUserFunctionsViewFields, PgStatUserFunctionsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_user_functions", PgStatUserFunctionsViewFields, PgStatUserFunctionsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatUserFunctionsViewRow] = {
    sql"select funcid, schemaname, funcname, calls, total_time, self_time from pg_catalog.pg_stat_user_functions".query(PgStatUserFunctionsViewRow.read).stream
  }
}
