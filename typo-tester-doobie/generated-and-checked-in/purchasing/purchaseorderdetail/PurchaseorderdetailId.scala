/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId

/** Type for the composite primary key of table `purchasing.purchaseorderdetail` */
case class PurchaseorderdetailId(purchaseorderid: PurchaseorderheaderId, purchaseorderdetailid: Int)
object PurchaseorderdetailId {
  implicit def ordering: Ordering[PurchaseorderdetailId] = Ordering.by(x => (x.purchaseorderid, x.purchaseorderdetailid))
  
}
