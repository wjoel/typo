/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VpersondemographicsViewRepo {
  def selectAll: Stream[ConnectionIO, VpersondemographicsViewRow]
  def selectByFieldValues(fieldValues: List[VpersondemographicsViewFieldOrIdValue[_]]): Stream[ConnectionIO, VpersondemographicsViewRow]
}
