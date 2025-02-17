/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.transactionhistory` which has not been persisted yet */
case class TransactionhistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** W = WorkOrder, S = SalesOrder, P = PurchaseOrder */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: nextval('production.transactionhistory_transactionid_seq'::regclass)
      Primary key for TransactionHistory records. */
  transactionid: Defaulted[TransactionhistoryId] = Defaulted.UseDefault,
  /** Default: 0
      Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date and time of the transaction. */
  transactiondate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(transactionidDefault: => TransactionhistoryId, referenceorderlineidDefault: => Int, transactiondateDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): TransactionhistoryRow =
    TransactionhistoryRow(
      productid = productid,
      referenceorderid = referenceorderid,
      transactiontype = transactiontype,
      quantity = quantity,
      actualcost = actualcost,
      transactionid = transactionid match {
                        case Defaulted.UseDefault => transactionidDefault
                        case Defaulted.Provided(value) => value
                      },
      referenceorderlineid = referenceorderlineid match {
                               case Defaulted.UseDefault => referenceorderlineidDefault
                               case Defaulted.Provided(value) => value
                             },
      transactiondate = transactiondate match {
                          case Defaulted.UseDefault => transactiondateDefault
                          case Defaulted.Provided(value) => value
                        },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object TransactionhistoryRowUnsaved {
  implicit lazy val reads: Reads[TransactionhistoryRowUnsaved] = Reads[TransactionhistoryRowUnsaved](json => JsResult.fromTry(
      Try(
        TransactionhistoryRowUnsaved(
          productid = json.\("productid").as(ProductId.reads),
          referenceorderid = json.\("referenceorderid").as(Reads.IntReads),
          transactiontype = json.\("transactiontype").as(Reads.StringReads),
          quantity = json.\("quantity").as(Reads.IntReads),
          actualcost = json.\("actualcost").as(Reads.bigDecReads),
          transactionid = json.\("transactionid").as(Defaulted.reads(TransactionhistoryId.reads)),
          referenceorderlineid = json.\("referenceorderlineid").as(Defaulted.reads(Reads.IntReads)),
          transactiondate = json.\("transactiondate").as(Defaulted.reads(TypoLocalDateTime.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[TransactionhistoryRowUnsaved] = OWrites[TransactionhistoryRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "referenceorderid" -> Writes.IntWrites.writes(o.referenceorderid),
      "transactiontype" -> Writes.StringWrites.writes(o.transactiontype),
      "quantity" -> Writes.IntWrites.writes(o.quantity),
      "actualcost" -> Writes.BigDecimalWrites.writes(o.actualcost),
      "transactionid" -> Defaulted.writes(TransactionhistoryId.writes).writes(o.transactionid),
      "referenceorderlineid" -> Defaulted.writes(Writes.IntWrites).writes(o.referenceorderlineid),
      "transactiondate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.transactiondate),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
