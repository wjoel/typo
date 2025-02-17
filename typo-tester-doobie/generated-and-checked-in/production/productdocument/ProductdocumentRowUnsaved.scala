/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productdocument` which has not been persisted yet */
case class ProductdocumentRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: '/'::character varying
      Document identification number. Foreign key to Document.DocumentNode.
      Points to [[document.DocumentRow.documentnode]] */
  documentnode: Defaulted[DocumentId] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime, documentnodeDefault: => DocumentId): ProductdocumentRow =
    ProductdocumentRow(
      productid = productid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     },
      documentnode = documentnode match {
                       case Defaulted.UseDefault => documentnodeDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductdocumentRowUnsaved {
  implicit val decoder: Decoder[ProductdocumentRowUnsaved] = Decoder.forProduct3[ProductdocumentRowUnsaved, ProductId, Defaulted[TypoLocalDateTime], Defaulted[DocumentId]]("productid", "modifieddate", "documentnode")(ProductdocumentRowUnsaved.apply)(ProductId.decoder, Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(DocumentId.decoder))
  implicit val encoder: Encoder[ProductdocumentRowUnsaved] = Encoder.forProduct3[ProductdocumentRowUnsaved, ProductId, Defaulted[TypoLocalDateTime], Defaulted[DocumentId]]("productid", "modifieddate", "documentnode")(x => (x.productid, x.modifieddate, x.documentnode))(ProductId.encoder, Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(DocumentId.encoder))
}
