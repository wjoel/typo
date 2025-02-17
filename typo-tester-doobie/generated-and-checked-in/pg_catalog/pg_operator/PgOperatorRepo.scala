/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgOperatorRepo {
  def delete(oid: PgOperatorId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgOperatorFields, PgOperatorRow]
  def insert(unsaved: PgOperatorRow): ConnectionIO[PgOperatorRow]
  def select: SelectBuilder[PgOperatorFields, PgOperatorRow]
  def selectAll: Stream[ConnectionIO, PgOperatorRow]
  def selectById(oid: PgOperatorId): ConnectionIO[Option[PgOperatorRow]]
  def selectByIds(oids: Array[PgOperatorId]): Stream[ConnectionIO, PgOperatorRow]
  def update(row: PgOperatorRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgOperatorFields, PgOperatorRow]
  def upsert(unsaved: PgOperatorRow): ConnectionIO[PgOperatorRow]
}
