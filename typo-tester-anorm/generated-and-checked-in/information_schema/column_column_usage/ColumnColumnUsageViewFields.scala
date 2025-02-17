/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_column_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait ColumnColumnUsageViewFields[Row] {
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
  val columnName: OptField[SqlIdentifier, Row]
  val dependentColumn: OptField[SqlIdentifier, Row]
}
object ColumnColumnUsageViewFields extends ColumnColumnUsageViewStructure[ColumnColumnUsageViewRow](None, identity, (_, x) => x)

