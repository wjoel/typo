package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgCastRowUnsaved(
  castsource: Long,
  casttarget: Long,
  castfunc: Long,
  castcontext: String,
  castmethod: String
)
object PgCastRowUnsaved {
  implicit val oFormat: OFormat[PgCastRowUnsaved] = new OFormat[PgCastRowUnsaved]{
    override def writes(o: PgCastRowUnsaved): JsObject =
      Json.obj(
        "castsource" -> o.castsource,
      "casttarget" -> o.casttarget,
      "castfunc" -> o.castfunc,
      "castcontext" -> o.castcontext,
      "castmethod" -> o.castmethod
      )

    override def reads(json: JsValue): JsResult[PgCastRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgCastRowUnsaved(
            castsource = json.\("castsource").as[Long],
            casttarget = json.\("casttarget").as[Long],
            castfunc = json.\("castfunc").as[Long],
            castcontext = json.\("castcontext").as[String],
            castmethod = json.\("castmethod").as[String]
          )
        )
      )
    }
  }
}
