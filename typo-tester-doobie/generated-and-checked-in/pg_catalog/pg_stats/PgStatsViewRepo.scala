/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatsViewRepo {
  def select: SelectBuilder[PgStatsViewFields, PgStatsViewRow]
  def selectAll: Stream[ConnectionIO, PgStatsViewRow]
}
