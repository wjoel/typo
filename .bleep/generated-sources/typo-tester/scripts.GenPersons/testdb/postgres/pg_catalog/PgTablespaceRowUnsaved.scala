package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTablespaceRowUnsaved(
  spcname: String,
  spcowner: Long,
  spcacl: Option[Array[String]],
  spcoptions: Option[Array[String]]
)
object PgTablespaceRowUnsaved {
  implicit val oFormat: OFormat[PgTablespaceRowUnsaved] = new OFormat[PgTablespaceRowUnsaved]{
    override def writes(o: PgTablespaceRowUnsaved): JsObject =
      Json.obj(
        "spcname" -> o.spcname,
      "spcowner" -> o.spcowner,
      "spcacl" -> o.spcacl,
      "spcoptions" -> o.spcoptions
      )

    override def reads(json: JsValue): JsResult[PgTablespaceRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgTablespaceRowUnsaved(
            spcname = json.\("spcname").as[String],
            spcowner = json.\("spcowner").as[Long],
            spcacl = json.\("spcacl").toOption.map(_.as[Array[String]]),
            spcoptions = json.\("spcoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
