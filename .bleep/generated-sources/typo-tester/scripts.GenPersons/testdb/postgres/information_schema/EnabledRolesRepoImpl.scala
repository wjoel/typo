package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait EnabledRolesRepoImpl extends EnabledRolesRepo {
  override def selectAll(implicit c: Connection): List[EnabledRolesRow] = {
    SQL"""select role_name from information_schema.enabled_roles""".as(EnabledRolesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[EnabledRolesFieldValue[_]])(implicit c: Connection): List[EnabledRolesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case EnabledRolesFieldValue.roleName(value) => NamedParameter("role_name", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.enabled_roles where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(EnabledRolesRow.rowParser.*)
    }

  }
}