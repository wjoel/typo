/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.productlistpricehistory` which has not been persisted yet */
case class ProductlistpricehistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** List price start date. */
  startdate: TypoLocalDateTime,
  /** List price end date */
  enddate: Option[TypoLocalDateTime],
  /** Product list price. */
  listprice: BigDecimal,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductlistpricehistoryRow =
    ProductlistpricehistoryRow(
      productid = productid,
      startdate = startdate,
      enddate = enddate,
      listprice = listprice,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductlistpricehistoryRowUnsaved {
  implicit lazy val reads: Reads[ProductlistpricehistoryRowUnsaved] = Reads[ProductlistpricehistoryRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductlistpricehistoryRowUnsaved(
          productid = json.\("productid").as(ProductId.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          listprice = json.\("listprice").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductlistpricehistoryRowUnsaved] = OWrites[ProductlistpricehistoryRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "listprice" -> Writes.BigDecimalWrites.writes(o.listprice),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
