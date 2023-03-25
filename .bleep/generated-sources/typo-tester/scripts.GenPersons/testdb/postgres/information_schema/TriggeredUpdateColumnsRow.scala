/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class TriggeredUpdateColumnsRow(
  triggerCatalog: Option[String],
  triggerSchema: Option[String],
  triggerName: Option[String],
  eventObjectCatalog: Option[String],
  eventObjectSchema: Option[String],
  eventObjectTable: Option[String],
  eventObjectColumn: Option[String]
)

object TriggeredUpdateColumnsRow {
  def rowParser(prefix: String): RowParser[TriggeredUpdateColumnsRow] = { row =>
    Success(
      TriggeredUpdateColumnsRow(
        triggerCatalog = row[Option[String]](prefix + "trigger_catalog"),
        triggerSchema = row[Option[String]](prefix + "trigger_schema"),
        triggerName = row[Option[String]](prefix + "trigger_name"),
        eventObjectCatalog = row[Option[String]](prefix + "event_object_catalog"),
        eventObjectSchema = row[Option[String]](prefix + "event_object_schema"),
        eventObjectTable = row[Option[String]](prefix + "event_object_table"),
        eventObjectColumn = row[Option[String]](prefix + "event_object_column")
      )
    )
  }

  implicit val oFormat: OFormat[TriggeredUpdateColumnsRow] = new OFormat[TriggeredUpdateColumnsRow]{
    override def writes(o: TriggeredUpdateColumnsRow): JsObject =
      Json.obj(
        "trigger_catalog" -> o.triggerCatalog,
      "trigger_schema" -> o.triggerSchema,
      "trigger_name" -> o.triggerName,
      "event_object_catalog" -> o.eventObjectCatalog,
      "event_object_schema" -> o.eventObjectSchema,
      "event_object_table" -> o.eventObjectTable,
      "event_object_column" -> o.eventObjectColumn
      )

    override def reads(json: JsValue): JsResult[TriggeredUpdateColumnsRow] = {
      JsResult.fromTry(
        Try(
          TriggeredUpdateColumnsRow(
            triggerCatalog = json.\("trigger_catalog").toOption.map(_.as[String]),
            triggerSchema = json.\("trigger_schema").toOption.map(_.as[String]),
            triggerName = json.\("trigger_name").toOption.map(_.as[String]),
            eventObjectCatalog = json.\("event_object_catalog").toOption.map(_.as[String]),
            eventObjectSchema = json.\("event_object_schema").toOption.map(_.as[String]),
            eventObjectTable = json.\("event_object_table").toOption.map(_.as[String]),
            eventObjectColumn = json.\("event_object_column").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
