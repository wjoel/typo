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

case class DomainConstraintsRow(
  constraintCatalog: Option[String],
  constraintSchema: Option[String],
  constraintName: Option[String],
  domainCatalog: Option[String],
  domainSchema: Option[String],
  domainName: Option[String],
  isDeferrable: Option[String],
  initiallyDeferred: Option[String]
)

object DomainConstraintsRow {
  def rowParser(prefix: String): RowParser[DomainConstraintsRow] = { row =>
    Success(
      DomainConstraintsRow(
        constraintCatalog = row[Option[String]](prefix + "constraint_catalog"),
        constraintSchema = row[Option[String]](prefix + "constraint_schema"),
        constraintName = row[Option[String]](prefix + "constraint_name"),
        domainCatalog = row[Option[String]](prefix + "domain_catalog"),
        domainSchema = row[Option[String]](prefix + "domain_schema"),
        domainName = row[Option[String]](prefix + "domain_name"),
        isDeferrable = row[Option[String]](prefix + "is_deferrable"),
        initiallyDeferred = row[Option[String]](prefix + "initially_deferred")
      )
    )
  }

  implicit val oFormat: OFormat[DomainConstraintsRow] = new OFormat[DomainConstraintsRow]{
    override def writes(o: DomainConstraintsRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
      "constraint_schema" -> o.constraintSchema,
      "constraint_name" -> o.constraintName,
      "domain_catalog" -> o.domainCatalog,
      "domain_schema" -> o.domainSchema,
      "domain_name" -> o.domainName,
      "is_deferrable" -> o.isDeferrable,
      "initially_deferred" -> o.initiallyDeferred
      )

    override def reads(json: JsValue): JsResult[DomainConstraintsRow] = {
      JsResult.fromTry(
        Try(
          DomainConstraintsRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[String]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[String]),
            constraintName = json.\("constraint_name").toOption.map(_.as[String]),
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[String]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[String]),
            domainName = json.\("domain_name").toOption.map(_.as[String]),
            isDeferrable = json.\("is_deferrable").toOption.map(_.as[String]),
            initiallyDeferred = json.\("initially_deferred").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
