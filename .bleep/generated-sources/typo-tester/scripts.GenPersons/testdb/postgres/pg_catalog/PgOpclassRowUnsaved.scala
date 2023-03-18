package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgOpclassRowUnsaved(
  opcmethod: Long,
  opcname: String,
  opcnamespace: Long,
  opcowner: Long,
  opcfamily: Long,
  opcintype: Long,
  opcdefault: Boolean,
  opckeytype: Long
)
object PgOpclassRowUnsaved {
  implicit val oFormat: OFormat[PgOpclassRowUnsaved] = new OFormat[PgOpclassRowUnsaved]{
    override def writes(o: PgOpclassRowUnsaved): JsObject =
      Json.obj(
        "opcmethod" -> o.opcmethod,
      "opcname" -> o.opcname,
      "opcnamespace" -> o.opcnamespace,
      "opcowner" -> o.opcowner,
      "opcfamily" -> o.opcfamily,
      "opcintype" -> o.opcintype,
      "opcdefault" -> o.opcdefault,
      "opckeytype" -> o.opckeytype
      )

    override def reads(json: JsValue): JsResult[PgOpclassRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgOpclassRowUnsaved(
            opcmethod = json.\("opcmethod").as[Long],
            opcname = json.\("opcname").as[String],
            opcnamespace = json.\("opcnamespace").as[Long],
            opcowner = json.\("opcowner").as[Long],
            opcfamily = json.\("opcfamily").as[Long],
            opcintype = json.\("opcintype").as[Long],
            opcdefault = json.\("opcdefault").as[Boolean],
            opckeytype = json.\("opckeytype").as[Long]
          )
        )
      )
    }
  }
}
