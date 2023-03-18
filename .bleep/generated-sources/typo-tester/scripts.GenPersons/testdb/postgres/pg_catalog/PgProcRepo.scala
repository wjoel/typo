package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgProcRepo {
  def selectAll(implicit c: Connection): List[PgProcRow]
  def selectById(oid: PgProcId)(implicit c: Connection): Option[PgProcRow]
  def selectByIds(oids: List[PgProcId])(implicit c: Connection): List[PgProcRow]
  def selectByFieldValues(fieldValues: List[PgProcFieldValue[_]])(implicit c: Connection): List[PgProcRow]
  def updateFieldValues(oid: PgProcId, fieldValues: List[PgProcFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgProcId, unsaved: PgProcRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgProcId)(implicit c: Connection): Boolean
  def selectByUnique(proname: String, proargtypes: String, pronamespace: Long)(implicit c: Connection): Option[PgProcRow]
}
