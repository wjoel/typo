package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgEnumRowUnsaved(
  enumtypid: Long,
  enumsortorder: Float,
  enumlabel: String
)
object PgEnumRowUnsaved {
  implicit val oFormat: OFormat[PgEnumRowUnsaved] = new OFormat[PgEnumRowUnsaved]{
    override def writes(o: PgEnumRowUnsaved): JsObject =
      Json.obj(
        "enumtypid" -> o.enumtypid,
      "enumsortorder" -> o.enumsortorder,
      "enumlabel" -> o.enumlabel
      )

    override def reads(json: JsValue): JsResult[PgEnumRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgEnumRowUnsaved(
            enumtypid = json.\("enumtypid").as[Long],
            enumsortorder = json.\("enumsortorder").as[Float],
            enumlabel = json.\("enumlabel").as[String]
          )
        )
      )
    }
  }
}