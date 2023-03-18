package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTsConfigMapRowUnsaved(
  mapdict: Long
)
object PgTsConfigMapRowUnsaved {
  implicit val oFormat: OFormat[PgTsConfigMapRowUnsaved] = new OFormat[PgTsConfigMapRowUnsaved]{
    override def writes(o: PgTsConfigMapRowUnsaved): JsObject =
      Json.obj(
        "mapdict" -> o.mapdict
      )

    override def reads(json: JsValue): JsResult[PgTsConfigMapRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgTsConfigMapRowUnsaved(
            mapdict = json.\("mapdict").as[Long]
          )
        )
      )
    }
  }
}
