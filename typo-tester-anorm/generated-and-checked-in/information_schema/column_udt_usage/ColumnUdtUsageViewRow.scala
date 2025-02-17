/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_udt_usage

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

case class ColumnUdtUsageViewRow(
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier]
)

object ColumnUdtUsageViewRow {
  implicit lazy val reads: Reads[ColumnUdtUsageViewRow] = Reads[ColumnUdtUsageViewRow](json => JsResult.fromTry(
      Try(
        ColumnUdtUsageViewRow(
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(SqlIdentifier.reads)),
          udtName = json.\("udt_name").toOption.map(_.as(SqlIdentifier.reads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          columnName = json.\("column_name").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnUdtUsageViewRow] = RowParser[ColumnUdtUsageViewRow] { row =>
    Success(
      ColumnUdtUsageViewRow(
        udtCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        udtSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        udtName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        columnName = row(idx + 6)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ColumnUdtUsageViewRow] = OWrites[ColumnUdtUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "udt_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtName),
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.columnName)
    ))
  )
}
