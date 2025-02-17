/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PurchaseorderdetailRepo {
  def delete(compositeId: PurchaseorderdetailId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow]
  def insert(unsaved: PurchaseorderdetailRow)(implicit c: Connection): PurchaseorderdetailRow
  def insert(unsaved: PurchaseorderdetailRowUnsaved)(implicit c: Connection): PurchaseorderdetailRow
  def select: SelectBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow]
  def selectAll(implicit c: Connection): List[PurchaseorderdetailRow]
  def selectById(compositeId: PurchaseorderdetailId)(implicit c: Connection): Option[PurchaseorderdetailRow]
  def update(row: PurchaseorderdetailRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow]
  def upsert(unsaved: PurchaseorderdetailRow)(implicit c: Connection): PurchaseorderdetailRow
}
