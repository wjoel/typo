/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VjobcandidateeducationViewRepo {
  def selectAll: Stream[ConnectionIO, VjobcandidateeducationViewRow]
  def selectByFieldValues(fieldValues: List[VjobcandidateeducationViewFieldOrIdValue[_]]): Stream[ConnectionIO, VjobcandidateeducationViewRow]
}
