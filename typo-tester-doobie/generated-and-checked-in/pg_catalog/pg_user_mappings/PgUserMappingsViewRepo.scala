/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mappings

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgUserMappingsViewRepo {
  def select: SelectBuilder[PgUserMappingsViewFields, PgUserMappingsViewRow]
  def selectAll: Stream[ConnectionIO, PgUserMappingsViewRow]
}
