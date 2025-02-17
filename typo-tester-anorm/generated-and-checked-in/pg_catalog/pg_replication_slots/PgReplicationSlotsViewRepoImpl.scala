/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_slots

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgReplicationSlotsViewRepoImpl extends PgReplicationSlotsViewRepo {
  override def select: SelectBuilder[PgReplicationSlotsViewFields, PgReplicationSlotsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_replication_slots", PgReplicationSlotsViewFields, PgReplicationSlotsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgReplicationSlotsViewRow] = {
    SQL"""select slot_name, plugin, slot_type, datoid, "database", "temporary", active, active_pid, xmin, catalog_xmin, restart_lsn, confirmed_flush_lsn, wal_status, safe_wal_size, two_phase
          from pg_catalog.pg_replication_slots
       """.as(PgReplicationSlotsViewRow.rowParser(1).*)
  }
}
