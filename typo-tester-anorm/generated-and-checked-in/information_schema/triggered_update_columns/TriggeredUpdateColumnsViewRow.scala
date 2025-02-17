/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggered_update_columns

import adventureworks.information_schema.SqlIdentifier
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

case class TriggeredUpdateColumnsViewRow(
  triggerCatalog: Option[SqlIdentifier],
  triggerSchema: Option[SqlIdentifier],
  triggerName: Option[SqlIdentifier],
  eventObjectCatalog: Option[SqlIdentifier],
  eventObjectSchema: Option[SqlIdentifier],
  eventObjectTable: Option[SqlIdentifier],
  eventObjectColumn: Option[SqlIdentifier]
)

object TriggeredUpdateColumnsViewRow {
  implicit lazy val reads: Reads[TriggeredUpdateColumnsViewRow] = Reads[TriggeredUpdateColumnsViewRow](json => JsResult.fromTry(
      Try(
        TriggeredUpdateColumnsViewRow(
          triggerCatalog = json.\("trigger_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          triggerSchema = json.\("trigger_schema").toOption.map(_.as(SqlIdentifier.reads)),
          triggerName = json.\("trigger_name").toOption.map(_.as(SqlIdentifier.reads)),
          eventObjectCatalog = json.\("event_object_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          eventObjectSchema = json.\("event_object_schema").toOption.map(_.as(SqlIdentifier.reads)),
          eventObjectTable = json.\("event_object_table").toOption.map(_.as(SqlIdentifier.reads)),
          eventObjectColumn = json.\("event_object_column").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TriggeredUpdateColumnsViewRow] = RowParser[TriggeredUpdateColumnsViewRow] { row =>
    Success(
      TriggeredUpdateColumnsViewRow(
        triggerCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        triggerSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        triggerName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        eventObjectCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        eventObjectSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        eventObjectTable = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        eventObjectColumn = row(idx + 6)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit lazy val writes: OWrites[TriggeredUpdateColumnsViewRow] = OWrites[TriggeredUpdateColumnsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "trigger_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.triggerCatalog),
      "trigger_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.triggerSchema),
      "trigger_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.triggerName),
      "event_object_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectCatalog),
      "event_object_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectSchema),
      "event_object_table" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectTable),
      "event_object_column" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.eventObjectColumn)
    ))
  )
}
