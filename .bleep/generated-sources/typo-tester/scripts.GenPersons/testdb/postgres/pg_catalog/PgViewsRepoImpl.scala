package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgViewsRepoImpl extends PgViewsRepo {
  override def selectAll(implicit c: Connection): List[PgViewsRow] = {
    SQL"""select schemaname, viewname, viewowner, definition from pg_catalog.pg_views""".as(PgViewsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgViewsFieldValue[_]])(implicit c: Connection): List[PgViewsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgViewsFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgViewsFieldValue.viewname(value) => NamedParameter("viewname", ParameterValue.from(value))
          case PgViewsFieldValue.viewowner(value) => NamedParameter("viewowner", ParameterValue.from(value))
          case PgViewsFieldValue.definition(value) => NamedParameter("definition", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_views where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgViewsRow.rowParser.*)
    }

  }
}