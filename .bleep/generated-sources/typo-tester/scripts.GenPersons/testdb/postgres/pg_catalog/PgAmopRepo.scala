package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAmopRepo {
  def selectAll(implicit c: Connection): List[PgAmopRow]
  def selectById(oid: PgAmopId)(implicit c: Connection): Option[PgAmopRow]
  def selectByIds(oids: List[PgAmopId])(implicit c: Connection): List[PgAmopRow]
  def selectByFieldValues(fieldValues: List[PgAmopFieldValue[_]])(implicit c: Connection): List[PgAmopRow]
  def updateFieldValues(oid: PgAmopId, fieldValues: List[PgAmopFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgAmopId, unsaved: PgAmopRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgAmopId)(implicit c: Connection): Boolean
  def selectByUnique(amopfamily: Long, amoplefttype: Long, amoprighttype: Long, amopstrategy: Short)(implicit c: Connection): Option[PgAmopRow]
  def selectByUnique(amopopr: Long, amoppurpose: String, amopfamily: Long)(implicit c: Connection): Option[PgAmopRow]
}
