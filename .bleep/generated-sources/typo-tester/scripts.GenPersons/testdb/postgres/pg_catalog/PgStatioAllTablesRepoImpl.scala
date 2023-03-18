package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatioAllTablesRepoImpl extends PgStatioAllTablesRepo {
  override def selectAll(implicit c: Connection): List[PgStatioAllTablesRow] = {
    SQL"""select relid, schemaname, relname, heap_blks_read, heap_blks_hit, idx_blks_read, idx_blks_hit, toast_blks_read, toast_blks_hit, tidx_blks_read, tidx_blks_hit from pg_catalog.pg_statio_all_tables""".as(PgStatioAllTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatioAllTablesFieldValue[_]])(implicit c: Connection): List[PgStatioAllTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatioAllTablesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.heapBlksRead(value) => NamedParameter("heap_blks_read", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.heapBlksHit(value) => NamedParameter("heap_blks_hit", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.idxBlksRead(value) => NamedParameter("idx_blks_read", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.idxBlksHit(value) => NamedParameter("idx_blks_hit", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.toastBlksRead(value) => NamedParameter("toast_blks_read", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.toastBlksHit(value) => NamedParameter("toast_blks_hit", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.tidxBlksRead(value) => NamedParameter("tidx_blks_read", ParameterValue.from(value))
          case PgStatioAllTablesFieldValue.tidxBlksHit(value) => NamedParameter("tidx_blks_hit", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_statio_all_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatioAllTablesRow.rowParser.*)
    }

  }
}