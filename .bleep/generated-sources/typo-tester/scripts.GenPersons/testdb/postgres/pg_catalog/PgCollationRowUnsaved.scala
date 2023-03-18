package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgCollationRowUnsaved(
  collname: String,
  collnamespace: Long,
  collowner: Long,
  collprovider: String,
  collisdeterministic: Boolean,
  collencoding: Int,
  collcollate: String,
  collctype: String,
  collversion: Option[String]
)
object PgCollationRowUnsaved {
  implicit val oFormat: OFormat[PgCollationRowUnsaved] = new OFormat[PgCollationRowUnsaved]{
    override def writes(o: PgCollationRowUnsaved): JsObject =
      Json.obj(
        "collname" -> o.collname,
      "collnamespace" -> o.collnamespace,
      "collowner" -> o.collowner,
      "collprovider" -> o.collprovider,
      "collisdeterministic" -> o.collisdeterministic,
      "collencoding" -> o.collencoding,
      "collcollate" -> o.collcollate,
      "collctype" -> o.collctype,
      "collversion" -> o.collversion
      )

    override def reads(json: JsValue): JsResult[PgCollationRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgCollationRowUnsaved(
            collname = json.\("collname").as[String],
            collnamespace = json.\("collnamespace").as[Long],
            collowner = json.\("collowner").as[Long],
            collprovider = json.\("collprovider").as[String],
            collisdeterministic = json.\("collisdeterministic").as[Boolean],
            collencoding = json.\("collencoding").as[Int],
            collcollate = json.\("collcollate").as[String],
            collctype = json.\("collctype").as[String],
            collversion = json.\("collversion").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
