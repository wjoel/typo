/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
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

object PgStatisticExtRepoImpl extends PgStatisticExtRepo {
  override def delete(oid: PgStatisticExtId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_statistic_ext where oid = ${fromWrite(oid)(Write.fromPut(PgStatisticExtId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgStatisticExtFields, PgStatisticExtRow] = {
    DeleteBuilder("pg_catalog.pg_statistic_ext", PgStatisticExtFields)
  }
  override def insert(unsaved: PgStatisticExtRow): ConnectionIO[PgStatisticExtRow] = {
    sql"""insert into pg_catalog.pg_statistic_ext(oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgStatisticExtId.put))}::oid, ${fromWrite(unsaved.stxrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stxname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.stxnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stxowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stxstattarget)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.stxkeys)(Write.fromPut(TypoInt2Vector.put))}::int2vector, ${fromWrite(unsaved.stxkind)(Write.fromPut(adventureworks.StringArrayMeta.put))}::_char, ${fromWrite(unsaved.stxexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree)
          returning oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs
       """.query(PgStatisticExtRow.read).unique
  }
  override def select: SelectBuilder[PgStatisticExtFields, PgStatisticExtRow] = {
    SelectBuilderSql("pg_catalog.pg_statistic_ext", PgStatisticExtFields, PgStatisticExtRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatisticExtRow] = {
    sql"select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext".query(PgStatisticExtRow.read).stream
  }
  override def selectById(oid: PgStatisticExtId): ConnectionIO[Option[PgStatisticExtRow]] = {
    sql"select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext where oid = ${fromWrite(oid)(Write.fromPut(PgStatisticExtId.put))}".query(PgStatisticExtRow.read).option
  }
  override def selectByIds(oids: Array[PgStatisticExtId]): Stream[ConnectionIO, PgStatisticExtRow] = {
    sql"select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext where oid = ANY(${fromWrite(oids)(Write.fromPut(PgStatisticExtId.arrayPut))})".query(PgStatisticExtRow.read).stream
  }
  override def update(row: PgStatisticExtRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_statistic_ext
          set stxrelid = ${fromWrite(row.stxrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stxname = ${fromWrite(row.stxname)(Write.fromPut(Meta.StringMeta.put))}::name,
              stxnamespace = ${fromWrite(row.stxnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stxowner = ${fromWrite(row.stxowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stxstattarget = ${fromWrite(row.stxstattarget)(Write.fromPut(Meta.IntMeta.put))}::int4,
              stxkeys = ${fromWrite(row.stxkeys)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
              stxkind = ${fromWrite(row.stxkind)(Write.fromPut(adventureworks.StringArrayMeta.put))}::_char,
              stxexprs = ${fromWrite(row.stxexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          where oid = ${fromWrite(oid)(Write.fromPut(PgStatisticExtId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgStatisticExtFields, PgStatisticExtRow] = {
    UpdateBuilder("pg_catalog.pg_statistic_ext", PgStatisticExtFields, PgStatisticExtRow.read)
  }
  override def upsert(unsaved: PgStatisticExtRow): ConnectionIO[PgStatisticExtRow] = {
    sql"""insert into pg_catalog.pg_statistic_ext(oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgStatisticExtId.put))}::oid,
            ${fromWrite(unsaved.stxrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stxname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.stxnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stxowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stxstattarget)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.stxkeys)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
            ${fromWrite(unsaved.stxkind)(Write.fromPut(adventureworks.StringArrayMeta.put))}::_char,
            ${fromWrite(unsaved.stxexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (oid)
          do update set
            stxrelid = EXCLUDED.stxrelid,
            stxname = EXCLUDED.stxname,
            stxnamespace = EXCLUDED.stxnamespace,
            stxowner = EXCLUDED.stxowner,
            stxstattarget = EXCLUDED.stxstattarget,
            stxkeys = EXCLUDED.stxkeys,
            stxkind = EXCLUDED.stxkind,
            stxexprs = EXCLUDED.stxexprs
          returning oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs
       """.query(PgStatisticExtRow.read).unique
  }
}
