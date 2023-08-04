/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_table_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait ViewTableUsageViewFields[Row] {
  val viewCatalog: OptField[SqlIdentifier, Row]
  val viewSchema: OptField[SqlIdentifier, Row]
  val viewName: OptField[SqlIdentifier, Row]
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
}
object ViewTableUsageViewFields extends ViewTableUsageViewStructure[ViewTableUsageViewRow](None, identity, (_, x) => x)
