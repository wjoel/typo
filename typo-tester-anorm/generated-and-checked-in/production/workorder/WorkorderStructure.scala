/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class WorkorderStructure[Row](val prefix: Option[String], val extract: Row => WorkorderRow, val merge: (Row, WorkorderRow) => Row)
  extends Relation[WorkorderFields, WorkorderRow, Row]
    with WorkorderFields[Row] { outer =>

  override val workorderid = new IdField[WorkorderId, Row](prefix, "workorderid", None, Some("int4"))(x => extract(x).workorderid, (row, value) => merge(row, extract(row).copy(workorderid = value)))
  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val orderqty = new Field[Int, Row](prefix, "orderqty", None, Some("int4"))(x => extract(x).orderqty, (row, value) => merge(row, extract(row).copy(orderqty = value)))
  override val scrappedqty = new Field[Int, Row](prefix, "scrappedqty", None, Some("int2"))(x => extract(x).scrappedqty, (row, value) => merge(row, extract(row).copy(scrappedqty = value)))
  override val startdate = new Field[TypoLocalDateTime, Row](prefix, "startdate", Some("text"), Some("timestamp"))(x => extract(x).startdate, (row, value) => merge(row, extract(row).copy(startdate = value)))
  override val enddate = new OptField[TypoLocalDateTime, Row](prefix, "enddate", Some("text"), Some("timestamp"))(x => extract(x).enddate, (row, value) => merge(row, extract(row).copy(enddate = value)))
  override val duedate = new Field[TypoLocalDateTime, Row](prefix, "duedate", Some("text"), Some("timestamp"))(x => extract(x).duedate, (row, value) => merge(row, extract(row).copy(duedate = value)))
  override val scrapreasonid = new OptField[ScrapreasonId, Row](prefix, "scrapreasonid", None, Some("int2"))(x => extract(x).scrapreasonid, (row, value) => merge(row, extract(row).copy(scrapreasonid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => WorkorderRow, merge: (NewRow, WorkorderRow) => NewRow): WorkorderStructure[NewRow] =
    new WorkorderStructure(prefix, extract, merge)
}
