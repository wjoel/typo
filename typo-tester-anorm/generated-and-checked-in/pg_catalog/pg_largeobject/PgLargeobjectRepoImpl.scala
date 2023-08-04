/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgLargeobjectRepoImpl extends PgLargeobjectRepo {
  override def delete(compositeId: PgLargeobjectId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_largeobject where loid = ${compositeId.loid} AND pageno = ${compositeId.pageno}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgLargeobjectFields, PgLargeobjectRow] = {
    DeleteBuilder("pg_catalog.pg_largeobject", PgLargeobjectFields)
  }
  override def insert(unsaved: PgLargeobjectRow)(implicit c: Connection): PgLargeobjectRow = {
    SQL"""insert into pg_catalog.pg_largeobject(loid, pageno, "data")
          values (${unsaved.loid}::oid, ${unsaved.pageno}::int4, ${unsaved.data}::bytea)
          returning loid, pageno, "data"
       """
      .executeInsert(PgLargeobjectRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgLargeobjectFields, PgLargeobjectRow] = {
    SelectBuilderSql("pg_catalog.pg_largeobject", PgLargeobjectFields, PgLargeobjectRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgLargeobjectRow] = {
    SQL"""select loid, pageno, "data"
          from pg_catalog.pg_largeobject
       """.as(PgLargeobjectRow.rowParser(1).*)
  }
  override def selectById(compositeId: PgLargeobjectId)(implicit c: Connection): Option[PgLargeobjectRow] = {
    SQL"""select loid, pageno, "data"
          from pg_catalog.pg_largeobject
          where loid = ${compositeId.loid} AND pageno = ${compositeId.pageno}
       """.as(PgLargeobjectRow.rowParser(1).singleOpt)
  }
  override def update(row: PgLargeobjectRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_largeobject
          set "data" = ${row.data}::bytea
          where loid = ${compositeId.loid} AND pageno = ${compositeId.pageno}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgLargeobjectFields, PgLargeobjectRow] = {
    UpdateBuilder("pg_catalog.pg_largeobject", PgLargeobjectFields, PgLargeobjectRow.rowParser)
  }
  override def upsert(unsaved: PgLargeobjectRow)(implicit c: Connection): PgLargeobjectRow = {
    SQL"""insert into pg_catalog.pg_largeobject(loid, pageno, "data")
          values (
            ${unsaved.loid}::oid,
            ${unsaved.pageno}::int4,
            ${unsaved.data}::bytea
          )
          on conflict (loid, pageno)
          do update set
            "data" = EXCLUDED."data"
          returning loid, pageno, "data"
       """
      .executeInsert(PgLargeobjectRow.rowParser(1).single)
    
  }
}