package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTsDictRowUnsaved(
  dictname: String,
  dictnamespace: Long,
  dictowner: Long,
  dicttemplate: Long,
  dictinitoption: Option[String]
)
object PgTsDictRowUnsaved {
  implicit val oFormat: OFormat[PgTsDictRowUnsaved] = new OFormat[PgTsDictRowUnsaved]{
    override def writes(o: PgTsDictRowUnsaved): JsObject =
      Json.obj(
        "dictname" -> o.dictname,
      "dictnamespace" -> o.dictnamespace,
      "dictowner" -> o.dictowner,
      "dicttemplate" -> o.dicttemplate,
      "dictinitoption" -> o.dictinitoption
      )

    override def reads(json: JsValue): JsResult[PgTsDictRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgTsDictRowUnsaved(
            dictname = json.\("dictname").as[String],
            dictnamespace = json.\("dictnamespace").as[Long],
            dictowner = json.\("dictowner").as[Long],
            dicttemplate = json.\("dicttemplate").as[Long],
            dictinitoption = json.\("dictinitoption").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
