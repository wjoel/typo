package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgLargeobjectMetadataRowUnsaved(
  lomowner: Long,
  lomacl: Option[Array[String]]
)
object PgLargeobjectMetadataRowUnsaved {
  implicit val oFormat: OFormat[PgLargeobjectMetadataRowUnsaved] = new OFormat[PgLargeobjectMetadataRowUnsaved]{
    override def writes(o: PgLargeobjectMetadataRowUnsaved): JsObject =
      Json.obj(
        "lomowner" -> o.lomowner,
      "lomacl" -> o.lomacl
      )

    override def reads(json: JsValue): JsResult[PgLargeobjectMetadataRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgLargeobjectMetadataRowUnsaved(
            lomowner = json.\("lomowner").as[Long],
            lomacl = json.\("lomacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}