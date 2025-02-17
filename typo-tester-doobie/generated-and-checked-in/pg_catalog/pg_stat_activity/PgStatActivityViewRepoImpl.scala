/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_activity

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatActivityViewRepoImpl extends PgStatActivityViewRepo {
  override def select: SelectBuilder[PgStatActivityViewFields, PgStatActivityViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_activity", PgStatActivityViewFields, PgStatActivityViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatActivityViewRow] = {
    sql"""select datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start::text, xact_start::text, query_start::text, state_change::text, wait_event_type, wait_event, "state", backend_xid, backend_xmin, query_id, query, backend_type from pg_catalog.pg_stat_activity""".query(PgStatActivityViewRow.read).stream
  }
}
