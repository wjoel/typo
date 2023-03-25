/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
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

case class TransformsRow(
  udtCatalog: Option[String],
  udtSchema: Option[String],
  udtName: Option[String],
  specificCatalog: Option[String],
  specificSchema: Option[String],
  specificName: Option[String],
  groupName: Option[String],
  transformType: Option[String]
)

object TransformsRow {
  def rowParser(prefix: String): RowParser[TransformsRow] = { row =>
    Success(
      TransformsRow(
        udtCatalog = row[Option[String]](prefix + "udt_catalog"),
        udtSchema = row[Option[String]](prefix + "udt_schema"),
        udtName = row[Option[String]](prefix + "udt_name"),
        specificCatalog = row[Option[String]](prefix + "specific_catalog"),
        specificSchema = row[Option[String]](prefix + "specific_schema"),
        specificName = row[Option[String]](prefix + "specific_name"),
        groupName = row[Option[String]](prefix + "group_name"),
        transformType = row[Option[String]](prefix + "transform_type")
      )
    )
  }

  implicit val oFormat: OFormat[TransformsRow] = new OFormat[TransformsRow]{
    override def writes(o: TransformsRow): JsObject =
      Json.obj(
        "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "group_name" -> o.groupName,
      "transform_type" -> o.transformType
      )

    override def reads(json: JsValue): JsResult[TransformsRow] = {
      JsResult.fromTry(
        Try(
          TransformsRow(
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            groupName = json.\("group_name").toOption.map(_.as[String]),
            transformType = json.\("transform_type").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
