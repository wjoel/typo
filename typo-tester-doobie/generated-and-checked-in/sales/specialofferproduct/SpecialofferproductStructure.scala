/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class SpecialofferproductStructure[Row](val prefix: Option[String], val extract: Row => SpecialofferproductRow, val merge: (Row, SpecialofferproductRow) => Row)
  extends Relation[SpecialofferproductFields, SpecialofferproductRow, Row]
    with SpecialofferproductFields[Row] { outer =>

  override val specialofferid = new IdField[SpecialofferId, Row](prefix, "specialofferid", None, Some("int4"))(x => extract(x).specialofferid, (row, value) => merge(row, extract(row).copy(specialofferid = value)))
  override val productid = new IdField[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val rowguid = new Field[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](specialofferid, productid, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SpecialofferproductRow, merge: (NewRow, SpecialofferproductRow) => NewRow): SpecialofferproductStructure[NewRow] =
    new SpecialofferproductStructure(prefix, extract, merge)
}
