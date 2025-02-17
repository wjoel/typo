/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class SalesorderdetailStructure[Row](val prefix: Option[String], val extract: Row => SalesorderdetailRow, val merge: (Row, SalesorderdetailRow) => Row)
  extends Relation[SalesorderdetailFields, SalesorderdetailRow, Row]
    with SalesorderdetailFields[Row] { outer =>

  override val salesorderid = new IdField[SalesorderheaderId, Row](prefix, "salesorderid", None, Some("int4"))(x => extract(x).salesorderid, (row, value) => merge(row, extract(row).copy(salesorderid = value)))
  override val salesorderdetailid = new IdField[Int, Row](prefix, "salesorderdetailid", None, Some("int4"))(x => extract(x).salesorderdetailid, (row, value) => merge(row, extract(row).copy(salesorderdetailid = value)))
  override val carriertrackingnumber = new OptField[/* max 25 chars */ String, Row](prefix, "carriertrackingnumber", None, None)(x => extract(x).carriertrackingnumber, (row, value) => merge(row, extract(row).copy(carriertrackingnumber = value)))
  override val orderqty = new Field[Int, Row](prefix, "orderqty", None, Some("int2"))(x => extract(x).orderqty, (row, value) => merge(row, extract(row).copy(orderqty = value)))
  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val specialofferid = new Field[SpecialofferId, Row](prefix, "specialofferid", None, Some("int4"))(x => extract(x).specialofferid, (row, value) => merge(row, extract(row).copy(specialofferid = value)))
  override val unitprice = new Field[BigDecimal, Row](prefix, "unitprice", None, Some("numeric"))(x => extract(x).unitprice, (row, value) => merge(row, extract(row).copy(unitprice = value)))
  override val unitpricediscount = new Field[BigDecimal, Row](prefix, "unitpricediscount", None, Some("numeric"))(x => extract(x).unitpricediscount, (row, value) => merge(row, extract(row).copy(unitpricediscount = value)))
  override val rowguid = new Field[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SalesorderdetailRow, merge: (NewRow, SalesorderdetailRow) => NewRow): SalesorderdetailStructure[NewRow] =
    new SalesorderdetailStructure(prefix, extract, merge)
}
