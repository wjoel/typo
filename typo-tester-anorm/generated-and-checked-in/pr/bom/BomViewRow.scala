/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import adventureworks.TypoLocalDateTime
import adventureworks.production.billofmaterials.BillofmaterialsId
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

case class BomViewRow(
  id: Option[Int],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.billofmaterialsid]] */
  billofmaterialsid: Option[BillofmaterialsId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.productassemblyid]] */
  productassemblyid: Option[ProductId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.componentid]] */
  componentid: Option[ProductId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.startdate]] */
  startdate: Option[TypoLocalDateTime],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.bomlevel]] */
  bomlevel: Option[Int],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.perassemblyqty]] */
  perassemblyqty: Option[BigDecimal],
  /** Points to [[production.billofmaterials.BillofmaterialsRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object BomViewRow {
  implicit val reads: Reads[BomViewRow] = Reads[BomViewRow](json => JsResult.fromTry(
      Try(
        BomViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          billofmaterialsid = json.\("billofmaterialsid").toOption.map(_.as(BillofmaterialsId.reads)),
          productassemblyid = json.\("productassemblyid").toOption.map(_.as(ProductId.reads)),
          componentid = json.\("componentid").toOption.map(_.as(ProductId.reads)),
          startdate = json.\("startdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          unitmeasurecode = json.\("unitmeasurecode").toOption.map(_.as(UnitmeasureId.reads)),
          bomlevel = json.\("bomlevel").toOption.map(_.as(Reads.IntReads)),
          perassemblyqty = json.\("perassemblyqty").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BomViewRow] = RowParser[BomViewRow] { row =>
    Success(
      BomViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        billofmaterialsid = row(idx + 1)(Column.columnToOption(BillofmaterialsId.column)),
        productassemblyid = row(idx + 2)(Column.columnToOption(ProductId.column)),
        componentid = row(idx + 3)(Column.columnToOption(ProductId.column)),
        startdate = row(idx + 4)(Column.columnToOption(TypoLocalDateTime.column)),
        enddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column)),
        unitmeasurecode = row(idx + 6)(Column.columnToOption(UnitmeasureId.column)),
        bomlevel = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        perassemblyqty = row(idx + 8)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 9)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit val writes: OWrites[BomViewRow] = OWrites[BomViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "billofmaterialsid" -> Writes.OptionWrites(BillofmaterialsId.writes).writes(o.billofmaterialsid),
      "productassemblyid" -> Writes.OptionWrites(ProductId.writes).writes(o.productassemblyid),
      "componentid" -> Writes.OptionWrites(ProductId.writes).writes(o.componentid),
      "startdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "unitmeasurecode" -> Writes.OptionWrites(UnitmeasureId.writes).writes(o.unitmeasurecode),
      "bomlevel" -> Writes.OptionWrites(Writes.IntWrites).writes(o.bomlevel),
      "perassemblyqty" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.perassemblyqty),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
