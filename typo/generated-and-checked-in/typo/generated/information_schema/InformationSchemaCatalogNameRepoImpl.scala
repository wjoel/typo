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

object InformationSchemaCatalogNameRepoImpl extends InformationSchemaCatalogNameRepo {
  override def selectAll(implicit c: Connection): List[InformationSchemaCatalogNameRow] = {
    SQL"""select catalog_name from information_schema.information_schema_catalog_name""".as(InformationSchemaCatalogNameRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[InformationSchemaCatalogNameFieldValue[_]])(implicit c: Connection): List[InformationSchemaCatalogNameRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case InformationSchemaCatalogNameFieldValue.catalogName(value) => NamedParameter("catalog_name", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.information_schema_catalog_name where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(InformationSchemaCatalogNameRow.rowParser.*)
    }

  }
}
