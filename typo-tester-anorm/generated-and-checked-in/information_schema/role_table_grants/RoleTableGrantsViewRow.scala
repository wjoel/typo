/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_table_grants

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

case class RoleTableGrantsViewRow(
  /** Points to [[table_privileges.TablePrivilegesViewRow.grantor]] */
  grantor: Option[SqlIdentifier],
  /** Points to [[table_privileges.TablePrivilegesViewRow.grantee]] */
  grantee: Option[SqlIdentifier],
  /** Points to [[table_privileges.TablePrivilegesViewRow.tableCatalog]] */
  tableCatalog: Option[SqlIdentifier],
  /** Points to [[table_privileges.TablePrivilegesViewRow.tableSchema]] */
  tableSchema: Option[SqlIdentifier],
  /** Points to [[table_privileges.TablePrivilegesViewRow.tableName]] */
  tableName: Option[SqlIdentifier],
  /** Points to [[table_privileges.TablePrivilegesViewRow.privilegeType]] */
  privilegeType: Option[CharacterData],
  /** Points to [[table_privileges.TablePrivilegesViewRow.isGrantable]] */
  isGrantable: Option[YesOrNo],
  /** Points to [[table_privileges.TablePrivilegesViewRow.withHierarchy]] */
  withHierarchy: Option[YesOrNo]
)

object RoleTableGrantsViewRow {
  implicit lazy val reads: Reads[RoleTableGrantsViewRow] = Reads[RoleTableGrantsViewRow](json => JsResult.fromTry(
      Try(
        RoleTableGrantsViewRow(
          grantor = json.\("grantor").toOption.map(_.as(SqlIdentifier.reads)),
          grantee = json.\("grantee").toOption.map(_.as(SqlIdentifier.reads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          privilegeType = json.\("privilege_type").toOption.map(_.as(CharacterData.reads)),
          isGrantable = json.\("is_grantable").toOption.map(_.as(YesOrNo.reads)),
          withHierarchy = json.\("with_hierarchy").toOption.map(_.as(YesOrNo.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[RoleTableGrantsViewRow] = RowParser[RoleTableGrantsViewRow] { row =>
    Success(
      RoleTableGrantsViewRow(
        grantor = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        grantee = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableCatalog = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        privilegeType = row(idx + 5)(Column.columnToOption(CharacterData.column)),
        isGrantable = row(idx + 6)(Column.columnToOption(YesOrNo.column)),
        withHierarchy = row(idx + 7)(Column.columnToOption(YesOrNo.column))
      )
    )
  }
  implicit lazy val writes: OWrites[RoleTableGrantsViewRow] = OWrites[RoleTableGrantsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantor" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantor),
      "grantee" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantee),
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "privilege_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.privilegeType),
      "is_grantable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isGrantable),
      "with_hierarchy" -> Writes.OptionWrites(YesOrNo.writes).writes(o.withHierarchy)
    ))
  )
}
