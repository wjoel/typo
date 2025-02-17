/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class DepartmentStructure[Row](val prefix: Option[String], val extract: Row => DepartmentRow, val merge: (Row, DepartmentRow) => Row)
  extends Relation[DepartmentFields, DepartmentRow, Row]
    with DepartmentFields[Row] { outer =>

  override val departmentid = new IdField[DepartmentId, Row](prefix, "departmentid", None, Some("int4"))(x => extract(x).departmentid, (row, value) => merge(row, extract(row).copy(departmentid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val groupname = new Field[Name, Row](prefix, "groupname", None, Some(""""public"."Name""""))(x => extract(x).groupname, (row, value) => merge(row, extract(row).copy(groupname = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](departmentid, name, groupname, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => DepartmentRow, merge: (NewRow, DepartmentRow) => NewRow): DepartmentStructure[NewRow] =
    new DepartmentStructure(prefix, extract, merge)
}
