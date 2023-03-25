/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import org.postgresql.util.PGInterval
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTimezoneNamesRow(
  name: Option[String],
  abbrev: Option[String],
  utcOffset: Option[PGInterval],
  isDst: Option[Boolean]
)

object PgTimezoneNamesRow {
  def rowParser(prefix: String): RowParser[PgTimezoneNamesRow] = { row =>
    Success(
      PgTimezoneNamesRow(
        name = row[Option[String]](prefix + "name"),
        abbrev = row[Option[String]](prefix + "abbrev"),
        utcOffset = row[Option[PGInterval]](prefix + "utc_offset"),
        isDst = row[Option[Boolean]](prefix + "is_dst")
      )
    )
  }

  implicit val oFormat: OFormat[PgTimezoneNamesRow] = new OFormat[PgTimezoneNamesRow]{
    override def writes(o: PgTimezoneNamesRow): JsObject =
      Json.obj(
        "name" -> o.name,
      "abbrev" -> o.abbrev,
      "utc_offset" -> o.utcOffset,
      "is_dst" -> o.isDst
      )

    override def reads(json: JsValue): JsResult[PgTimezoneNamesRow] = {
      JsResult.fromTry(
        Try(
          PgTimezoneNamesRow(
            name = json.\("name").toOption.map(_.as[String]),
            abbrev = json.\("abbrev").toOption.map(_.as[String]),
            utcOffset = json.\("utc_offset").toOption.map(_.as[PGInterval]),
            isDst = json.\("is_dst").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}
