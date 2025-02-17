/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import adventureworks.TypoLocalDateTime
import adventureworks.production.transactionhistoryarchive.TransactionhistoryarchiveId
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

case class ThaViewRow(
  id: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactionid]] */
  transactionid: Option[TransactionhistoryarchiveId],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.productid]] */
  productid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.referenceorderid]] */
  referenceorderid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.referenceorderlineid]] */
  referenceorderlineid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactiondate]] */
  transactiondate: Option[TypoLocalDateTime],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactiontype]] */
  transactiontype: Option[/* bpchar */ String],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object ThaViewRow {
  implicit lazy val reads: Reads[ThaViewRow] = Reads[ThaViewRow](json => JsResult.fromTry(
      Try(
        ThaViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          transactionid = json.\("transactionid").toOption.map(_.as(TransactionhistoryarchiveId.reads)),
          productid = json.\("productid").toOption.map(_.as(Reads.IntReads)),
          referenceorderid = json.\("referenceorderid").toOption.map(_.as(Reads.IntReads)),
          referenceorderlineid = json.\("referenceorderlineid").toOption.map(_.as(Reads.IntReads)),
          transactiondate = json.\("transactiondate").toOption.map(_.as(TypoLocalDateTime.reads)),
          transactiontype = json.\("transactiontype").toOption.map(_.as(Reads.StringReads)),
          quantity = json.\("quantity").toOption.map(_.as(Reads.IntReads)),
          actualcost = json.\("actualcost").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ThaViewRow] = RowParser[ThaViewRow] { row =>
    Success(
      ThaViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        transactionid = row(idx + 1)(Column.columnToOption(TransactionhistoryarchiveId.column)),
        productid = row(idx + 2)(Column.columnToOption(Column.columnToInt)),
        referenceorderid = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        referenceorderlineid = row(idx + 4)(Column.columnToOption(Column.columnToInt)),
        transactiondate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column)),
        transactiontype = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        quantity = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        actualcost = row(idx + 8)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 9)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ThaViewRow] = OWrites[ThaViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "transactionid" -> Writes.OptionWrites(TransactionhistoryarchiveId.writes).writes(o.transactionid),
      "productid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.productid),
      "referenceorderid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.referenceorderid),
      "referenceorderlineid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.referenceorderlineid),
      "transactiondate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.transactiondate),
      "transactiontype" -> Writes.OptionWrites(Writes.StringWrites).writes(o.transactiontype),
      "quantity" -> Writes.OptionWrites(Writes.IntWrites).writes(o.quantity),
      "actualcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualcost),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
