/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PvViewRow(
  id: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[purchasing.productvendor.ProductvendorRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[purchasing.productvendor.ProductvendorRow.averageleadtime]] */
  averageleadtime: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.standardprice]] */
  standardprice: Option[BigDecimal],
  /** Points to [[purchasing.productvendor.ProductvendorRow.lastreceiptcost]] */
  lastreceiptcost: Option[BigDecimal],
  /** Points to [[purchasing.productvendor.ProductvendorRow.lastreceiptdate]] */
  lastreceiptdate: Option[TypoLocalDateTime],
  /** Points to [[purchasing.productvendor.ProductvendorRow.minorderqty]] */
  minorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.maxorderqty]] */
  maxorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.onorderqty]] */
  onorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[purchasing.productvendor.ProductvendorRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PvViewRow {
  implicit val decoder: Decoder[PvViewRow] = Decoder.forProduct12[PvViewRow, Option[Int], Option[ProductId], Option[BusinessentityId], Option[Int], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime], Option[Int], Option[Int], Option[Int], Option[UnitmeasureId], Option[TypoLocalDateTime]]("id", "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(PvViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(UnitmeasureId.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[PvViewRow] = Encoder.forProduct12[PvViewRow, Option[Int], Option[ProductId], Option[BusinessentityId], Option[Int], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime], Option[Int], Option[Int], Option[Int], Option[UnitmeasureId], Option[TypoLocalDateTime]]("id", "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(x => (x.id, x.productid, x.businessentityid, x.averageleadtime, x.standardprice, x.lastreceiptcost, x.lastreceiptdate, x.minorderqty, x.maxorderqty, x.onorderqty, x.unitmeasurecode, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(UnitmeasureId.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[PvViewRow] = new Read[PvViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (BusinessentityId.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PvViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNullable(rs, i + 1),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 2),
      averageleadtime = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      standardprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      lastreceiptcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 5),
      lastreceiptdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6),
      minorderqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      maxorderqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      onorderqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 9),
      unitmeasurecode = UnitmeasureId.get.unsafeGetNullable(rs, i + 10),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 11)
    )
  )
}
