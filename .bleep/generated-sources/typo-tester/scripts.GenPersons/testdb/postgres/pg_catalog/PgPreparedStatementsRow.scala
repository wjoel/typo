/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.ZonedDateTime
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPreparedStatementsRow(
  name: Option[String],
  statement: Option[String],
  prepareTime: Option[ZonedDateTime],
  parameterTypes: Option[Array[PGobject]],
  fromSql: Option[Boolean],
  genericPlans: Option[Long],
  customPlans: Option[Long]
)

object PgPreparedStatementsRow {
  def rowParser(prefix: String): RowParser[PgPreparedStatementsRow] = { row =>
    Success(
      PgPreparedStatementsRow(
        name = row[Option[String]](prefix + "name"),
        statement = row[Option[String]](prefix + "statement"),
        prepareTime = row[Option[ZonedDateTime]](prefix + "prepare_time"),
        parameterTypes = row[Option[Array[PGobject]]](prefix + "parameter_types"),
        fromSql = row[Option[Boolean]](prefix + "from_sql"),
        genericPlans = row[Option[Long]](prefix + "generic_plans"),
        customPlans = row[Option[Long]](prefix + "custom_plans")
      )
    )
  }

  implicit val oFormat: OFormat[PgPreparedStatementsRow] = new OFormat[PgPreparedStatementsRow]{
    override def writes(o: PgPreparedStatementsRow): JsObject =
      Json.obj(
        "name" -> o.name,
      "statement" -> o.statement,
      "prepare_time" -> o.prepareTime,
      "parameter_types" -> o.parameterTypes,
      "from_sql" -> o.fromSql,
      "generic_plans" -> o.genericPlans,
      "custom_plans" -> o.customPlans
      )

    override def reads(json: JsValue): JsResult[PgPreparedStatementsRow] = {
      JsResult.fromTry(
        Try(
          PgPreparedStatementsRow(
            name = json.\("name").toOption.map(_.as[String]),
            statement = json.\("statement").toOption.map(_.as[String]),
            prepareTime = json.\("prepare_time").toOption.map(_.as[ZonedDateTime]),
            parameterTypes = json.\("parameter_types").toOption.map(_.as[Array[PGobject]]),
            fromSql = json.\("from_sql").toOption.map(_.as[Boolean]),
            genericPlans = json.\("generic_plans").toOption.map(_.as[Long]),
            customPlans = json.\("custom_plans").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
