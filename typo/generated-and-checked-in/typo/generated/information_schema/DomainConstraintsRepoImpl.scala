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

object DomainConstraintsRepoImpl extends DomainConstraintsRepo {
  override def selectAll(implicit c: Connection): List[DomainConstraintsRow] = {
    SQL"""select constraint_catalog, constraint_schema, constraint_name, domain_catalog, domain_schema, domain_name, is_deferrable, initially_deferred from information_schema.domain_constraints""".as(DomainConstraintsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[DomainConstraintsFieldValue[_]])(implicit c: Connection): List[DomainConstraintsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DomainConstraintsFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case DomainConstraintsFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case DomainConstraintsFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
          case DomainConstraintsFieldValue.domainCatalog(value) => NamedParameter("domain_catalog", ParameterValue.from(value))
          case DomainConstraintsFieldValue.domainSchema(value) => NamedParameter("domain_schema", ParameterValue.from(value))
          case DomainConstraintsFieldValue.domainName(value) => NamedParameter("domain_name", ParameterValue.from(value))
          case DomainConstraintsFieldValue.isDeferrable(value) => NamedParameter("is_deferrable", ParameterValue.from(value))
          case DomainConstraintsFieldValue.initiallyDeferred(value) => NamedParameter("initially_deferred", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.domain_constraints where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(DomainConstraintsRow.rowParser.*)
    }

  }
}
