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

case class RoleRoutineGrantsRow(
  grantor: Option[String],
  grantee: Option[String],
  specificCatalog: Option[String],
  specificSchema: Option[String],
  specificName: Option[String],
  routineCatalog: Option[String],
  routineSchema: Option[String],
  routineName: Option[String],
  privilegeType: Option[String],
  isGrantable: Option[String]
)

object RoleRoutineGrantsRow {
  def rowParser(prefix: String): RowParser[RoleRoutineGrantsRow] = { row =>
    Success(
      RoleRoutineGrantsRow(
        grantor = row[Option[String]](prefix + "grantor"),
        grantee = row[Option[String]](prefix + "grantee"),
        specificCatalog = row[Option[String]](prefix + "specific_catalog"),
        specificSchema = row[Option[String]](prefix + "specific_schema"),
        specificName = row[Option[String]](prefix + "specific_name"),
        routineCatalog = row[Option[String]](prefix + "routine_catalog"),
        routineSchema = row[Option[String]](prefix + "routine_schema"),
        routineName = row[Option[String]](prefix + "routine_name"),
        privilegeType = row[Option[String]](prefix + "privilege_type"),
        isGrantable = row[Option[String]](prefix + "is_grantable")
      )
    )
  }

  implicit val oFormat: OFormat[RoleRoutineGrantsRow] = new OFormat[RoleRoutineGrantsRow]{
    override def writes(o: RoleRoutineGrantsRow): JsObject =
      Json.obj(
        "grantor" -> o.grantor,
      "grantee" -> o.grantee,
      "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "routine_catalog" -> o.routineCatalog,
      "routine_schema" -> o.routineSchema,
      "routine_name" -> o.routineName,
      "privilege_type" -> o.privilegeType,
      "is_grantable" -> o.isGrantable
      )

    override def reads(json: JsValue): JsResult[RoleRoutineGrantsRow] = {
      JsResult.fromTry(
        Try(
          RoleRoutineGrantsRow(
            grantor = json.\("grantor").toOption.map(_.as[String]),
            grantee = json.\("grantee").toOption.map(_.as[String]),
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            routineCatalog = json.\("routine_catalog").toOption.map(_.as[String]),
            routineSchema = json.\("routine_schema").toOption.map(_.as[String]),
            routineName = json.\("routine_name").toOption.map(_.as[String]),
            privilegeType = json.\("privilege_type").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
