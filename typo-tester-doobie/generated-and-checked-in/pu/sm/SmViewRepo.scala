/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait SmViewRepo {
  def selectAll: Stream[ConnectionIO, SmViewRow]
  def selectByFieldValues(fieldValues: List[SmViewFieldOrIdValue[_]]): Stream[ConnectionIO, SmViewRow]
}