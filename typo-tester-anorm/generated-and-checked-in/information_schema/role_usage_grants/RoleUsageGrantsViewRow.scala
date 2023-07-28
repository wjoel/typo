/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_usage_grants

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

case class RoleUsageGrantsViewRow(
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.grantor]] */
  grantor: Option[SqlIdentifier],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.grantee]] */
  grantee: Option[SqlIdentifier],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectCatalog]] */
  objectCatalog: Option[SqlIdentifier],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectSchema]] */
  objectSchema: Option[SqlIdentifier],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectName]] */
  objectName: Option[SqlIdentifier],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectType]] */
  objectType: Option[CharacterData],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.privilegeType]] */
  privilegeType: Option[CharacterData],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.isGrantable]] */
  isGrantable: Option[YesOrNo]
)

object RoleUsageGrantsViewRow {
  implicit val reads: Reads[RoleUsageGrantsViewRow] = Reads[RoleUsageGrantsViewRow](json => JsResult.fromTry(
      Try(
        RoleUsageGrantsViewRow(
          grantor = json.\("grantor").toOption.map(_.as(SqlIdentifier.reads)),
          grantee = json.\("grantee").toOption.map(_.as(SqlIdentifier.reads)),
          objectCatalog = json.\("object_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          objectSchema = json.\("object_schema").toOption.map(_.as(SqlIdentifier.reads)),
          objectName = json.\("object_name").toOption.map(_.as(SqlIdentifier.reads)),
          objectType = json.\("object_type").toOption.map(_.as(CharacterData.reads)),
          privilegeType = json.\("privilege_type").toOption.map(_.as(CharacterData.reads)),
          isGrantable = json.\("is_grantable").toOption.map(_.as(YesOrNo.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[RoleUsageGrantsViewRow] = RowParser[RoleUsageGrantsViewRow] { row =>
    Success(
      RoleUsageGrantsViewRow(
        grantor = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        grantee = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        objectCatalog = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        objectSchema = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        objectName = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        objectType = row(idx + 5)(Column.columnToOption(CharacterData.column)),
        privilegeType = row(idx + 6)(Column.columnToOption(CharacterData.column)),
        isGrantable = row(idx + 7)(Column.columnToOption(YesOrNo.column))
      )
    )
  }
  implicit val writes: OWrites[RoleUsageGrantsViewRow] = OWrites[RoleUsageGrantsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantor" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantor),
      "grantee" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantee),
      "object_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.objectCatalog),
      "object_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.objectSchema),
      "object_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.objectName),
      "object_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.objectType),
      "privilege_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.privilegeType),
      "is_grantable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isGrantable)
    ))
  )
}
