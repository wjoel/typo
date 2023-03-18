package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgConversionRepo {
  def selectAll(implicit c: Connection): List[PgConversionRow]
  def selectById(oid: PgConversionId)(implicit c: Connection): Option[PgConversionRow]
  def selectByIds(oids: List[PgConversionId])(implicit c: Connection): List[PgConversionRow]
  def selectByFieldValues(fieldValues: List[PgConversionFieldValue[_]])(implicit c: Connection): List[PgConversionRow]
  def updateFieldValues(oid: PgConversionId, fieldValues: List[PgConversionFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgConversionId, unsaved: PgConversionRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgConversionId)(implicit c: Connection): Boolean
  def selectByUnique(connamespace: Long, conforencoding: Int, contoencoding: Int, oid: Long)(implicit c: Connection): Option[PgConversionRow]
  def selectByUnique(conname: String, connamespace: Long)(implicit c: Connection): Option[PgConversionRow]
}
