/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgSequenceRepoImpl extends PgSequenceRepo {
  override def delete(seqrelid: PgSequenceId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_sequence where seqrelid = ${fromWrite(seqrelid)(Write.fromPut(PgSequenceId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgSequenceRow): ConnectionIO[PgSequenceRow] = {
    sql"""insert into pg_catalog.pg_sequence(seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle)
          values (${fromWrite(unsaved.seqrelid)(Write.fromPut(PgSequenceId.put))}::oid, ${fromWrite(unsaved.seqtypid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.seqstart)(Write.fromPut(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.seqincrement)(Write.fromPut(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.seqmax)(Write.fromPut(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.seqmin)(Write.fromPut(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.seqcache)(Write.fromPut(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.seqcycle)(Write.fromPut(Meta.BooleanMeta.put))})
          returning seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
       """.query(PgSequenceRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgSequenceRow] = {
    sql"select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle from pg_catalog.pg_sequence".query(PgSequenceRow.read).stream
  }
  override def selectById(seqrelid: PgSequenceId): ConnectionIO[Option[PgSequenceRow]] = {
    sql"select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle from pg_catalog.pg_sequence where seqrelid = ${fromWrite(seqrelid)(Write.fromPut(PgSequenceId.put))}".query(PgSequenceRow.read).option
  }
  override def selectByIds(seqrelids: Array[PgSequenceId]): Stream[ConnectionIO, PgSequenceRow] = {
    sql"select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle from pg_catalog.pg_sequence where seqrelid = ANY(${fromWrite(seqrelids)(Write.fromPut(PgSequenceId.arrayPut))})".query(PgSequenceRow.read).stream
  }
  override def update(row: PgSequenceRow): ConnectionIO[Boolean] = {
    val seqrelid = row.seqrelid
    sql"""update pg_catalog.pg_sequence
          set seqtypid = ${fromWrite(row.seqtypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              seqstart = ${fromWrite(row.seqstart)(Write.fromPut(Meta.LongMeta.put))}::int8,
              seqincrement = ${fromWrite(row.seqincrement)(Write.fromPut(Meta.LongMeta.put))}::int8,
              seqmax = ${fromWrite(row.seqmax)(Write.fromPut(Meta.LongMeta.put))}::int8,
              seqmin = ${fromWrite(row.seqmin)(Write.fromPut(Meta.LongMeta.put))}::int8,
              seqcache = ${fromWrite(row.seqcache)(Write.fromPut(Meta.LongMeta.put))}::int8,
              seqcycle = ${fromWrite(row.seqcycle)(Write.fromPut(Meta.BooleanMeta.put))}
          where seqrelid = ${fromWrite(seqrelid)(Write.fromPut(PgSequenceId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgSequenceRow): ConnectionIO[PgSequenceRow] = {
    sql"""insert into pg_catalog.pg_sequence(seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle)
          values (
            ${fromWrite(unsaved.seqrelid)(Write.fromPut(PgSequenceId.put))}::oid,
            ${fromWrite(unsaved.seqtypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.seqstart)(Write.fromPut(Meta.LongMeta.put))}::int8,
            ${fromWrite(unsaved.seqincrement)(Write.fromPut(Meta.LongMeta.put))}::int8,
            ${fromWrite(unsaved.seqmax)(Write.fromPut(Meta.LongMeta.put))}::int8,
            ${fromWrite(unsaved.seqmin)(Write.fromPut(Meta.LongMeta.put))}::int8,
            ${fromWrite(unsaved.seqcache)(Write.fromPut(Meta.LongMeta.put))}::int8,
            ${fromWrite(unsaved.seqcycle)(Write.fromPut(Meta.BooleanMeta.put))}
          )
          on conflict (seqrelid)
          do update set
            seqtypid = EXCLUDED.seqtypid,
            seqstart = EXCLUDED.seqstart,
            seqincrement = EXCLUDED.seqincrement,
            seqmax = EXCLUDED.seqmax,
            seqmin = EXCLUDED.seqmin,
            seqcache = EXCLUDED.seqcache,
            seqcycle = EXCLUDED.seqcycle
          returning seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
       """.query(PgSequenceRow.read).unique
  }
}
