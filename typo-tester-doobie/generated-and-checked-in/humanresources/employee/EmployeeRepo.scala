/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream

trait EmployeeRepo {
  def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def insert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow]
  def insert(unsaved: EmployeeRowUnsaved): ConnectionIO[EmployeeRow]
  def selectAll: Stream[ConnectionIO, EmployeeRow]
  def selectByFieldValues(fieldValues: List[EmployeeFieldOrIdValue[_]]): Stream[ConnectionIO, EmployeeRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[EmployeeRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, EmployeeRow]
  def update(row: EmployeeRow): ConnectionIO[Boolean]
  def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[EmployeeFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow]
}
