/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.OptField

trait ColumnPrivilegesViewFields[Row] {
  val grantor: OptField[SqlIdentifier, Row]
  val grantee: OptField[SqlIdentifier, Row]
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
  val columnName: OptField[SqlIdentifier, Row]
  val privilegeType: OptField[CharacterData, Row]
  val isGrantable: OptField[YesOrNo, Row]
}
object ColumnPrivilegesViewFields extends ColumnPrivilegesViewStructure[ColumnPrivilegesViewRow](None, identity, (_, x) => x)

