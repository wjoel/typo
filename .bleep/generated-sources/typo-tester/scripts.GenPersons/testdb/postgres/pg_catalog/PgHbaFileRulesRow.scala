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

case class PgHbaFileRulesRow(
  lineNumber: /* unknown nullability */ Option[Int],
  `type`: /* unknown nullability */ Option[String],
  database: /* unknown nullability */ Option[Array[String]],
  userName: /* unknown nullability */ Option[Array[String]],
  address: /* unknown nullability */ Option[String],
  netmask: /* unknown nullability */ Option[String],
  authMethod: /* unknown nullability */ Option[String],
  options: /* unknown nullability */ Option[Array[String]],
  error: /* unknown nullability */ Option[String]
)

object PgHbaFileRulesRow {
  implicit val rowParser: RowParser[PgHbaFileRulesRow] = { row =>
    Success(
      PgHbaFileRulesRow(
        lineNumber = row[/* unknown nullability */ Option[Int]]("line_number"),
        `type` = row[/* unknown nullability */ Option[String]]("type"),
        database = row[/* unknown nullability */ Option[Array[String]]]("database"),
        userName = row[/* unknown nullability */ Option[Array[String]]]("user_name"),
        address = row[/* unknown nullability */ Option[String]]("address"),
        netmask = row[/* unknown nullability */ Option[String]]("netmask"),
        authMethod = row[/* unknown nullability */ Option[String]]("auth_method"),
        options = row[/* unknown nullability */ Option[Array[String]]]("options"),
        error = row[/* unknown nullability */ Option[String]]("error")
      )
    )
  }

  implicit val oFormat: OFormat[PgHbaFileRulesRow] = new OFormat[PgHbaFileRulesRow]{
    override def writes(o: PgHbaFileRulesRow): JsObject =
      Json.obj(
        "line_number" -> o.lineNumber,
      "type" -> o.`type`,
      "database" -> o.database,
      "user_name" -> o.userName,
      "address" -> o.address,
      "netmask" -> o.netmask,
      "auth_method" -> o.authMethod,
      "options" -> o.options,
      "error" -> o.error
      )

    override def reads(json: JsValue): JsResult[PgHbaFileRulesRow] = {
      JsResult.fromTry(
        Try(
          PgHbaFileRulesRow(
            lineNumber = json.\("line_number").toOption.map(_.as[Int]),
            `type` = json.\("type").toOption.map(_.as[String]),
            database = json.\("database").toOption.map(_.as[Array[String]]),
            userName = json.\("user_name").toOption.map(_.as[Array[String]]),
            address = json.\("address").toOption.map(_.as[String]),
            netmask = json.\("netmask").toOption.map(_.as[String]),
            authMethod = json.\("auth_method").toOption.map(_.as[String]),
            options = json.\("options").toOption.map(_.as[Array[String]]),
            error = json.\("error").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}