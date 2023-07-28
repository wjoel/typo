/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_table

import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgForeignTableRepoImpl extends PgForeignTableRepo {
  override def delete(ftrelid: PgForeignTableId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_foreign_table where ftrelid = ${fromWrite(ftrelid)(Write.fromPut(PgForeignTableId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgForeignTableRow): ConnectionIO[PgForeignTableRow] = {
    sql"""insert into pg_catalog.pg_foreign_table(ftrelid, ftserver, ftoptions)
          values (${fromWrite(unsaved.ftrelid)(Write.fromPut(PgForeignTableId.put))}::oid, ${fromWrite(unsaved.ftserver)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.ftoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text)
          returning ftrelid, ftserver, ftoptions
       """.query(PgForeignTableRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgForeignTableRow] = {
    sql"select ftrelid, ftserver, ftoptions from pg_catalog.pg_foreign_table".query(PgForeignTableRow.read).stream
  }
  override def selectById(ftrelid: PgForeignTableId): ConnectionIO[Option[PgForeignTableRow]] = {
    sql"select ftrelid, ftserver, ftoptions from pg_catalog.pg_foreign_table where ftrelid = ${fromWrite(ftrelid)(Write.fromPut(PgForeignTableId.put))}".query(PgForeignTableRow.read).option
  }
  override def selectByIds(ftrelids: Array[PgForeignTableId]): Stream[ConnectionIO, PgForeignTableRow] = {
    sql"select ftrelid, ftserver, ftoptions from pg_catalog.pg_foreign_table where ftrelid = ANY(${fromWrite(ftrelids)(Write.fromPut(PgForeignTableId.arrayPut))})".query(PgForeignTableRow.read).stream
  }
  override def update(row: PgForeignTableRow): ConnectionIO[Boolean] = {
    val ftrelid = row.ftrelid
    sql"""update pg_catalog.pg_foreign_table
          set ftserver = ${fromWrite(row.ftserver)(Write.fromPut(Meta.LongMeta.put))}::oid,
              ftoptions = ${fromWrite(row.ftoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          where ftrelid = ${fromWrite(ftrelid)(Write.fromPut(PgForeignTableId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgForeignTableRow): ConnectionIO[PgForeignTableRow] = {
    sql"""insert into pg_catalog.pg_foreign_table(ftrelid, ftserver, ftoptions)
          values (
            ${fromWrite(unsaved.ftrelid)(Write.fromPut(PgForeignTableId.put))}::oid,
            ${fromWrite(unsaved.ftserver)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.ftoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          )
          on conflict (ftrelid)
          do update set
            ftserver = EXCLUDED.ftserver,
            ftoptions = EXCLUDED.ftoptions
          returning ftrelid, ftserver, ftoptions
       """.query(PgForeignTableRow.read).unique
  }
}
