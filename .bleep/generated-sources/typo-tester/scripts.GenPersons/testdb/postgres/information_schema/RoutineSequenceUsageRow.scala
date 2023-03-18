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

case class RoutineSequenceUsageRow(
  specificCatalog: /* unknown nullability */ Option[String],
  specificSchema: /* unknown nullability */ Option[String],
  specificName: /* unknown nullability */ Option[String],
  routineCatalog: /* unknown nullability */ Option[String],
  routineSchema: /* unknown nullability */ Option[String],
  routineName: /* unknown nullability */ Option[String],
  sequenceCatalog: /* unknown nullability */ Option[String],
  sequenceSchema: /* unknown nullability */ Option[String],
  sequenceName: /* unknown nullability */ Option[String]
)

object RoutineSequenceUsageRow {
  implicit val rowParser: RowParser[RoutineSequenceUsageRow] = { row =>
    Success(
      RoutineSequenceUsageRow(
        specificCatalog = row[/* unknown nullability */ Option[String]]("specific_catalog"),
        specificSchema = row[/* unknown nullability */ Option[String]]("specific_schema"),
        specificName = row[/* unknown nullability */ Option[String]]("specific_name"),
        routineCatalog = row[/* unknown nullability */ Option[String]]("routine_catalog"),
        routineSchema = row[/* unknown nullability */ Option[String]]("routine_schema"),
        routineName = row[/* unknown nullability */ Option[String]]("routine_name"),
        sequenceCatalog = row[/* unknown nullability */ Option[String]]("sequence_catalog"),
        sequenceSchema = row[/* unknown nullability */ Option[String]]("sequence_schema"),
        sequenceName = row[/* unknown nullability */ Option[String]]("sequence_name")
      )
    )
  }

  implicit val oFormat: OFormat[RoutineSequenceUsageRow] = new OFormat[RoutineSequenceUsageRow]{
    override def writes(o: RoutineSequenceUsageRow): JsObject =
      Json.obj(
        "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "routine_catalog" -> o.routineCatalog,
      "routine_schema" -> o.routineSchema,
      "routine_name" -> o.routineName,
      "sequence_catalog" -> o.sequenceCatalog,
      "sequence_schema" -> o.sequenceSchema,
      "sequence_name" -> o.sequenceName
      )

    override def reads(json: JsValue): JsResult[RoutineSequenceUsageRow] = {
      JsResult.fromTry(
        Try(
          RoutineSequenceUsageRow(
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            routineCatalog = json.\("routine_catalog").toOption.map(_.as[String]),
            routineSchema = json.\("routine_schema").toOption.map(_.as[String]),
            routineName = json.\("routine_name").toOption.map(_.as[String]),
            sequenceCatalog = json.\("sequence_catalog").toOption.map(_.as[String]),
            sequenceSchema = json.\("sequence_schema").toOption.map(_.as[String]),
            sequenceName = json.\("sequence_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}