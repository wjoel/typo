/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import adventureworks.TypoLocalDateTime
import adventureworks.production.productdescription.ProductdescriptionId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class PdViewRow(
  id: Option[Int],
  /** Points to [[production.productdescription.ProductdescriptionRow.productdescriptionid]] */
  productdescriptionid: Option[ProductdescriptionId],
  /** Points to [[production.productdescription.ProductdescriptionRow.description]] */
  description: Option[/* max 400 chars */ String],
  /** Points to [[production.productdescription.ProductdescriptionRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productdescription.ProductdescriptionRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PdViewRow {
  implicit val decoder: Decoder[PdViewRow] = Decoder.forProduct5[PdViewRow, Option[Int], Option[ProductdescriptionId], Option[/* max 400 chars */ String], Option[UUID], Option[TypoLocalDateTime]]("id", "productdescriptionid", "description", "rowguid", "modifieddate")(PdViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductdescriptionId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[PdViewRow] = Encoder.forProduct5[PdViewRow, Option[Int], Option[ProductdescriptionId], Option[/* max 400 chars */ String], Option[UUID], Option[TypoLocalDateTime]]("id", "productdescriptionid", "description", "rowguid", "modifieddate")(x => (x.id, x.productdescriptionid, x.description, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductdescriptionId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[PdViewRow] = new Read[PdViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductdescriptionId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PdViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productdescriptionid = ProductdescriptionId.get.unsafeGetNullable(rs, i + 1),
      description = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
