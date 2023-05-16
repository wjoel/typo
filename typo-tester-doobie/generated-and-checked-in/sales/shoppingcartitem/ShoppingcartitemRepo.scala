/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait ShoppingcartitemRepo {
  def delete(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Boolean]
  def insert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow]
  def insert(unsaved: ShoppingcartitemRowUnsaved): ConnectionIO[ShoppingcartitemRow]
  def selectAll: Stream[ConnectionIO, ShoppingcartitemRow]
  def selectByFieldValues(fieldValues: List[ShoppingcartitemFieldOrIdValue[_]]): Stream[ConnectionIO, ShoppingcartitemRow]
  def selectById(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Option[ShoppingcartitemRow]]
  def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): Stream[ConnectionIO, ShoppingcartitemRow]
  def update(row: ShoppingcartitemRow): ConnectionIO[Boolean]
  def updateFieldValues(shoppingcartitemid: ShoppingcartitemId, fieldValues: List[ShoppingcartitemFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow]
}
