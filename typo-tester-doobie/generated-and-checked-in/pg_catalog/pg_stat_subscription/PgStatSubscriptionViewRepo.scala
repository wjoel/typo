/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_subscription

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatSubscriptionViewRepo {
  def select: SelectBuilder[PgStatSubscriptionViewFields, PgStatSubscriptionViewRow]
  def selectAll: Stream[ConnectionIO, PgStatSubscriptionViewRow]
}