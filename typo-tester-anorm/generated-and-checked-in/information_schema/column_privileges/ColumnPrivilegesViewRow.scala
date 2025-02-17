/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_privileges

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

case class ColumnPrivilegesViewRow(
  grantor: Option[SqlIdentifier],
  grantee: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  privilegeType: Option[CharacterData],
  isGrantable: Option[YesOrNo]
)

object ColumnPrivilegesViewRow {
  implicit lazy val reads: Reads[ColumnPrivilegesViewRow] = Reads[ColumnPrivilegesViewRow](json => JsResult.fromTry(
      Try(
        ColumnPrivilegesViewRow(
          grantor = json.\("grantor").toOption.map(_.as(SqlIdentifier.reads)),
          grantee = json.\("grantee").toOption.map(_.as(SqlIdentifier.reads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          columnName = json.\("column_name").toOption.map(_.as(SqlIdentifier.reads)),
          privilegeType = json.\("privilege_type").toOption.map(_.as(CharacterData.reads)),
          isGrantable = json.\("is_grantable").toOption.map(_.as(YesOrNo.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnPrivilegesViewRow] = RowParser[ColumnPrivilegesViewRow] { row =>
    Success(
      ColumnPrivilegesViewRow(
        grantor = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        grantee = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableCatalog = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        columnName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        privilegeType = row(idx + 6)(Column.columnToOption(CharacterData.column)),
        isGrantable = row(idx + 7)(Column.columnToOption(YesOrNo.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ColumnPrivilegesViewRow] = OWrites[ColumnPrivilegesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantor" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantor),
      "grantee" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantee),
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.columnName),
      "privilege_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.privilegeType),
      "is_grantable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isGrantable)
    ))
  )
}
