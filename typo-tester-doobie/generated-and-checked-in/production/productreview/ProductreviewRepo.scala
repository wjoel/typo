/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait ProductreviewRepo {
  def delete(productreviewid: ProductreviewId): ConnectionIO[Boolean]
  def insert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow]
  def insert(unsaved: ProductreviewRowUnsaved): ConnectionIO[ProductreviewRow]
  def selectAll: Stream[ConnectionIO, ProductreviewRow]
  def selectByFieldValues(fieldValues: List[ProductreviewFieldOrIdValue[_]]): Stream[ConnectionIO, ProductreviewRow]
  def selectById(productreviewid: ProductreviewId): ConnectionIO[Option[ProductreviewRow]]
  def selectByIds(productreviewids: Array[ProductreviewId]): Stream[ConnectionIO, ProductreviewRow]
  def update(row: ProductreviewRow): ConnectionIO[Boolean]
  def updateFieldValues(productreviewid: ProductreviewId, fieldValues: List[ProductreviewFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow]
}