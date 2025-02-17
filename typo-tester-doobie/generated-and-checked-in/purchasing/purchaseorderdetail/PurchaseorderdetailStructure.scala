/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PurchaseorderdetailStructure[Row](val prefix: Option[String], val extract: Row => PurchaseorderdetailRow, val merge: (Row, PurchaseorderdetailRow) => Row)
  extends Relation[PurchaseorderdetailFields, PurchaseorderdetailRow, Row]
    with PurchaseorderdetailFields[Row] { outer =>

  override val purchaseorderid = new IdField[PurchaseorderheaderId, Row](prefix, "purchaseorderid", None, Some("int4"))(x => extract(x).purchaseorderid, (row, value) => merge(row, extract(row).copy(purchaseorderid = value)))
  override val purchaseorderdetailid = new IdField[Int, Row](prefix, "purchaseorderdetailid", None, Some("int4"))(x => extract(x).purchaseorderdetailid, (row, value) => merge(row, extract(row).copy(purchaseorderdetailid = value)))
  override val duedate = new Field[TypoLocalDateTime, Row](prefix, "duedate", Some("text"), Some("timestamp"))(x => extract(x).duedate, (row, value) => merge(row, extract(row).copy(duedate = value)))
  override val orderqty = new Field[Int, Row](prefix, "orderqty", None, Some("int2"))(x => extract(x).orderqty, (row, value) => merge(row, extract(row).copy(orderqty = value)))
  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val unitprice = new Field[BigDecimal, Row](prefix, "unitprice", None, Some("numeric"))(x => extract(x).unitprice, (row, value) => merge(row, extract(row).copy(unitprice = value)))
  override val receivedqty = new Field[BigDecimal, Row](prefix, "receivedqty", None, Some("numeric"))(x => extract(x).receivedqty, (row, value) => merge(row, extract(row).copy(receivedqty = value)))
  override val rejectedqty = new Field[BigDecimal, Row](prefix, "rejectedqty", None, Some("numeric"))(x => extract(x).rejectedqty, (row, value) => merge(row, extract(row).copy(rejectedqty = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PurchaseorderdetailRow, merge: (NewRow, PurchaseorderdetailRow) => NewRow): PurchaseorderdetailStructure[NewRow] =
    new PurchaseorderdetailStructure(prefix, extract, merge)
}
