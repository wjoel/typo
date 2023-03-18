package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ApplicableRolesRow(
  grantee: /* unknown nullability */ Option[String],
  roleName: /* unknown nullability */ Option[String],
  isGrantable: /* unknown nullability */ Option[String]
)

object ApplicableRolesRow {
  implicit val rowParser: RowParser[ApplicableRolesRow] = { row =>
    Success(
      ApplicableRolesRow(
        grantee = row[/* unknown nullability */ Option[String]]("grantee"),
        roleName = row[/* unknown nullability */ Option[String]]("role_name"),
        isGrantable = row[/* unknown nullability */ Option[String]]("is_grantable")
      )
    )
  }

  implicit val oFormat: OFormat[ApplicableRolesRow] = new OFormat[ApplicableRolesRow]{
    override def writes(o: ApplicableRolesRow): JsObject =
      Json.obj(
        "grantee" -> o.grantee,
      "role_name" -> o.roleName,
      "is_grantable" -> o.isGrantable
      )

    override def reads(json: JsValue): JsResult[ApplicableRolesRow] = {
      JsResult.fromTry(
        Try(
          ApplicableRolesRow(
            grantee = json.\("grantee").toOption.map(_.as[String]),
            roleName = json.\("role_name").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}