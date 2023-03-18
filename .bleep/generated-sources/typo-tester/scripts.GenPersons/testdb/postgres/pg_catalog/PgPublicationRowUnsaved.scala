package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPublicationRowUnsaved(
  pubname: String,
  pubowner: Long,
  puballtables: Boolean,
  pubinsert: Boolean,
  pubupdate: Boolean,
  pubdelete: Boolean,
  pubtruncate: Boolean,
  pubviaroot: Boolean
)
object PgPublicationRowUnsaved {
  implicit val oFormat: OFormat[PgPublicationRowUnsaved] = new OFormat[PgPublicationRowUnsaved]{
    override def writes(o: PgPublicationRowUnsaved): JsObject =
      Json.obj(
        "pubname" -> o.pubname,
      "pubowner" -> o.pubowner,
      "puballtables" -> o.puballtables,
      "pubinsert" -> o.pubinsert,
      "pubupdate" -> o.pubupdate,
      "pubdelete" -> o.pubdelete,
      "pubtruncate" -> o.pubtruncate,
      "pubviaroot" -> o.pubviaroot
      )

    override def reads(json: JsValue): JsResult[PgPublicationRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgPublicationRowUnsaved(
            pubname = json.\("pubname").as[String],
            pubowner = json.\("pubowner").as[Long],
            puballtables = json.\("puballtables").as[Boolean],
            pubinsert = json.\("pubinsert").as[Boolean],
            pubupdate = json.\("pubupdate").as[Boolean],
            pubdelete = json.\("pubdelete").as[Boolean],
            pubtruncate = json.\("pubtruncate").as[Boolean],
            pubviaroot = json.\("pubviaroot").as[Boolean]
          )
        )
      )
    }
  }
}
