package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgBackendMemoryContextsRepoImpl extends PgBackendMemoryContextsRepo {
  override def selectAll(implicit c: Connection): List[PgBackendMemoryContextsRow] = {
    SQL"""select name, ident, parent, level, total_bytes, total_nblocks, free_bytes, free_chunks, used_bytes from pg_catalog.pg_backend_memory_contexts""".as(PgBackendMemoryContextsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgBackendMemoryContextsFieldValue[_]])(implicit c: Connection): List[PgBackendMemoryContextsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgBackendMemoryContextsFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.ident(value) => NamedParameter("ident", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.parent(value) => NamedParameter("parent", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.level(value) => NamedParameter("level", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.totalBytes(value) => NamedParameter("total_bytes", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.totalNblocks(value) => NamedParameter("total_nblocks", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.freeBytes(value) => NamedParameter("free_bytes", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.freeChunks(value) => NamedParameter("free_chunks", ParameterValue.from(value))
          case PgBackendMemoryContextsFieldValue.usedBytes(value) => NamedParameter("used_bytes", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_backend_memory_contexts where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgBackendMemoryContextsRow.rowParser.*)
    }

  }
}