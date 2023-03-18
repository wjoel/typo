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

case class PgPublicationRelRow(
  oid: PgPublicationRelId,
  prpubid: Long,
  prrelid: Long
)

object PgPublicationRelRow {
  implicit val rowParser: RowParser[PgPublicationRelRow] = { row =>
    Success(
      PgPublicationRelRow(
        oid = row[PgPublicationRelId]("oid"),
        prpubid = row[Long]("prpubid"),
        prrelid = row[Long]("prrelid")
      )
    )
  }

  implicit val oFormat: OFormat[PgPublicationRelRow] = new OFormat[PgPublicationRelRow]{
    override def writes(o: PgPublicationRelRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "prpubid" -> o.prpubid,
      "prrelid" -> o.prrelid
      )

    override def reads(json: JsValue): JsResult[PgPublicationRelRow] = {
      JsResult.fromTry(
        Try(
          PgPublicationRelRow(
            oid = json.\("oid").as[PgPublicationRelId],
            prpubid = json.\("prpubid").as[Long],
            prrelid = json.\("prrelid").as[Long]
          )
        )
      )
    }
  }
}
