/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class UmRow(
  id: Option[/* bpchar */ String],
  /** Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.unitmeasure.UnitmeasureRow.name]] */
  name: Option[Name],
  /** Points to [[production.unitmeasure.UnitmeasureRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object UmRow {
  implicit val oFormat: OFormat[UmRow] = new OFormat[UmRow]{
    override def writes(o: UmRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "unitmeasurecode" -> o.unitmeasurecode,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[UmRow] = {
      JsResult.fromTry(
        Try(
          UmRow(
            id = json.\("id").toOption.map(_.as[/* bpchar */ String]),
            unitmeasurecode = json.\("unitmeasurecode").toOption.map(_.as[UnitmeasureId]),
            name = json.\("name").toOption.map(_.as[Name]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
