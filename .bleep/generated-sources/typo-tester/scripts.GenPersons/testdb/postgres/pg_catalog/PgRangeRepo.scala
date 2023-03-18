package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgRangeRepo {
  def selectAll(implicit c: Connection): List[PgRangeRow]
  def selectById(rngtypid: PgRangeId)(implicit c: Connection): Option[PgRangeRow]
  def selectByIds(rngtypids: List[PgRangeId])(implicit c: Connection): List[PgRangeRow]
  def selectByFieldValues(fieldValues: List[PgRangeFieldValue[_]])(implicit c: Connection): List[PgRangeRow]
  def updateFieldValues(rngtypid: PgRangeId, fieldValues: List[PgRangeFieldValue[_]])(implicit c: Connection): Int
  def insert(rngtypid: PgRangeId, unsaved: PgRangeRowUnsaved)(implicit c: Connection): Unit
  def delete(rngtypid: PgRangeId)(implicit c: Connection): Boolean
  def selectByUnique(rngmultitypid: Long)(implicit c: Connection): Option[PgRangeRow]
}
