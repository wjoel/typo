/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VViewRepo {
  def selectAll: Stream[ConnectionIO, VViewRow]
  def selectByFieldValues(fieldValues: List[VViewFieldOrIdValue[_]]): Stream[ConnectionIO, VViewRow]
}