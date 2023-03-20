/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object ColumnColumnUsageRepoImpl extends ColumnColumnUsageRepo {
  override def selectAll(implicit c: Connection): List[ColumnColumnUsageRow] = {
    SQL"""select table_catalog, table_schema, table_name, column_name, dependent_column from information_schema.column_column_usage""".as(ColumnColumnUsageRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ColumnColumnUsageFieldValue[_]])(implicit c: Connection): List[ColumnColumnUsageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ColumnColumnUsageFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case ColumnColumnUsageFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case ColumnColumnUsageFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case ColumnColumnUsageFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
          case ColumnColumnUsageFieldValue.dependentColumn(value) => NamedParameter("dependent_column", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.column_column_usage where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(ColumnColumnUsageRow.rowParser.*)
    }

  }
}