/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collation_character_set_applicability

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait CollationCharacterSetApplicabilityViewRepo {
  def select: SelectBuilder[CollationCharacterSetApplicabilityViewFields, CollationCharacterSetApplicabilityViewRow]
  def selectAll: Stream[ConnectionIO, CollationCharacterSetApplicabilityViewRow]
}