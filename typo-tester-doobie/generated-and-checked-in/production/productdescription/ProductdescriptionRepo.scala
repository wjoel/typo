/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait ProductdescriptionRepo {
  def delete(productdescriptionid: ProductdescriptionId): ConnectionIO[Boolean]
  def insert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow]
  def insert(unsaved: ProductdescriptionRowUnsaved): ConnectionIO[ProductdescriptionRow]
  def selectAll: Stream[ConnectionIO, ProductdescriptionRow]
  def selectByFieldValues(fieldValues: List[ProductdescriptionFieldOrIdValue[_]]): Stream[ConnectionIO, ProductdescriptionRow]
  def selectById(productdescriptionid: ProductdescriptionId): ConnectionIO[Option[ProductdescriptionRow]]
  def selectByIds(productdescriptionids: Array[ProductdescriptionId]): Stream[ConnectionIO, ProductdescriptionRow]
  def update(row: ProductdescriptionRow): ConnectionIO[Boolean]
  def updateFieldValues(productdescriptionid: ProductdescriptionId, fieldValues: List[ProductdescriptionFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow]
}
