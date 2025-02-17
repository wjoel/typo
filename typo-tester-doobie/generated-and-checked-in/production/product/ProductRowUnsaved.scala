/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.util.UUID
import scala.util.Try

/** This class corresponds to a row in table `production.product` which has not been persisted yet */
case class ProductRowUnsaved(
  /** Name of the product. */
  name: Name,
  /** Unique product identification number. */
  productnumber: /* max 25 chars */ String,
  /** Product color. */
  color: Option[/* max 15 chars */ String],
  /** Minimum inventory quantity. */
  safetystocklevel: Int,
  /** Inventory level that triggers a purchase order or work order. */
  reorderpoint: Int,
  /** Standard cost of the product. */
  standardcost: BigDecimal,
  /** Selling price. */
  listprice: BigDecimal,
  /** Product size. */
  size: Option[/* max 5 chars */ String],
  /** Unit of measure for Size column.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Unit of measure for Weight column.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Product weight. */
  weight: Option[BigDecimal],
  /** Number of days required to manufacture the product. */
  daystomanufacture: Int,
  /** R = Road, M = Mountain, T = Touring, S = Standard */
  productline: Option[/* bpchar */ String],
  /** H = High, M = Medium, L = Low */
  `class`: Option[/* bpchar */ String],
  /** W = Womens, M = Mens, U = Universal */
  style: Option[/* bpchar */ String],
  /** Product is a member of this product subcategory. Foreign key to ProductSubCategory.ProductSubCategoryID.
      Points to [[productsubcategory.ProductsubcategoryRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Product is a member of this product model. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Date the product was available for sale. */
  sellstartdate: TypoLocalDateTime,
  /** Date the product was no longer available for sale. */
  sellenddate: Option[TypoLocalDateTime],
  /** Date the product was discontinued. */
  discontinueddate: Option[TypoLocalDateTime],
  /** Default: nextval('production.product_productid_seq'::regclass)
      Primary key for Product records. */
  productid: Defaulted[ProductId] = Defaulted.UseDefault,
  /** Default: true
      0 = Product is purchased, 1 = Product is manufactured in-house. */
  makeflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: true
      0 = Product is not a salable item. 1 = Product is salable. */
  finishedgoodsflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productidDefault: => ProductId, makeflagDefault: => Flag, finishedgoodsflagDefault: => Flag, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): ProductRow =
    ProductRow(
      name = name,
      productnumber = productnumber,
      color = color,
      safetystocklevel = safetystocklevel,
      reorderpoint = reorderpoint,
      standardcost = standardcost,
      listprice = listprice,
      size = size,
      sizeunitmeasurecode = sizeunitmeasurecode,
      weightunitmeasurecode = weightunitmeasurecode,
      weight = weight,
      daystomanufacture = daystomanufacture,
      productline = productline,
      `class` = `class`,
      style = style,
      productsubcategoryid = productsubcategoryid,
      productmodelid = productmodelid,
      sellstartdate = sellstartdate,
      sellenddate = sellenddate,
      discontinueddate = discontinueddate,
      productid = productid match {
                    case Defaulted.UseDefault => productidDefault
                    case Defaulted.Provided(value) => value
                  },
      makeflag = makeflag match {
                   case Defaulted.UseDefault => makeflagDefault
                   case Defaulted.Provided(value) => value
                 },
      finishedgoodsflag = finishedgoodsflag match {
                            case Defaulted.UseDefault => finishedgoodsflagDefault
                            case Defaulted.Provided(value) => value
                          },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductRowUnsaved {
  implicit val decoder: Decoder[ProductRowUnsaved] = Decoder.instanceTry[ProductRowUnsaved]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      ProductRowUnsaved(
        name = orThrow(c.get("name")(Name.decoder)),
        productnumber = orThrow(c.get("productnumber")(Decoder.decodeString)),
        color = orThrow(c.get("color")(Decoder.decodeOption(Decoder.decodeString))),
        safetystocklevel = orThrow(c.get("safetystocklevel")(Decoder.decodeInt)),
        reorderpoint = orThrow(c.get("reorderpoint")(Decoder.decodeInt)),
        standardcost = orThrow(c.get("standardcost")(Decoder.decodeBigDecimal)),
        listprice = orThrow(c.get("listprice")(Decoder.decodeBigDecimal)),
        size = orThrow(c.get("size")(Decoder.decodeOption(Decoder.decodeString))),
        sizeunitmeasurecode = orThrow(c.get("sizeunitmeasurecode")(Decoder.decodeOption(UnitmeasureId.decoder))),
        weightunitmeasurecode = orThrow(c.get("weightunitmeasurecode")(Decoder.decodeOption(UnitmeasureId.decoder))),
        weight = orThrow(c.get("weight")(Decoder.decodeOption(Decoder.decodeBigDecimal))),
        daystomanufacture = orThrow(c.get("daystomanufacture")(Decoder.decodeInt)),
        productline = orThrow(c.get("productline")(Decoder.decodeOption(Decoder.decodeString))),
        `class` = orThrow(c.get("class")(Decoder.decodeOption(Decoder.decodeString))),
        style = orThrow(c.get("style")(Decoder.decodeOption(Decoder.decodeString))),
        productsubcategoryid = orThrow(c.get("productsubcategoryid")(Decoder.decodeOption(ProductsubcategoryId.decoder))),
        productmodelid = orThrow(c.get("productmodelid")(Decoder.decodeOption(ProductmodelId.decoder))),
        sellstartdate = orThrow(c.get("sellstartdate")(TypoLocalDateTime.decoder)),
        sellenddate = orThrow(c.get("sellenddate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        discontinueddate = orThrow(c.get("discontinueddate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        productid = orThrow(c.get("productid")(Defaulted.decoder(ProductId.decoder))),
        makeflag = orThrow(c.get("makeflag")(Defaulted.decoder(Flag.decoder))),
        finishedgoodsflag = orThrow(c.get("finishedgoodsflag")(Defaulted.decoder(Flag.decoder))),
        rowguid = orThrow(c.get("rowguid")(Defaulted.decoder(Decoder.decodeUUID))),
        modifieddate = orThrow(c.get("modifieddate")(Defaulted.decoder(TypoLocalDateTime.decoder)))
      )
    }
  )
  implicit val encoder: Encoder[ProductRowUnsaved] = Encoder[ProductRowUnsaved](row =>
    Json.obj(
      "name" -> Name.encoder.apply(row.name),
      "productnumber" -> Encoder.encodeString.apply(row.productnumber),
      "color" -> Encoder.encodeOption(Encoder.encodeString).apply(row.color),
      "safetystocklevel" -> Encoder.encodeInt.apply(row.safetystocklevel),
      "reorderpoint" -> Encoder.encodeInt.apply(row.reorderpoint),
      "standardcost" -> Encoder.encodeBigDecimal.apply(row.standardcost),
      "listprice" -> Encoder.encodeBigDecimal.apply(row.listprice),
      "size" -> Encoder.encodeOption(Encoder.encodeString).apply(row.size),
      "sizeunitmeasurecode" -> Encoder.encodeOption(UnitmeasureId.encoder).apply(row.sizeunitmeasurecode),
      "weightunitmeasurecode" -> Encoder.encodeOption(UnitmeasureId.encoder).apply(row.weightunitmeasurecode),
      "weight" -> Encoder.encodeOption(Encoder.encodeBigDecimal).apply(row.weight),
      "daystomanufacture" -> Encoder.encodeInt.apply(row.daystomanufacture),
      "productline" -> Encoder.encodeOption(Encoder.encodeString).apply(row.productline),
      "class" -> Encoder.encodeOption(Encoder.encodeString).apply(row.`class`),
      "style" -> Encoder.encodeOption(Encoder.encodeString).apply(row.style),
      "productsubcategoryid" -> Encoder.encodeOption(ProductsubcategoryId.encoder).apply(row.productsubcategoryid),
      "productmodelid" -> Encoder.encodeOption(ProductmodelId.encoder).apply(row.productmodelid),
      "sellstartdate" -> TypoLocalDateTime.encoder.apply(row.sellstartdate),
      "sellenddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.sellenddate),
      "discontinueddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.discontinueddate),
      "productid" -> Defaulted.encoder(ProductId.encoder).apply(row.productid),
      "makeflag" -> Defaulted.encoder(Flag.encoder).apply(row.makeflag),
      "finishedgoodsflag" -> Defaulted.encoder(Flag.encoder).apply(row.finishedgoodsflag),
      "rowguid" -> Defaulted.encoder(Encoder.encodeUUID).apply(row.rowguid),
      "modifieddate" -> Defaulted.encoder(TypoLocalDateTime.encoder).apply(row.modifieddate)
    )
  )
}
