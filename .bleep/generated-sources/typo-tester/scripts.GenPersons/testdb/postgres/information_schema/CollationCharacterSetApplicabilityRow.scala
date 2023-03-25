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

case class CollationCharacterSetApplicabilityRow(
  collationCatalog: Option[String],
  collationSchema: Option[String],
  collationName: Option[String],
  characterSetCatalog: Option[String],
  characterSetSchema: Option[String],
  characterSetName: Option[String]
)

object CollationCharacterSetApplicabilityRow {
  def rowParser(prefix: String): RowParser[CollationCharacterSetApplicabilityRow] = { row =>
    Success(
      CollationCharacterSetApplicabilityRow(
        collationCatalog = row[Option[String]](prefix + "collation_catalog"),
        collationSchema = row[Option[String]](prefix + "collation_schema"),
        collationName = row[Option[String]](prefix + "collation_name"),
        characterSetCatalog = row[Option[String]](prefix + "character_set_catalog"),
        characterSetSchema = row[Option[String]](prefix + "character_set_schema"),
        characterSetName = row[Option[String]](prefix + "character_set_name")
      )
    )
  }

  implicit val oFormat: OFormat[CollationCharacterSetApplicabilityRow] = new OFormat[CollationCharacterSetApplicabilityRow]{
    override def writes(o: CollationCharacterSetApplicabilityRow): JsObject =
      Json.obj(
        "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName
      )

    override def reads(json: JsValue): JsResult[CollationCharacterSetApplicabilityRow] = {
      JsResult.fromTry(
        Try(
          CollationCharacterSetApplicabilityRow(
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
