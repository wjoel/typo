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

/** Type for the composite primary key of table `production.productlistpricehistory` */
case class ProductlistpricehistoryId(productid: ProductId, startdate: LocalDateTime)
object ProductlistpricehistoryId {
  implicit def ordering: Ordering[ProductlistpricehistoryId] = Ordering.by(x => (x.productid, x.startdate))
  
}
