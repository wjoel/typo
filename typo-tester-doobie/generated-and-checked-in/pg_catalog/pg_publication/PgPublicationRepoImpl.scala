/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

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

object PgPublicationRepoImpl extends PgPublicationRepo {
  override def delete(oid: PgPublicationId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_publication where oid = ${fromWrite(oid)(Write.fromPut(PgPublicationId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow] = {
    DeleteBuilder("pg_catalog.pg_publication", PgPublicationFields)
  }
  override def insert(unsaved: PgPublicationRow): ConnectionIO[PgPublicationRow] = {
    sql"""insert into pg_catalog.pg_publication(oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgPublicationId.put))}::oid, ${fromWrite(unsaved.pubname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.pubowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.puballtables)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.pubinsert)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.pubupdate)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.pubdelete)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.pubtruncate)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.pubviaroot)(Write.fromPut(Meta.BooleanMeta.put))})
          returning oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
       """.query(PgPublicationRow.read).unique
  }
  override def select: SelectBuilder[PgPublicationFields, PgPublicationRow] = {
    SelectBuilderSql("pg_catalog.pg_publication", PgPublicationFields, PgPublicationRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgPublicationRow] = {
    sql"select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot from pg_catalog.pg_publication".query(PgPublicationRow.read).stream
  }
  override def selectById(oid: PgPublicationId): ConnectionIO[Option[PgPublicationRow]] = {
    sql"select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot from pg_catalog.pg_publication where oid = ${fromWrite(oid)(Write.fromPut(PgPublicationId.put))}".query(PgPublicationRow.read).option
  }
  override def selectByIds(oids: Array[PgPublicationId]): Stream[ConnectionIO, PgPublicationRow] = {
    sql"select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot from pg_catalog.pg_publication where oid = ANY(${fromWrite(oids)(Write.fromPut(PgPublicationId.arrayPut))})".query(PgPublicationRow.read).stream
  }
  override def update(row: PgPublicationRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_publication
          set pubname = ${fromWrite(row.pubname)(Write.fromPut(Meta.StringMeta.put))}::name,
              pubowner = ${fromWrite(row.pubowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              puballtables = ${fromWrite(row.puballtables)(Write.fromPut(Meta.BooleanMeta.put))},
              pubinsert = ${fromWrite(row.pubinsert)(Write.fromPut(Meta.BooleanMeta.put))},
              pubupdate = ${fromWrite(row.pubupdate)(Write.fromPut(Meta.BooleanMeta.put))},
              pubdelete = ${fromWrite(row.pubdelete)(Write.fromPut(Meta.BooleanMeta.put))},
              pubtruncate = ${fromWrite(row.pubtruncate)(Write.fromPut(Meta.BooleanMeta.put))},
              pubviaroot = ${fromWrite(row.pubviaroot)(Write.fromPut(Meta.BooleanMeta.put))}
          where oid = ${fromWrite(oid)(Write.fromPut(PgPublicationId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgPublicationFields, PgPublicationRow] = {
    UpdateBuilder("pg_catalog.pg_publication", PgPublicationFields, PgPublicationRow.read)
  }
  override def upsert(unsaved: PgPublicationRow): ConnectionIO[PgPublicationRow] = {
    sql"""insert into pg_catalog.pg_publication(oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgPublicationId.put))}::oid,
            ${fromWrite(unsaved.pubname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.pubowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.puballtables)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.pubinsert)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.pubupdate)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.pubdelete)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.pubtruncate)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.pubviaroot)(Write.fromPut(Meta.BooleanMeta.put))}
          )
          on conflict (oid)
          do update set
            pubname = EXCLUDED.pubname,
            pubowner = EXCLUDED.pubowner,
            puballtables = EXCLUDED.puballtables,
            pubinsert = EXCLUDED.pubinsert,
            pubupdate = EXCLUDED.pubupdate,
            pubdelete = EXCLUDED.pubdelete,
            pubtruncate = EXCLUDED.pubtruncate,
            pubviaroot = EXCLUDED.pubviaroot
          returning oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
       """.query(PgPublicationRow.read).unique
  }
}