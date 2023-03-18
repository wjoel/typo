package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgDescriptionRowUnsaved(
  description: String
)
object PgDescriptionRowUnsaved {
  implicit val oFormat: OFormat[PgDescriptionRowUnsaved] = new OFormat[PgDescriptionRowUnsaved]{
    override def writes(o: PgDescriptionRowUnsaved): JsObject =
      Json.obj(
        "description" -> o.description
      )

    override def reads(json: JsValue): JsResult[PgDescriptionRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgDescriptionRowUnsaved(
            description = json.\("description").as[String]
          )
        )
      )
    }
  }
}
