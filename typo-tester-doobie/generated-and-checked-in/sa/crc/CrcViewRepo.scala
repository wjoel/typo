/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait CrcViewRepo {
  def selectAll: Stream[ConnectionIO, CrcViewRow]
  def selectByFieldValues(fieldValues: List[CrcViewFieldOrIdValue[_]]): Stream[ConnectionIO, CrcViewRow]
}
