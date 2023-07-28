/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `purchasing.productvendor` which has not been persisted yet */
case class ProductvendorRowUnsaved(
  /** Primary key. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Primary key. Foreign key to Vendor.BusinessEntityID.
      Points to [[vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** The average span of time (in days) between placing an order with the vendor and receiving the purchased product. */
  averageleadtime: Int,
  /** The vendor's usual selling price. */
  standardprice: BigDecimal,
  /** The selling price when last purchased. */
  lastreceiptcost: Option[BigDecimal],
  /** Date the product was last received by the vendor. */
  lastreceiptdate: Option[TypoLocalDateTime],
  /** The maximum quantity that should be ordered. */
  minorderqty: Int,
  /** The minimum quantity that should be ordered. */
  maxorderqty: Int,
  /** The quantity currently on order. */
  onorderqty: Option[Int],
  /** The product's unit of measure.
      Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductvendorRow =
    ProductvendorRow(
      productid = productid,
      businessentityid = businessentityid,
      averageleadtime = averageleadtime,
      standardprice = standardprice,
      lastreceiptcost = lastreceiptcost,
      lastreceiptdate = lastreceiptdate,
      minorderqty = minorderqty,
      maxorderqty = maxorderqty,
      onorderqty = onorderqty,
      unitmeasurecode = unitmeasurecode,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductvendorRowUnsaved {
  implicit val decoder: Decoder[ProductvendorRowUnsaved] = Decoder.forProduct11[ProductvendorRowUnsaved, ProductId, BusinessentityId, Int, BigDecimal, Option[BigDecimal], Option[TypoLocalDateTime], Int, Int, Option[Int], UnitmeasureId, Defaulted[TypoLocalDateTime]]("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(ProductvendorRowUnsaved.apply)(ProductId.decoder, BusinessentityId.decoder, Decoder.decodeInt, Decoder.decodeBigDecimal, Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeInt), UnitmeasureId.decoder, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[ProductvendorRowUnsaved] = Encoder.forProduct11[ProductvendorRowUnsaved, ProductId, BusinessentityId, Int, BigDecimal, Option[BigDecimal], Option[TypoLocalDateTime], Int, Int, Option[Int], UnitmeasureId, Defaulted[TypoLocalDateTime]]("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(x => (x.productid, x.businessentityid, x.averageleadtime, x.standardprice, x.lastreceiptcost, x.lastreceiptdate, x.minorderqty, x.maxorderqty, x.onorderqty, x.unitmeasurecode, x.modifieddate))(ProductId.encoder, BusinessentityId.encoder, Encoder.encodeInt, Encoder.encodeBigDecimal, Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeInt), UnitmeasureId.encoder, Defaulted.encoder(TypoLocalDateTime.encoder))
}
