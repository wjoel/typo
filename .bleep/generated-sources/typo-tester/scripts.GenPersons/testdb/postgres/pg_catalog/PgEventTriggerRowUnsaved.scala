package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgEventTriggerRowUnsaved(
  evtname: String,
  evtevent: String,
  evtowner: Long,
  evtfoid: Long,
  evtenabled: String,
  evttags: Option[Array[String]]
)
object PgEventTriggerRowUnsaved {
  implicit val oFormat: OFormat[PgEventTriggerRowUnsaved] = new OFormat[PgEventTriggerRowUnsaved]{
    override def writes(o: PgEventTriggerRowUnsaved): JsObject =
      Json.obj(
        "evtname" -> o.evtname,
      "evtevent" -> o.evtevent,
      "evtowner" -> o.evtowner,
      "evtfoid" -> o.evtfoid,
      "evtenabled" -> o.evtenabled,
      "evttags" -> o.evttags
      )

    override def reads(json: JsValue): JsResult[PgEventTriggerRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgEventTriggerRowUnsaved(
            evtname = json.\("evtname").as[String],
            evtevent = json.\("evtevent").as[String],
            evtowner = json.\("evtowner").as[Long],
            evtfoid = json.\("evtfoid").as[Long],
            evtenabled = json.\("evtenabled").as[String],
            evttags = json.\("evttags").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
