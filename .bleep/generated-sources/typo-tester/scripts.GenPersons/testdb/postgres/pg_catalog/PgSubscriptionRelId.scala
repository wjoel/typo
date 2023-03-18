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

case class PgSubscriptionRelId(srrelid: Long, srsubid: Long)
object PgSubscriptionRelId {
  implicit val ordering: Ordering[PgSubscriptionRelId] = Ordering.by(x => (x.srrelid, x.srsubid))
  implicit val oFormat: OFormat[PgSubscriptionRelId] = new OFormat[PgSubscriptionRelId]{
    override def writes(o: PgSubscriptionRelId): JsObject =
      Json.obj(
        "srrelid" -> o.srrelid,
      "srsubid" -> o.srsubid
      )

    override def reads(json: JsValue): JsResult[PgSubscriptionRelId] = {
      JsResult.fromTry(
        Try(
          PgSubscriptionRelId(
            srrelid = json.\("srrelid").as[Long],
            srsubid = json.\("srsubid").as[Long]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgSubscriptionRelId] = { row =>
    Success(
      PgSubscriptionRelId(
        srrelid = row[Long]("srrelid"),
        srsubid = row[Long]("srsubid")
      )
    )
  }

}
