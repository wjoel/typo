/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import java.util.UUID

case class ProductinventoryRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Inventory location identification number. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Storage compartment within an inventory location. */
  shelf: String,
  /** Storage container on a shelf in an inventory location. */
  bin: Int,
  /** Quantity of products in the inventory location. */
  quantity: Int,
  rowguid: UUID,
  modifieddate: LocalDateTime
){
   val compositeId: ProductinventoryId = ProductinventoryId(productid, locationid)
 }


