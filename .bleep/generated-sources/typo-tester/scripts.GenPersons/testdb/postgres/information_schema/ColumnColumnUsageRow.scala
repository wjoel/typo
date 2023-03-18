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

case class ColumnColumnUsageRow(
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  columnName: /* unknown nullability */ Option[String],
  dependentColumn: /* unknown nullability */ Option[String]
)

object ColumnColumnUsageRow {
  implicit val rowParser: RowParser[ColumnColumnUsageRow] = { row =>
    Success(
      ColumnColumnUsageRow(
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        columnName = row[/* unknown nullability */ Option[String]]("column_name"),
        dependentColumn = row[/* unknown nullability */ Option[String]]("dependent_column")
      )
    )
  }

  implicit val oFormat: OFormat[ColumnColumnUsageRow] = new OFormat[ColumnColumnUsageRow]{
    override def writes(o: ColumnColumnUsageRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName,
      "dependent_column" -> o.dependentColumn
      )

    override def reads(json: JsValue): JsResult[ColumnColumnUsageRow] = {
      JsResult.fromTry(
        Try(
          ColumnColumnUsageRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String]),
            dependentColumn = json.\("dependent_column").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}