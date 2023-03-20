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

object SchemataRepoImpl extends SchemataRepo {
  override def selectAll(implicit c: Connection): List[SchemataRow] = {
    SQL"""select catalog_name, schema_name, schema_owner, default_character_set_catalog, default_character_set_schema, default_character_set_name, sql_path from information_schema.schemata""".as(SchemataRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SchemataFieldValue[_]])(implicit c: Connection): List[SchemataRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SchemataFieldValue.catalogName(value) => NamedParameter("catalog_name", ParameterValue.from(value))
          case SchemataFieldValue.schemaName(value) => NamedParameter("schema_name", ParameterValue.from(value))
          case SchemataFieldValue.schemaOwner(value) => NamedParameter("schema_owner", ParameterValue.from(value))
          case SchemataFieldValue.defaultCharacterSetCatalog(value) => NamedParameter("default_character_set_catalog", ParameterValue.from(value))
          case SchemataFieldValue.defaultCharacterSetSchema(value) => NamedParameter("default_character_set_schema", ParameterValue.from(value))
          case SchemataFieldValue.defaultCharacterSetName(value) => NamedParameter("default_character_set_name", ParameterValue.from(value))
          case SchemataFieldValue.sqlPath(value) => NamedParameter("sql_path", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.schemata where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(SchemataRow.rowParser.*)
    }

  }
}
