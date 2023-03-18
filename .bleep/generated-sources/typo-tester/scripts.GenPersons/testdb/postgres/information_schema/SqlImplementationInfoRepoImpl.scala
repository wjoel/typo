package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait SqlImplementationInfoRepoImpl extends SqlImplementationInfoRepo {
  override def selectAll(implicit c: Connection): List[SqlImplementationInfoRow] = {
    SQL"""select implementation_info_id, implementation_info_name, integer_value, character_value, comments from information_schema.sql_implementation_info""".as(SqlImplementationInfoRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SqlImplementationInfoFieldValue[_]])(implicit c: Connection): List[SqlImplementationInfoRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SqlImplementationInfoFieldValue.implementationInfoId(value) => NamedParameter("implementation_info_id", ParameterValue.from(value))
          case SqlImplementationInfoFieldValue.implementationInfoName(value) => NamedParameter("implementation_info_name", ParameterValue.from(value))
          case SqlImplementationInfoFieldValue.integerValue(value) => NamedParameter("integer_value", ParameterValue.from(value))
          case SqlImplementationInfoFieldValue.characterValue(value) => NamedParameter("character_value", ParameterValue.from(value))
          case SqlImplementationInfoFieldValue.comments(value) => NamedParameter("comments", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.sql_implementation_info where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(SqlImplementationInfoRow.rowParser.*)
    }

  }
}