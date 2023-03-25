/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
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
  grantee: Option[String],
  roleName: Option[String],
  isGrantable: Option[String]
)

object ApplicableRolesRow {
  def rowParser(prefix: String): RowParser[ApplicableRolesRow] = { row =>
    Success(
      ApplicableRolesRow(
        grantee = row[Option[String]](prefix + "grantee"),
        roleName = row[Option[String]](prefix + "role_name"),
        isGrantable = row[Option[String]](prefix + "is_grantable")
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
