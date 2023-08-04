/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package soh

import adventureworks.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.creditcard.CreditcardId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait SohViewFields[Row] {
  val id: OptField[Int, Row]
  val salesorderid: OptField[SalesorderheaderId, Row]
  val revisionnumber: OptField[Int, Row]
  val orderdate: OptField[TypoLocalDateTime, Row]
  val duedate: OptField[TypoLocalDateTime, Row]
  val shipdate: OptField[TypoLocalDateTime, Row]
  val status: OptField[Int, Row]
  val onlineorderflag: Field[Flag, Row]
  val purchaseordernumber: OptField[OrderNumber, Row]
  val accountnumber: OptField[AccountNumber, Row]
  val customerid: OptField[CustomerId, Row]
  val salespersonid: OptField[BusinessentityId, Row]
  val territoryid: OptField[SalesterritoryId, Row]
  val billtoaddressid: OptField[AddressId, Row]
  val shiptoaddressid: OptField[AddressId, Row]
  val shipmethodid: OptField[ShipmethodId, Row]
  val creditcardid: OptField[CreditcardId, Row]
  val creditcardapprovalcode: OptField[/* max 15 chars */ String, Row]
  val currencyrateid: OptField[CurrencyrateId, Row]
  val subtotal: OptField[BigDecimal, Row]
  val taxamt: OptField[BigDecimal, Row]
  val freight: OptField[BigDecimal, Row]
  val totaldue: OptField[BigDecimal, Row]
  val comment: OptField[/* max 128 chars */ String, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object SohViewFields extends SohViewStructure[SohViewRow](None, identity, (_, x) => x)
