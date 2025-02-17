/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opfamily

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

object PgOpfamilyRepoImpl extends PgOpfamilyRepo {
  override def delete(oid: PgOpfamilyId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_opfamily where oid = ${fromWrite(oid)(Write.fromPut(PgOpfamilyId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    DeleteBuilder("pg_catalog.pg_opfamily", PgOpfamilyFields)
  }
  override def insert(unsaved: PgOpfamilyRow): ConnectionIO[PgOpfamilyRow] = {
    sql"""insert into pg_catalog.pg_opfamily(oid, opfmethod, opfname, opfnamespace, opfowner)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgOpfamilyId.put))}::oid, ${fromWrite(unsaved.opfmethod)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.opfname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.opfnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.opfowner)(Write.fromPut(Meta.LongMeta.put))}::oid)
          returning oid, opfmethod, opfname, opfnamespace, opfowner
       """.query(PgOpfamilyRow.read).unique
  }
  override def select: SelectBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    SelectBuilderSql("pg_catalog.pg_opfamily", PgOpfamilyFields, PgOpfamilyRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgOpfamilyRow] = {
    sql"select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily".query(PgOpfamilyRow.read).stream
  }
  override def selectById(oid: PgOpfamilyId): ConnectionIO[Option[PgOpfamilyRow]] = {
    sql"select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily where oid = ${fromWrite(oid)(Write.fromPut(PgOpfamilyId.put))}".query(PgOpfamilyRow.read).option
  }
  override def selectByIds(oids: Array[PgOpfamilyId]): Stream[ConnectionIO, PgOpfamilyRow] = {
    sql"select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily where oid = ANY(${fromWrite(oids)(Write.fromPut(PgOpfamilyId.arrayPut))})".query(PgOpfamilyRow.read).stream
  }
  override def update(row: PgOpfamilyRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_opfamily
          set opfmethod = ${fromWrite(row.opfmethod)(Write.fromPut(Meta.LongMeta.put))}::oid,
              opfname = ${fromWrite(row.opfname)(Write.fromPut(Meta.StringMeta.put))}::name,
              opfnamespace = ${fromWrite(row.opfnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              opfowner = ${fromWrite(row.opfowner)(Write.fromPut(Meta.LongMeta.put))}::oid
          where oid = ${fromWrite(oid)(Write.fromPut(PgOpfamilyId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    UpdateBuilder("pg_catalog.pg_opfamily", PgOpfamilyFields, PgOpfamilyRow.read)
  }
  override def upsert(unsaved: PgOpfamilyRow): ConnectionIO[PgOpfamilyRow] = {
    sql"""insert into pg_catalog.pg_opfamily(oid, opfmethod, opfname, opfnamespace, opfowner)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgOpfamilyId.put))}::oid,
            ${fromWrite(unsaved.opfmethod)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.opfname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.opfnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.opfowner)(Write.fromPut(Meta.LongMeta.put))}::oid
          )
          on conflict (oid)
          do update set
            opfmethod = EXCLUDED.opfmethod,
            opfname = EXCLUDED.opfname,
            opfnamespace = EXCLUDED.opfnamespace,
            opfowner = EXCLUDED.opfowner
          returning oid, opfmethod, opfname, opfnamespace, opfowner
       """.query(PgOpfamilyRow.read).unique
  }
}
