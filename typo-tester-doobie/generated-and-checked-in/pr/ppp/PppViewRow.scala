/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PppViewRow(
  /** Points to [[production.productproductphoto.ProductproductphotoRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productproductphoto.ProductproductphotoRow.productphotoid]] */
  productphotoid: Option[ProductphotoId],
  /** Points to [[production.productproductphoto.ProductproductphotoRow.primary]] */
  primary: Flag,
  /** Points to [[production.productproductphoto.ProductproductphotoRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PppViewRow {
  implicit val decoder: Decoder[PppViewRow] = Decoder.forProduct4[PppViewRow, Option[ProductId], Option[ProductphotoId], Flag, Option[TypoLocalDateTime]]("productid", "productphotoid", "primary", "modifieddate")(PppViewRow.apply)(Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(ProductphotoId.decoder), Flag.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[PppViewRow] = Encoder.forProduct4[PppViewRow, Option[ProductId], Option[ProductphotoId], Flag, Option[TypoLocalDateTime]]("productid", "productphotoid", "primary", "modifieddate")(x => (x.productid, x.productphotoid, x.primary, x.modifieddate))(Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(ProductphotoId.encoder), Flag.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[PppViewRow] = new Read[PppViewRow](
    gets = List(
      (ProductId.get, Nullability.Nullable),
      (ProductphotoId.get, Nullability.Nullable),
      (Flag.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PppViewRow(
      productid = ProductId.get.unsafeGetNullable(rs, i + 0),
      productphotoid = ProductphotoId.get.unsafeGetNullable(rs, i + 1),
      primary = Flag.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
