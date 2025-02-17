/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

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

object PgShdescriptionRepoImpl extends PgShdescriptionRepo {
  override def delete(compositeId: PgShdescriptionId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_shdescription where objoid = ${fromWrite(compositeId.objoid)(Write.fromPut(Meta.LongMeta.put))} AND classoid = ${fromWrite(compositeId.classoid)(Write.fromPut(Meta.LongMeta.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgShdescriptionFields, PgShdescriptionRow] = {
    DeleteBuilder("pg_catalog.pg_shdescription", PgShdescriptionFields)
  }
  override def insert(unsaved: PgShdescriptionRow): ConnectionIO[PgShdescriptionRow] = {
    sql"""insert into pg_catalog.pg_shdescription(objoid, classoid, description)
          values (${fromWrite(unsaved.objoid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.classoid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))})
          returning objoid, classoid, description
       """.query(PgShdescriptionRow.read).unique
  }
  override def select: SelectBuilder[PgShdescriptionFields, PgShdescriptionRow] = {
    SelectBuilderSql("pg_catalog.pg_shdescription", PgShdescriptionFields, PgShdescriptionRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgShdescriptionRow] = {
    sql"select objoid, classoid, description from pg_catalog.pg_shdescription".query(PgShdescriptionRow.read).stream
  }
  override def selectById(compositeId: PgShdescriptionId): ConnectionIO[Option[PgShdescriptionRow]] = {
    sql"select objoid, classoid, description from pg_catalog.pg_shdescription where objoid = ${fromWrite(compositeId.objoid)(Write.fromPut(Meta.LongMeta.put))} AND classoid = ${fromWrite(compositeId.classoid)(Write.fromPut(Meta.LongMeta.put))}".query(PgShdescriptionRow.read).option
  }
  override def update(row: PgShdescriptionRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_shdescription
          set description = ${fromWrite(row.description)(Write.fromPut(Meta.StringMeta.put))}
          where objoid = ${fromWrite(compositeId.objoid)(Write.fromPut(Meta.LongMeta.put))} AND classoid = ${fromWrite(compositeId.classoid)(Write.fromPut(Meta.LongMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgShdescriptionFields, PgShdescriptionRow] = {
    UpdateBuilder("pg_catalog.pg_shdescription", PgShdescriptionFields, PgShdescriptionRow.read)
  }
  override def upsert(unsaved: PgShdescriptionRow): ConnectionIO[PgShdescriptionRow] = {
    sql"""insert into pg_catalog.pg_shdescription(objoid, classoid, description)
          values (
            ${fromWrite(unsaved.objoid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.classoid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}
          )
          on conflict (objoid, classoid)
          do update set
            description = EXCLUDED.description
          returning objoid, classoid, description
       """.query(PgShdescriptionRow.read).unique
  }
}
