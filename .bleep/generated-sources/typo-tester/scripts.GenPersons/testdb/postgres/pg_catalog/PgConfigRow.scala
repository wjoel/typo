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

case class PgConfigRow(
  name: /* unknown nullability */ Option[String],
  setting: /* unknown nullability */ Option[String]
)

object PgConfigRow {
  implicit val rowParser: RowParser[PgConfigRow] = { row =>
    Success(
      PgConfigRow(
        name = row[/* unknown nullability */ Option[String]]("name"),
        setting = row[/* unknown nullability */ Option[String]]("setting")
      )
    )
  }

  implicit val oFormat: OFormat[PgConfigRow] = new OFormat[PgConfigRow]{
    override def writes(o: PgConfigRow): JsObject =
      Json.obj(
        "name" -> o.name,
      "setting" -> o.setting
      )

    override def reads(json: JsValue): JsResult[PgConfigRow] = {
      JsResult.fromTry(
        Try(
          PgConfigRow(
            name = json.\("name").toOption.map(_.as[String]),
            setting = json.\("setting").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}