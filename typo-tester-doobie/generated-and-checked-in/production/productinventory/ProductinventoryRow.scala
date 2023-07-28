/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class ProductinventoryRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Inventory location identification number. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Storage compartment within an inventory location. */
  shelf: /* max 10 chars */ String,
  /** Storage container on a shelf in an inventory location. */
  bin: Int,
  /** Quantity of products in the inventory location. */
  quantity: Int,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductinventoryId = ProductinventoryId(productid, locationid)
 }

object ProductinventoryRow {
  implicit val decoder: Decoder[ProductinventoryRow] = Decoder.forProduct7[ProductinventoryRow, ProductId, LocationId, /* max 10 chars */ String, Int, Int, UUID, TypoLocalDateTime]("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(ProductinventoryRow.apply)(ProductId.decoder, LocationId.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit val encoder: Encoder[ProductinventoryRow] = Encoder.forProduct7[ProductinventoryRow, ProductId, LocationId, /* max 10 chars */ String, Int, Int, UUID, TypoLocalDateTime]("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(x => (x.productid, x.locationid, x.shelf, x.bin, x.quantity, x.rowguid, x.modifieddate))(ProductId.encoder, LocationId.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit val read: Read[ProductinventoryRow] = new Read[ProductinventoryRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (LocationId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductinventoryRow(
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      locationid = LocationId.get.unsafeGetNonNullable(rs, i + 1),
      shelf = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      bin = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      quantity = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
