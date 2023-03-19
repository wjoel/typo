package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgLanguageRowUnsaved(
  lanname: String,
  lanowner: Long,
  lanispl: Boolean,
  lanpltrusted: Boolean,
  lanplcallfoid: Long,
  laninline: Long,
  lanvalidator: Long,
  lanacl: Option[Array[String]]
)
object PgLanguageRowUnsaved {
  implicit val oFormat: OFormat[PgLanguageRowUnsaved] = new OFormat[PgLanguageRowUnsaved]{
    override def writes(o: PgLanguageRowUnsaved): JsObject =
      Json.obj(
        "lanname" -> o.lanname,
      "lanowner" -> o.lanowner,
      "lanispl" -> o.lanispl,
      "lanpltrusted" -> o.lanpltrusted,
      "lanplcallfoid" -> o.lanplcallfoid,
      "laninline" -> o.laninline,
      "lanvalidator" -> o.lanvalidator,
      "lanacl" -> o.lanacl
      )

    override def reads(json: JsValue): JsResult[PgLanguageRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgLanguageRowUnsaved(
            lanname = json.\("lanname").as[String],
            lanowner = json.\("lanowner").as[Long],
            lanispl = json.\("lanispl").as[Boolean],
            lanpltrusted = json.\("lanpltrusted").as[Boolean],
            lanplcallfoid = json.\("lanplcallfoid").as[Long],
            laninline = json.\("laninline").as[Long],
            lanvalidator = json.\("lanvalidator").as[Long],
            lanacl = json.\("lanacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}