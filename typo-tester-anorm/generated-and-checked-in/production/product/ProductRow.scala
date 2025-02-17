/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.TypoLocalDateTime
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class ProductRow(
  /** Primary key for Product records. */
  productid: ProductId,
  /** Name of the product. */
  name: Name,
  /** Unique product identification number. */
  productnumber: /* max 25 chars */ String,
  /** 0 = Product is purchased, 1 = Product is manufactured in-house. */
  makeflag: Flag,
  /** 0 = Product is not a salable item. 1 = Product is salable. */
  finishedgoodsflag: Flag,
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
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ProductRow {
  implicit lazy val reads: Reads[ProductRow] = Reads[ProductRow](json => JsResult.fromTry(
      Try(
        ProductRow(
          productid = json.\("productid").as(ProductId.reads),
          name = json.\("name").as(Name.reads),
          productnumber = json.\("productnumber").as(Reads.StringReads),
          makeflag = json.\("makeflag").as(Flag.reads),
          finishedgoodsflag = json.\("finishedgoodsflag").as(Flag.reads),
          color = json.\("color").toOption.map(_.as(Reads.StringReads)),
          safetystocklevel = json.\("safetystocklevel").as(Reads.IntReads),
          reorderpoint = json.\("reorderpoint").as(Reads.IntReads),
          standardcost = json.\("standardcost").as(Reads.bigDecReads),
          listprice = json.\("listprice").as(Reads.bigDecReads),
          size = json.\("size").toOption.map(_.as(Reads.StringReads)),
          sizeunitmeasurecode = json.\("sizeunitmeasurecode").toOption.map(_.as(UnitmeasureId.reads)),
          weightunitmeasurecode = json.\("weightunitmeasurecode").toOption.map(_.as(UnitmeasureId.reads)),
          weight = json.\("weight").toOption.map(_.as(Reads.bigDecReads)),
          daystomanufacture = json.\("daystomanufacture").as(Reads.IntReads),
          productline = json.\("productline").toOption.map(_.as(Reads.StringReads)),
          `class` = json.\("class").toOption.map(_.as(Reads.StringReads)),
          style = json.\("style").toOption.map(_.as(Reads.StringReads)),
          productsubcategoryid = json.\("productsubcategoryid").toOption.map(_.as(ProductsubcategoryId.reads)),
          productmodelid = json.\("productmodelid").toOption.map(_.as(ProductmodelId.reads)),
          sellstartdate = json.\("sellstartdate").as(TypoLocalDateTime.reads),
          sellenddate = json.\("sellenddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          discontinueddate = json.\("discontinueddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductRow] = RowParser[ProductRow] { row =>
    Success(
      ProductRow(
        productid = row(idx + 0)(ProductId.column),
        name = row(idx + 1)(Name.column),
        productnumber = row(idx + 2)(Column.columnToString),
        makeflag = row(idx + 3)(Flag.column),
        finishedgoodsflag = row(idx + 4)(Flag.column),
        color = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        safetystocklevel = row(idx + 6)(Column.columnToInt),
        reorderpoint = row(idx + 7)(Column.columnToInt),
        standardcost = row(idx + 8)(Column.columnToScalaBigDecimal),
        listprice = row(idx + 9)(Column.columnToScalaBigDecimal),
        size = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        sizeunitmeasurecode = row(idx + 11)(Column.columnToOption(UnitmeasureId.column)),
        weightunitmeasurecode = row(idx + 12)(Column.columnToOption(UnitmeasureId.column)),
        weight = row(idx + 13)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        daystomanufacture = row(idx + 14)(Column.columnToInt),
        productline = row(idx + 15)(Column.columnToOption(Column.columnToString)),
        `class` = row(idx + 16)(Column.columnToOption(Column.columnToString)),
        style = row(idx + 17)(Column.columnToOption(Column.columnToString)),
        productsubcategoryid = row(idx + 18)(Column.columnToOption(ProductsubcategoryId.column)),
        productmodelid = row(idx + 19)(Column.columnToOption(ProductmodelId.column)),
        sellstartdate = row(idx + 20)(TypoLocalDateTime.column),
        sellenddate = row(idx + 21)(Column.columnToOption(TypoLocalDateTime.column)),
        discontinueddate = row(idx + 22)(Column.columnToOption(TypoLocalDateTime.column)),
        rowguid = row(idx + 23)(Column.columnToUUID),
        modifieddate = row(idx + 24)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ProductRow] = OWrites[ProductRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "name" -> Name.writes.writes(o.name),
      "productnumber" -> Writes.StringWrites.writes(o.productnumber),
      "makeflag" -> Flag.writes.writes(o.makeflag),
      "finishedgoodsflag" -> Flag.writes.writes(o.finishedgoodsflag),
      "color" -> Writes.OptionWrites(Writes.StringWrites).writes(o.color),
      "safetystocklevel" -> Writes.IntWrites.writes(o.safetystocklevel),
      "reorderpoint" -> Writes.IntWrites.writes(o.reorderpoint),
      "standardcost" -> Writes.BigDecimalWrites.writes(o.standardcost),
      "listprice" -> Writes.BigDecimalWrites.writes(o.listprice),
      "size" -> Writes.OptionWrites(Writes.StringWrites).writes(o.size),
      "sizeunitmeasurecode" -> Writes.OptionWrites(UnitmeasureId.writes).writes(o.sizeunitmeasurecode),
      "weightunitmeasurecode" -> Writes.OptionWrites(UnitmeasureId.writes).writes(o.weightunitmeasurecode),
      "weight" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.weight),
      "daystomanufacture" -> Writes.IntWrites.writes(o.daystomanufacture),
      "productline" -> Writes.OptionWrites(Writes.StringWrites).writes(o.productline),
      "class" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`class`),
      "style" -> Writes.OptionWrites(Writes.StringWrites).writes(o.style),
      "productsubcategoryid" -> Writes.OptionWrites(ProductsubcategoryId.writes).writes(o.productsubcategoryid),
      "productmodelid" -> Writes.OptionWrites(ProductmodelId.writes).writes(o.productmodelid),
      "sellstartdate" -> TypoLocalDateTime.writes.writes(o.sellstartdate),
      "sellenddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.sellenddate),
      "discontinueddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.discontinueddate),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
