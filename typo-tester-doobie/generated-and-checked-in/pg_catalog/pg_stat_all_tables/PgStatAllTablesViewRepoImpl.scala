/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_all_tables

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatAllTablesViewRepoImpl extends PgStatAllTablesViewRepo {
  override def select: SelectBuilder[PgStatAllTablesViewFields, PgStatAllTablesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_all_tables", PgStatAllTablesViewFields, PgStatAllTablesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatAllTablesViewRow] = {
    sql"select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd, n_live_tup, n_dead_tup, n_mod_since_analyze, n_ins_since_vacuum, last_vacuum::text, last_autovacuum::text, last_analyze::text, last_autoanalyze::text, vacuum_count, autovacuum_count, analyze_count, autoanalyze_count from pg_catalog.pg_stat_all_tables".query(PgStatAllTablesViewRow.read).stream
  }
}
