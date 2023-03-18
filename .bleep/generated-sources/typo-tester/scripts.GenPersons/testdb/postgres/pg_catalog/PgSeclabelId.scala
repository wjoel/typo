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

case class PgSeclabelId(objoid: Long, classoid: Long, objsubid: Int, provider: String)
object PgSeclabelId {
  implicit val ordering: Ordering[PgSeclabelId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid, x.provider))
  implicit val oFormat: OFormat[PgSeclabelId] = new OFormat[PgSeclabelId]{
    override def writes(o: PgSeclabelId): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "objsubid" -> o.objsubid,
      "provider" -> o.provider
      )

    override def reads(json: JsValue): JsResult[PgSeclabelId] = {
      JsResult.fromTry(
        Try(
          PgSeclabelId(
            objoid = json.\("objoid").as[Long],
            classoid = json.\("classoid").as[Long],
            objsubid = json.\("objsubid").as[Int],
            provider = json.\("provider").as[String]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgSeclabelId] = { row =>
    Success(
      PgSeclabelId(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid"),
        objsubid = row[Int]("objsubid"),
        provider = row[String]("provider")
      )
    )
  }

}
