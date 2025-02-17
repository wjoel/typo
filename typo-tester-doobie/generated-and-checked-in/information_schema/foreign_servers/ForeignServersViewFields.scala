/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_servers

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait ForeignServersViewFields[Row] {
  val foreignServerCatalog: OptField[SqlIdentifier, Row]
  val foreignServerName: OptField[SqlIdentifier, Row]
  val foreignDataWrapperCatalog: OptField[SqlIdentifier, Row]
  val foreignDataWrapperName: OptField[SqlIdentifier, Row]
  val foreignServerType: OptField[CharacterData, Row]
  val foreignServerVersion: OptField[CharacterData, Row]
  val authorizationIdentifier: OptField[SqlIdentifier, Row]
}
object ForeignServersViewFields extends ForeignServersViewStructure[ForeignServersViewRow](None, identity, (_, x) => x)

