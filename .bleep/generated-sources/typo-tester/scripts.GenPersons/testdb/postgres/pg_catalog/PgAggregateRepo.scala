package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAggregateRepo {
  def selectAll(implicit c: Connection): List[PgAggregateRow]
  def selectById(aggfnoid: PgAggregateId)(implicit c: Connection): Option[PgAggregateRow]
  def selectByIds(aggfnoids: List[PgAggregateId])(implicit c: Connection): List[PgAggregateRow]
  def selectByFieldValues(fieldValues: List[PgAggregateFieldValue[_]])(implicit c: Connection): List[PgAggregateRow]
  def updateFieldValues(aggfnoid: PgAggregateId, fieldValues: List[PgAggregateFieldValue[_]])(implicit c: Connection): Int
  def insert(aggfnoid: PgAggregateId, unsaved: PgAggregateRowUnsaved)(implicit c: Connection): Unit
  def delete(aggfnoid: PgAggregateId)(implicit c: Connection): Boolean
}
