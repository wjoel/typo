/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgDatabaseRepo {
  def delete(oid: PgDatabaseId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgDatabaseFields, PgDatabaseRow]
  def insert(unsaved: PgDatabaseRow): ConnectionIO[PgDatabaseRow]
  def select: SelectBuilder[PgDatabaseFields, PgDatabaseRow]
  def selectAll: Stream[ConnectionIO, PgDatabaseRow]
  def selectById(oid: PgDatabaseId): ConnectionIO[Option[PgDatabaseRow]]
  def selectByIds(oids: Array[PgDatabaseId]): Stream[ConnectionIO, PgDatabaseRow]
  def update(row: PgDatabaseRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgDatabaseFields, PgDatabaseRow]
  def upsert(unsaved: PgDatabaseRow): ConnectionIO[PgDatabaseRow]
}
