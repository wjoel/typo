package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAuthMembersRowUnsaved(
  grantor: Long,
  adminOption: Boolean
)
object PgAuthMembersRowUnsaved {
  implicit val oFormat: OFormat[PgAuthMembersRowUnsaved] = new OFormat[PgAuthMembersRowUnsaved]{
    override def writes(o: PgAuthMembersRowUnsaved): JsObject =
      Json.obj(
        "grantor" -> o.grantor,
      "admin_option" -> o.adminOption
      )

    override def reads(json: JsValue): JsResult[PgAuthMembersRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgAuthMembersRowUnsaved(
            grantor = json.\("grantor").as[Long],
            adminOption = json.\("admin_option").as[Boolean]
          )
        )
      )
    }
  }
}
