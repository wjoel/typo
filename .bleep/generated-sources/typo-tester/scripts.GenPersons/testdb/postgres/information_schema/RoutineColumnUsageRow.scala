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

case class RoutineColumnUsageRow(
  specificCatalog: /* unknown nullability */ Option[String],
  specificSchema: /* unknown nullability */ Option[String],
  specificName: /* unknown nullability */ Option[String],
  routineCatalog: /* unknown nullability */ Option[String],
  routineSchema: /* unknown nullability */ Option[String],
  routineName: /* unknown nullability */ Option[String],
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  columnName: /* unknown nullability */ Option[String]
)

object RoutineColumnUsageRow {
  implicit val rowParser: RowParser[RoutineColumnUsageRow] = { row =>
    Success(
      RoutineColumnUsageRow(
        specificCatalog = row[/* unknown nullability */ Option[String]]("specific_catalog"),
        specificSchema = row[/* unknown nullability */ Option[String]]("specific_schema"),
        specificName = row[/* unknown nullability */ Option[String]]("specific_name"),
        routineCatalog = row[/* unknown nullability */ Option[String]]("routine_catalog"),
        routineSchema = row[/* unknown nullability */ Option[String]]("routine_schema"),
        routineName = row[/* unknown nullability */ Option[String]]("routine_name"),
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        columnName = row[/* unknown nullability */ Option[String]]("column_name")
      )
    )
  }

  implicit val oFormat: OFormat[RoutineColumnUsageRow] = new OFormat[RoutineColumnUsageRow]{
    override def writes(o: RoutineColumnUsageRow): JsObject =
      Json.obj(
        "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "routine_catalog" -> o.routineCatalog,
      "routine_schema" -> o.routineSchema,
      "routine_name" -> o.routineName,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName
      )

    override def reads(json: JsValue): JsResult[RoutineColumnUsageRow] = {
      JsResult.fromTry(
        Try(
          RoutineColumnUsageRow(
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            routineCatalog = json.\("routine_catalog").toOption.map(_.as[String]),
            routineSchema = json.\("routine_schema").toOption.map(_.as[String]),
            routineName = json.\("routine_name").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}