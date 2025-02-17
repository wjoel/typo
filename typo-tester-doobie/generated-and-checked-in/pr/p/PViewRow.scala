/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.util.UUID
import scala.util.Try

case class PViewRow(
  id: Option[Int],
  /** Points to [[production.product.ProductRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.product.ProductRow.name]] */
  name: Option[Name],
  /** Points to [[production.product.ProductRow.productnumber]] */
  productnumber: Option[/* max 25 chars */ String],
  /** Points to [[production.product.ProductRow.makeflag]] */
  makeflag: Flag,
  /** Points to [[production.product.ProductRow.finishedgoodsflag]] */
  finishedgoodsflag: Flag,
  /** Points to [[production.product.ProductRow.color]] */
  color: Option[/* max 15 chars */ String],
  /** Points to [[production.product.ProductRow.safetystocklevel]] */
  safetystocklevel: Option[Int],
  /** Points to [[production.product.ProductRow.reorderpoint]] */
  reorderpoint: Option[Int],
  /** Points to [[production.product.ProductRow.standardcost]] */
  standardcost: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.listprice]] */
  listprice: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.size]] */
  size: Option[/* max 5 chars */ String],
  /** Points to [[production.product.ProductRow.sizeunitmeasurecode]] */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.product.ProductRow.weightunitmeasurecode]] */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.product.ProductRow.weight]] */
  weight: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.daystomanufacture]] */
  daystomanufacture: Option[Int],
  /** Points to [[production.product.ProductRow.productline]] */
  productline: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.class]] */
  `class`: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.style]] */
  style: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Points to [[production.product.ProductRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.product.ProductRow.sellstartdate]] */
  sellstartdate: Option[TypoLocalDateTime],
  /** Points to [[production.product.ProductRow.sellenddate]] */
  sellenddate: Option[TypoLocalDateTime],
  /** Points to [[production.product.ProductRow.discontinueddate]] */
  discontinueddate: Option[TypoLocalDateTime],
  /** Points to [[production.product.ProductRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.product.ProductRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PViewRow {
  implicit val decoder: Decoder[PViewRow] = Decoder.instanceTry[PViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PViewRow(
        id = orThrow(c.get("id")(Decoder.decodeOption(Decoder.decodeInt))),
        productid = orThrow(c.get("productid")(Decoder.decodeOption(ProductId.decoder))),
        name = orThrow(c.get("name")(Decoder.decodeOption(Name.decoder))),
        productnumber = orThrow(c.get("productnumber")(Decoder.decodeOption(Decoder.decodeString))),
        makeflag = orThrow(c.get("makeflag")(Flag.decoder)),
        finishedgoodsflag = orThrow(c.get("finishedgoodsflag")(Flag.decoder)),
        color = orThrow(c.get("color")(Decoder.decodeOption(Decoder.decodeString))),
        safetystocklevel = orThrow(c.get("safetystocklevel")(Decoder.decodeOption(Decoder.decodeInt))),
        reorderpoint = orThrow(c.get("reorderpoint")(Decoder.decodeOption(Decoder.decodeInt))),
        standardcost = orThrow(c.get("standardcost")(Decoder.decodeOption(Decoder.decodeBigDecimal))),
        listprice = orThrow(c.get("listprice")(Decoder.decodeOption(Decoder.decodeBigDecimal))),
        size = orThrow(c.get("size")(Decoder.decodeOption(Decoder.decodeString))),
        sizeunitmeasurecode = orThrow(c.get("sizeunitmeasurecode")(Decoder.decodeOption(UnitmeasureId.decoder))),
        weightunitmeasurecode = orThrow(c.get("weightunitmeasurecode")(Decoder.decodeOption(UnitmeasureId.decoder))),
        weight = orThrow(c.get("weight")(Decoder.decodeOption(Decoder.decodeBigDecimal))),
        daystomanufacture = orThrow(c.get("daystomanufacture")(Decoder.decodeOption(Decoder.decodeInt))),
        productline = orThrow(c.get("productline")(Decoder.decodeOption(Decoder.decodeString))),
        `class` = orThrow(c.get("class")(Decoder.decodeOption(Decoder.decodeString))),
        style = orThrow(c.get("style")(Decoder.decodeOption(Decoder.decodeString))),
        productsubcategoryid = orThrow(c.get("productsubcategoryid")(Decoder.decodeOption(ProductsubcategoryId.decoder))),
        productmodelid = orThrow(c.get("productmodelid")(Decoder.decodeOption(ProductmodelId.decoder))),
        sellstartdate = orThrow(c.get("sellstartdate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        sellenddate = orThrow(c.get("sellenddate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        discontinueddate = orThrow(c.get("discontinueddate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        rowguid = orThrow(c.get("rowguid")(Decoder.decodeOption(Decoder.decodeUUID))),
        modifieddate = orThrow(c.get("modifieddate")(Decoder.decodeOption(TypoLocalDateTime.decoder)))
      )
    }
  )
  implicit val encoder: Encoder[PViewRow] = Encoder[PViewRow](row =>
    Json.obj(
      "id" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.id),
      "productid" -> Encoder.encodeOption(ProductId.encoder).apply(row.productid),
      "name" -> Encoder.encodeOption(Name.encoder).apply(row.name),
      "productnumber" -> Encoder.encodeOption(Encoder.encodeString).apply(row.productnumber),
      "makeflag" -> Flag.encoder.apply(row.makeflag),
      "finishedgoodsflag" -> Flag.encoder.apply(row.finishedgoodsflag),
      "color" -> Encoder.encodeOption(Encoder.encodeString).apply(row.color),
      "safetystocklevel" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.safetystocklevel),
      "reorderpoint" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.reorderpoint),
      "standardcost" -> Encoder.encodeOption(Encoder.encodeBigDecimal).apply(row.standardcost),
      "listprice" -> Encoder.encodeOption(Encoder.encodeBigDecimal).apply(row.listprice),
      "size" -> Encoder.encodeOption(Encoder.encodeString).apply(row.size),
      "sizeunitmeasurecode" -> Encoder.encodeOption(UnitmeasureId.encoder).apply(row.sizeunitmeasurecode),
      "weightunitmeasurecode" -> Encoder.encodeOption(UnitmeasureId.encoder).apply(row.weightunitmeasurecode),
      "weight" -> Encoder.encodeOption(Encoder.encodeBigDecimal).apply(row.weight),
      "daystomanufacture" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.daystomanufacture),
      "productline" -> Encoder.encodeOption(Encoder.encodeString).apply(row.productline),
      "class" -> Encoder.encodeOption(Encoder.encodeString).apply(row.`class`),
      "style" -> Encoder.encodeOption(Encoder.encodeString).apply(row.style),
      "productsubcategoryid" -> Encoder.encodeOption(ProductsubcategoryId.encoder).apply(row.productsubcategoryid),
      "productmodelid" -> Encoder.encodeOption(ProductmodelId.encoder).apply(row.productmodelid),
      "sellstartdate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.sellstartdate),
      "sellenddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.sellenddate),
      "discontinueddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.discontinueddate),
      "rowguid" -> Encoder.encodeOption(Encoder.encodeUUID).apply(row.rowguid),
      "modifieddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.modifieddate)
    )
  )
  implicit val read: Read[PViewRow] = new Read[PViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Flag.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (ProductsubcategoryId.get, Nullability.Nullable),
      (ProductmodelId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      productnumber = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      makeflag = Flag.get.unsafeGetNonNullable(rs, i + 4),
      finishedgoodsflag = Flag.get.unsafeGetNonNullable(rs, i + 5),
      color = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      safetystocklevel = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      reorderpoint = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      standardcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 9),
      listprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 10),
      size = Meta.StringMeta.get.unsafeGetNullable(rs, i + 11),
      sizeunitmeasurecode = UnitmeasureId.get.unsafeGetNullable(rs, i + 12),
      weightunitmeasurecode = UnitmeasureId.get.unsafeGetNullable(rs, i + 13),
      weight = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 14),
      daystomanufacture = Meta.IntMeta.get.unsafeGetNullable(rs, i + 15),
      productline = Meta.StringMeta.get.unsafeGetNullable(rs, i + 16),
      `class` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 17),
      style = Meta.StringMeta.get.unsafeGetNullable(rs, i + 18),
      productsubcategoryid = ProductsubcategoryId.get.unsafeGetNullable(rs, i + 19),
      productmodelid = ProductmodelId.get.unsafeGetNullable(rs, i + 20),
      sellstartdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 21),
      sellenddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 22),
      discontinueddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 23),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 24),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 25)
    )
  )
}
