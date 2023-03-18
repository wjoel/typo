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

case class PgForeignTableRow(
  ftrelid: PgForeignTableId,
  ftserver: Long,
  ftoptions: Option[Array[String]]
)

object PgForeignTableRow {
  implicit val rowParser: RowParser[PgForeignTableRow] = { row =>
    Success(
      PgForeignTableRow(
        ftrelid = row[PgForeignTableId]("ftrelid"),
        ftserver = row[Long]("ftserver"),
        ftoptions = row[Option[Array[String]]]("ftoptions")
      )
    )
  }

  implicit val oFormat: OFormat[PgForeignTableRow] = new OFormat[PgForeignTableRow]{
    override def writes(o: PgForeignTableRow): JsObject =
      Json.obj(
        "ftrelid" -> o.ftrelid,
      "ftserver" -> o.ftserver,
      "ftoptions" -> o.ftoptions
      )

    override def reads(json: JsValue): JsResult[PgForeignTableRow] = {
      JsResult.fromTry(
        Try(
          PgForeignTableRow(
            ftrelid = json.\("ftrelid").as[PgForeignTableId],
            ftserver = json.\("ftserver").as[Long],
            ftoptions = json.\("ftoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
