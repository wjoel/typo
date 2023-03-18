package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatioUserIndexesRepoImpl extends PgStatioUserIndexesRepo {
  override def selectAll(implicit c: Connection): List[PgStatioUserIndexesRow] = {
    SQL"""select relid, indexrelid, schemaname, relname, indexrelname, idx_blks_read, idx_blks_hit from pg_catalog.pg_statio_user_indexes""".as(PgStatioUserIndexesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatioUserIndexesFieldValue[_]])(implicit c: Connection): List[PgStatioUserIndexesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatioUserIndexesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatioUserIndexesFieldValue.indexrelid(value) => NamedParameter("indexrelid", ParameterValue.from(value))
          case PgStatioUserIndexesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatioUserIndexesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatioUserIndexesFieldValue.indexrelname(value) => NamedParameter("indexrelname", ParameterValue.from(value))
          case PgStatioUserIndexesFieldValue.idxBlksRead(value) => NamedParameter("idx_blks_read", ParameterValue.from(value))
          case PgStatioUserIndexesFieldValue.idxBlksHit(value) => NamedParameter("idx_blks_hit", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_statio_user_indexes where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatioUserIndexesRow.rowParser.*)
    }

  }
}