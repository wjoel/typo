/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgClassRepo {
  def delete(oid: PgClassId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgClassFields, PgClassRow]
  def insert(unsaved: PgClassRow)(implicit c: Connection): PgClassRow
  def select: SelectBuilder[PgClassFields, PgClassRow]
  def selectAll(implicit c: Connection): List[PgClassRow]
  def selectById(oid: PgClassId)(implicit c: Connection): Option[PgClassRow]
  def selectByIds(oids: Array[PgClassId])(implicit c: Connection): List[PgClassRow]
  def update(row: PgClassRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgClassFields, PgClassRow]
  def upsert(unsaved: PgClassRow)(implicit c: Connection): PgClassRow
}
