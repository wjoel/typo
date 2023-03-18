package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgInheritsRowUnsaved(
  inhparent: Long,
  inhdetachpending: Boolean
)
object PgInheritsRowUnsaved {
  implicit val oFormat: OFormat[PgInheritsRowUnsaved] = new OFormat[PgInheritsRowUnsaved]{
    override def writes(o: PgInheritsRowUnsaved): JsObject =
      Json.obj(
        "inhparent" -> o.inhparent,
      "inhdetachpending" -> o.inhdetachpending
      )

    override def reads(json: JsValue): JsResult[PgInheritsRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgInheritsRowUnsaved(
            inhparent = json.\("inhparent").as[Long],
            inhdetachpending = json.\("inhdetachpending").as[Boolean]
          )
        )
      )
    }
  }
}
