/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatsViewRepoImpl extends PgStatsViewRepo {
  override def select: SelectBuilder[PgStatsViewFields, PgStatsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stats", PgStatsViewFields, PgStatsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatsViewRow] = {
    SQL"""select schemaname, tablename, attname, inherited, null_frac, avg_width, n_distinct, most_common_vals, most_common_freqs, histogram_bounds, correlation, most_common_elems, most_common_elem_freqs, elem_count_histogram
          from pg_catalog.pg_stats
       """.as(PgStatsViewRow.rowParser(1).*)
  }
}
