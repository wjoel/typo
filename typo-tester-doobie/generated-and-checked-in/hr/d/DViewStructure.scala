/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package d

import adventureworks.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.public.Name
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class DViewStructure[Row](val prefix: Option[String], val extract: Row => DViewRow, val merge: (Row, DViewRow) => Row)
  extends Relation[DViewFields, DViewRow, Row]
    with DViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val departmentid = new OptField[DepartmentId, Row](prefix, "departmentid", None, Some("int4"))(x => extract(x).departmentid, (row, value) => merge(row, extract(row).copy(departmentid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val groupname = new OptField[Name, Row](prefix, "groupname", None, Some(""""public"."Name""""))(x => extract(x).groupname, (row, value) => merge(row, extract(row).copy(groupname = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, departmentid, name, groupname, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => DViewRow, merge: (NewRow, DViewRow) => NewRow): DViewStructure[NewRow] =
    new DViewStructure(prefix, extract, merge)
}
