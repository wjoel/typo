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

case class RoleUdtGrantsRow(
  /** Points to [[UdtPrivilegesRow.grantor]] */
  grantor: Option[String],
  /** Points to [[UdtPrivilegesRow.grantee]] */
  grantee: Option[String],
  /** Points to [[UdtPrivilegesRow.udtCatalog]] */
  udtCatalog: Option[String],
  /** Points to [[UdtPrivilegesRow.udtSchema]] */
  udtSchema: Option[String],
  /** Points to [[UdtPrivilegesRow.udtName]] */
  udtName: Option[String],
  /** Points to [[UdtPrivilegesRow.privilegeType]] */
  privilegeType: Option[String],
  /** Points to [[UdtPrivilegesRow.isGrantable]] */
  isGrantable: Option[String]
)

object RoleUdtGrantsRow {
  def rowParser(prefix: String): RowParser[RoleUdtGrantsRow] = { row =>
    Success(
      RoleUdtGrantsRow(
        grantor = row[Option[String]](prefix + "grantor"),
        grantee = row[Option[String]](prefix + "grantee"),
        udtCatalog = row[Option[String]](prefix + "udt_catalog"),
        udtSchema = row[Option[String]](prefix + "udt_schema"),
        udtName = row[Option[String]](prefix + "udt_name"),
        privilegeType = row[Option[String]](prefix + "privilege_type"),
        isGrantable = row[Option[String]](prefix + "is_grantable")
      )
    )
  }

  implicit val oFormat: OFormat[RoleUdtGrantsRow] = new OFormat[RoleUdtGrantsRow]{
    override def writes(o: RoleUdtGrantsRow): JsObject =
      Json.obj(
        "grantor" -> o.grantor,
      "grantee" -> o.grantee,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "privilege_type" -> o.privilegeType,
      "is_grantable" -> o.isGrantable
      )

    override def reads(json: JsValue): JsResult[RoleUdtGrantsRow] = {
      JsResult.fromTry(
        Try(
          RoleUdtGrantsRow(
            grantor = json.\("grantor").toOption.map(_.as[String]),
            grantee = json.\("grantee").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            privilegeType = json.\("privilege_type").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
