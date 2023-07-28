/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_statements

import adventureworks.TypoOffsetDateTime
import adventureworks.TypoRegtype
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

case class PgPreparedStatementsViewRow(
  name: Option[String],
  statement: Option[String],
  prepareTime: Option[TypoOffsetDateTime],
  parameterTypes: Option[Array[TypoRegtype]],
  fromSql: Option[Boolean],
  genericPlans: Option[Long],
  customPlans: Option[Long]
)

object PgPreparedStatementsViewRow {
  implicit val reads: Reads[PgPreparedStatementsViewRow] = Reads[PgPreparedStatementsViewRow](json => JsResult.fromTry(
      Try(
        PgPreparedStatementsViewRow(
          name = json.\("name").toOption.map(_.as(Reads.StringReads)),
          statement = json.\("statement").toOption.map(_.as(Reads.StringReads)),
          prepareTime = json.\("prepare_time").toOption.map(_.as(TypoOffsetDateTime.reads)),
          parameterTypes = json.\("parameter_types").toOption.map(_.as(Reads.ArrayReads[TypoRegtype](TypoRegtype.reads, implicitly))),
          fromSql = json.\("from_sql").toOption.map(_.as(Reads.BooleanReads)),
          genericPlans = json.\("generic_plans").toOption.map(_.as(Reads.LongReads)),
          customPlans = json.\("custom_plans").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPreparedStatementsViewRow] = RowParser[PgPreparedStatementsViewRow] { row =>
    Success(
      PgPreparedStatementsViewRow(
        name = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        statement = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        prepareTime = row(idx + 2)(Column.columnToOption(TypoOffsetDateTime.column)),
        parameterTypes = row(idx + 3)(Column.columnToOption(TypoRegtype.arrayColumn)),
        fromSql = row(idx + 4)(Column.columnToOption(Column.columnToBoolean)),
        genericPlans = row(idx + 5)(Column.columnToOption(Column.columnToLong)),
        customPlans = row(idx + 6)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit val writes: OWrites[PgPreparedStatementsViewRow] = OWrites[PgPreparedStatementsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.name),
      "statement" -> Writes.OptionWrites(Writes.StringWrites).writes(o.statement),
      "prepare_time" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.prepareTime),
      "parameter_types" -> Writes.OptionWrites(Writes.arrayWrites[TypoRegtype](implicitly, TypoRegtype.writes)).writes(o.parameterTypes),
      "from_sql" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.fromSql),
      "generic_plans" -> Writes.OptionWrites(Writes.LongWrites).writes(o.genericPlans),
      "custom_plans" -> Writes.OptionWrites(Writes.LongWrites).writes(o.customPlans)
    ))
  )
}
