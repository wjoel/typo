/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PohViewRepo {
  def selectAll: Stream[ConnectionIO, PohViewRow]
  def selectByFieldValues(fieldValues: List[PohViewFieldOrIdValue[_]]): Stream[ConnectionIO, PohViewRow]
}
