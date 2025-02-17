/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_constraints

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.OptField

trait TableConstraintsViewFields[Row] {
  val constraintCatalog: OptField[SqlIdentifier, Row]
  val constraintSchema: OptField[SqlIdentifier, Row]
  val constraintName: OptField[SqlIdentifier, Row]
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
  val constraintType: OptField[CharacterData, Row]
  val isDeferrable: OptField[YesOrNo, Row]
  val initiallyDeferred: OptField[YesOrNo, Row]
  val enforced: OptField[YesOrNo, Row]
}
object TableConstraintsViewFields extends TableConstraintsViewStructure[TableConstraintsViewRow](None, identity, (_, x) => x)

