/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgInheritsRepoImpl extends PgInheritsRepo {
  override def delete(compositeId: PgInheritsId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_inherits where inhrelid = ${fromWrite(compositeId.inhrelid)(Write.fromPut(Meta.LongMeta.put))} AND inhseqno = ${fromWrite(compositeId.inhseqno)(Write.fromPut(Meta.IntMeta.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgInheritsFields, PgInheritsRow] = {
    DeleteBuilder("pg_catalog.pg_inherits", PgInheritsFields)
  }
  override def insert(unsaved: PgInheritsRow): ConnectionIO[PgInheritsRow] = {
    sql"""insert into pg_catalog.pg_inherits(inhrelid, inhparent, inhseqno, inhdetachpending)
          values (${fromWrite(unsaved.inhrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.inhparent)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.inhseqno)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.inhdetachpending)(Write.fromPut(Meta.BooleanMeta.put))})
          returning inhrelid, inhparent, inhseqno, inhdetachpending
       """.query(PgInheritsRow.read).unique
  }
  override def select: SelectBuilder[PgInheritsFields, PgInheritsRow] = {
    SelectBuilderSql("pg_catalog.pg_inherits", PgInheritsFields, PgInheritsRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgInheritsRow] = {
    sql"select inhrelid, inhparent, inhseqno, inhdetachpending from pg_catalog.pg_inherits".query(PgInheritsRow.read).stream
  }
  override def selectById(compositeId: PgInheritsId): ConnectionIO[Option[PgInheritsRow]] = {
    sql"select inhrelid, inhparent, inhseqno, inhdetachpending from pg_catalog.pg_inherits where inhrelid = ${fromWrite(compositeId.inhrelid)(Write.fromPut(Meta.LongMeta.put))} AND inhseqno = ${fromWrite(compositeId.inhseqno)(Write.fromPut(Meta.IntMeta.put))}".query(PgInheritsRow.read).option
  }
  override def update(row: PgInheritsRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_inherits
          set inhparent = ${fromWrite(row.inhparent)(Write.fromPut(Meta.LongMeta.put))}::oid,
              inhdetachpending = ${fromWrite(row.inhdetachpending)(Write.fromPut(Meta.BooleanMeta.put))}
          where inhrelid = ${fromWrite(compositeId.inhrelid)(Write.fromPut(Meta.LongMeta.put))} AND inhseqno = ${fromWrite(compositeId.inhseqno)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgInheritsFields, PgInheritsRow] = {
    UpdateBuilder("pg_catalog.pg_inherits", PgInheritsFields, PgInheritsRow.read)
  }
  override def upsert(unsaved: PgInheritsRow): ConnectionIO[PgInheritsRow] = {
    sql"""insert into pg_catalog.pg_inherits(inhrelid, inhparent, inhseqno, inhdetachpending)
          values (
            ${fromWrite(unsaved.inhrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.inhparent)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.inhseqno)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.inhdetachpending)(Write.fromPut(Meta.BooleanMeta.put))}
          )
          on conflict (inhrelid, inhseqno)
          do update set
            inhparent = EXCLUDED.inhparent,
            inhdetachpending = EXCLUDED.inhdetachpending
          returning inhrelid, inhparent, inhseqno, inhdetachpending
       """.query(PgInheritsRow.read).unique
  }
}
