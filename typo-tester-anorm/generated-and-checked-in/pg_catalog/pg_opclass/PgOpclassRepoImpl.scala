/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opclass

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgOpclassRepoImpl extends PgOpclassRepo {
  override def delete(oid: PgOpclassId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_opclass where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgOpclassFields, PgOpclassRow] = {
    DeleteBuilder("pg_catalog.pg_opclass", PgOpclassFields)
  }
  override def insert(unsaved: PgOpclassRow)(implicit c: Connection): PgOpclassRow = {
    SQL"""insert into pg_catalog.pg_opclass(oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype)
          values (${unsaved.oid}::oid, ${unsaved.opcmethod}::oid, ${unsaved.opcname}::name, ${unsaved.opcnamespace}::oid, ${unsaved.opcowner}::oid, ${unsaved.opcfamily}::oid, ${unsaved.opcintype}::oid, ${unsaved.opcdefault}, ${unsaved.opckeytype}::oid)
          returning oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype
       """
      .executeInsert(PgOpclassRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgOpclassFields, PgOpclassRow] = {
    SelectBuilderSql("pg_catalog.pg_opclass", PgOpclassFields, PgOpclassRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgOpclassRow] = {
    SQL"""select oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype
          from pg_catalog.pg_opclass
       """.as(PgOpclassRow.rowParser(1).*)
  }
  override def selectById(oid: PgOpclassId)(implicit c: Connection): Option[PgOpclassRow] = {
    SQL"""select oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype
          from pg_catalog.pg_opclass
          where oid = $oid
       """.as(PgOpclassRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgOpclassId])(implicit c: Connection): List[PgOpclassRow] = {
    SQL"""select oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype
          from pg_catalog.pg_opclass
          where oid = ANY($oids)
       """.as(PgOpclassRow.rowParser(1).*)
    
  }
  override def update(row: PgOpclassRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_opclass
          set opcmethod = ${row.opcmethod}::oid,
              opcname = ${row.opcname}::name,
              opcnamespace = ${row.opcnamespace}::oid,
              opcowner = ${row.opcowner}::oid,
              opcfamily = ${row.opcfamily}::oid,
              opcintype = ${row.opcintype}::oid,
              opcdefault = ${row.opcdefault},
              opckeytype = ${row.opckeytype}::oid
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgOpclassFields, PgOpclassRow] = {
    UpdateBuilder("pg_catalog.pg_opclass", PgOpclassFields, PgOpclassRow.rowParser)
  }
  override def upsert(unsaved: PgOpclassRow)(implicit c: Connection): PgOpclassRow = {
    SQL"""insert into pg_catalog.pg_opclass(oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.opcmethod}::oid,
            ${unsaved.opcname}::name,
            ${unsaved.opcnamespace}::oid,
            ${unsaved.opcowner}::oid,
            ${unsaved.opcfamily}::oid,
            ${unsaved.opcintype}::oid,
            ${unsaved.opcdefault},
            ${unsaved.opckeytype}::oid
          )
          on conflict (oid)
          do update set
            opcmethod = EXCLUDED.opcmethod,
            opcname = EXCLUDED.opcname,
            opcnamespace = EXCLUDED.opcnamespace,
            opcowner = EXCLUDED.opcowner,
            opcfamily = EXCLUDED.opcfamily,
            opcintype = EXCLUDED.opcintype,
            opcdefault = EXCLUDED.opcdefault,
            opckeytype = EXCLUDED.opckeytype
          returning oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype
       """
      .executeInsert(PgOpclassRow.rowParser(1).single)
    
  }
}
