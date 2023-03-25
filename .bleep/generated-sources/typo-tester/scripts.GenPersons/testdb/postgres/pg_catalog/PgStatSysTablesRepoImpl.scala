/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatSysTablesRepoImpl extends PgStatSysTablesRepo {
  override def selectAll(implicit c: Connection): List[PgStatSysTablesRow] = {
    SQL"""select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd, n_live_tup, n_dead_tup, n_mod_since_analyze, n_ins_since_vacuum, last_vacuum, last_autovacuum, last_analyze, last_autoanalyze, vacuum_count, autovacuum_count, analyze_count, autoanalyze_count from pg_catalog.pg_stat_sys_tables""".as(PgStatSysTablesRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatSysTablesFieldValue[_]])(implicit c: Connection): List[PgStatSysTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatSysTablesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.seqScan(value) => NamedParameter("seq_scan", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.seqTupRead(value) => NamedParameter("seq_tup_read", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.idxScan(value) => NamedParameter("idx_scan", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.idxTupFetch(value) => NamedParameter("idx_tup_fetch", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nTupIns(value) => NamedParameter("n_tup_ins", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nTupUpd(value) => NamedParameter("n_tup_upd", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nTupDel(value) => NamedParameter("n_tup_del", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nTupHotUpd(value) => NamedParameter("n_tup_hot_upd", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nLiveTup(value) => NamedParameter("n_live_tup", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nDeadTup(value) => NamedParameter("n_dead_tup", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nModSinceAnalyze(value) => NamedParameter("n_mod_since_analyze", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.nInsSinceVacuum(value) => NamedParameter("n_ins_since_vacuum", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.lastVacuum(value) => NamedParameter("last_vacuum", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.lastAutovacuum(value) => NamedParameter("last_autovacuum", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.lastAnalyze(value) => NamedParameter("last_analyze", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.lastAutoanalyze(value) => NamedParameter("last_autoanalyze", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.vacuumCount(value) => NamedParameter("vacuum_count", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.autovacuumCount(value) => NamedParameter("autovacuum_count", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.analyzeCount(value) => NamedParameter("analyze_count", ParameterValue.from(value))
          case PgStatSysTablesFieldValue.autoanalyzeCount(value) => NamedParameter("autoanalyze_count", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_stat_sys_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatSysTablesRow.rowParser("").*)
    }

  }
}
