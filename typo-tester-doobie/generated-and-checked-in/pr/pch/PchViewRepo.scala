/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PchViewRepo {
  def selectAll: Stream[ConnectionIO, PchViewRow]
  def selectByFieldValues(fieldValues: List[PchViewFieldOrIdValue[_]]): Stream[ConnectionIO, PchViewRow]
}
