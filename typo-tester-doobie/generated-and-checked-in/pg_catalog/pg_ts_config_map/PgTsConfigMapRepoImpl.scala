/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config_map

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

object PgTsConfigMapRepoImpl extends PgTsConfigMapRepo {
  override def delete(compositeId: PgTsConfigMapId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_ts_config_map where mapcfg = ${fromWrite(compositeId.mapcfg)(Write.fromPut(Meta.LongMeta.put))} AND maptokentype = ${fromWrite(compositeId.maptokentype)(Write.fromPut(Meta.IntMeta.put))} AND mapseqno = ${fromWrite(compositeId.mapseqno)(Write.fromPut(Meta.IntMeta.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgTsConfigMapFields, PgTsConfigMapRow] = {
    DeleteBuilder("pg_catalog.pg_ts_config_map", PgTsConfigMapFields)
  }
  override def insert(unsaved: PgTsConfigMapRow): ConnectionIO[PgTsConfigMapRow] = {
    sql"""insert into pg_catalog.pg_ts_config_map(mapcfg, maptokentype, mapseqno, mapdict)
          values (${fromWrite(unsaved.mapcfg)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.maptokentype)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.mapseqno)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.mapdict)(Write.fromPut(Meta.LongMeta.put))}::oid)
          returning mapcfg, maptokentype, mapseqno, mapdict
       """.query(PgTsConfigMapRow.read).unique
  }
  override def select: SelectBuilder[PgTsConfigMapFields, PgTsConfigMapRow] = {
    SelectBuilderSql("pg_catalog.pg_ts_config_map", PgTsConfigMapFields, PgTsConfigMapRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgTsConfigMapRow] = {
    sql"select mapcfg, maptokentype, mapseqno, mapdict from pg_catalog.pg_ts_config_map".query(PgTsConfigMapRow.read).stream
  }
  override def selectById(compositeId: PgTsConfigMapId): ConnectionIO[Option[PgTsConfigMapRow]] = {
    sql"select mapcfg, maptokentype, mapseqno, mapdict from pg_catalog.pg_ts_config_map where mapcfg = ${fromWrite(compositeId.mapcfg)(Write.fromPut(Meta.LongMeta.put))} AND maptokentype = ${fromWrite(compositeId.maptokentype)(Write.fromPut(Meta.IntMeta.put))} AND mapseqno = ${fromWrite(compositeId.mapseqno)(Write.fromPut(Meta.IntMeta.put))}".query(PgTsConfigMapRow.read).option
  }
  override def update(row: PgTsConfigMapRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_ts_config_map
          set mapdict = ${fromWrite(row.mapdict)(Write.fromPut(Meta.LongMeta.put))}::oid
          where mapcfg = ${fromWrite(compositeId.mapcfg)(Write.fromPut(Meta.LongMeta.put))} AND maptokentype = ${fromWrite(compositeId.maptokentype)(Write.fromPut(Meta.IntMeta.put))} AND mapseqno = ${fromWrite(compositeId.mapseqno)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgTsConfigMapFields, PgTsConfigMapRow] = {
    UpdateBuilder("pg_catalog.pg_ts_config_map", PgTsConfigMapFields, PgTsConfigMapRow.read)
  }
  override def upsert(unsaved: PgTsConfigMapRow): ConnectionIO[PgTsConfigMapRow] = {
    sql"""insert into pg_catalog.pg_ts_config_map(mapcfg, maptokentype, mapseqno, mapdict)
          values (
            ${fromWrite(unsaved.mapcfg)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.maptokentype)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.mapseqno)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.mapdict)(Write.fromPut(Meta.LongMeta.put))}::oid
          )
          on conflict (mapcfg, maptokentype, mapseqno)
          do update set
            mapdict = EXCLUDED.mapdict
          returning mapcfg, maptokentype, mapseqno, mapdict
       """.query(PgTsConfigMapRow.read).unique
  }
}
