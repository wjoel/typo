/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_table_usage

import adventureworks.information_schema.SqlIdentifier
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class ConstraintTableUsageViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier]
)

object ConstraintTableUsageViewRow {
  implicit val reads: Reads[ConstraintTableUsageViewRow] = Reads[ConstraintTableUsageViewRow](json => JsResult.fromTry(
      Try(
        ConstraintTableUsageViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(SqlIdentifier.reads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ConstraintTableUsageViewRow] = RowParser[ConstraintTableUsageViewRow] { row =>
    Success(
      ConstraintTableUsageViewRow(
        tableCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        constraintCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        constraintSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        constraintName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit val writes: OWrites[ConstraintTableUsageViewRow] = OWrites[ConstraintTableUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "constraint_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintName)
    ))
  )
}
