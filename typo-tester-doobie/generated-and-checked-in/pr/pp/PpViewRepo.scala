/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PpViewRepo {
  def selectAll: Stream[ConnectionIO, PpViewRow]
  def selectByFieldValues(fieldValues: List[PpViewFieldOrIdValue[_]]): Stream[ConnectionIO, PpViewRow]
}
