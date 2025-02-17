/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pi

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

case class PiViewRow(
  id: Option[Int],
  /** Points to [[production.productinventory.ProductinventoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productinventory.ProductinventoryRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.productinventory.ProductinventoryRow.shelf]] */
  shelf: Option[/* max 10 chars */ String],
  /** Points to [[production.productinventory.ProductinventoryRow.bin]] */
  bin: Option[Int],
  /** Points to [[production.productinventory.ProductinventoryRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.productinventory.ProductinventoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productinventory.ProductinventoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PiViewRow {
  implicit val decoder: Decoder[PiViewRow] = Decoder.forProduct8[PiViewRow, Option[Int], Option[ProductId], Option[LocationId], Option[/* max 10 chars */ String], Option[Int], Option[Int], Option[UUID], Option[TypoLocalDateTime]]("id", "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(PiViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(LocationId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[PiViewRow] = Encoder.forProduct8[PiViewRow, Option[Int], Option[ProductId], Option[LocationId], Option[/* max 10 chars */ String], Option[Int], Option[Int], Option[UUID], Option[TypoLocalDateTime]]("id", "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(x => (x.id, x.productid, x.locationid, x.shelf, x.bin, x.quantity, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(LocationId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[PiViewRow] = new Read[PiViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (LocationId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PiViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNullable(rs, i + 1),
      locationid = LocationId.get.unsafeGetNullable(rs, i + 2),
      shelf = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      bin = Meta.IntMeta.get.unsafeGetNullable(rs, i + 4),
      quantity = Meta.IntMeta.get.unsafeGetNullable(rs, i + 5),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 6),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 7)
    )
  )
}
