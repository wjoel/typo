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

case class TableConstraintsRow(
  constraintCatalog: Option[String],
  constraintSchema: Option[String],
  constraintName: Option[String],
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String],
  constraintType: Option[String],
  isDeferrable: Option[String],
  initiallyDeferred: Option[String],
  enforced: Option[String]
)

object TableConstraintsRow {
  def rowParser(prefix: String): RowParser[TableConstraintsRow] = { row =>
    Success(
      TableConstraintsRow(
        constraintCatalog = row[Option[String]](prefix + "constraint_catalog"),
        constraintSchema = row[Option[String]](prefix + "constraint_schema"),
        constraintName = row[Option[String]](prefix + "constraint_name"),
        tableCatalog = row[Option[String]](prefix + "table_catalog"),
        tableSchema = row[Option[String]](prefix + "table_schema"),
        tableName = row[Option[String]](prefix + "table_name"),
        constraintType = row[Option[String]](prefix + "constraint_type"),
        isDeferrable = row[Option[String]](prefix + "is_deferrable"),
        initiallyDeferred = row[Option[String]](prefix + "initially_deferred"),
        enforced = row[Option[String]](prefix + "enforced")
      )
    )
  }

  implicit val oFormat: OFormat[TableConstraintsRow] = new OFormat[TableConstraintsRow]{
    override def writes(o: TableConstraintsRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
      "constraint_schema" -> o.constraintSchema,
      "constraint_name" -> o.constraintName,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "constraint_type" -> o.constraintType,
      "is_deferrable" -> o.isDeferrable,
      "initially_deferred" -> o.initiallyDeferred,
      "enforced" -> o.enforced
      )

    override def reads(json: JsValue): JsResult[TableConstraintsRow] = {
      JsResult.fromTry(
        Try(
          TableConstraintsRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[String]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[String]),
            constraintName = json.\("constraint_name").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            constraintType = json.\("constraint_type").toOption.map(_.as[String]),
            isDeferrable = json.\("is_deferrable").toOption.map(_.as[String]),
            initiallyDeferred = json.\("initially_deferred").toOption.map(_.as[String]),
            enforced = json.\("enforced").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
