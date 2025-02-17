/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgTsParserRepoImpl extends PgTsParserRepo {
  override def delete(oid: PgTsParserId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_ts_parser where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgTsParserFields, PgTsParserRow] = {
    DeleteBuilder("pg_catalog.pg_ts_parser", PgTsParserFields)
  }
  override def insert(unsaved: PgTsParserRow)(implicit c: Connection): PgTsParserRow = {
    SQL"""insert into pg_catalog.pg_ts_parser(oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)
          values (${unsaved.oid}::oid, ${unsaved.prsname}::name, ${unsaved.prsnamespace}::oid, ${unsaved.prsstart}::regproc, ${unsaved.prstoken}::regproc, ${unsaved.prsend}::regproc, ${unsaved.prsheadline}::regproc, ${unsaved.prslextype}::regproc)
          returning oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
       """
      .executeInsert(PgTsParserRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgTsParserFields, PgTsParserRow] = {
    SelectBuilderSql("pg_catalog.pg_ts_parser", PgTsParserFields, PgTsParserRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
          from pg_catalog.pg_ts_parser
       """.as(PgTsParserRow.rowParser(1).*)
  }
  override def selectById(oid: PgTsParserId)(implicit c: Connection): Option[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
          from pg_catalog.pg_ts_parser
          where oid = $oid
       """.as(PgTsParserRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgTsParserId])(implicit c: Connection): List[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
          from pg_catalog.pg_ts_parser
          where oid = ANY($oids)
       """.as(PgTsParserRow.rowParser(1).*)
    
  }
  override def update(row: PgTsParserRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_ts_parser
          set prsname = ${row.prsname}::name,
              prsnamespace = ${row.prsnamespace}::oid,
              prsstart = ${row.prsstart}::regproc,
              prstoken = ${row.prstoken}::regproc,
              prsend = ${row.prsend}::regproc,
              prsheadline = ${row.prsheadline}::regproc,
              prslextype = ${row.prslextype}::regproc
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgTsParserFields, PgTsParserRow] = {
    UpdateBuilder("pg_catalog.pg_ts_parser", PgTsParserFields, PgTsParserRow.rowParser)
  }
  override def upsert(unsaved: PgTsParserRow)(implicit c: Connection): PgTsParserRow = {
    SQL"""insert into pg_catalog.pg_ts_parser(oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.prsname}::name,
            ${unsaved.prsnamespace}::oid,
            ${unsaved.prsstart}::regproc,
            ${unsaved.prstoken}::regproc,
            ${unsaved.prsend}::regproc,
            ${unsaved.prsheadline}::regproc,
            ${unsaved.prslextype}::regproc
          )
          on conflict (oid)
          do update set
            prsname = EXCLUDED.prsname,
            prsnamespace = EXCLUDED.prsnamespace,
            prsstart = EXCLUDED.prsstart,
            prstoken = EXCLUDED.prstoken,
            prsend = EXCLUDED.prsend,
            prsheadline = EXCLUDED.prsheadline,
            prslextype = EXCLUDED.prslextype
          returning oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
       """
      .executeInsert(PgTsParserRow.rowParser(1).single)
    
  }
}
