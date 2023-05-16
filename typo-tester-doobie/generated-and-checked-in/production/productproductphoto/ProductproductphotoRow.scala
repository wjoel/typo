/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import java.time.LocalDateTime

case class ProductproductphotoRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product photo identification number. Foreign key to ProductPhoto.ProductPhotoID.
      Points to [[productphoto.ProductphotoRow.productphotoid]] */
  productphotoid: ProductphotoId,
  /** 0 = Photo is not the principal image. 1 = Photo is the principal image. */
  primary: Flag,
  modifieddate: LocalDateTime
){
   val compositeId: ProductproductphotoId = ProductproductphotoId(productid, productphotoid)
 }


