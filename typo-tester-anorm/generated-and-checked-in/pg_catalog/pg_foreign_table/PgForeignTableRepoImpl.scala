/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_table

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgForeignTableRepoImpl extends PgForeignTableRepo {
  override def delete(ftrelid: PgForeignTableId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_foreign_table where ftrelid = $ftrelid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgForeignTableFields, PgForeignTableRow] = {
    DeleteBuilder("pg_catalog.pg_foreign_table", PgForeignTableFields)
  }
  override def insert(unsaved: PgForeignTableRow)(implicit c: Connection): PgForeignTableRow = {
    SQL"""insert into pg_catalog.pg_foreign_table(ftrelid, ftserver, ftoptions)
          values (${unsaved.ftrelid}::oid, ${unsaved.ftserver}::oid, ${unsaved.ftoptions}::_text)
          returning ftrelid, ftserver, ftoptions
       """
      .executeInsert(PgForeignTableRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgForeignTableFields, PgForeignTableRow] = {
    SelectBuilderSql("pg_catalog.pg_foreign_table", PgForeignTableFields, PgForeignTableRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgForeignTableRow] = {
    SQL"""select ftrelid, ftserver, ftoptions
          from pg_catalog.pg_foreign_table
       """.as(PgForeignTableRow.rowParser(1).*)
  }
  override def selectById(ftrelid: PgForeignTableId)(implicit c: Connection): Option[PgForeignTableRow] = {
    SQL"""select ftrelid, ftserver, ftoptions
          from pg_catalog.pg_foreign_table
          where ftrelid = $ftrelid
       """.as(PgForeignTableRow.rowParser(1).singleOpt)
  }
  override def selectByIds(ftrelids: Array[PgForeignTableId])(implicit c: Connection): List[PgForeignTableRow] = {
    SQL"""select ftrelid, ftserver, ftoptions
          from pg_catalog.pg_foreign_table
          where ftrelid = ANY($ftrelids)
       """.as(PgForeignTableRow.rowParser(1).*)
    
  }
  override def update(row: PgForeignTableRow)(implicit c: Connection): Boolean = {
    val ftrelid = row.ftrelid
    SQL"""update pg_catalog.pg_foreign_table
          set ftserver = ${row.ftserver}::oid,
              ftoptions = ${row.ftoptions}::_text
          where ftrelid = $ftrelid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgForeignTableFields, PgForeignTableRow] = {
    UpdateBuilder("pg_catalog.pg_foreign_table", PgForeignTableFields, PgForeignTableRow.rowParser)
  }
  override def upsert(unsaved: PgForeignTableRow)(implicit c: Connection): PgForeignTableRow = {
    SQL"""insert into pg_catalog.pg_foreign_table(ftrelid, ftserver, ftoptions)
          values (
            ${unsaved.ftrelid}::oid,
            ${unsaved.ftserver}::oid,
            ${unsaved.ftoptions}::_text
          )
          on conflict (ftrelid)
          do update set
            ftserver = EXCLUDED.ftserver,
            ftoptions = EXCLUDED.ftoptions
          returning ftrelid, ftserver, ftoptions
       """
      .executeInsert(PgForeignTableRow.rowParser(1).single)
    
  }
}
