/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_init_privs

import adventureworks.TypoAclItem
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

object PgInitPrivsRepoImpl extends PgInitPrivsRepo {
  override def delete(compositeId: PgInitPrivsId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_init_privs where objoid = ${fromWrite(compositeId.objoid)(Write.fromPut(Meta.LongMeta.put))} AND classoid = ${fromWrite(compositeId.classoid)(Write.fromPut(Meta.LongMeta.put))} AND objsubid = ${fromWrite(compositeId.objsubid)(Write.fromPut(Meta.IntMeta.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgInitPrivsFields, PgInitPrivsRow] = {
    DeleteBuilder("pg_catalog.pg_init_privs", PgInitPrivsFields)
  }
  override def insert(unsaved: PgInitPrivsRow): ConnectionIO[PgInitPrivsRow] = {
    sql"""insert into pg_catalog.pg_init_privs(objoid, classoid, objsubid, privtype, initprivs)
          values (${fromWrite(unsaved.objoid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.classoid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.objsubid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.privtype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.initprivs)(Write.fromPut(TypoAclItem.arrayPut))}::_aclitem)
          returning objoid, classoid, objsubid, privtype, initprivs
       """.query(PgInitPrivsRow.read).unique
  }
  override def select: SelectBuilder[PgInitPrivsFields, PgInitPrivsRow] = {
    SelectBuilderSql("pg_catalog.pg_init_privs", PgInitPrivsFields, PgInitPrivsRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgInitPrivsRow] = {
    sql"select objoid, classoid, objsubid, privtype, initprivs from pg_catalog.pg_init_privs".query(PgInitPrivsRow.read).stream
  }
  override def selectById(compositeId: PgInitPrivsId): ConnectionIO[Option[PgInitPrivsRow]] = {
    sql"select objoid, classoid, objsubid, privtype, initprivs from pg_catalog.pg_init_privs where objoid = ${fromWrite(compositeId.objoid)(Write.fromPut(Meta.LongMeta.put))} AND classoid = ${fromWrite(compositeId.classoid)(Write.fromPut(Meta.LongMeta.put))} AND objsubid = ${fromWrite(compositeId.objsubid)(Write.fromPut(Meta.IntMeta.put))}".query(PgInitPrivsRow.read).option
  }
  override def update(row: PgInitPrivsRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_init_privs
          set privtype = ${fromWrite(row.privtype)(Write.fromPut(Meta.StringMeta.put))}::char,
              initprivs = ${fromWrite(row.initprivs)(Write.fromPut(TypoAclItem.arrayPut))}::_aclitem
          where objoid = ${fromWrite(compositeId.objoid)(Write.fromPut(Meta.LongMeta.put))} AND classoid = ${fromWrite(compositeId.classoid)(Write.fromPut(Meta.LongMeta.put))} AND objsubid = ${fromWrite(compositeId.objsubid)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgInitPrivsFields, PgInitPrivsRow] = {
    UpdateBuilder("pg_catalog.pg_init_privs", PgInitPrivsFields, PgInitPrivsRow.read)
  }
  override def upsert(unsaved: PgInitPrivsRow): ConnectionIO[PgInitPrivsRow] = {
    sql"""insert into pg_catalog.pg_init_privs(objoid, classoid, objsubid, privtype, initprivs)
          values (
            ${fromWrite(unsaved.objoid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.classoid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.objsubid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.privtype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.initprivs)(Write.fromPut(TypoAclItem.arrayPut))}::_aclitem
          )
          on conflict (objoid, classoid, objsubid)
          do update set
            privtype = EXCLUDED.privtype,
            initprivs = EXCLUDED.initprivs
          returning objoid, classoid, objsubid, privtype, initprivs
       """.query(PgInitPrivsRow.read).unique
  }
}
