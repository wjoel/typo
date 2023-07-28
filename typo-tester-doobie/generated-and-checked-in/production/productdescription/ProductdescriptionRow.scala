/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.TypoLocalDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class ProductdescriptionRow(
  /** Primary key for ProductDescription records. */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product. */
  description: /* max 400 chars */ String,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ProductdescriptionRow {
  implicit val decoder: Decoder[ProductdescriptionRow] = Decoder.forProduct4[ProductdescriptionRow, ProductdescriptionId, /* max 400 chars */ String, UUID, TypoLocalDateTime]("productdescriptionid", "description", "rowguid", "modifieddate")(ProductdescriptionRow.apply)(ProductdescriptionId.decoder, Decoder.decodeString, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit val encoder: Encoder[ProductdescriptionRow] = Encoder.forProduct4[ProductdescriptionRow, ProductdescriptionId, /* max 400 chars */ String, UUID, TypoLocalDateTime]("productdescriptionid", "description", "rowguid", "modifieddate")(x => (x.productdescriptionid, x.description, x.rowguid, x.modifieddate))(ProductdescriptionId.encoder, Encoder.encodeString, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit val read: Read[ProductdescriptionRow] = new Read[ProductdescriptionRow](
    gets = List(
      (ProductdescriptionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductdescriptionRow(
      productdescriptionid = ProductdescriptionId.get.unsafeGetNonNullable(rs, i + 0),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
