package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgOpfamilyRepo {
  def selectAll(implicit c: Connection): List[PgOpfamilyRow]
  def selectById(oid: PgOpfamilyId)(implicit c: Connection): Option[PgOpfamilyRow]
  def selectByIds(oids: List[PgOpfamilyId])(implicit c: Connection): List[PgOpfamilyRow]
  def selectByFieldValues(fieldValues: List[PgOpfamilyFieldValue[_]])(implicit c: Connection): List[PgOpfamilyRow]
  def updateFieldValues(oid: PgOpfamilyId, fieldValues: List[PgOpfamilyFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgOpfamilyId, unsaved: PgOpfamilyRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgOpfamilyId)(implicit c: Connection): Boolean
  def selectByUnique(opfmethod: Long, opfname: String, opfnamespace: Long)(implicit c: Connection): Option[PgOpfamilyRow]
}
