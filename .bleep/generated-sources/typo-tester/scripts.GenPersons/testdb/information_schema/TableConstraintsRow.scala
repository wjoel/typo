package testdb.information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class TableConstraintsRow(
  constraintCatalog: /* unknown nullability */ Option[String],
  constraintSchema: /* unknown nullability */ Option[String],
  constraintName: /* unknown nullability */ Option[String],
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  constraintType: /* unknown nullability */ Option[String],
  isDeferrable: /* unknown nullability */ Option[String],
  initiallyDeferred: /* unknown nullability */ Option[String],
  enforced: /* unknown nullability */ Option[String]
)

object TableConstraintsRow {
  implicit val rowParser: RowParser[TableConstraintsRow] = { row =>
    Success(
      TableConstraintsRow(
        constraintCatalog = row[/* unknown nullability */ Option[String]]("constraint_catalog"),
        constraintSchema = row[/* unknown nullability */ Option[String]]("constraint_schema"),
        constraintName = row[/* unknown nullability */ Option[String]]("constraint_name"),
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        constraintType = row[/* unknown nullability */ Option[String]]("constraint_type"),
        isDeferrable = row[/* unknown nullability */ Option[String]]("is_deferrable"),
        initiallyDeferred = row[/* unknown nullability */ Option[String]]("initially_deferred"),
        enforced = row[/* unknown nullability */ Option[String]]("enforced")
      )
    )
  }

  implicit val oFormat: OFormat[TableConstraintsRow] = Json.format
}