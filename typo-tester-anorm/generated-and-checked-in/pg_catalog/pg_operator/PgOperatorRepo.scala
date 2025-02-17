/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgOperatorRepo {
  def delete(oid: PgOperatorId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgOperatorFields, PgOperatorRow]
  def insert(unsaved: PgOperatorRow)(implicit c: Connection): PgOperatorRow
  def select: SelectBuilder[PgOperatorFields, PgOperatorRow]
  def selectAll(implicit c: Connection): List[PgOperatorRow]
  def selectById(oid: PgOperatorId)(implicit c: Connection): Option[PgOperatorRow]
  def selectByIds(oids: Array[PgOperatorId])(implicit c: Connection): List[PgOperatorRow]
  def update(row: PgOperatorRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgOperatorFields, PgOperatorRow]
  def upsert(unsaved: PgOperatorRow)(implicit c: Connection): PgOperatorRow
}
