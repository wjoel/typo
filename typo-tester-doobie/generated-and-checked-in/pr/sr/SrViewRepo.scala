/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait SrViewRepo {
  def selectAll: Stream[ConnectionIO, SrViewRow]
  def selectByFieldValues(fieldValues: List[SrViewFieldOrIdValue[_]]): Stream[ConnectionIO, SrViewRow]
}