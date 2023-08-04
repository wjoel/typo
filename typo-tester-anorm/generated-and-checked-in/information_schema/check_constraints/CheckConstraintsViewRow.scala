/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraints

import adventureworks.information_schema.CharacterData
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

case class CheckConstraintsViewRow(
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier],
  checkClause: Option[CharacterData]
)

object CheckConstraintsViewRow {
  implicit lazy val reads: Reads[CheckConstraintsViewRow] = Reads[CheckConstraintsViewRow](json => JsResult.fromTry(
      Try(
        CheckConstraintsViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(SqlIdentifier.reads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(SqlIdentifier.reads)),
          checkClause = json.\("check_clause").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CheckConstraintsViewRow] = RowParser[CheckConstraintsViewRow] { row =>
    Success(
      CheckConstraintsViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        constraintSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        constraintName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        checkClause = row(idx + 3)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit lazy val writes: OWrites[CheckConstraintsViewRow] = OWrites[CheckConstraintsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintName),
      "check_clause" -> Writes.OptionWrites(CharacterData.writes).writes(o.checkClause)
    ))
  )
}