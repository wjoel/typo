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

case class PgTsDictRow(
  oid: PgTsDictId,
  dictname: String,
  dictnamespace: Long,
  dictowner: Long,
  dicttemplate: Long,
  dictinitoption: Option[String]
)

object PgTsDictRow {
  implicit val rowParser: RowParser[PgTsDictRow] = { row =>
    Success(
      PgTsDictRow(
        oid = row[PgTsDictId]("oid"),
        dictname = row[String]("dictname"),
        dictnamespace = row[Long]("dictnamespace"),
        dictowner = row[Long]("dictowner"),
        dicttemplate = row[Long]("dicttemplate"),
        dictinitoption = row[Option[String]]("dictinitoption")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsDictRow] = new OFormat[PgTsDictRow]{
    override def writes(o: PgTsDictRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "dictname" -> o.dictname,
      "dictnamespace" -> o.dictnamespace,
      "dictowner" -> o.dictowner,
      "dicttemplate" -> o.dicttemplate,
      "dictinitoption" -> o.dictinitoption
      )

    override def reads(json: JsValue): JsResult[PgTsDictRow] = {
      JsResult.fromTry(
        Try(
          PgTsDictRow(
            oid = json.\("oid").as[PgTsDictId],
            dictname = json.\("dictname").as[String],
            dictnamespace = json.\("dictnamespace").as[Long],
            dictowner = json.\("dictowner").as[Long],
            dicttemplate = json.\("dicttemplate").as[Long],
            dictinitoption = json.\("dictinitoption").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
