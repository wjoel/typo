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

case class PgStatisticExtRow(
  oid: Long,
  stxrelid: Long,
  stxname: String,
  stxnamespace: Long,
  stxowner: Long,
  stxstattarget: Int,
  stxkeys: String,
  stxkind: Array[String],
  stxexprs: Option[String]
)

object PgStatisticExtRow {
  implicit val rowParser: RowParser[PgStatisticExtRow] = { row =>
    Success(
      PgStatisticExtRow(
        oid = row[Long]("oid"),
        stxrelid = row[Long]("stxrelid"),
        stxname = row[String]("stxname"),
        stxnamespace = row[Long]("stxnamespace"),
        stxowner = row[Long]("stxowner"),
        stxstattarget = row[Int]("stxstattarget"),
        stxkeys = row[String]("stxkeys"),
        stxkind = row[Array[String]]("stxkind"),
        stxexprs = row[Option[String]]("stxexprs")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatisticExtRow] = new OFormat[PgStatisticExtRow]{
    override def writes(o: PgStatisticExtRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "stxrelid" -> o.stxrelid,
      "stxname" -> o.stxname,
      "stxnamespace" -> o.stxnamespace,
      "stxowner" -> o.stxowner,
      "stxstattarget" -> o.stxstattarget,
      "stxkeys" -> o.stxkeys,
      "stxkind" -> o.stxkind,
      "stxexprs" -> o.stxexprs
      )

    override def reads(json: JsValue): JsResult[PgStatisticExtRow] = {
      JsResult.fromTry(
        Try(
          PgStatisticExtRow(
            oid = json.\("oid").as[Long],
            stxrelid = json.\("stxrelid").as[Long],
            stxname = json.\("stxname").as[String],
            stxnamespace = json.\("stxnamespace").as[Long],
            stxowner = json.\("stxowner").as[Long],
            stxstattarget = json.\("stxstattarget").as[Int],
            stxkeys = json.\("stxkeys").as[String],
            stxkind = json.\("stxkind").as[Array[String]],
            stxexprs = json.\("stxexprs").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}