package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgReplicationOriginRowUnsaved(
  roname: String
)
object PgReplicationOriginRowUnsaved {
  implicit val oFormat: OFormat[PgReplicationOriginRowUnsaved] = new OFormat[PgReplicationOriginRowUnsaved]{
    override def writes(o: PgReplicationOriginRowUnsaved): JsObject =
      Json.obj(
        "roname" -> o.roname
      )

    override def reads(json: JsValue): JsResult[PgReplicationOriginRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgReplicationOriginRowUnsaved(
            roname = json.\("roname").as[String]
          )
        )
      )
    }
  }
}
