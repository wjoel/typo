/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import java.sql.Connection

trait VstorewithaddressesViewRepo {
  def selectAll(implicit c: Connection): List[VstorewithaddressesViewRow]
  def selectByFieldValues(fieldValues: List[VstorewithaddressesViewFieldOrIdValue[_]])(implicit c: Connection): List[VstorewithaddressesViewRow]
}