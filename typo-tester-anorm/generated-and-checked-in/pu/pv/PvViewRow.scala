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
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

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
  implicit val reads: Reads[PvViewRow] = Reads[PvViewRow](json => JsResult.fromTry(
      Try(
        PvViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          productid = json.\("productid").toOption.map(_.as(ProductId.reads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          averageleadtime = json.\("averageleadtime").toOption.map(_.as(Reads.IntReads)),
          standardprice = json.\("standardprice").toOption.map(_.as(Reads.bigDecReads)),
          lastreceiptcost = json.\("lastreceiptcost").toOption.map(_.as(Reads.bigDecReads)),
          lastreceiptdate = json.\("lastreceiptdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          minorderqty = json.\("minorderqty").toOption.map(_.as(Reads.IntReads)),
          maxorderqty = json.\("maxorderqty").toOption.map(_.as(Reads.IntReads)),
          onorderqty = json.\("onorderqty").toOption.map(_.as(Reads.IntReads)),
          unitmeasurecode = json.\("unitmeasurecode").toOption.map(_.as(UnitmeasureId.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PvViewRow] = RowParser[PvViewRow] { row =>
    Success(
      PvViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        productid = row(idx + 1)(Column.columnToOption(ProductId.column)),
        businessentityid = row(idx + 2)(Column.columnToOption(BusinessentityId.column)),
        averageleadtime = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        standardprice = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        lastreceiptcost = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        lastreceiptdate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column)),
        minorderqty = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        maxorderqty = row(idx + 8)(Column.columnToOption(Column.columnToInt)),
        onorderqty = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        unitmeasurecode = row(idx + 10)(Column.columnToOption(UnitmeasureId.column)),
        modifieddate = row(idx + 11)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit val writes: OWrites[PvViewRow] = OWrites[PvViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "productid" -> Writes.OptionWrites(ProductId.writes).writes(o.productid),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "averageleadtime" -> Writes.OptionWrites(Writes.IntWrites).writes(o.averageleadtime),
      "standardprice" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.standardprice),
      "lastreceiptcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.lastreceiptcost),
      "lastreceiptdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.lastreceiptdate),
      "minorderqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.minorderqty),
      "maxorderqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.maxorderqty),
      "onorderqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.onorderqty),
      "unitmeasurecode" -> Writes.OptionWrites(UnitmeasureId.writes).writes(o.unitmeasurecode),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
