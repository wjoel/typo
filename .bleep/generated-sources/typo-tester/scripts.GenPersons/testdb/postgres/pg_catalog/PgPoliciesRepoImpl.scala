package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgPoliciesRepoImpl extends PgPoliciesRepo {
  override def selectAll(implicit c: Connection): List[PgPoliciesRow] = {
    SQL"""select schemaname, tablename, policyname, permissive, roles, cmd, qual, with_check from pg_catalog.pg_policies""".as(PgPoliciesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPoliciesFieldValue[_]])(implicit c: Connection): List[PgPoliciesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPoliciesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgPoliciesFieldValue.tablename(value) => NamedParameter("tablename", ParameterValue.from(value))
          case PgPoliciesFieldValue.policyname(value) => NamedParameter("policyname", ParameterValue.from(value))
          case PgPoliciesFieldValue.permissive(value) => NamedParameter("permissive", ParameterValue.from(value))
          case PgPoliciesFieldValue.roles(value) => NamedParameter("roles", ParameterValue.from(value))
          case PgPoliciesFieldValue.cmd(value) => NamedParameter("cmd", ParameterValue.from(value))
          case PgPoliciesFieldValue.qual(value) => NamedParameter("qual", ParameterValue.from(value))
          case PgPoliciesFieldValue.withCheck(value) => NamedParameter("with_check", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_policies where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgPoliciesRow.rowParser.*)
    }

  }
}