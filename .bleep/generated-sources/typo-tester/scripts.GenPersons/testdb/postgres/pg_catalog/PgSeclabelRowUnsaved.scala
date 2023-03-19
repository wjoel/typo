package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgSeclabelRowUnsaved(
  label: String
)
object PgSeclabelRowUnsaved {
  implicit val oFormat: OFormat[PgSeclabelRowUnsaved] = new OFormat[PgSeclabelRowUnsaved]{
    override def writes(o: PgSeclabelRowUnsaved): JsObject =
      Json.obj(
        "label" -> o.label
      )

    override def reads(json: JsValue): JsResult[PgSeclabelRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgSeclabelRowUnsaved(
            label = json.\("label").as[String]
          )
        )
      )
    }
  }
}