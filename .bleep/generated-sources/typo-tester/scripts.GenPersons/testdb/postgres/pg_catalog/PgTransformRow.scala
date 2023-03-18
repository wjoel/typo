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

case class PgTransformRow(
  oid: Long,
  trftype: Long,
  trflang: Long,
  trffromsql: String,
  trftosql: String
)

object PgTransformRow {
  implicit val rowParser: RowParser[PgTransformRow] = { row =>
    Success(
      PgTransformRow(
        oid = row[Long]("oid"),
        trftype = row[Long]("trftype"),
        trflang = row[Long]("trflang"),
        trffromsql = row[String]("trffromsql"),
        trftosql = row[String]("trftosql")
      )
    )
  }

  implicit val oFormat: OFormat[PgTransformRow] = new OFormat[PgTransformRow]{
    override def writes(o: PgTransformRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "trftype" -> o.trftype,
      "trflang" -> o.trflang,
      "trffromsql" -> o.trffromsql,
      "trftosql" -> o.trftosql
      )

    override def reads(json: JsValue): JsResult[PgTransformRow] = {
      JsResult.fromTry(
        Try(
          PgTransformRow(
            oid = json.\("oid").as[Long],
            trftype = json.\("trftype").as[Long],
            trflang = json.\("trflang").as[Long],
            trffromsql = json.\("trffromsql").as[String],
            trftosql = json.\("trftosql").as[String]
          )
        )
      )
    }
  }
}