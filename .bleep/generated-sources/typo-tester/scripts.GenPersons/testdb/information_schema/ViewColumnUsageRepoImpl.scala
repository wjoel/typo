package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait ViewColumnUsageRepoImpl extends ViewColumnUsageRepo {
  override def selectAll(implicit c: Connection): List[ViewColumnUsageRow] = {
    SQL"""select view_catalog, view_schema, view_name, table_catalog, table_schema, table_name, column_name from information_schema.view_column_usage""".as(ViewColumnUsageRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ViewColumnUsageFieldValue[_]])(implicit c: Connection): List[ViewColumnUsageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ViewColumnUsageFieldValue.viewCatalog(value) => NamedParameter("view_catalog", ParameterValue.from(value))
          case ViewColumnUsageFieldValue.viewSchema(value) => NamedParameter("view_schema", ParameterValue.from(value))
          case ViewColumnUsageFieldValue.viewName(value) => NamedParameter("view_name", ParameterValue.from(value))
          case ViewColumnUsageFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case ViewColumnUsageFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case ViewColumnUsageFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case ViewColumnUsageFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.view_column_usage where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(ViewColumnUsageRow.rowParser.*)
    }

  }
}