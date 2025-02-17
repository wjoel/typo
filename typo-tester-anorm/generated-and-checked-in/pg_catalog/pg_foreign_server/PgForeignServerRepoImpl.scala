/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_server

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgForeignServerRepoImpl extends PgForeignServerRepo {
  override def delete(oid: PgForeignServerId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_foreign_server where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgForeignServerFields, PgForeignServerRow] = {
    DeleteBuilder("pg_catalog.pg_foreign_server", PgForeignServerFields)
  }
  override def insert(unsaved: PgForeignServerRow)(implicit c: Connection): PgForeignServerRow = {
    SQL"""insert into pg_catalog.pg_foreign_server(oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions)
          values (${unsaved.oid}::oid, ${unsaved.srvname}::name, ${unsaved.srvowner}::oid, ${unsaved.srvfdw}::oid, ${unsaved.srvtype}, ${unsaved.srvversion}, ${unsaved.srvacl}::_aclitem, ${unsaved.srvoptions}::_text)
          returning oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
       """
      .executeInsert(PgForeignServerRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgForeignServerFields, PgForeignServerRow] = {
    SelectBuilderSql("pg_catalog.pg_foreign_server", PgForeignServerFields, PgForeignServerRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgForeignServerRow] = {
    SQL"""select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
          from pg_catalog.pg_foreign_server
       """.as(PgForeignServerRow.rowParser(1).*)
  }
  override def selectById(oid: PgForeignServerId)(implicit c: Connection): Option[PgForeignServerRow] = {
    SQL"""select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
          from pg_catalog.pg_foreign_server
          where oid = $oid
       """.as(PgForeignServerRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgForeignServerId])(implicit c: Connection): List[PgForeignServerRow] = {
    SQL"""select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
          from pg_catalog.pg_foreign_server
          where oid = ANY($oids)
       """.as(PgForeignServerRow.rowParser(1).*)
    
  }
  override def update(row: PgForeignServerRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_foreign_server
          set srvname = ${row.srvname}::name,
              srvowner = ${row.srvowner}::oid,
              srvfdw = ${row.srvfdw}::oid,
              srvtype = ${row.srvtype},
              srvversion = ${row.srvversion},
              srvacl = ${row.srvacl}::_aclitem,
              srvoptions = ${row.srvoptions}::_text
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgForeignServerFields, PgForeignServerRow] = {
    UpdateBuilder("pg_catalog.pg_foreign_server", PgForeignServerFields, PgForeignServerRow.rowParser)
  }
  override def upsert(unsaved: PgForeignServerRow)(implicit c: Connection): PgForeignServerRow = {
    SQL"""insert into pg_catalog.pg_foreign_server(oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.srvname}::name,
            ${unsaved.srvowner}::oid,
            ${unsaved.srvfdw}::oid,
            ${unsaved.srvtype},
            ${unsaved.srvversion},
            ${unsaved.srvacl}::_aclitem,
            ${unsaved.srvoptions}::_text
          )
          on conflict (oid)
          do update set
            srvname = EXCLUDED.srvname,
            srvowner = EXCLUDED.srvowner,
            srvfdw = EXCLUDED.srvfdw,
            srvtype = EXCLUDED.srvtype,
            srvversion = EXCLUDED.srvversion,
            srvacl = EXCLUDED.srvacl,
            srvoptions = EXCLUDED.srvoptions
          returning oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
       """
      .executeInsert(PgForeignServerRow.rowParser(1).single)
    
  }
}
