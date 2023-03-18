package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAuthidRepo {
  def selectAll(implicit c: Connection): List[PgAuthidRow]
  def selectById(oid: PgAuthidId)(implicit c: Connection): Option[PgAuthidRow]
  def selectByIds(oids: List[PgAuthidId])(implicit c: Connection): List[PgAuthidRow]
  def selectByFieldValues(fieldValues: List[PgAuthidFieldValue[_]])(implicit c: Connection): List[PgAuthidRow]
  def updateFieldValues(oid: PgAuthidId, fieldValues: List[PgAuthidFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgAuthidId, unsaved: PgAuthidRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgAuthidId)(implicit c: Connection): Boolean
  def selectByUnique(rolname: String)(implicit c: Connection): Option[PgAuthidRow]
}
