/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_subscription

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatSubscriptionViewRepoImpl extends PgStatSubscriptionViewRepo {
  override def select: SelectBuilder[PgStatSubscriptionViewFields, PgStatSubscriptionViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_subscription", PgStatSubscriptionViewFields, PgStatSubscriptionViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatSubscriptionViewRow] = {
    SQL"""select subid, subname, pid, relid, received_lsn, last_msg_send_time::text, last_msg_receipt_time::text, latest_end_lsn, latest_end_time::text
          from pg_catalog.pg_stat_subscription
       """.as(PgStatSubscriptionViewRow.rowParser(1).*)
  }
}
