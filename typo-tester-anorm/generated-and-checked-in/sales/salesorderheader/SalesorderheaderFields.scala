/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

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
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait SalesorderheaderFields[Row] {
  val salesorderid: IdField[SalesorderheaderId, Row]
  val revisionnumber: Field[Int, Row]
  val orderdate: Field[TypoLocalDateTime, Row]
  val duedate: Field[TypoLocalDateTime, Row]
  val shipdate: OptField[TypoLocalDateTime, Row]
  val status: Field[Int, Row]
  val onlineorderflag: Field[Flag, Row]
  val purchaseordernumber: OptField[OrderNumber, Row]
  val accountnumber: OptField[AccountNumber, Row]
  val customerid: Field[CustomerId, Row]
  val salespersonid: OptField[BusinessentityId, Row]
  val territoryid: OptField[SalesterritoryId, Row]
  val billtoaddressid: Field[AddressId, Row]
  val shiptoaddressid: Field[AddressId, Row]
  val shipmethodid: Field[ShipmethodId, Row]
  val creditcardid: OptField[CreditcardId, Row]
  val creditcardapprovalcode: OptField[/* max 15 chars */ String, Row]
  val currencyrateid: OptField[CurrencyrateId, Row]
  val subtotal: Field[BigDecimal, Row]
  val taxamt: Field[BigDecimal, Row]
  val freight: Field[BigDecimal, Row]
  val totaldue: OptField[BigDecimal, Row]
  val comment: OptField[/* max 128 chars */ String, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SalesorderheaderFields extends SalesorderheaderStructure[SalesorderheaderRow](None, identity, (_, x) => x)

