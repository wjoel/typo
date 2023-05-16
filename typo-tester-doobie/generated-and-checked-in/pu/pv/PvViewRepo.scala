/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PvViewRepo {
  def selectAll: Stream[ConnectionIO, PvViewRow]
  def selectByFieldValues(fieldValues: List[PvViewFieldOrIdValue[_]]): Stream[ConnectionIO, PvViewRow]
}
