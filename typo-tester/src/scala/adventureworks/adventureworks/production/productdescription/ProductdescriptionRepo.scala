/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import java.sql.Connection

trait ProductdescriptionRepo {
  def delete(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductdescriptionRowUnsaved)(implicit c: Connection): ProductdescriptionId
  def selectAll(implicit c: Connection): List[ProductdescriptionRow]
  def selectByFieldValues(fieldValues: List[ProductdescriptionFieldOrIdValue[_]])(implicit c: Connection): List[ProductdescriptionRow]
  def selectById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Option[ProductdescriptionRow]
  def selectByIds(productdescriptionids: List[ProductdescriptionId])(implicit c: Connection): List[ProductdescriptionRow]
  def update(row: ProductdescriptionRow)(implicit c: Connection): Boolean
  def updateFieldValues(productdescriptionid: ProductdescriptionId, fieldValues: List[ProductdescriptionFieldValue[_]])(implicit c: Connection): Boolean
}
