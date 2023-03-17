package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait TriggeredUpdateColumnsRepoImpl extends TriggeredUpdateColumnsRepo {
  override def selectAll(implicit c: Connection): List[TriggeredUpdateColumnsRow] = {
    SQL"""select trigger_catalog, trigger_schema, trigger_name, event_object_catalog, event_object_schema, event_object_table, event_object_column from information_schema.triggered_update_columns""".as(TriggeredUpdateColumnsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[TriggeredUpdateColumnsFieldValue[_]])(implicit c: Connection): List[TriggeredUpdateColumnsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TriggeredUpdateColumnsFieldValue.triggerCatalog(value) => NamedParameter("trigger_catalog", ParameterValue.from(value))
          case TriggeredUpdateColumnsFieldValue.triggerSchema(value) => NamedParameter("trigger_schema", ParameterValue.from(value))
          case TriggeredUpdateColumnsFieldValue.triggerName(value) => NamedParameter("trigger_name", ParameterValue.from(value))
          case TriggeredUpdateColumnsFieldValue.eventObjectCatalog(value) => NamedParameter("event_object_catalog", ParameterValue.from(value))
          case TriggeredUpdateColumnsFieldValue.eventObjectSchema(value) => NamedParameter("event_object_schema", ParameterValue.from(value))
          case TriggeredUpdateColumnsFieldValue.eventObjectTable(value) => NamedParameter("event_object_table", ParameterValue.from(value))
          case TriggeredUpdateColumnsFieldValue.eventObjectColumn(value) => NamedParameter("event_object_column", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.triggered_update_columns where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(TriggeredUpdateColumnsRow.rowParser.*)
    }

  }
}