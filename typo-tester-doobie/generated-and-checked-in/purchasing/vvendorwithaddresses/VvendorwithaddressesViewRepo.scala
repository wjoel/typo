/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithaddresses

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VvendorwithaddressesViewRepo {
  def selectAll: Stream[ConnectionIO, VvendorwithaddressesViewRow]
  def selectByFieldValues(fieldValues: List[VvendorwithaddressesViewFieldOrIdValue[_]]): Stream[ConnectionIO, VvendorwithaddressesViewRow]
}
