package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTsConfigMapId(mapcfg: Long, maptokentype: Int, mapseqno: Int)
object PgTsConfigMapId {
  implicit val ordering: Ordering[PgTsConfigMapId] = Ordering.by(x => (x.mapcfg, x.maptokentype, x.mapseqno))
  implicit val oFormat: OFormat[PgTsConfigMapId] = new OFormat[PgTsConfigMapId]{
    override def writes(o: PgTsConfigMapId): JsObject =
      Json.obj(
        "mapcfg" -> o.mapcfg,
      "maptokentype" -> o.maptokentype,
      "mapseqno" -> o.mapseqno
      )

    override def reads(json: JsValue): JsResult[PgTsConfigMapId] = {
      JsResult.fromTry(
        Try(
          PgTsConfigMapId(
            mapcfg = json.\("mapcfg").as[Long],
            maptokentype = json.\("maptokentype").as[Int],
            mapseqno = json.\("mapseqno").as[Int]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgTsConfigMapId] = { row =>
    Success(
      PgTsConfigMapId(
        mapcfg = row[Long]("mapcfg"),
        maptokentype = row[Int]("maptokentype"),
        mapseqno = row[Int]("mapseqno")
      )
    )
  }

}
