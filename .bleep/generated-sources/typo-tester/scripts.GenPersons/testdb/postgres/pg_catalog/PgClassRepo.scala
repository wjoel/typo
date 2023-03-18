package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgClassRepo {
  def selectAll(implicit c: Connection): List[PgClassRow]
  def selectById(oid: PgClassId)(implicit c: Connection): Option[PgClassRow]
  def selectByIds(oids: List[PgClassId])(implicit c: Connection): List[PgClassRow]
  def selectByFieldValues(fieldValues: List[PgClassFieldValue[_]])(implicit c: Connection): List[PgClassRow]
  def updateFieldValues(oid: PgClassId, fieldValues: List[PgClassFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgClassId, unsaved: PgClassRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgClassId)(implicit c: Connection): Boolean
  def selectByUnique(relname: String, relnamespace: Long)(implicit c: Connection): Option[PgClassRow]
}
