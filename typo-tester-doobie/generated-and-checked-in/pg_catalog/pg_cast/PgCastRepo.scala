/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgCastRepo {
  def delete(oid: PgCastId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgCastFields, PgCastRow]
  def insert(unsaved: PgCastRow): ConnectionIO[PgCastRow]
  def select: SelectBuilder[PgCastFields, PgCastRow]
  def selectAll: Stream[ConnectionIO, PgCastRow]
  def selectById(oid: PgCastId): ConnectionIO[Option[PgCastRow]]
  def selectByIds(oids: Array[PgCastId]): Stream[ConnectionIO, PgCastRow]
  def update(row: PgCastRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgCastFields, PgCastRow]
  def upsert(unsaved: PgCastRow): ConnectionIO[PgCastRow]
}
