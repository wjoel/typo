package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAmprocRepo {
  def selectAll(implicit c: Connection): List[PgAmprocRow]
  def selectById(oid: PgAmprocId)(implicit c: Connection): Option[PgAmprocRow]
  def selectByIds(oids: List[PgAmprocId])(implicit c: Connection): List[PgAmprocRow]
  def selectByFieldValues(fieldValues: List[PgAmprocFieldValue[_]])(implicit c: Connection): List[PgAmprocRow]
  def updateFieldValues(oid: PgAmprocId, fieldValues: List[PgAmprocFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgAmprocId, unsaved: PgAmprocRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgAmprocId)(implicit c: Connection): Boolean
  def selectByUnique(amprocfamily: Long, amproclefttype: Long, amprocrighttype: Long, amprocnum: Short)(implicit c: Connection): Option[PgAmprocRow]
}
