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
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class TriggersViewRow(
  triggerCatalog: Option[SqlIdentifier],
  triggerSchema: Option[SqlIdentifier],
  triggerName: Option[SqlIdentifier],
  eventManipulation: Option[CharacterData],
  eventObjectCatalog: Option[SqlIdentifier],
  eventObjectSchema: Option[SqlIdentifier],
  eventObjectTable: Option[SqlIdentifier],
  actionOrder: Option[CardinalNumber],
  actionCondition: Option[CharacterData],
  actionStatement: Option[CharacterData],
  actionOrientation: Option[CharacterData],
  actionTiming: Option[CharacterData],
  actionReferenceOldTable: Option[SqlIdentifier],
  actionReferenceNewTable: Option[SqlIdentifier],
  actionReferenceOldRow: Option[SqlIdentifier],
  actionReferenceNewRow: Option[SqlIdentifier],
  created: Option[TimeStamp]
)

object TriggersViewRow {
  implicit lazy val reads: Reads[TriggersViewRow] = Reads[TriggersViewRow](json => JsResult.fromTry(
      Try(
        TriggersViewRow(
          triggerCatalog = json.\("trigger_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          triggerSchema = json.\("trigger_schema").toOption.map(_.as(SqlIdentifier.reads)),
          triggerName = json.\("trigger_name").toOption.map(_.as(SqlIdentifier.reads)),
          eventManipulation = json.\("event_manipulation").toOption.map(_.as(CharacterData.reads)),
          eventObjectCatalog = json.\("event_object_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          eventObjectSchema = json.\("event_object_schema").toOption.map(_.as(SqlIdentifier.reads)),
          eventObjectTable = json.\("event_object_table").toOption.map(_.as(SqlIdentifier.reads)),
          actionOrder = json.\("action_order").toOption.map(_.as(CardinalNumber.reads)),
          actionCondition = json.\("action_condition").toOption.map(_.as(CharacterData.reads)),
          actionStatement = json.\("action_statement").toOption.map(_.as(CharacterData.reads)),
          actionOrientation = json.\("action_orientation").toOption.map(_.as(CharacterData.reads)),
          actionTiming = json.\("action_timing").toOption.map(_.as(CharacterData.reads)),
          actionReferenceOldTable = json.\("action_reference_old_table").toOption.map(_.as(SqlIdentifier.reads)),
          actionReferenceNewTable = json.\("action_reference_new_table").toOption.map(_.as(SqlIdentifier.reads)),
          actionReferenceOldRow = json.\("action_reference_old_row").toOption.map(_.as(SqlIdentifier.reads)),
          actionReferenceNewRow = json.\("action_reference_new_row").toOption.map(_.as(SqlIdentifier.reads)),
          created = json.\("created").toOption.map(_.as(TimeStamp.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TriggersViewRow] = RowParser[TriggersViewRow] { row =>
    Success(
      TriggersViewRow(
        triggerCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        triggerSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        triggerName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        eventManipulation = row(idx + 3)(Column.columnToOption(CharacterData.column)),
        eventObjectCatalog = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        eventObjectSchema = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        eventObjectTable = row(idx + 6)(Column.columnToOption(SqlIdentifier.column)),
        actionOrder = row(idx + 7)(Column.columnToOption(CardinalNumber.column)),
        actionCondition = row(idx + 8)(Column.columnToOption(CharacterData.column)),
        actionStatement = row(idx + 9)(Column.columnToOption(CharacterData.column)),
        actionOrientation = row(idx + 10)(Column.columnToOption(CharacterData.column)),
        actionTiming = row(idx + 11)(Column.columnToOption(CharacterData.column)),
        actionReferenceOldTable = row(idx + 12)(Column.columnToOption(SqlIdentifier.column)),
        actionReferenceNewTable = row(idx + 13)(Column.columnToOption(SqlIdentifier.column)),
        actionReferenceOldRow = row(idx + 14)(Column.columnToOption(SqlIdentifier.column)),
        actionReferenceNewRow = row(idx + 15)(Column.columnToOption(SqlIdentifier.column)),
        created = row(idx + 16)(Column.columnToOption(TimeStamp.column))
      )
    )
  }
  implicit lazy val writes: OWrites[TriggersViewRow] = OWrites[TriggersViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "trigger_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.triggerCatalog),
      "trigger_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.triggerSchema),
      "trigger_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.triggerName),
      "event_manipulation" -> Writes.OptionWrites(CharacterData.writes).writes(o.eventManipulation),
      "event_object_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectCatalog),
      "event_object_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectSchema),
      "event_object_table" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectTable),
      "action_order" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.actionOrder),
      "action_condition" -> Writes.OptionWrites(CharacterData.writes).writes(o.actionCondition),
      "action_statement" -> Writes.OptionWrites(CharacterData.writes).writes(o.actionStatement),
      "action_orientation" -> Writes.OptionWrites(CharacterData.writes).writes(o.actionOrientation),
      "action_timing" -> Writes.OptionWrites(CharacterData.writes).writes(o.actionTiming),
      "action_reference_old_table" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.actionReferenceOldTable),
      "action_reference_new_table" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.actionReferenceNewTable),
      "action_reference_old_row" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.actionReferenceOldRow),
      "action_reference_new_row" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.actionReferenceNewRow),
      "created" -> Writes.OptionWrites(TimeStamp.writes).writes(o.created)
    ))
  )
}
