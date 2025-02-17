/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package administrable_role_authorizations

import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class AdministrableRoleAuthorizationsViewStructure[Row](val prefix: Option[String], val extract: Row => AdministrableRoleAuthorizationsViewRow, val merge: (Row, AdministrableRoleAuthorizationsViewRow) => Row)
  extends Relation[AdministrableRoleAuthorizationsViewFields, AdministrableRoleAuthorizationsViewRow, Row]
    with AdministrableRoleAuthorizationsViewFields[Row] { outer =>

  override val grantee = new OptField[SqlIdentifier, Row](prefix, "grantee", None, Some("information_schema.sql_identifier"))(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val roleName = new OptField[SqlIdentifier, Row](prefix, "role_name", None, Some("information_schema.sql_identifier"))(x => extract(x).roleName, (row, value) => merge(row, extract(row).copy(roleName = value)))
  override val isGrantable = new OptField[YesOrNo, Row](prefix, "is_grantable", None, Some("information_schema.yes_or_no"))(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantee, roleName, isGrantable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => AdministrableRoleAuthorizationsViewRow, merge: (NewRow, AdministrableRoleAuthorizationsViewRow) => NewRow): AdministrableRoleAuthorizationsViewStructure[NewRow] =
    new AdministrableRoleAuthorizationsViewStructure(prefix, extract, merge)
}
