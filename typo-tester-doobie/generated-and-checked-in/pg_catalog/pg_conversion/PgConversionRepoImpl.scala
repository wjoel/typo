/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import adventureworks.TypoRegproc
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgConversionRepoImpl extends PgConversionRepo {
  override def delete(oid: PgConversionId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_conversion where oid = ${fromWrite(oid)(Write.fromPut(PgConversionId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgConversionRow): ConnectionIO[PgConversionRow] = {
    sql"""insert into pg_catalog.pg_conversion(oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgConversionId.put))}::oid, ${fromWrite(unsaved.conname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.connamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.conowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.conforencoding)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.contoencoding)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.conproc)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.condefault)(Write.fromPut(Meta.BooleanMeta.put))})
          returning oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
       """.query(PgConversionRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgConversionRow] = {
    sql"select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault from pg_catalog.pg_conversion".query(PgConversionRow.read).stream
  }
  override def selectById(oid: PgConversionId): ConnectionIO[Option[PgConversionRow]] = {
    sql"select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault from pg_catalog.pg_conversion where oid = ${fromWrite(oid)(Write.fromPut(PgConversionId.put))}".query(PgConversionRow.read).option
  }
  override def selectByIds(oids: Array[PgConversionId]): Stream[ConnectionIO, PgConversionRow] = {
    sql"select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault from pg_catalog.pg_conversion where oid = ANY(${fromWrite(oids)(Write.fromPut(PgConversionId.arrayPut))})".query(PgConversionRow.read).stream
  }
  override def update(row: PgConversionRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_conversion
          set conname = ${fromWrite(row.conname)(Write.fromPut(Meta.StringMeta.put))}::name,
              connamespace = ${fromWrite(row.connamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              conowner = ${fromWrite(row.conowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              conforencoding = ${fromWrite(row.conforencoding)(Write.fromPut(Meta.IntMeta.put))}::int4,
              contoencoding = ${fromWrite(row.contoencoding)(Write.fromPut(Meta.IntMeta.put))}::int4,
              conproc = ${fromWrite(row.conproc)(Write.fromPut(TypoRegproc.put))}::regproc,
              condefault = ${fromWrite(row.condefault)(Write.fromPut(Meta.BooleanMeta.put))}
          where oid = ${fromWrite(oid)(Write.fromPut(PgConversionId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgConversionRow): ConnectionIO[PgConversionRow] = {
    sql"""insert into pg_catalog.pg_conversion(oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgConversionId.put))}::oid,
            ${fromWrite(unsaved.conname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.connamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.conowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.conforencoding)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.contoencoding)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.conproc)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.condefault)(Write.fromPut(Meta.BooleanMeta.put))}
          )
          on conflict (oid)
          do update set
            conname = EXCLUDED.conname,
            connamespace = EXCLUDED.connamespace,
            conowner = EXCLUDED.conowner,
            conforencoding = EXCLUDED.conforencoding,
            contoencoding = EXCLUDED.contoencoding,
            conproc = EXCLUDED.conproc,
            condefault = EXCLUDED.condefault
          returning oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
       """.query(PgConversionRow.read).unique
  }
}
