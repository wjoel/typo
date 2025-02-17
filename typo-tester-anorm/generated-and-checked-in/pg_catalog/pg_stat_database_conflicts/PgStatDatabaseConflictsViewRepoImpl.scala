/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database_conflicts

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatDatabaseConflictsViewRepoImpl extends PgStatDatabaseConflictsViewRepo {
  override def select: SelectBuilder[PgStatDatabaseConflictsViewFields, PgStatDatabaseConflictsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_database_conflicts", PgStatDatabaseConflictsViewFields, PgStatDatabaseConflictsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatDatabaseConflictsViewRow] = {
    SQL"""select datid, datname, confl_tablespace, confl_lock, confl_snapshot, confl_bufferpin, confl_deadlock
          from pg_catalog.pg_stat_database_conflicts
       """.as(PgStatDatabaseConflictsViewRow.rowParser(1).*)
  }
}
