package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgLargeobjectRepo {
  def selectAll(implicit c: Connection): List[PgLargeobjectRow]
  def selectById(compositeId: PgLargeobjectId)(implicit c: Connection): Option[PgLargeobjectRow]
  def selectByFieldValues(fieldValues: List[PgLargeobjectFieldValue[_]])(implicit c: Connection): List[PgLargeobjectRow]
  def updateFieldValues(compositeId: PgLargeobjectId, fieldValues: List[PgLargeobjectFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgLargeobjectId, unsaved: PgLargeobjectRowUnsaved)(implicit c: Connection): Unit
  def delete(compositeId: PgLargeobjectId)(implicit c: Connection): Boolean
}
