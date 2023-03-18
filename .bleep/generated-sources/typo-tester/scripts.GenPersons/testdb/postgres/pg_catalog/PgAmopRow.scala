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

case class PgAmopRow(
  oid: Long,
  amopfamily: Long,
  amoplefttype: Long,
  amoprighttype: Long,
  amopstrategy: Short,
  amoppurpose: String,
  amopopr: Long,
  amopmethod: Long,
  amopsortfamily: Long
)

object PgAmopRow {
  implicit val rowParser: RowParser[PgAmopRow] = { row =>
    Success(
      PgAmopRow(
        oid = row[Long]("oid"),
        amopfamily = row[Long]("amopfamily"),
        amoplefttype = row[Long]("amoplefttype"),
        amoprighttype = row[Long]("amoprighttype"),
        amopstrategy = row[Short]("amopstrategy"),
        amoppurpose = row[String]("amoppurpose"),
        amopopr = row[Long]("amopopr"),
        amopmethod = row[Long]("amopmethod"),
        amopsortfamily = row[Long]("amopsortfamily")
      )
    )
  }

  implicit val oFormat: OFormat[PgAmopRow] = new OFormat[PgAmopRow]{
    override def writes(o: PgAmopRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "amopfamily" -> o.amopfamily,
      "amoplefttype" -> o.amoplefttype,
      "amoprighttype" -> o.amoprighttype,
      "amopstrategy" -> o.amopstrategy,
      "amoppurpose" -> o.amoppurpose,
      "amopopr" -> o.amopopr,
      "amopmethod" -> o.amopmethod,
      "amopsortfamily" -> o.amopsortfamily
      )

    override def reads(json: JsValue): JsResult[PgAmopRow] = {
      JsResult.fromTry(
        Try(
          PgAmopRow(
            oid = json.\("oid").as[Long],
            amopfamily = json.\("amopfamily").as[Long],
            amoplefttype = json.\("amoplefttype").as[Long],
            amoprighttype = json.\("amoprighttype").as[Long],
            amopstrategy = json.\("amopstrategy").as[Short],
            amoppurpose = json.\("amoppurpose").as[String],
            amopopr = json.\("amopopr").as[Long],
            amopmethod = json.\("amopmethod").as[Long],
            amopsortfamily = json.\("amopsortfamily").as[Long]
          )
        )
      )
    }
  }
}