/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import java.sql.Connection

trait PcViewRepo {
  def selectAll(implicit c: Connection): List[PcViewRow]
  def selectByFieldValues(fieldValues: List[PcViewFieldOrIdValue[_]])(implicit c: Connection): List[PcViewRow]
}