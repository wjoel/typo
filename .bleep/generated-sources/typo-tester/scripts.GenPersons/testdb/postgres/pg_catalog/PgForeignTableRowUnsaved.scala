package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgForeignTableRowUnsaved(
  ftserver: Long,
  ftoptions: Option[Array[String]]
)
object PgForeignTableRowUnsaved {
  implicit val oFormat: OFormat[PgForeignTableRowUnsaved] = new OFormat[PgForeignTableRowUnsaved]{
    override def writes(o: PgForeignTableRowUnsaved): JsObject =
      Json.obj(
        "ftserver" -> o.ftserver,
      "ftoptions" -> o.ftoptions
      )

    override def reads(json: JsValue): JsResult[PgForeignTableRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgForeignTableRowUnsaved(
            ftserver = json.\("ftserver").as[Long],
            ftoptions = json.\("ftoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
