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
import io.circe.HCursor
import io.circe.Json
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

object ProductdocumentRow {
  implicit val decoder: Decoder[ProductdocumentRow] =
    (c: HCursor) =>
      for {
        productid <- c.downField("productid").as[ProductId]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
        documentnode <- c.downField("documentnode").as[DocumentId]
      } yield ProductdocumentRow(productid, modifieddate, documentnode)
  implicit val encoder: Encoder[ProductdocumentRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productid" := row.productid,
        "modifieddate" := row.modifieddate,
        "documentnode" := row.documentnode
      )}
}