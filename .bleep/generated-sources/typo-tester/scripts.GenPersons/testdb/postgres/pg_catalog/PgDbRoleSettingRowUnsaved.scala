package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgDbRoleSettingRowUnsaved(
  setconfig: Option[Array[String]]
)
object PgDbRoleSettingRowUnsaved {
  implicit val oFormat: OFormat[PgDbRoleSettingRowUnsaved] = new OFormat[PgDbRoleSettingRowUnsaved]{
    override def writes(o: PgDbRoleSettingRowUnsaved): JsObject =
      Json.obj(
        "setconfig" -> o.setconfig
      )

    override def reads(json: JsValue): JsResult[PgDbRoleSettingRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgDbRoleSettingRowUnsaved(
            setconfig = json.\("setconfig").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
