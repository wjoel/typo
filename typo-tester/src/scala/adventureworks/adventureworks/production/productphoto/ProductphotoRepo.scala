/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import java.sql.Connection

trait ProductphotoRepo {
  def delete(productphotoid: ProductphotoId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductphotoRowUnsaved)(implicit c: Connection): ProductphotoId
  def selectAll(implicit c: Connection): List[ProductphotoRow]
  def selectByFieldValues(fieldValues: List[ProductphotoFieldOrIdValue[_]])(implicit c: Connection): List[ProductphotoRow]
  def selectById(productphotoid: ProductphotoId)(implicit c: Connection): Option[ProductphotoRow]
  def selectByIds(productphotoids: List[ProductphotoId])(implicit c: Connection): List[ProductphotoRow]
  def update(row: ProductphotoRow)(implicit c: Connection): Boolean
  def updateFieldValues(productphotoid: ProductphotoId, fieldValues: List[ProductphotoFieldValue[_]])(implicit c: Connection): Boolean
}
