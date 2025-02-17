/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_sequences

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatioSysSequencesViewRepoImpl extends PgStatioSysSequencesViewRepo {
  override def select: SelectBuilder[PgStatioSysSequencesViewFields, PgStatioSysSequencesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_statio_sys_sequences", PgStatioSysSequencesViewFields, PgStatioSysSequencesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatioSysSequencesViewRow] = {
    sql"select relid, schemaname, relname, blks_read, blks_hit from pg_catalog.pg_statio_sys_sequences".query(PgStatioSysSequencesViewRow.read).stream
  }
}
