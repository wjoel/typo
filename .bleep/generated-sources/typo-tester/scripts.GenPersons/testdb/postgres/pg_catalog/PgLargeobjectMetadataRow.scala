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
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgLargeobjectMetadataRow(
  oid: PgLargeobjectMetadataId,
  lomowner: Long,
  lomacl: Option[Array[PGobject]]
)

object PgLargeobjectMetadataRow {
  def rowParser(prefix: String): RowParser[PgLargeobjectMetadataRow] = { row =>
    Success(
      PgLargeobjectMetadataRow(
        oid = row[PgLargeobjectMetadataId](prefix + "oid"),
        lomowner = row[Long](prefix + "lomowner"),
        lomacl = row[Option[Array[PGobject]]](prefix + "lomacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgLargeobjectMetadataRow] = new OFormat[PgLargeobjectMetadataRow]{
    override def writes(o: PgLargeobjectMetadataRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "lomowner" -> o.lomowner,
      "lomacl" -> o.lomacl
      )

    override def reads(json: JsValue): JsResult[PgLargeobjectMetadataRow] = {
      JsResult.fromTry(
        Try(
          PgLargeobjectMetadataRow(
            oid = json.\("oid").as[PgLargeobjectMetadataId],
            lomowner = json.\("lomowner").as[Long],
            lomacl = json.\("lomacl").toOption.map(_.as[Array[PGobject]])
          )
        )
      )
    }
  }
}
