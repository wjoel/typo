/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait ContacttypeRepo {
  def delete(contacttypeid: ContacttypeId): ConnectionIO[Boolean]
  def insert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow]
  def insert(unsaved: ContacttypeRowUnsaved): ConnectionIO[ContacttypeRow]
  def selectAll: Stream[ConnectionIO, ContacttypeRow]
  def selectByFieldValues(fieldValues: List[ContacttypeFieldOrIdValue[_]]): Stream[ConnectionIO, ContacttypeRow]
  def selectById(contacttypeid: ContacttypeId): ConnectionIO[Option[ContacttypeRow]]
  def selectByIds(contacttypeids: Array[ContacttypeId]): Stream[ConnectionIO, ContacttypeRow]
  def update(row: ContacttypeRow): ConnectionIO[Boolean]
  def updateFieldValues(contacttypeid: ContacttypeId, fieldValues: List[ContacttypeFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow]
}
