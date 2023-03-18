package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPreparedXactsRow(
  transaction: /* unknown nullability */ Option[/* xid */ String],
  gid: /* unknown nullability */ Option[String],
  prepared: /* unknown nullability */ Option[LocalDateTime],
  /** Points to [[PgAuthidRow.rolname]] */
  owner: String,
  /** Points to [[PgDatabaseRow.datname]] */
  database: String
)

object PgPreparedXactsRow {
  implicit val rowParser: RowParser[PgPreparedXactsRow] = { row =>
    Success(
      PgPreparedXactsRow(
        transaction = row[/* unknown nullability */ Option[/* xid */ String]]("transaction"),
        gid = row[/* unknown nullability */ Option[String]]("gid"),
        prepared = row[/* unknown nullability */ Option[LocalDateTime]]("prepared"),
        owner = row[String]("owner"),
        database = row[String]("database")
      )
    )
  }

  implicit val oFormat: OFormat[PgPreparedXactsRow] = new OFormat[PgPreparedXactsRow]{
    override def writes(o: PgPreparedXactsRow): JsObject =
      Json.obj(
        "transaction" -> o.transaction,
      "gid" -> o.gid,
      "prepared" -> o.prepared,
      "owner" -> o.owner,
      "database" -> o.database
      )

    override def reads(json: JsValue): JsResult[PgPreparedXactsRow] = {
      JsResult.fromTry(
        Try(
          PgPreparedXactsRow(
            transaction = json.\("transaction").toOption.map(_.as[/* xid */ String]),
            gid = json.\("gid").toOption.map(_.as[String]),
            prepared = json.\("prepared").toOption.map(_.as[LocalDateTime]),
            owner = json.\("owner").as[String],
            database = json.\("database").as[String]
          )
        )
      )
    }
  }
}