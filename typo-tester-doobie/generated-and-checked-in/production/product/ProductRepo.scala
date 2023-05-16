/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait ProductRepo {
  def delete(productid: ProductId): ConnectionIO[Boolean]
  def insert(unsaved: ProductRow): ConnectionIO[ProductRow]
  def insert(unsaved: ProductRowUnsaved): ConnectionIO[ProductRow]
  def selectAll: Stream[ConnectionIO, ProductRow]
  def selectByFieldValues(fieldValues: List[ProductFieldOrIdValue[_]]): Stream[ConnectionIO, ProductRow]
  def selectById(productid: ProductId): ConnectionIO[Option[ProductRow]]
  def selectByIds(productids: Array[ProductId]): Stream[ConnectionIO, ProductRow]
  def update(row: ProductRow): ConnectionIO[Boolean]
  def updateFieldValues(productid: ProductId, fieldValues: List[ProductFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: ProductRow): ConnectionIO[ProductRow]
}
