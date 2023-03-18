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

case class PgShdescriptionId(objoid: Long, classoid: Long)
object PgShdescriptionId {
  implicit val ordering: Ordering[PgShdescriptionId] = Ordering.by(x => (x.objoid, x.classoid))
  implicit val oFormat: OFormat[PgShdescriptionId] = new OFormat[PgShdescriptionId]{
    override def writes(o: PgShdescriptionId): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid
      )

    override def reads(json: JsValue): JsResult[PgShdescriptionId] = {
      JsResult.fromTry(
        Try(
          PgShdescriptionId(
            objoid = json.\("objoid").as[Long],
            classoid = json.\("classoid").as[Long]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgShdescriptionId] = { row =>
    Success(
      PgShdescriptionId(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid")
      )
    )
  }

}
