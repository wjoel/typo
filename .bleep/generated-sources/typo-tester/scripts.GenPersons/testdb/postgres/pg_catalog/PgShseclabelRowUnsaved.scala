package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgShseclabelRowUnsaved(
  label: String
)
object PgShseclabelRowUnsaved {
  implicit val oFormat: OFormat[PgShseclabelRowUnsaved] = new OFormat[PgShseclabelRowUnsaved]{
    override def writes(o: PgShseclabelRowUnsaved): JsObject =
      Json.obj(
        "label" -> o.label
      )

    override def reads(json: JsValue): JsResult[PgShseclabelRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgShseclabelRowUnsaved(
            label = json.\("label").as[String]
          )
        )
      )
    }
  }
}
