/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class UnitmeasureStructure[Row](val prefix: Option[String], val extract: Row => UnitmeasureRow, val merge: (Row, UnitmeasureRow) => Row)
  extends Relation[UnitmeasureFields, UnitmeasureRow, Row]
    with UnitmeasureFields[Row] { outer =>

  override val unitmeasurecode = new IdField[UnitmeasureId, Row](prefix, "unitmeasurecode", None, Some("bpchar"))(x => extract(x).unitmeasurecode, (row, value) => merge(row, extract(row).copy(unitmeasurecode = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](unitmeasurecode, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => UnitmeasureRow, merge: (NewRow, UnitmeasureRow) => NewRow): UnitmeasureStructure[NewRow] =
    new UnitmeasureStructure(prefix, extract, merge)
}
