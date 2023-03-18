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

case class PgOperatorRow(
  oid: PgOperatorId,
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

object PgOperatorRow {
  implicit val rowParser: RowParser[PgOperatorRow] = { row =>
    Success(
      PgOperatorRow(
        oid = row[PgOperatorId]("oid"),
        oprname = row[String]("oprname"),
        oprnamespace = row[Long]("oprnamespace"),
        oprowner = row[Long]("oprowner"),
        oprkind = row[String]("oprkind"),
        oprcanmerge = row[Boolean]("oprcanmerge"),
        oprcanhash = row[Boolean]("oprcanhash"),
        oprleft = row[Long]("oprleft"),
        oprright = row[Long]("oprright"),
        oprresult = row[Long]("oprresult"),
        oprcom = row[Long]("oprcom"),
        oprnegate = row[Long]("oprnegate"),
        oprcode = row[String]("oprcode"),
        oprrest = row[String]("oprrest"),
        oprjoin = row[String]("oprjoin")
      )
    )
  }

  implicit val oFormat: OFormat[PgOperatorRow] = new OFormat[PgOperatorRow]{
    override def writes(o: PgOperatorRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
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

    override def reads(json: JsValue): JsResult[PgOperatorRow] = {
      JsResult.fromTry(
        Try(
          PgOperatorRow(
            oid = json.\("oid").as[PgOperatorId],
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
