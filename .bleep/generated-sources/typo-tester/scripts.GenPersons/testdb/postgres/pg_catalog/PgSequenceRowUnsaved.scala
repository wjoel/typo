package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgSequenceRowUnsaved(
  seqtypid: Long,
  seqstart: Long,
  seqincrement: Long,
  seqmax: Long,
  seqmin: Long,
  seqcache: Long,
  seqcycle: Boolean
)
object PgSequenceRowUnsaved {
  implicit val oFormat: OFormat[PgSequenceRowUnsaved] = new OFormat[PgSequenceRowUnsaved]{
    override def writes(o: PgSequenceRowUnsaved): JsObject =
      Json.obj(
        "seqtypid" -> o.seqtypid,
      "seqstart" -> o.seqstart,
      "seqincrement" -> o.seqincrement,
      "seqmax" -> o.seqmax,
      "seqmin" -> o.seqmin,
      "seqcache" -> o.seqcache,
      "seqcycle" -> o.seqcycle
      )

    override def reads(json: JsValue): JsResult[PgSequenceRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgSequenceRowUnsaved(
            seqtypid = json.\("seqtypid").as[Long],
            seqstart = json.\("seqstart").as[Long],
            seqincrement = json.\("seqincrement").as[Long],
            seqmax = json.\("seqmax").as[Long],
            seqmin = json.\("seqmin").as[Long],
            seqcache = json.\("seqcache").as[Long],
            seqcycle = json.\("seqcycle").as[Boolean]
          )
        )
      )
    }
  }
}
