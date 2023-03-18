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

case class PgShdescriptionRow(
  objoid: Long,
  classoid: Long,
  description: String
)

object PgShdescriptionRow {
  implicit val rowParser: RowParser[PgShdescriptionRow] = { row =>
    Success(
      PgShdescriptionRow(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid"),
        description = row[String]("description")
      )
    )
  }

  implicit val oFormat: OFormat[PgShdescriptionRow] = new OFormat[PgShdescriptionRow]{
    override def writes(o: PgShdescriptionRow): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "description" -> o.description
      )

    override def reads(json: JsValue): JsResult[PgShdescriptionRow] = {
      JsResult.fromTry(
        Try(
          PgShdescriptionRow(
            objoid = json.\("objoid").as[Long],
            classoid = json.\("classoid").as[Long],
            description = json.\("description").as[String]
          )
        )
      )
    }
  }
}