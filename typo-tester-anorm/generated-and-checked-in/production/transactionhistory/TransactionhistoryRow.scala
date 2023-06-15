/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class TransactionhistoryRow(
  /** Primary key for TransactionHistory records. */
  transactionid: TransactionhistoryId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Int,
  /** Date and time of the transaction. */
  transactiondate: LocalDateTime,
  /** W = WorkOrder, S = SalesOrder, P = PurchaseOrder */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  modifieddate: LocalDateTime
)

object TransactionhistoryRow {
  implicit val oFormat: OFormat[TransactionhistoryRow] = new OFormat[TransactionhistoryRow]{
    override def writes(o: TransactionhistoryRow): JsObject =
      Json.obj(
        "transactionid" -> o.transactionid,
        "productid" -> o.productid,
        "referenceorderid" -> o.referenceorderid,
        "referenceorderlineid" -> o.referenceorderlineid,
        "transactiondate" -> o.transactiondate,
        "transactiontype" -> o.transactiontype,
        "quantity" -> o.quantity,
        "actualcost" -> o.actualcost,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[TransactionhistoryRow] = {
      JsResult.fromTry(
        Try(
          TransactionhistoryRow(
            transactionid = json.\("transactionid").as[TransactionhistoryId],
            productid = json.\("productid").as[ProductId],
            referenceorderid = json.\("referenceorderid").as[Int],
            referenceorderlineid = json.\("referenceorderlineid").as[Int],
            transactiondate = json.\("transactiondate").as[LocalDateTime],
            transactiontype = json.\("transactiontype").as[/* bpchar */ String],
            quantity = json.\("quantity").as[Int],
            actualcost = json.\("actualcost").as[BigDecimal],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}