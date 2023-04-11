/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import java.sql.Connection

trait ProductinventoryRepo {
  def delete(compositeId: ProductinventoryId)(implicit c: Connection): Boolean
  def insert(compositeId: ProductinventoryId, unsaved: ProductinventoryRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[ProductinventoryRow]
  def selectByFieldValues(fieldValues: List[ProductinventoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductinventoryRow]
  def selectById(compositeId: ProductinventoryId)(implicit c: Connection): Option[ProductinventoryRow]
  def update(row: ProductinventoryRow)(implicit c: Connection): Boolean
  def updateFieldValues(compositeId: ProductinventoryId, fieldValues: List[ProductinventoryFieldValue[_]])(implicit c: Connection): Boolean
}
