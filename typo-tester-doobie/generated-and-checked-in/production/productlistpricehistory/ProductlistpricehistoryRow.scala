/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.production.product.ProductId
import java.time.LocalDateTime

case class ProductlistpricehistoryRow(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** List price start date. */
  startdate: LocalDateTime,
  /** List price end date */
  enddate: Option[LocalDateTime],
  /** Product list price. */
  listprice: BigDecimal,
  modifieddate: LocalDateTime
){
   val compositeId: ProductlistpricehistoryId = ProductlistpricehistoryId(productid, startdate)
 }


