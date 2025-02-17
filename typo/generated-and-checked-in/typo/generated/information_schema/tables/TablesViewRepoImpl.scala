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
package tables

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object TablesViewRepoImpl extends TablesViewRepo {
  override def selectAll(implicit c: Connection): List[TablesViewRow] = {
    SQL"""select table_catalog, table_schema, "table_name", table_type, self_referencing_column_name, reference_generation, "user_defined_type_catalog", "user_defined_type_schema", "user_defined_type_name", is_insertable_into, is_typed, commit_action
          from information_schema."tables"
       """.as(TablesViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[TablesViewFieldOrIdValue[_]])(implicit c: Connection): List[TablesViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TablesViewFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case TablesViewFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case TablesViewFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case TablesViewFieldValue.tableType(value) => NamedParameter("table_type", ParameterValue.from(value))
          case TablesViewFieldValue.selfReferencingColumnName(value) => NamedParameter("self_referencing_column_name", ParameterValue.from(value))
          case TablesViewFieldValue.referenceGeneration(value) => NamedParameter("reference_generation", ParameterValue.from(value))
          case TablesViewFieldValue.userDefinedTypeCatalog(value) => NamedParameter("user_defined_type_catalog", ParameterValue.from(value))
          case TablesViewFieldValue.userDefinedTypeSchema(value) => NamedParameter("user_defined_type_schema", ParameterValue.from(value))
          case TablesViewFieldValue.userDefinedTypeName(value) => NamedParameter("user_defined_type_name", ParameterValue.from(value))
          case TablesViewFieldValue.isInsertableInto(value) => NamedParameter("is_insertable_into", ParameterValue.from(value))
          case TablesViewFieldValue.isTyped(value) => NamedParameter("is_typed", ParameterValue.from(value))
          case TablesViewFieldValue.commitAction(value) => NamedParameter("commit_action", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select table_catalog, table_schema, "table_name", table_type, self_referencing_column_name, reference_generation, "user_defined_type_catalog", "user_defined_type_schema", "user_defined_type_name", is_insertable_into, is_typed, commit_action
                    from information_schema."tables"
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(TablesViewRow.rowParser(1).*)
    }
  
  }
}
