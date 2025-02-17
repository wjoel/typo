/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package views

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
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

case class ViewsViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  viewDefinition: Option[CharacterData],
  checkOption: Option[CharacterData],
  isUpdatable: Option[YesOrNo],
  isInsertableInto: Option[YesOrNo],
  isTriggerUpdatable: Option[YesOrNo],
  isTriggerDeletable: Option[YesOrNo],
  isTriggerInsertableInto: Option[YesOrNo]
)

object ViewsViewRow {
  implicit lazy val reads: Reads[ViewsViewRow] = Reads[ViewsViewRow](json => JsResult.fromTry(
      Try(
        ViewsViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          viewDefinition = json.\("view_definition").toOption.map(_.as(CharacterData.reads)),
          checkOption = json.\("check_option").toOption.map(_.as(CharacterData.reads)),
          isUpdatable = json.\("is_updatable").toOption.map(_.as(YesOrNo.reads)),
          isInsertableInto = json.\("is_insertable_into").toOption.map(_.as(YesOrNo.reads)),
          isTriggerUpdatable = json.\("is_trigger_updatable").toOption.map(_.as(YesOrNo.reads)),
          isTriggerDeletable = json.\("is_trigger_deletable").toOption.map(_.as(YesOrNo.reads)),
          isTriggerInsertableInto = json.\("is_trigger_insertable_into").toOption.map(_.as(YesOrNo.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ViewsViewRow] = RowParser[ViewsViewRow] { row =>
    Success(
      ViewsViewRow(
        tableCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        viewDefinition = row(idx + 3)(Column.columnToOption(CharacterData.column)),
        checkOption = row(idx + 4)(Column.columnToOption(CharacterData.column)),
        isUpdatable = row(idx + 5)(Column.columnToOption(YesOrNo.column)),
        isInsertableInto = row(idx + 6)(Column.columnToOption(YesOrNo.column)),
        isTriggerUpdatable = row(idx + 7)(Column.columnToOption(YesOrNo.column)),
        isTriggerDeletable = row(idx + 8)(Column.columnToOption(YesOrNo.column)),
        isTriggerInsertableInto = row(idx + 9)(Column.columnToOption(YesOrNo.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ViewsViewRow] = OWrites[ViewsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "view_definition" -> Writes.OptionWrites(CharacterData.writes).writes(o.viewDefinition),
      "check_option" -> Writes.OptionWrites(CharacterData.writes).writes(o.checkOption),
      "is_updatable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isUpdatable),
      "is_insertable_into" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isInsertableInto),
      "is_trigger_updatable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isTriggerUpdatable),
      "is_trigger_deletable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isTriggerDeletable),
      "is_trigger_insertable_into" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isTriggerInsertableInto)
    ))
  )
}
