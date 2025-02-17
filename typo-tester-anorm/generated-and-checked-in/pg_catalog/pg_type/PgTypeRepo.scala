/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_type

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTypeRepo {
  def delete(oid: PgTypeId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgTypeFields, PgTypeRow]
  def insert(unsaved: PgTypeRow)(implicit c: Connection): PgTypeRow
  def select: SelectBuilder[PgTypeFields, PgTypeRow]
  def selectAll(implicit c: Connection): List[PgTypeRow]
  def selectById(oid: PgTypeId)(implicit c: Connection): Option[PgTypeRow]
  def selectByIds(oids: Array[PgTypeId])(implicit c: Connection): List[PgTypeRow]
  def update(row: PgTypeRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgTypeFields, PgTypeRow]
  def upsert(unsaved: PgTypeRow)(implicit c: Connection): PgTypeRow
}
