/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.shoppingcartitem.ShoppingcartitemId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class SciViewStructure[Row](val prefix: Option[String], val extract: Row => SciViewRow, val merge: (Row, SciViewRow) => Row)
  extends Relation[SciViewFields, SciViewRow, Row]
    with SciViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val shoppingcartitemid = new OptField[ShoppingcartitemId, Row](prefix, "shoppingcartitemid", None, Some("int4"))(x => extract(x).shoppingcartitemid, (row, value) => merge(row, extract(row).copy(shoppingcartitemid = value)))
  override val shoppingcartid = new OptField[/* max 50 chars */ String, Row](prefix, "shoppingcartid", None, None)(x => extract(x).shoppingcartid, (row, value) => merge(row, extract(row).copy(shoppingcartid = value)))
  override val quantity = new OptField[Int, Row](prefix, "quantity", None, Some("int4"))(x => extract(x).quantity, (row, value) => merge(row, extract(row).copy(quantity = value)))
  override val productid = new OptField[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val datecreated = new OptField[TypoLocalDateTime, Row](prefix, "datecreated", Some("text"), Some("timestamp"))(x => extract(x).datecreated, (row, value) => merge(row, extract(row).copy(datecreated = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SciViewRow, merge: (NewRow, SciViewRow) => NewRow): SciViewStructure[NewRow] =
    new SciViewStructure(prefix, extract, merge)
}
