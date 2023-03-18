package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgDefaultAclRowUnsaved(
  defaclrole: Long,
  defaclnamespace: Long,
  defaclobjtype: String,
  defaclacl: Array[String]
)
object PgDefaultAclRowUnsaved {
  implicit val oFormat: OFormat[PgDefaultAclRowUnsaved] = new OFormat[PgDefaultAclRowUnsaved]{
    override def writes(o: PgDefaultAclRowUnsaved): JsObject =
      Json.obj(
        "defaclrole" -> o.defaclrole,
      "defaclnamespace" -> o.defaclnamespace,
      "defaclobjtype" -> o.defaclobjtype,
      "defaclacl" -> o.defaclacl
      )

    override def reads(json: JsValue): JsResult[PgDefaultAclRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgDefaultAclRowUnsaved(
            defaclrole = json.\("defaclrole").as[Long],
            defaclnamespace = json.\("defaclnamespace").as[Long],
            defaclobjtype = json.\("defaclobjtype").as[String],
            defaclacl = json.\("defaclacl").as[Array[String]]
          )
        )
      )
    }
  }
}
