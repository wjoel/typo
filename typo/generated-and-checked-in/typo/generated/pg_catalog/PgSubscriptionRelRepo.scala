/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import java.sql.Connection

trait PgSubscriptionRelRepo {
  def selectAll(implicit c: Connection): List[PgSubscriptionRelRow]
  def selectById(compositeId: PgSubscriptionRelId)(implicit c: Connection): Option[PgSubscriptionRelRow]
  def selectByFieldValues(fieldValues: List[PgSubscriptionRelFieldValue[_]])(implicit c: Connection): List[PgSubscriptionRelRow]
  def updateFieldValues(compositeId: PgSubscriptionRelId, fieldValues: List[PgSubscriptionRelFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgSubscriptionRelId, unsaved: PgSubscriptionRelRowUnsaved)(implicit c: Connection): Unit
  def delete(compositeId: PgSubscriptionRelId)(implicit c: Connection): Boolean
}
