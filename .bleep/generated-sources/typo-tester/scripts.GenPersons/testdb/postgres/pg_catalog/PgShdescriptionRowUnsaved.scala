package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgShdescriptionRowUnsaved(
  description: String
)
object PgShdescriptionRowUnsaved {
  implicit val oFormat: OFormat[PgShdescriptionRowUnsaved] = new OFormat[PgShdescriptionRowUnsaved]{
    override def writes(o: PgShdescriptionRowUnsaved): JsObject =
      Json.obj(
        "description" -> o.description
      )

    override def reads(json: JsValue): JsResult[PgShdescriptionRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgShdescriptionRowUnsaved(
            description = json.\("description").as[String]
          )
        )
      )
    }
  }
}
