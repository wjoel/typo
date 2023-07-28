/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class BillofmaterialsRow(
  /** Primary key for BillOfMaterials records. */
  billofmaterialsid: BillofmaterialsId,
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  componentid: ProductId,
  /** Date the component started being used in the assembly item. */
  startdate: TypoLocalDateTime,
  /** Date the component stopped being used in the assembly item. */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID). */
  bomlevel: Int,
  /** Quantity of the component needed to create the assembly. */
  perassemblyqty: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object BillofmaterialsRow {
  implicit val decoder: Decoder[BillofmaterialsRow] = Decoder.forProduct9[BillofmaterialsRow, BillofmaterialsId, Option[ProductId], ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], UnitmeasureId, Int, BigDecimal, TypoLocalDateTime]("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")(BillofmaterialsRow.apply)(BillofmaterialsId.decoder, Decoder.decodeOption(ProductId.decoder), ProductId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), UnitmeasureId.decoder, Decoder.decodeInt, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit val encoder: Encoder[BillofmaterialsRow] = Encoder.forProduct9[BillofmaterialsRow, BillofmaterialsId, Option[ProductId], ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], UnitmeasureId, Int, BigDecimal, TypoLocalDateTime]("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")(x => (x.billofmaterialsid, x.productassemblyid, x.componentid, x.startdate, x.enddate, x.unitmeasurecode, x.bomlevel, x.perassemblyqty, x.modifieddate))(BillofmaterialsId.encoder, Encoder.encodeOption(ProductId.encoder), ProductId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), UnitmeasureId.encoder, Encoder.encodeInt, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit val read: Read[BillofmaterialsRow] = new Read[BillofmaterialsRow](
    gets = List(
      (BillofmaterialsId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.Nullable),
      (ProductId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BillofmaterialsRow(
      billofmaterialsid = BillofmaterialsId.get.unsafeGetNonNullable(rs, i + 0),
      productassemblyid = ProductId.get.unsafeGetNullable(rs, i + 1),
      componentid = ProductId.get.unsafeGetNonNullable(rs, i + 2),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 4),
      unitmeasurecode = UnitmeasureId.get.unsafeGetNonNullable(rs, i + 5),
      bomlevel = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      perassemblyqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
