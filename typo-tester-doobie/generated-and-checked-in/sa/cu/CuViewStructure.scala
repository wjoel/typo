/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.sales.currency.CurrencyId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class CuViewStructure[Row](val prefix: Option[String], val extract: Row => CuViewRow, val merge: (Row, CuViewRow) => Row)
  extends Relation[CuViewFields, CuViewRow, Row]
    with CuViewFields[Row] { outer =>

  override val id = new OptField[/* bpchar */ String, Row](prefix, "id", None, Some("bpchar"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val currencycode = new OptField[CurrencyId, Row](prefix, "currencycode", None, Some("bpchar"))(x => extract(x).currencycode, (row, value) => merge(row, extract(row).copy(currencycode = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, currencycode, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CuViewRow, merge: (NewRow, CuViewRow) => NewRow): CuViewStructure[NewRow] =
    new CuViewStructure(prefix, extract, merge)
}
