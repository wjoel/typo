/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
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

case class PurchaseorderheaderRow(
  /** Primary key. */
  purchaseorderid: PurchaseorderheaderId,
  /** Incremental number to track changes to the purchase order over time. */
  revisionnumber: Int,
  /** Order current status. 1 = Pending; 2 = Approved; 3 = Rejected; 4 = Complete */
  status: Int,
  /** Employee who created the purchase order. Foreign key to Employee.BusinessEntityID.
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  employeeid: BusinessentityId,
  /** Vendor with whom the purchase order is placed. Foreign key to Vendor.BusinessEntityID.
      Points to [[vendor.VendorRow.businessentityid]] */
  vendorid: BusinessentityId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Purchase order creation date. */
  orderdate: TypoLocalDateTime,
  /** Estimated shipment date from the vendor. */
  shipdate: Option[TypoLocalDateTime],
  /** Purchase order subtotal. Computed as SUM(PurchaseOrderDetail.LineTotal)for the appropriate PurchaseOrderID. */
  subtotal: BigDecimal,
  /** Tax amount. */
  taxamt: BigDecimal,
  /** Shipping cost. */
  freight: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object PurchaseorderheaderRow {
  implicit lazy val reads: Reads[PurchaseorderheaderRow] = Reads[PurchaseorderheaderRow](json => JsResult.fromTry(
      Try(
        PurchaseorderheaderRow(
          purchaseorderid = json.\("purchaseorderid").as(PurchaseorderheaderId.reads),
          revisionnumber = json.\("revisionnumber").as(Reads.IntReads),
          status = json.\("status").as(Reads.IntReads),
          employeeid = json.\("employeeid").as(BusinessentityId.reads),
          vendorid = json.\("vendorid").as(BusinessentityId.reads),
          shipmethodid = json.\("shipmethodid").as(ShipmethodId.reads),
          orderdate = json.\("orderdate").as(TypoLocalDateTime.reads),
          shipdate = json.\("shipdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          subtotal = json.\("subtotal").as(Reads.bigDecReads),
          taxamt = json.\("taxamt").as(Reads.bigDecReads),
          freight = json.\("freight").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PurchaseorderheaderRow] = RowParser[PurchaseorderheaderRow] { row =>
    Success(
      PurchaseorderheaderRow(
        purchaseorderid = row(idx + 0)(PurchaseorderheaderId.column),
        revisionnumber = row(idx + 1)(Column.columnToInt),
        status = row(idx + 2)(Column.columnToInt),
        employeeid = row(idx + 3)(BusinessentityId.column),
        vendorid = row(idx + 4)(BusinessentityId.column),
        shipmethodid = row(idx + 5)(ShipmethodId.column),
        orderdate = row(idx + 6)(TypoLocalDateTime.column),
        shipdate = row(idx + 7)(Column.columnToOption(TypoLocalDateTime.column)),
        subtotal = row(idx + 8)(Column.columnToScalaBigDecimal),
        taxamt = row(idx + 9)(Column.columnToScalaBigDecimal),
        freight = row(idx + 10)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 11)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PurchaseorderheaderRow] = OWrites[PurchaseorderheaderRow](o =>
    new JsObject(ListMap[String, JsValue](
      "purchaseorderid" -> PurchaseorderheaderId.writes.writes(o.purchaseorderid),
      "revisionnumber" -> Writes.IntWrites.writes(o.revisionnumber),
      "status" -> Writes.IntWrites.writes(o.status),
      "employeeid" -> BusinessentityId.writes.writes(o.employeeid),
      "vendorid" -> BusinessentityId.writes.writes(o.vendorid),
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "orderdate" -> TypoLocalDateTime.writes.writes(o.orderdate),
      "shipdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.shipdate),
      "subtotal" -> Writes.BigDecimalWrites.writes(o.subtotal),
      "taxamt" -> Writes.BigDecimalWrites.writes(o.taxamt),
      "freight" -> Writes.BigDecimalWrites.writes(o.freight),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
