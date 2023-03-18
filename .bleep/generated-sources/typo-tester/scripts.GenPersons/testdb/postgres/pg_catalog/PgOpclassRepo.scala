package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgOpclassRepo {
  def selectAll(implicit c: Connection): List[PgOpclassRow]
  def selectById(oid: PgOpclassId)(implicit c: Connection): Option[PgOpclassRow]
  def selectByIds(oids: List[PgOpclassId])(implicit c: Connection): List[PgOpclassRow]
  def selectByFieldValues(fieldValues: List[PgOpclassFieldValue[_]])(implicit c: Connection): List[PgOpclassRow]
  def updateFieldValues(oid: PgOpclassId, fieldValues: List[PgOpclassFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgOpclassId, unsaved: PgOpclassRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgOpclassId)(implicit c: Connection): Boolean
  def selectByUnique(opcmethod: Long, opcname: String, opcnamespace: Long)(implicit c: Connection): Option[PgOpclassRow]
}
