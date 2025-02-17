/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

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

object PgDbRoleSettingRepoImpl extends PgDbRoleSettingRepo {
  override def delete(compositeId: PgDbRoleSettingId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_db_role_setting where setdatabase = ${fromWrite(compositeId.setdatabase)(Write.fromPut(Meta.LongMeta.put))} AND setrole = ${fromWrite(compositeId.setrole)(Write.fromPut(Meta.LongMeta.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgDbRoleSettingFields, PgDbRoleSettingRow] = {
    DeleteBuilder("pg_catalog.pg_db_role_setting", PgDbRoleSettingFields)
  }
  override def insert(unsaved: PgDbRoleSettingRow): ConnectionIO[PgDbRoleSettingRow] = {
    sql"""insert into pg_catalog.pg_db_role_setting(setdatabase, setrole, setconfig)
          values (${fromWrite(unsaved.setdatabase)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.setrole)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.setconfig)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text)
          returning setdatabase, setrole, setconfig
       """.query(PgDbRoleSettingRow.read).unique
  }
  override def select: SelectBuilder[PgDbRoleSettingFields, PgDbRoleSettingRow] = {
    SelectBuilderSql("pg_catalog.pg_db_role_setting", PgDbRoleSettingFields, PgDbRoleSettingRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgDbRoleSettingRow] = {
    sql"select setdatabase, setrole, setconfig from pg_catalog.pg_db_role_setting".query(PgDbRoleSettingRow.read).stream
  }
  override def selectById(compositeId: PgDbRoleSettingId): ConnectionIO[Option[PgDbRoleSettingRow]] = {
    sql"select setdatabase, setrole, setconfig from pg_catalog.pg_db_role_setting where setdatabase = ${fromWrite(compositeId.setdatabase)(Write.fromPut(Meta.LongMeta.put))} AND setrole = ${fromWrite(compositeId.setrole)(Write.fromPut(Meta.LongMeta.put))}".query(PgDbRoleSettingRow.read).option
  }
  override def update(row: PgDbRoleSettingRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_db_role_setting
          set setconfig = ${fromWrite(row.setconfig)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          where setdatabase = ${fromWrite(compositeId.setdatabase)(Write.fromPut(Meta.LongMeta.put))} AND setrole = ${fromWrite(compositeId.setrole)(Write.fromPut(Meta.LongMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgDbRoleSettingFields, PgDbRoleSettingRow] = {
    UpdateBuilder("pg_catalog.pg_db_role_setting", PgDbRoleSettingFields, PgDbRoleSettingRow.read)
  }
  override def upsert(unsaved: PgDbRoleSettingRow): ConnectionIO[PgDbRoleSettingRow] = {
    sql"""insert into pg_catalog.pg_db_role_setting(setdatabase, setrole, setconfig)
          values (
            ${fromWrite(unsaved.setdatabase)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.setrole)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.setconfig)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          )
          on conflict (setdatabase, setrole)
          do update set
            setconfig = EXCLUDED.setconfig
          returning setdatabase, setrole, setconfig
       """.query(PgDbRoleSettingRow.read).unique
  }
}
