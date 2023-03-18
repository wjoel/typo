package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatActivityRepoImpl extends PgStatActivityRepo {
  override def selectAll(implicit c: Connection): List[PgStatActivityRow] = {
    SQL"""select datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query_id, query, backend_type from pg_catalog.pg_stat_activity""".as(PgStatActivityRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatActivityFieldValue[_]])(implicit c: Connection): List[PgStatActivityRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatActivityFieldValue.datid(value) => NamedParameter("datid", ParameterValue.from(value))
          case PgStatActivityFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgStatActivityFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatActivityFieldValue.leaderPid(value) => NamedParameter("leader_pid", ParameterValue.from(value))
          case PgStatActivityFieldValue.usesysid(value) => NamedParameter("usesysid", ParameterValue.from(value))
          case PgStatActivityFieldValue.usename(value) => NamedParameter("usename", ParameterValue.from(value))
          case PgStatActivityFieldValue.applicationName(value) => NamedParameter("application_name", ParameterValue.from(value))
          case PgStatActivityFieldValue.clientAddr(value) => NamedParameter("client_addr", ParameterValue.from(value))
          case PgStatActivityFieldValue.clientHostname(value) => NamedParameter("client_hostname", ParameterValue.from(value))
          case PgStatActivityFieldValue.clientPort(value) => NamedParameter("client_port", ParameterValue.from(value))
          case PgStatActivityFieldValue.backendStart(value) => NamedParameter("backend_start", ParameterValue.from(value))
          case PgStatActivityFieldValue.xactStart(value) => NamedParameter("xact_start", ParameterValue.from(value))
          case PgStatActivityFieldValue.queryStart(value) => NamedParameter("query_start", ParameterValue.from(value))
          case PgStatActivityFieldValue.stateChange(value) => NamedParameter("state_change", ParameterValue.from(value))
          case PgStatActivityFieldValue.waitEventType(value) => NamedParameter("wait_event_type", ParameterValue.from(value))
          case PgStatActivityFieldValue.waitEvent(value) => NamedParameter("wait_event", ParameterValue.from(value))
          case PgStatActivityFieldValue.state(value) => NamedParameter("state", ParameterValue.from(value))
          case PgStatActivityFieldValue.backendXid(value) => NamedParameter("backend_xid", ParameterValue.from(value))
          case PgStatActivityFieldValue.backendXmin(value) => NamedParameter("backend_xmin", ParameterValue.from(value))
          case PgStatActivityFieldValue.queryId(value) => NamedParameter("query_id", ParameterValue.from(value))
          case PgStatActivityFieldValue.query(value) => NamedParameter("query", ParameterValue.from(value))
          case PgStatActivityFieldValue.backendType(value) => NamedParameter("backend_type", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_activity where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatActivityRow.rowParser.*)
    }

  }
}