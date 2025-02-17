/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_dict

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTsDictRepo {
  def delete(oid: PgTsDictId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgTsDictFields, PgTsDictRow]
  def insert(unsaved: PgTsDictRow): ConnectionIO[PgTsDictRow]
  def select: SelectBuilder[PgTsDictFields, PgTsDictRow]
  def selectAll: Stream[ConnectionIO, PgTsDictRow]
  def selectById(oid: PgTsDictId): ConnectionIO[Option[PgTsDictRow]]
  def selectByIds(oids: Array[PgTsDictId]): Stream[ConnectionIO, PgTsDictRow]
  def update(row: PgTsDictRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgTsDictFields, PgTsDictRow]
  def upsert(unsaved: PgTsDictRow): ConnectionIO[PgTsDictRow]
}
