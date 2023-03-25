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
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgCursorsRow(
  name: Option[String],
  statement: Option[String],
  isHoldable: Option[Boolean],
  isBinary: Option[Boolean],
  isScrollable: Option[Boolean],
  creationTime: Option[ZonedDateTime]
)

object PgCursorsRow {
  def rowParser(prefix: String): RowParser[PgCursorsRow] = { row =>
    Success(
      PgCursorsRow(
        name = row[Option[String]](prefix + "name"),
        statement = row[Option[String]](prefix + "statement"),
        isHoldable = row[Option[Boolean]](prefix + "is_holdable"),
        isBinary = row[Option[Boolean]](prefix + "is_binary"),
        isScrollable = row[Option[Boolean]](prefix + "is_scrollable"),
        creationTime = row[Option[ZonedDateTime]](prefix + "creation_time")
      )
    )
  }

  implicit val oFormat: OFormat[PgCursorsRow] = new OFormat[PgCursorsRow]{
    override def writes(o: PgCursorsRow): JsObject =
      Json.obj(
        "name" -> o.name,
      "statement" -> o.statement,
      "is_holdable" -> o.isHoldable,
      "is_binary" -> o.isBinary,
      "is_scrollable" -> o.isScrollable,
      "creation_time" -> o.creationTime
      )

    override def reads(json: JsValue): JsResult[PgCursorsRow] = {
      JsResult.fromTry(
        Try(
          PgCursorsRow(
            name = json.\("name").toOption.map(_.as[String]),
            statement = json.\("statement").toOption.map(_.as[String]),
            isHoldable = json.\("is_holdable").toOption.map(_.as[Boolean]),
            isBinary = json.\("is_binary").toOption.map(_.as[Boolean]),
            isScrollable = json.\("is_scrollable").toOption.map(_.as[Boolean]),
            creationTime = json.\("creation_time").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
