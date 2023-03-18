package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAttributeRepo {
  def selectAll(implicit c: Connection): List[PgAttributeRow]
  def selectById(compositeId: PgAttributeId)(implicit c: Connection): Option[PgAttributeRow]
  def selectByFieldValues(fieldValues: List[PgAttributeFieldValue[_]])(implicit c: Connection): List[PgAttributeRow]
  def updateFieldValues(compositeId: PgAttributeId, fieldValues: List[PgAttributeFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgAttributeId, unsaved: PgAttributeRowUnsaved)(implicit c: Connection): Unit
  def delete(compositeId: PgAttributeId)(implicit c: Connection): Boolean
  def selectByUnique(attrelid: Long, attname: String)(implicit c: Connection): Option[PgAttributeRow]
}
