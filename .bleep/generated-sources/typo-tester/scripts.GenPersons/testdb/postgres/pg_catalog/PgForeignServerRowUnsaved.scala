package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgForeignServerRowUnsaved(
  srvname: String,
  srvowner: Long,
  srvfdw: Long,
  srvtype: Option[String],
  srvversion: Option[String],
  srvacl: Option[Array[String]],
  srvoptions: Option[Array[String]]
)
object PgForeignServerRowUnsaved {
  implicit val oFormat: OFormat[PgForeignServerRowUnsaved] = new OFormat[PgForeignServerRowUnsaved]{
    override def writes(o: PgForeignServerRowUnsaved): JsObject =
      Json.obj(
        "srvname" -> o.srvname,
      "srvowner" -> o.srvowner,
      "srvfdw" -> o.srvfdw,
      "srvtype" -> o.srvtype,
      "srvversion" -> o.srvversion,
      "srvacl" -> o.srvacl,
      "srvoptions" -> o.srvoptions
      )

    override def reads(json: JsValue): JsResult[PgForeignServerRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgForeignServerRowUnsaved(
            srvname = json.\("srvname").as[String],
            srvowner = json.\("srvowner").as[Long],
            srvfdw = json.\("srvfdw").as[Long],
            srvtype = json.\("srvtype").toOption.map(_.as[String]),
            srvversion = json.\("srvversion").toOption.map(_.as[String]),
            srvacl = json.\("srvacl").toOption.map(_.as[Array[String]]),
            srvoptions = json.\("srvoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
