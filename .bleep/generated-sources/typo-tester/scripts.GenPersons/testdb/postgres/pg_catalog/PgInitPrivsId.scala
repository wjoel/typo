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

case class PgInitPrivsId(objoid: Long, classoid: Long, objsubid: Int)
object PgInitPrivsId {
  implicit val ordering: Ordering[PgInitPrivsId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid))
  implicit val oFormat: OFormat[PgInitPrivsId] = new OFormat[PgInitPrivsId]{
    override def writes(o: PgInitPrivsId): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "objsubid" -> o.objsubid
      )

    override def reads(json: JsValue): JsResult[PgInitPrivsId] = {
      JsResult.fromTry(
        Try(
          PgInitPrivsId(
            objoid = json.\("objoid").as[Long],
            classoid = json.\("classoid").as[Long],
            objsubid = json.\("objsubid").as[Int]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgInitPrivsId] = { row =>
    Success(
      PgInitPrivsId(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid"),
        objsubid = row[Int]("objsubid")
      )
    )
  }

}
