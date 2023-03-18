package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgDatabaseRowUnsaved(
  datname: String,
  datdba: Long,
  encoding: Int,
  datcollate: String,
  datctype: String,
  datistemplate: Boolean,
  datallowconn: Boolean,
  datconnlimit: Int,
  datlastsysoid: Long,
  datfrozenxid: String,
  datminmxid: String,
  dattablespace: Long,
  datacl: Option[Array[String]]
)
object PgDatabaseRowUnsaved {
  implicit val oFormat: OFormat[PgDatabaseRowUnsaved] = new OFormat[PgDatabaseRowUnsaved]{
    override def writes(o: PgDatabaseRowUnsaved): JsObject =
      Json.obj(
        "datname" -> o.datname,
      "datdba" -> o.datdba,
      "encoding" -> o.encoding,
      "datcollate" -> o.datcollate,
      "datctype" -> o.datctype,
      "datistemplate" -> o.datistemplate,
      "datallowconn" -> o.datallowconn,
      "datconnlimit" -> o.datconnlimit,
      "datlastsysoid" -> o.datlastsysoid,
      "datfrozenxid" -> o.datfrozenxid,
      "datminmxid" -> o.datminmxid,
      "dattablespace" -> o.dattablespace,
      "datacl" -> o.datacl
      )

    override def reads(json: JsValue): JsResult[PgDatabaseRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgDatabaseRowUnsaved(
            datname = json.\("datname").as[String],
            datdba = json.\("datdba").as[Long],
            encoding = json.\("encoding").as[Int],
            datcollate = json.\("datcollate").as[String],
            datctype = json.\("datctype").as[String],
            datistemplate = json.\("datistemplate").as[Boolean],
            datallowconn = json.\("datallowconn").as[Boolean],
            datconnlimit = json.\("datconnlimit").as[Int],
            datlastsysoid = json.\("datlastsysoid").as[Long],
            datfrozenxid = json.\("datfrozenxid").as[String],
            datminmxid = json.\("datminmxid").as[String],
            dattablespace = json.\("dattablespace").as[Long],
            datacl = json.\("datacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
