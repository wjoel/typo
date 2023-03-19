package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatisticExtRowUnsaved(
  stxrelid: Long,
  stxname: String,
  stxnamespace: Long,
  stxowner: Long,
  stxstattarget: Int,
  stxkeys: String,
  stxkind: Array[String],
  stxexprs: Option[String]
)
object PgStatisticExtRowUnsaved {
  implicit val oFormat: OFormat[PgStatisticExtRowUnsaved] = new OFormat[PgStatisticExtRowUnsaved]{
    override def writes(o: PgStatisticExtRowUnsaved): JsObject =
      Json.obj(
        "stxrelid" -> o.stxrelid,
      "stxname" -> o.stxname,
      "stxnamespace" -> o.stxnamespace,
      "stxowner" -> o.stxowner,
      "stxstattarget" -> o.stxstattarget,
      "stxkeys" -> o.stxkeys,
      "stxkind" -> o.stxkind,
      "stxexprs" -> o.stxexprs
      )

    override def reads(json: JsValue): JsResult[PgStatisticExtRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgStatisticExtRowUnsaved(
            stxrelid = json.\("stxrelid").as[Long],
            stxname = json.\("stxname").as[String],
            stxnamespace = json.\("stxnamespace").as[Long],
            stxowner = json.\("stxowner").as[Long],
            stxstattarget = json.\("stxstattarget").as[Int],
            stxkeys = json.\("stxkeys").as[String],
            stxkind = json.\("stxkind").as[Array[String]],
            stxexprs = json.\("stxexprs").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}