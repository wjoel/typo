/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgEnumRepoImpl extends PgEnumRepo {
  override def delete(oid: PgEnumId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_enum where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgEnumFields, PgEnumRow] = {
    DeleteBuilder("pg_catalog.pg_enum", PgEnumFields)
  }
  override def insert(unsaved: PgEnumRow)(implicit c: Connection): PgEnumRow = {
    SQL"""insert into pg_catalog.pg_enum(oid, enumtypid, enumsortorder, enumlabel)
          values (${unsaved.oid}::oid, ${unsaved.enumtypid}::oid, ${unsaved.enumsortorder}::float4, ${unsaved.enumlabel}::name)
          returning oid, enumtypid, enumsortorder, enumlabel
       """
      .executeInsert(PgEnumRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgEnumFields, PgEnumRow] = {
    SelectBuilderSql("pg_catalog.pg_enum", PgEnumFields, PgEnumRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel
          from pg_catalog.pg_enum
       """.as(PgEnumRow.rowParser(1).*)
  }
  override def selectById(oid: PgEnumId)(implicit c: Connection): Option[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel
          from pg_catalog.pg_enum
          where oid = $oid
       """.as(PgEnumRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgEnumId])(implicit c: Connection): List[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel
          from pg_catalog.pg_enum
          where oid = ANY($oids)
       """.as(PgEnumRow.rowParser(1).*)
    
  }
  override def update(row: PgEnumRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_enum
          set enumtypid = ${row.enumtypid}::oid,
              enumsortorder = ${row.enumsortorder}::float4,
              enumlabel = ${row.enumlabel}::name
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgEnumFields, PgEnumRow] = {
    UpdateBuilder("pg_catalog.pg_enum", PgEnumFields, PgEnumRow.rowParser)
  }
  override def upsert(unsaved: PgEnumRow)(implicit c: Connection): PgEnumRow = {
    SQL"""insert into pg_catalog.pg_enum(oid, enumtypid, enumsortorder, enumlabel)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.enumtypid}::oid,
            ${unsaved.enumsortorder}::float4,
            ${unsaved.enumlabel}::name
          )
          on conflict (oid)
          do update set
            enumtypid = EXCLUDED.enumtypid,
            enumsortorder = EXCLUDED.enumsortorder,
            enumlabel = EXCLUDED.enumlabel
          returning oid, enumtypid, enumsortorder, enumlabel
       """
      .executeInsert(PgEnumRow.rowParser(1).single)
    
  }
}
