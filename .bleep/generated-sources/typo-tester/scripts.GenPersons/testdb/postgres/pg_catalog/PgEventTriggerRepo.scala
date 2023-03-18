package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgEventTriggerRepo {
  def selectAll(implicit c: Connection): List[PgEventTriggerRow]
  def selectById(oid: PgEventTriggerId)(implicit c: Connection): Option[PgEventTriggerRow]
  def selectByIds(oids: List[PgEventTriggerId])(implicit c: Connection): List[PgEventTriggerRow]
  def selectByFieldValues(fieldValues: List[PgEventTriggerFieldValue[_]])(implicit c: Connection): List[PgEventTriggerRow]
  def updateFieldValues(oid: PgEventTriggerId, fieldValues: List[PgEventTriggerFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgEventTriggerId, unsaved: PgEventTriggerRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgEventTriggerId)(implicit c: Connection): Boolean
  def selectByUnique(evtname: String)(implicit c: Connection): Option[PgEventTriggerRow]
}
