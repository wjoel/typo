/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PchViewStructure[Row](val prefix: Option[String], val extract: Row => PchViewRow, val merge: (Row, PchViewRow) => Row)
  extends Relation[PchViewFields, PchViewRow, Row]
    with PchViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val productid = new OptField[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val startdate = new OptField[TypoLocalDateTime, Row](prefix, "startdate", Some("text"), Some("timestamp"))(x => extract(x).startdate, (row, value) => merge(row, extract(row).copy(startdate = value)))
  override val enddate = new OptField[TypoLocalDateTime, Row](prefix, "enddate", Some("text"), Some("timestamp"))(x => extract(x).enddate, (row, value) => merge(row, extract(row).copy(enddate = value)))
  override val standardcost = new OptField[BigDecimal, Row](prefix, "standardcost", None, Some("numeric"))(x => extract(x).standardcost, (row, value) => merge(row, extract(row).copy(standardcost = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, productid, startdate, enddate, standardcost, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PchViewRow, merge: (NewRow, PchViewRow) => NewRow): PchViewStructure[NewRow] =
    new PchViewStructure(prefix, extract, merge)
}
