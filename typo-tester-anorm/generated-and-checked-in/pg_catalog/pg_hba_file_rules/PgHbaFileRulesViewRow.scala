/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_hba_file_rules

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

case class PgHbaFileRulesViewRow(
  lineNumber: Option[Int],
  `type`: Option[String],
  database: Option[Array[String]],
  userName: Option[Array[String]],
  address: Option[String],
  netmask: Option[String],
  authMethod: Option[String],
  options: Option[Array[String]],
  error: Option[String]
)

object PgHbaFileRulesViewRow {
  implicit lazy val reads: Reads[PgHbaFileRulesViewRow] = Reads[PgHbaFileRulesViewRow](json => JsResult.fromTry(
      Try(
        PgHbaFileRulesViewRow(
          lineNumber = json.\("line_number").toOption.map(_.as(Reads.IntReads)),
          `type` = json.\("type").toOption.map(_.as(Reads.StringReads)),
          database = json.\("database").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          userName = json.\("user_name").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          address = json.\("address").toOption.map(_.as(Reads.StringReads)),
          netmask = json.\("netmask").toOption.map(_.as(Reads.StringReads)),
          authMethod = json.\("auth_method").toOption.map(_.as(Reads.StringReads)),
          options = json.\("options").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          error = json.\("error").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgHbaFileRulesViewRow] = RowParser[PgHbaFileRulesViewRow] { row =>
    Success(
      PgHbaFileRulesViewRow(
        lineNumber = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        `type` = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        database = row(idx + 2)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        userName = row(idx + 3)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        address = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        netmask = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        authMethod = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        options = row(idx + 7)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        error = row(idx + 8)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgHbaFileRulesViewRow] = OWrites[PgHbaFileRulesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "line_number" -> Writes.OptionWrites(Writes.IntWrites).writes(o.lineNumber),
      "type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`type`),
      "database" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.database),
      "user_name" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.userName),
      "address" -> Writes.OptionWrites(Writes.StringWrites).writes(o.address),
      "netmask" -> Writes.OptionWrites(Writes.StringWrites).writes(o.netmask),
      "auth_method" -> Writes.OptionWrites(Writes.StringWrites).writes(o.authMethod),
      "options" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.options),
      "error" -> Writes.OptionWrites(Writes.StringWrites).writes(o.error)
    ))
  )
}
