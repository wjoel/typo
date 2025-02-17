/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_dict

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTsDictRepo {
  def delete(oid: PgTsDictId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgTsDictFields, PgTsDictRow]
  def insert(unsaved: PgTsDictRow)(implicit c: Connection): PgTsDictRow
  def select: SelectBuilder[PgTsDictFields, PgTsDictRow]
  def selectAll(implicit c: Connection): List[PgTsDictRow]
  def selectById(oid: PgTsDictId)(implicit c: Connection): Option[PgTsDictRow]
  def selectByIds(oids: Array[PgTsDictId])(implicit c: Connection): List[PgTsDictRow]
  def update(row: PgTsDictRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgTsDictFields, PgTsDictRow]
  def upsert(unsaved: PgTsDictRow)(implicit c: Connection): PgTsDictRow
}
