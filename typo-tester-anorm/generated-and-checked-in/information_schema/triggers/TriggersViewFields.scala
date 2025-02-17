/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.TimeStamp
import typo.dsl.SqlExpr.OptField

trait TriggersViewFields[Row] {
  val triggerCatalog: OptField[SqlIdentifier, Row]
  val triggerSchema: OptField[SqlIdentifier, Row]
  val triggerName: OptField[SqlIdentifier, Row]
  val eventManipulation: OptField[CharacterData, Row]
  val eventObjectCatalog: OptField[SqlIdentifier, Row]
  val eventObjectSchema: OptField[SqlIdentifier, Row]
  val eventObjectTable: OptField[SqlIdentifier, Row]
  val actionOrder: OptField[CardinalNumber, Row]
  val actionCondition: OptField[CharacterData, Row]
  val actionStatement: OptField[CharacterData, Row]
  val actionOrientation: OptField[CharacterData, Row]
  val actionTiming: OptField[CharacterData, Row]
  val actionReferenceOldTable: OptField[SqlIdentifier, Row]
  val actionReferenceNewTable: OptField[SqlIdentifier, Row]
  val actionReferenceOldRow: OptField[SqlIdentifier, Row]
  val actionReferenceNewRow: OptField[SqlIdentifier, Row]
  val created: OptField[TimeStamp, Row]
}
object TriggersViewFields extends TriggersViewStructure[TriggersViewRow](None, identity, (_, x) => x)

