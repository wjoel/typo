/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package applicable_roles

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

case class ApplicableRolesViewRow(
  grantee: Option[SqlIdentifier],
  roleName: Option[SqlIdentifier],
  isGrantable: Option[YesOrNo]
)

object ApplicableRolesViewRow {
  implicit lazy val reads: Reads[ApplicableRolesViewRow] = Reads[ApplicableRolesViewRow](json => JsResult.fromTry(
      Try(
        ApplicableRolesViewRow(
          grantee = json.\("grantee").toOption.map(_.as(SqlIdentifier.reads)),
          roleName = json.\("role_name").toOption.map(_.as(SqlIdentifier.reads)),
          isGrantable = json.\("is_grantable").toOption.map(_.as(YesOrNo.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ApplicableRolesViewRow] = RowParser[ApplicableRolesViewRow] { row =>
    Success(
      ApplicableRolesViewRow(
        grantee = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        roleName = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        isGrantable = row(idx + 2)(Column.columnToOption(YesOrNo.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ApplicableRolesViewRow] = OWrites[ApplicableRolesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantee" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.grantee),
      "role_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.roleName),
      "is_grantable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isGrantable)
    ))
  )
}
