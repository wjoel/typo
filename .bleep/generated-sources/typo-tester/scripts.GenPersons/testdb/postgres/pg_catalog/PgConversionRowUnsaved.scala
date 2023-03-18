package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgConversionRowUnsaved(
  conname: String,
  connamespace: Long,
  conowner: Long,
  conforencoding: Int,
  contoencoding: Int,
  conproc: String,
  condefault: Boolean
)
object PgConversionRowUnsaved {
  implicit val oFormat: OFormat[PgConversionRowUnsaved] = new OFormat[PgConversionRowUnsaved]{
    override def writes(o: PgConversionRowUnsaved): JsObject =
      Json.obj(
        "conname" -> o.conname,
      "connamespace" -> o.connamespace,
      "conowner" -> o.conowner,
      "conforencoding" -> o.conforencoding,
      "contoencoding" -> o.contoencoding,
      "conproc" -> o.conproc,
      "condefault" -> o.condefault
      )

    override def reads(json: JsValue): JsResult[PgConversionRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgConversionRowUnsaved(
            conname = json.\("conname").as[String],
            connamespace = json.\("connamespace").as[Long],
            conowner = json.\("conowner").as[Long],
            conforencoding = json.\("conforencoding").as[Int],
            contoencoding = json.\("contoencoding").as[Int],
            conproc = json.\("conproc").as[String],
            condefault = json.\("condefault").as[Boolean]
          )
        )
      )
    }
  }
}
