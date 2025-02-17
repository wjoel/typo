/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domain_udt_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class DomainUdtUsageViewStructure[Row](val prefix: Option[String], val extract: Row => DomainUdtUsageViewRow, val merge: (Row, DomainUdtUsageViewRow) => Row)
  extends Relation[DomainUdtUsageViewFields, DomainUdtUsageViewRow, Row]
    with DomainUdtUsageViewFields[Row] { outer =>

  override val udtCatalog = new OptField[SqlIdentifier, Row](prefix, "udt_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).udtCatalog, (row, value) => merge(row, extract(row).copy(udtCatalog = value)))
  override val udtSchema = new OptField[SqlIdentifier, Row](prefix, "udt_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).udtSchema, (row, value) => merge(row, extract(row).copy(udtSchema = value)))
  override val udtName = new OptField[SqlIdentifier, Row](prefix, "udt_name", None, Some("information_schema.sql_identifier"))(x => extract(x).udtName, (row, value) => merge(row, extract(row).copy(udtName = value)))
  override val domainCatalog = new OptField[SqlIdentifier, Row](prefix, "domain_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).domainCatalog, (row, value) => merge(row, extract(row).copy(domainCatalog = value)))
  override val domainSchema = new OptField[SqlIdentifier, Row](prefix, "domain_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).domainSchema, (row, value) => merge(row, extract(row).copy(domainSchema = value)))
  override val domainName = new OptField[SqlIdentifier, Row](prefix, "domain_name", None, Some("information_schema.sql_identifier"))(x => extract(x).domainName, (row, value) => merge(row, extract(row).copy(domainName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](udtCatalog, udtSchema, udtName, domainCatalog, domainSchema, domainName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => DomainUdtUsageViewRow, merge: (NewRow, DomainUdtUsageViewRow) => NewRow): DomainUdtUsageViewStructure[NewRow] =
    new DomainUdtUsageViewStructure(prefix, extract, merge)
}
