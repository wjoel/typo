/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_usage_grants

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.OptField

trait RoleUsageGrantsViewFields[Row] {
  val grantor: OptField[SqlIdentifier, Row]
  val grantee: OptField[SqlIdentifier, Row]
  val objectCatalog: OptField[SqlIdentifier, Row]
  val objectSchema: OptField[SqlIdentifier, Row]
  val objectName: OptField[SqlIdentifier, Row]
  val objectType: OptField[CharacterData, Row]
  val privilegeType: OptField[CharacterData, Row]
  val isGrantable: OptField[YesOrNo, Row]
}
object RoleUsageGrantsViewFields extends RoleUsageGrantsViewStructure[RoleUsageGrantsViewRow](None, identity, (_, x) => x)

