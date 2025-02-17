/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_indexes

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatioSysIndexesViewRepoImpl extends PgStatioSysIndexesViewRepo {
  override def select: SelectBuilder[PgStatioSysIndexesViewFields, PgStatioSysIndexesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_statio_sys_indexes", PgStatioSysIndexesViewFields, PgStatioSysIndexesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatioSysIndexesViewRow] = {
    sql"select relid, indexrelid, schemaname, relname, indexrelname, idx_blks_read, idx_blks_hit from pg_catalog.pg_statio_sys_indexes".query(PgStatioSysIndexesViewRow.read).stream
  }
}
