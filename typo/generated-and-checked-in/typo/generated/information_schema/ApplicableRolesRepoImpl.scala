/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object ApplicableRolesRepoImpl extends ApplicableRolesRepo {
  override def selectAll(implicit c: Connection): List[ApplicableRolesRow] = {
    SQL"""select grantee, role_name, is_grantable from information_schema.applicable_roles""".as(ApplicableRolesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ApplicableRolesFieldValue[_]])(implicit c: Connection): List[ApplicableRolesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ApplicableRolesFieldValue.grantee(value) => NamedParameter("grantee", ParameterValue.from(value))
          case ApplicableRolesFieldValue.roleName(value) => NamedParameter("role_name", ParameterValue.from(value))
          case ApplicableRolesFieldValue.isGrantable(value) => NamedParameter("is_grantable", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.applicable_roles where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(ApplicableRolesRow.rowParser.*)
    }

  }
}
