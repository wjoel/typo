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

case class PgStatisticExtDataRow(
  stxoid: Long,
  stxdndistinct: Option[String],
  stxddependencies: Option[String],
  stxdmcv: Option[String],
  stxdexpr: Option[Array[String]]
)

object PgStatisticExtDataRow {
  implicit val rowParser: RowParser[PgStatisticExtDataRow] = { row =>
    Success(
      PgStatisticExtDataRow(
        stxoid = row[Long]("stxoid"),
        stxdndistinct = row[Option[String]]("stxdndistinct"),
        stxddependencies = row[Option[String]]("stxddependencies"),
        stxdmcv = row[Option[String]]("stxdmcv"),
        stxdexpr = row[Option[Array[String]]]("stxdexpr")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatisticExtDataRow] = new OFormat[PgStatisticExtDataRow]{
    override def writes(o: PgStatisticExtDataRow): JsObject =
      Json.obj(
        "stxoid" -> o.stxoid,
      "stxdndistinct" -> o.stxdndistinct,
      "stxddependencies" -> o.stxddependencies,
      "stxdmcv" -> o.stxdmcv,
      "stxdexpr" -> o.stxdexpr
      )

    override def reads(json: JsValue): JsResult[PgStatisticExtDataRow] = {
      JsResult.fromTry(
        Try(
          PgStatisticExtDataRow(
            stxoid = json.\("stxoid").as[Long],
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