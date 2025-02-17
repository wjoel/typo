/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_udt_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait ColumnUdtUsageViewFields[Row] {
  val udtCatalog: OptField[SqlIdentifier, Row]
  val udtSchema: OptField[SqlIdentifier, Row]
  val udtName: OptField[SqlIdentifier, Row]
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
  val columnName: OptField[SqlIdentifier, Row]
}
object ColumnUdtUsageViewFields extends ColumnUdtUsageViewStructure[ColumnUdtUsageViewRow](None, identity, (_, x) => x)

