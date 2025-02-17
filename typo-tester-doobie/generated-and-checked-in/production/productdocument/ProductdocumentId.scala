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
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `production.productdocument` */
case class ProductdocumentId(productid: ProductId, documentnode: DocumentId)
object ProductdocumentId {
  implicit val decoder: Decoder[ProductdocumentId] = Decoder.forProduct2[ProductdocumentId, ProductId, DocumentId]("productid", "documentnode")(ProductdocumentId.apply)(ProductId.decoder, DocumentId.decoder)
  implicit val encoder: Encoder[ProductdocumentId] = Encoder.forProduct2[ProductdocumentId, ProductId, DocumentId]("productid", "documentnode")(x => (x.productid, x.documentnode))(ProductId.encoder, DocumentId.encoder)
  implicit val ordering: Ordering[ProductdocumentId] = Ordering.by(x => (x.productid, x.documentnode))
}
