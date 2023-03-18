package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SqlImplementationInfoRow(
  implementationInfoId: Option[String],
  implementationInfoName: Option[String],
  integerValue: Option[Int],
  characterValue: Option[String],
  comments: Option[String]
)

object SqlImplementationInfoRow {
  implicit val rowParser: RowParser[SqlImplementationInfoRow] = { row =>
    Success(
      SqlImplementationInfoRow(
        implementationInfoId = row[Option[String]]("implementation_info_id"),
        implementationInfoName = row[Option[String]]("implementation_info_name"),
        integerValue = row[Option[Int]]("integer_value"),
        characterValue = row[Option[String]]("character_value"),
        comments = row[Option[String]]("comments")
      )
    )
  }

  implicit val oFormat: OFormat[SqlImplementationInfoRow] = new OFormat[SqlImplementationInfoRow]{
    override def writes(o: SqlImplementationInfoRow): JsObject =
      Json.obj(
        "implementation_info_id" -> o.implementationInfoId,
      "implementation_info_name" -> o.implementationInfoName,
      "integer_value" -> o.integerValue,
      "character_value" -> o.characterValue,
      "comments" -> o.comments
      )

    override def reads(json: JsValue): JsResult[SqlImplementationInfoRow] = {
      JsResult.fromTry(
        Try(
          SqlImplementationInfoRow(
            implementationInfoId = json.\("implementation_info_id").toOption.map(_.as[String]),
            implementationInfoName = json.\("implementation_info_name").toOption.map(_.as[String]),
            integerValue = json.\("integer_value").toOption.map(_.as[Int]),
            characterValue = json.\("character_value").toOption.map(_.as[String]),
            comments = json.\("comments").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}