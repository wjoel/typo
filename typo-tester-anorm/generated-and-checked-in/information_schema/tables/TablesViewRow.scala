/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package tables

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

case class TablesViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  tableType: Option[CharacterData],
  selfReferencingColumnName: Option[SqlIdentifier],
  referenceGeneration: Option[CharacterData],
  userDefinedTypeCatalog: Option[SqlIdentifier],
  userDefinedTypeSchema: Option[SqlIdentifier],
  userDefinedTypeName: Option[SqlIdentifier],
  isInsertableInto: Option[YesOrNo],
  isTyped: Option[YesOrNo],
  commitAction: Option[CharacterData]
)

object TablesViewRow {
  implicit val reads: Reads[TablesViewRow] = Reads[TablesViewRow](json => JsResult.fromTry(
      Try(
        TablesViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          tableType = json.\("table_type").toOption.map(_.as(CharacterData.reads)),
          selfReferencingColumnName = json.\("self_referencing_column_name").toOption.map(_.as(SqlIdentifier.reads)),
          referenceGeneration = json.\("reference_generation").toOption.map(_.as(CharacterData.reads)),
          userDefinedTypeCatalog = json.\("user_defined_type_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          userDefinedTypeSchema = json.\("user_defined_type_schema").toOption.map(_.as(SqlIdentifier.reads)),
          userDefinedTypeName = json.\("user_defined_type_name").toOption.map(_.as(SqlIdentifier.reads)),
          isInsertableInto = json.\("is_insertable_into").toOption.map(_.as(YesOrNo.reads)),
          isTyped = json.\("is_typed").toOption.map(_.as(YesOrNo.reads)),
          commitAction = json.\("commit_action").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TablesViewRow] = RowParser[TablesViewRow] { row =>
    Success(
      TablesViewRow(
        tableCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableType = row(idx + 3)(Column.columnToOption(CharacterData.column)),
        selfReferencingColumnName = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        referenceGeneration = row(idx + 5)(Column.columnToOption(CharacterData.column)),
        userDefinedTypeCatalog = row(idx + 6)(Column.columnToOption(SqlIdentifier.column)),
        userDefinedTypeSchema = row(idx + 7)(Column.columnToOption(SqlIdentifier.column)),
        userDefinedTypeName = row(idx + 8)(Column.columnToOption(SqlIdentifier.column)),
        isInsertableInto = row(idx + 9)(Column.columnToOption(YesOrNo.column)),
        isTyped = row(idx + 10)(Column.columnToOption(YesOrNo.column)),
        commitAction = row(idx + 11)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit val writes: OWrites[TablesViewRow] = OWrites[TablesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "table_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.tableType),
      "self_referencing_column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.selfReferencingColumnName),
      "reference_generation" -> Writes.OptionWrites(CharacterData.writes).writes(o.referenceGeneration),
      "user_defined_type_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.userDefinedTypeCatalog),
      "user_defined_type_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.userDefinedTypeSchema),
      "user_defined_type_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.userDefinedTypeName),
      "is_insertable_into" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isInsertableInto),
      "is_typed" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isTyped),
      "commit_action" -> Writes.OptionWrites(CharacterData.writes).writes(o.commitAction)
    ))
  )
}
