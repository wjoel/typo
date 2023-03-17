package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatXactAllTablesRepoImpl extends PgStatXactAllTablesRepo {
  override def selectAll(implicit c: Connection): List[PgStatXactAllTablesRow] = {
    SQL"""select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd from pg_catalog.pg_stat_xact_all_tables""".as(PgStatXactAllTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatXactAllTablesFieldValue[_]])(implicit c: Connection): List[PgStatXactAllTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatXactAllTablesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.seqScan(value) => NamedParameter("seq_scan", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.seqTupRead(value) => NamedParameter("seq_tup_read", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.idxScan(value) => NamedParameter("idx_scan", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.idxTupFetch(value) => NamedParameter("idx_tup_fetch", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.nTupIns(value) => NamedParameter("n_tup_ins", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.nTupUpd(value) => NamedParameter("n_tup_upd", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.nTupDel(value) => NamedParameter("n_tup_del", ParameterValue.from(value))
          case PgStatXactAllTablesFieldValue.nTupHotUpd(value) => NamedParameter("n_tup_hot_upd", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_xact_all_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatXactAllTablesRow.rowParser.*)
    }

  }
}