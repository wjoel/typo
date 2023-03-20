/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatDatabaseConflictsRepoImpl extends PgStatDatabaseConflictsRepo {
  override def selectAll(implicit c: Connection): List[PgStatDatabaseConflictsRow] = {
    SQL"""select datid, datname, confl_tablespace, confl_lock, confl_snapshot, confl_bufferpin, confl_deadlock from pg_catalog.pg_stat_database_conflicts""".as(PgStatDatabaseConflictsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatDatabaseConflictsFieldValue[_]])(implicit c: Connection): List[PgStatDatabaseConflictsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatDatabaseConflictsFieldValue.datid(value) => NamedParameter("datid", ParameterValue.from(value))
          case PgStatDatabaseConflictsFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgStatDatabaseConflictsFieldValue.conflTablespace(value) => NamedParameter("confl_tablespace", ParameterValue.from(value))
          case PgStatDatabaseConflictsFieldValue.conflLock(value) => NamedParameter("confl_lock", ParameterValue.from(value))
          case PgStatDatabaseConflictsFieldValue.conflSnapshot(value) => NamedParameter("confl_snapshot", ParameterValue.from(value))
          case PgStatDatabaseConflictsFieldValue.conflBufferpin(value) => NamedParameter("confl_bufferpin", ParameterValue.from(value))
          case PgStatDatabaseConflictsFieldValue.conflDeadlock(value) => NamedParameter("confl_deadlock", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_stat_database_conflicts where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatDatabaseConflictsRow.rowParser.*)
    }

  }
}
