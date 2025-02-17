/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_column_usage

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

case class ColumnColumnUsageViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  dependentColumn: Option[SqlIdentifier]
)

object ColumnColumnUsageViewRow {
  implicit lazy val reads: Reads[ColumnColumnUsageViewRow] = Reads[ColumnColumnUsageViewRow](json => JsResult.fromTry(
      Try(
        ColumnColumnUsageViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          columnName = json.\("column_name").toOption.map(_.as(SqlIdentifier.reads)),
          dependentColumn = json.\("dependent_column").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnColumnUsageViewRow] = RowParser[ColumnColumnUsageViewRow] { row =>
    Success(
      ColumnColumnUsageViewRow(
        tableCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        columnName = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        dependentColumn = row(idx + 4)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ColumnColumnUsageViewRow] = OWrites[ColumnColumnUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.columnName),
      "dependent_column" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.dependentColumn)
    ))
  )
}
