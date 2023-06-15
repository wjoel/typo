/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import java.sql.Connection

trait ProductsubcategoryRepo {
  def delete(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow
  def insert(unsaved: ProductsubcategoryRowUnsaved)(implicit c: Connection): ProductsubcategoryRow
  def selectAll(implicit c: Connection): List[ProductsubcategoryRow]
  def selectByFieldValues(fieldValues: List[ProductsubcategoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductsubcategoryRow]
  def selectById(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Option[ProductsubcategoryRow]
  def selectByIds(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): List[ProductsubcategoryRow]
  def update(row: ProductsubcategoryRow)(implicit c: Connection): Boolean
  def updateFieldValues(productsubcategoryid: ProductsubcategoryId, fieldValues: List[ProductsubcategoryFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow
}