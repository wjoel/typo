/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import java.sql.Connection

trait CcViewRepo {
  def selectAll(implicit c: Connection): List[CcViewRow]
  def selectByFieldValues(fieldValues: List[CcViewFieldOrIdValue[_]])(implicit c: Connection): List[CcViewRow]
}