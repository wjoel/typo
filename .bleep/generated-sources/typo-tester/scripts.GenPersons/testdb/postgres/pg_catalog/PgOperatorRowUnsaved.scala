package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgOperatorRowUnsaved(
  oprname: String,
  oprnamespace: Long,
  oprowner: Long,
  oprkind: String,
  oprcanmerge: Boolean,
  oprcanhash: Boolean,
  oprleft: Long,
  oprright: Long,
  oprresult: Long,
  oprcom: Long,
  oprnegate: Long,
  oprcode: String,
  oprrest: String,
  oprjoin: String
)
object PgOperatorRowUnsaved {
  implicit val oFormat: OFormat[PgOperatorRowUnsaved] = new OFormat[PgOperatorRowUnsaved]{
    override def writes(o: PgOperatorRowUnsaved): JsObject =
      Json.obj(
        "oprname" -> o.oprname,
      "oprnamespace" -> o.oprnamespace,
      "oprowner" -> o.oprowner,
      "oprkind" -> o.oprkind,
      "oprcanmerge" -> o.oprcanmerge,
      "oprcanhash" -> o.oprcanhash,
      "oprleft" -> o.oprleft,
      "oprright" -> o.oprright,
      "oprresult" -> o.oprresult,
      "oprcom" -> o.oprcom,
      "oprnegate" -> o.oprnegate,
      "oprcode" -> o.oprcode,
      "oprrest" -> o.oprrest,
      "oprjoin" -> o.oprjoin
      )

    override def reads(json: JsValue): JsResult[PgOperatorRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgOperatorRowUnsaved(
            oprname = json.\("oprname").as[String],
            oprnamespace = json.\("oprnamespace").as[Long],
            oprowner = json.\("oprowner").as[Long],
            oprkind = json.\("oprkind").as[String],
            oprcanmerge = json.\("oprcanmerge").as[Boolean],
            oprcanhash = json.\("oprcanhash").as[Boolean],
            oprleft = json.\("oprleft").as[Long],
            oprright = json.\("oprright").as[Long],
            oprresult = json.\("oprresult").as[Long],
            oprcom = json.\("oprcom").as[Long],
            oprnegate = json.\("oprnegate").as[Long],
            oprcode = json.\("oprcode").as[String],
            oprrest = json.\("oprrest").as[String],
            oprjoin = json.\("oprjoin").as[String]
          )
        )
      )
    }
  }
}
