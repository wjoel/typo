/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import java.time.LocalDateTime

case class ProductdocumentRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  modifieddate: LocalDateTime,
  /** Document identification number. Foreign key to Document.DocumentNode.
      Points to [[document.DocumentRow.documentnode]] */
  documentnode: DocumentId
){
   val compositeId: ProductdocumentId = ProductdocumentId(productid, documentnode)
 }


