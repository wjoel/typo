package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPolicyRowUnsaved(
  polname: String,
  polrelid: Long,
  polcmd: String,
  polpermissive: Boolean,
  polroles: Array[Long],
  polqual: Option[String],
  polwithcheck: Option[String]
)
object PgPolicyRowUnsaved {
  implicit val oFormat: OFormat[PgPolicyRowUnsaved] = new OFormat[PgPolicyRowUnsaved]{
    override def writes(o: PgPolicyRowUnsaved): JsObject =
      Json.obj(
        "polname" -> o.polname,
      "polrelid" -> o.polrelid,
      "polcmd" -> o.polcmd,
      "polpermissive" -> o.polpermissive,
      "polroles" -> o.polroles,
      "polqual" -> o.polqual,
      "polwithcheck" -> o.polwithcheck
      )

    override def reads(json: JsValue): JsResult[PgPolicyRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgPolicyRowUnsaved(
            polname = json.\("polname").as[String],
            polrelid = json.\("polrelid").as[Long],
            polcmd = json.\("polcmd").as[String],
            polpermissive = json.\("polpermissive").as[Boolean],
            polroles = json.\("polroles").as[Array[Long]],
            polqual = json.\("polqual").toOption.map(_.as[String]),
            polwithcheck = json.\("polwithcheck").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
