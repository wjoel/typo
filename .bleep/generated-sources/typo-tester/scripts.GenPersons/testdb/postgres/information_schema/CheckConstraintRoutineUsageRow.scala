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

case class CheckConstraintRoutineUsageRow(
  constraintCatalog: Option[String],
  constraintSchema: Option[String],
  constraintName: Option[String],
  specificCatalog: Option[String],
  specificSchema: Option[String],
  specificName: Option[String]
)

object CheckConstraintRoutineUsageRow {
  def rowParser(prefix: String): RowParser[CheckConstraintRoutineUsageRow] = { row =>
    Success(
      CheckConstraintRoutineUsageRow(
        constraintCatalog = row[Option[String]](prefix + "constraint_catalog"),
        constraintSchema = row[Option[String]](prefix + "constraint_schema"),
        constraintName = row[Option[String]](prefix + "constraint_name"),
        specificCatalog = row[Option[String]](prefix + "specific_catalog"),
        specificSchema = row[Option[String]](prefix + "specific_schema"),
        specificName = row[Option[String]](prefix + "specific_name")
      )
    )
  }

  implicit val oFormat: OFormat[CheckConstraintRoutineUsageRow] = new OFormat[CheckConstraintRoutineUsageRow]{
    override def writes(o: CheckConstraintRoutineUsageRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
      "constraint_schema" -> o.constraintSchema,
      "constraint_name" -> o.constraintName,
      "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName
      )

    override def reads(json: JsValue): JsResult[CheckConstraintRoutineUsageRow] = {
      JsResult.fromTry(
        Try(
          CheckConstraintRoutineUsageRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[String]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[String]),
            constraintName = json.\("constraint_name").toOption.map(_.as[String]),
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
