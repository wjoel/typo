/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VemployeedepartmenthistoryViewRepo {
  def selectAll: Stream[ConnectionIO, VemployeedepartmenthistoryViewRow]
  def selectByFieldValues(fieldValues: List[VemployeedepartmenthistoryViewFieldOrIdValue[_]]): Stream[ConnectionIO, VemployeedepartmenthistoryViewRow]
}
