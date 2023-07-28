/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ShoppingcartitemRow(
  /** Primary key for ShoppingCartItem records. */
  shoppingcartitemid: ShoppingcartitemId,
  /** Shopping cart identification number. */
  shoppingcartid: /* max 50 chars */ String,
  /** Product quantity ordered. */
  quantity: Int,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Date the time the record was created. */
  datecreated: TypoLocalDateTime,
  modifieddate: TypoLocalDateTime
)

object ShoppingcartitemRow {
  implicit val decoder: Decoder[ShoppingcartitemRow] = Decoder.forProduct6[ShoppingcartitemRow, ShoppingcartitemId, /* max 50 chars */ String, Int, ProductId, TypoLocalDateTime, TypoLocalDateTime]("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")(ShoppingcartitemRow.apply)(ShoppingcartitemId.decoder, Decoder.decodeString, Decoder.decodeInt, ProductId.decoder, TypoLocalDateTime.decoder, TypoLocalDateTime.decoder)
  implicit val encoder: Encoder[ShoppingcartitemRow] = Encoder.forProduct6[ShoppingcartitemRow, ShoppingcartitemId, /* max 50 chars */ String, Int, ProductId, TypoLocalDateTime, TypoLocalDateTime]("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")(x => (x.shoppingcartitemid, x.shoppingcartid, x.quantity, x.productid, x.datecreated, x.modifieddate))(ShoppingcartitemId.encoder, Encoder.encodeString, Encoder.encodeInt, ProductId.encoder, TypoLocalDateTime.encoder, TypoLocalDateTime.encoder)
  implicit val read: Read[ShoppingcartitemRow] = new Read[ShoppingcartitemRow](
    gets = List(
      (ShoppingcartitemId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ShoppingcartitemRow(
      shoppingcartitemid = ShoppingcartitemId.get.unsafeGetNonNullable(rs, i + 0),
      shoppingcartid = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      quantity = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 3),
      datecreated = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
