/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_table_usage

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

case class ViewTableUsageViewRow(
  viewCatalog: Option[SqlIdentifier],
  viewSchema: Option[SqlIdentifier],
  viewName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier]
)

object ViewTableUsageViewRow {
  implicit val reads: Reads[ViewTableUsageViewRow] = Reads[ViewTableUsageViewRow](json => JsResult.fromTry(
      Try(
        ViewTableUsageViewRow(
          viewCatalog = json.\("view_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          viewSchema = json.\("view_schema").toOption.map(_.as(SqlIdentifier.reads)),
          viewName = json.\("view_name").toOption.map(_.as(SqlIdentifier.reads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ViewTableUsageViewRow] = RowParser[ViewTableUsageViewRow] { row =>
    Success(
      ViewTableUsageViewRow(
        viewCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        viewSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        viewName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit val writes: OWrites[ViewTableUsageViewRow] = OWrites[ViewTableUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "view_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.viewCatalog),
      "view_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.viewSchema),
      "view_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.viewName),
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName)
    ))
  )
}
