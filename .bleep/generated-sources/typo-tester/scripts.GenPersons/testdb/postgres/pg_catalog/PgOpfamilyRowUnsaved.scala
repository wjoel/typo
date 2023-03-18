package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgOpfamilyRowUnsaved(
  opfmethod: Long,
  opfname: String,
  opfnamespace: Long,
  opfowner: Long
)
object PgOpfamilyRowUnsaved {
  implicit val oFormat: OFormat[PgOpfamilyRowUnsaved] = new OFormat[PgOpfamilyRowUnsaved]{
    override def writes(o: PgOpfamilyRowUnsaved): JsObject =
      Json.obj(
        "opfmethod" -> o.opfmethod,
      "opfname" -> o.opfname,
      "opfnamespace" -> o.opfnamespace,
      "opfowner" -> o.opfowner
      )

    override def reads(json: JsValue): JsResult[PgOpfamilyRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgOpfamilyRowUnsaved(
            opfmethod = json.\("opfmethod").as[Long],
            opfname = json.\("opfname").as[String],
            opfnamespace = json.\("opfnamespace").as[Long],
            opfowner = json.\("opfowner").as[Long]
          )
        )
      )
    }
  }
}
