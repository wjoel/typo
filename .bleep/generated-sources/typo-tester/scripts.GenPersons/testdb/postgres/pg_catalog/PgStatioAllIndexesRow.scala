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

case class PgStatioAllIndexesRow(
  /** Points to [[PgClassRow.oid]] */
  relid: Long,
  /** Points to [[PgClassRow.oid]] */
  indexrelid: Long,
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  relname: String,
  /** Points to [[PgClassRow.relname]] */
  indexrelname: String,
  idxBlksRead: /* unknown nullability */ Option[Long],
  idxBlksHit: /* unknown nullability */ Option[Long]
)

object PgStatioAllIndexesRow {
  implicit val rowParser: RowParser[PgStatioAllIndexesRow] = { row =>
    Success(
      PgStatioAllIndexesRow(
        relid = row[Long]("relid"),
        indexrelid = row[Long]("indexrelid"),
        schemaname = row[String]("schemaname"),
        relname = row[String]("relname"),
        indexrelname = row[String]("indexrelname"),
        idxBlksRead = row[/* unknown nullability */ Option[Long]]("idx_blks_read"),
        idxBlksHit = row[/* unknown nullability */ Option[Long]]("idx_blks_hit")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatioAllIndexesRow] = new OFormat[PgStatioAllIndexesRow]{
    override def writes(o: PgStatioAllIndexesRow): JsObject =
      Json.obj(
        "relid" -> o.relid,
      "indexrelid" -> o.indexrelid,
      "schemaname" -> o.schemaname,
      "relname" -> o.relname,
      "indexrelname" -> o.indexrelname,
      "idx_blks_read" -> o.idxBlksRead,
      "idx_blks_hit" -> o.idxBlksHit
      )

    override def reads(json: JsValue): JsResult[PgStatioAllIndexesRow] = {
      JsResult.fromTry(
        Try(
          PgStatioAllIndexesRow(
            relid = json.\("relid").as[Long],
            indexrelid = json.\("indexrelid").as[Long],
            schemaname = json.\("schemaname").as[String],
            relname = json.\("relname").as[String],
            indexrelname = json.\("indexrelname").as[String],
            idxBlksRead = json.\("idx_blks_read").toOption.map(_.as[Long]),
            idxBlksHit = json.\("idx_blks_hit").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}