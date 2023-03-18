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

case class PgEnumRow(
  oid: PgEnumId,
  enumtypid: Long,
  enumsortorder: Float,
  enumlabel: String
)

object PgEnumRow {
  implicit val rowParser: RowParser[PgEnumRow] = { row =>
    Success(
      PgEnumRow(
        oid = row[PgEnumId]("oid"),
        enumtypid = row[Long]("enumtypid"),
        enumsortorder = row[Float]("enumsortorder"),
        enumlabel = row[String]("enumlabel")
      )
    )
  }

  implicit val oFormat: OFormat[PgEnumRow] = new OFormat[PgEnumRow]{
    override def writes(o: PgEnumRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "enumtypid" -> o.enumtypid,
      "enumsortorder" -> o.enumsortorder,
      "enumlabel" -> o.enumlabel
      )

    override def reads(json: JsValue): JsResult[PgEnumRow] = {
      JsResult.fromTry(
        Try(
          PgEnumRow(
            oid = json.\("oid").as[PgEnumId],
            enumtypid = json.\("enumtypid").as[Long],
            enumsortorder = json.\("enumsortorder").as[Float],
            enumlabel = json.\("enumlabel").as[String]
          )
        )
      )
    }
  }
}
