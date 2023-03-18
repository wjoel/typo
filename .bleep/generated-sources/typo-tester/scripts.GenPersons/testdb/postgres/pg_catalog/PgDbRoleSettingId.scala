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

case class PgDbRoleSettingId(setdatabase: Long, setrole: Long)
object PgDbRoleSettingId {
  implicit val ordering: Ordering[PgDbRoleSettingId] = Ordering.by(x => (x.setdatabase, x.setrole))
  implicit val oFormat: OFormat[PgDbRoleSettingId] = new OFormat[PgDbRoleSettingId]{
    override def writes(o: PgDbRoleSettingId): JsObject =
      Json.obj(
        "setdatabase" -> o.setdatabase,
      "setrole" -> o.setrole
      )

    override def reads(json: JsValue): JsResult[PgDbRoleSettingId] = {
      JsResult.fromTry(
        Try(
          PgDbRoleSettingId(
            setdatabase = json.\("setdatabase").as[Long],
            setrole = json.\("setrole").as[Long]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgDbRoleSettingId] = { row =>
    Success(
      PgDbRoleSettingId(
        setdatabase = row[Long]("setdatabase"),
        setrole = row[Long]("setrole")
      )
    )
  }

}
