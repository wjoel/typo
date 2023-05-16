/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream

trait SalespersonRepo {
  def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def insert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow]
  def insert(unsaved: SalespersonRowUnsaved): ConnectionIO[SalespersonRow]
  def selectAll: Stream[ConnectionIO, SalespersonRow]
  def selectByFieldValues(fieldValues: List[SalespersonFieldOrIdValue[_]]): Stream[ConnectionIO, SalespersonRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[SalespersonRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, SalespersonRow]
  def update(row: SalespersonRow): ConnectionIO[Boolean]
  def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[SalespersonFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow]
}
