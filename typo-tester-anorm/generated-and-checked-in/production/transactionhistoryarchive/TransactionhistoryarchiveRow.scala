/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.TypoLocalDateTime
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

case class TransactionhistoryarchiveRow(
  /** Primary key for TransactionHistoryArchive records. */
  transactionid: TransactionhistoryarchiveId,
  /** Product identification number. Foreign key to Product.ProductID. */
  productid: Int,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Int,
  /** Date and time of the transaction. */
  transactiondate: TypoLocalDateTime,
  /** W = Work Order, S = Sales Order, P = Purchase Order */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object TransactionhistoryarchiveRow {
  implicit lazy val reads: Reads[TransactionhistoryarchiveRow] = Reads[TransactionhistoryarchiveRow](json => JsResult.fromTry(
      Try(
        TransactionhistoryarchiveRow(
          transactionid = json.\("transactionid").as(TransactionhistoryarchiveId.reads),
          productid = json.\("productid").as(Reads.IntReads),
          referenceorderid = json.\("referenceorderid").as(Reads.IntReads),
          referenceorderlineid = json.\("referenceorderlineid").as(Reads.IntReads),
          transactiondate = json.\("transactiondate").as(TypoLocalDateTime.reads),
          transactiontype = json.\("transactiontype").as(Reads.StringReads),
          quantity = json.\("quantity").as(Reads.IntReads),
          actualcost = json.\("actualcost").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TransactionhistoryarchiveRow] = RowParser[TransactionhistoryarchiveRow] { row =>
    Success(
      TransactionhistoryarchiveRow(
        transactionid = row(idx + 0)(TransactionhistoryarchiveId.column),
        productid = row(idx + 1)(Column.columnToInt),
        referenceorderid = row(idx + 2)(Column.columnToInt),
        referenceorderlineid = row(idx + 3)(Column.columnToInt),
        transactiondate = row(idx + 4)(TypoLocalDateTime.column),
        transactiontype = row(idx + 5)(Column.columnToString),
        quantity = row(idx + 6)(Column.columnToInt),
        actualcost = row(idx + 7)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 8)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[TransactionhistoryarchiveRow] = OWrites[TransactionhistoryarchiveRow](o =>
    new JsObject(ListMap[String, JsValue](
      "transactionid" -> TransactionhistoryarchiveId.writes.writes(o.transactionid),
      "productid" -> Writes.IntWrites.writes(o.productid),
      "referenceorderid" -> Writes.IntWrites.writes(o.referenceorderid),
      "referenceorderlineid" -> Writes.IntWrites.writes(o.referenceorderlineid),
      "transactiondate" -> TypoLocalDateTime.writes.writes(o.transactiondate),
      "transactiontype" -> Writes.StringWrites.writes(o.transactiontype),
      "quantity" -> Writes.IntWrites.writes(o.quantity),
      "actualcost" -> Writes.BigDecimalWrites.writes(o.actualcost),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
