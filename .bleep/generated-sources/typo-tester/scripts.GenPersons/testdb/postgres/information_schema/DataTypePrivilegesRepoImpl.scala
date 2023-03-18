package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait DataTypePrivilegesRepoImpl extends DataTypePrivilegesRepo {
  override def selectAll(implicit c: Connection): List[DataTypePrivilegesRow] = {
    SQL"""select object_catalog, object_schema, object_name, object_type, dtd_identifier from information_schema.data_type_privileges""".as(DataTypePrivilegesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[DataTypePrivilegesFieldValue[_]])(implicit c: Connection): List[DataTypePrivilegesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DataTypePrivilegesFieldValue.objectCatalog(value) => NamedParameter("object_catalog", ParameterValue.from(value))
          case DataTypePrivilegesFieldValue.objectSchema(value) => NamedParameter("object_schema", ParameterValue.from(value))
          case DataTypePrivilegesFieldValue.objectName(value) => NamedParameter("object_name", ParameterValue.from(value))
          case DataTypePrivilegesFieldValue.objectType(value) => NamedParameter("object_type", ParameterValue.from(value))
          case DataTypePrivilegesFieldValue.dtdIdentifier(value) => NamedParameter("dtd_identifier", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.data_type_privileges where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(DataTypePrivilegesRow.rowParser.*)
    }

  }
}