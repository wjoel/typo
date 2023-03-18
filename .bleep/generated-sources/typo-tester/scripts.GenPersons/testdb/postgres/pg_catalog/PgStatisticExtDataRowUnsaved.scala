package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatisticExtDataRowUnsaved(
  stxdndistinct: Option[String],
  stxddependencies: Option[String],
  stxdmcv: Option[String],
  stxdexpr: Option[Array[String]]
)
object PgStatisticExtDataRowUnsaved {
  implicit val oFormat: OFormat[PgStatisticExtDataRowUnsaved] = new OFormat[PgStatisticExtDataRowUnsaved]{
    override def writes(o: PgStatisticExtDataRowUnsaved): JsObject =
      Json.obj(
        "stxdndistinct" -> o.stxdndistinct,
      "stxddependencies" -> o.stxddependencies,
      "stxdmcv" -> o.stxdmcv,
      "stxdexpr" -> o.stxdexpr
      )

    override def reads(json: JsValue): JsResult[PgStatisticExtDataRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgStatisticExtDataRowUnsaved(
            stxdndistinct = json.\("stxdndistinct").toOption.map(_.as[String]),
            stxddependencies = json.\("stxddependencies").toOption.map(_.as[String]),
            stxdmcv = json.\("stxdmcv").toOption.map(_.as[String]),
            stxdexpr = json.\("stxdexpr").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
