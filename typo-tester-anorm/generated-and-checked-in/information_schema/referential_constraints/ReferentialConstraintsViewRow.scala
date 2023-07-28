/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

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

case class ReferentialConstraintsViewRow(
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier],
  uniqueConstraintCatalog: Option[SqlIdentifier],
  uniqueConstraintSchema: Option[SqlIdentifier],
  uniqueConstraintName: Option[SqlIdentifier],
  matchOption: Option[CharacterData],
  updateRule: Option[CharacterData],
  deleteRule: Option[CharacterData]
)

object ReferentialConstraintsViewRow {
  implicit val reads: Reads[ReferentialConstraintsViewRow] = Reads[ReferentialConstraintsViewRow](json => JsResult.fromTry(
      Try(
        ReferentialConstraintsViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(SqlIdentifier.reads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(SqlIdentifier.reads)),
          uniqueConstraintCatalog = json.\("unique_constraint_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          uniqueConstraintSchema = json.\("unique_constraint_schema").toOption.map(_.as(SqlIdentifier.reads)),
          uniqueConstraintName = json.\("unique_constraint_name").toOption.map(_.as(SqlIdentifier.reads)),
          matchOption = json.\("match_option").toOption.map(_.as(CharacterData.reads)),
          updateRule = json.\("update_rule").toOption.map(_.as(CharacterData.reads)),
          deleteRule = json.\("delete_rule").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ReferentialConstraintsViewRow] = RowParser[ReferentialConstraintsViewRow] { row =>
    Success(
      ReferentialConstraintsViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        constraintSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        constraintName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        uniqueConstraintCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        uniqueConstraintSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        uniqueConstraintName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        matchOption = row(idx + 6)(Column.columnToOption(CharacterData.column)),
        updateRule = row(idx + 7)(Column.columnToOption(CharacterData.column)),
        deleteRule = row(idx + 8)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit val writes: OWrites[ReferentialConstraintsViewRow] = OWrites[ReferentialConstraintsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintName),
      "unique_constraint_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.uniqueConstraintCatalog),
      "unique_constraint_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.uniqueConstraintSchema),
      "unique_constraint_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.uniqueConstraintName),
      "match_option" -> Writes.OptionWrites(CharacterData.writes).writes(o.matchOption),
      "update_rule" -> Writes.OptionWrites(CharacterData.writes).writes(o.updateRule),
      "delete_rule" -> Writes.OptionWrites(CharacterData.writes).writes(o.deleteRule)
    ))
  )
}
