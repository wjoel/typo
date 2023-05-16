/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package soh

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
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object SohViewRepoImpl extends SohViewRepo {
  override def selectAll: Stream[ConnectionIO, SohViewRow] = {
    sql"""select "id", salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate from sa.soh""".query[SohViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SohViewFieldOrIdValue[_]]): Stream[ConnectionIO, SohViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SohViewFieldValue.id(value) => fr""""id" = $value"""
        case SohViewFieldValue.salesorderid(value) => fr"salesorderid = $value"
        case SohViewFieldValue.revisionnumber(value) => fr"revisionnumber = $value"
        case SohViewFieldValue.orderdate(value) => fr"orderdate = $value"
        case SohViewFieldValue.duedate(value) => fr"duedate = $value"
        case SohViewFieldValue.shipdate(value) => fr"shipdate = $value"
        case SohViewFieldValue.status(value) => fr"status = $value"
        case SohViewFieldValue.onlineorderflag(value) => fr"onlineorderflag = $value"
        case SohViewFieldValue.purchaseordernumber(value) => fr"purchaseordernumber = $value"
        case SohViewFieldValue.accountnumber(value) => fr"accountnumber = $value"
        case SohViewFieldValue.customerid(value) => fr"customerid = $value"
        case SohViewFieldValue.salespersonid(value) => fr"salespersonid = $value"
        case SohViewFieldValue.territoryid(value) => fr"territoryid = $value"
        case SohViewFieldValue.billtoaddressid(value) => fr"billtoaddressid = $value"
        case SohViewFieldValue.shiptoaddressid(value) => fr"shiptoaddressid = $value"
        case SohViewFieldValue.shipmethodid(value) => fr"shipmethodid = $value"
        case SohViewFieldValue.creditcardid(value) => fr"creditcardid = $value"
        case SohViewFieldValue.creditcardapprovalcode(value) => fr"creditcardapprovalcode = $value"
        case SohViewFieldValue.currencyrateid(value) => fr"currencyrateid = $value"
        case SohViewFieldValue.subtotal(value) => fr"subtotal = $value"
        case SohViewFieldValue.taxamt(value) => fr"taxamt = $value"
        case SohViewFieldValue.freight(value) => fr"freight = $value"
        case SohViewFieldValue.totaldue(value) => fr"totaldue = $value"
        case SohViewFieldValue.comment(value) => fr""""comment" = $value"""
        case SohViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case SohViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.soh $where".query[SohViewRow].stream
  
  }
  implicit val read: Read[SohViewRow] =
    new Read[SohViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[SalesorderheaderId], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Flag], Nullability.NoNulls),
        (Get[OrderNumber], Nullability.Nullable),
        (Get[AccountNumber], Nullability.Nullable),
        (Get[CustomerId], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[SalesterritoryId], Nullability.Nullable),
        (Get[AddressId], Nullability.Nullable),
        (Get[AddressId], Nullability.Nullable),
        (Get[ShipmethodId], Nullability.Nullable),
        (Get[CreditcardId], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[CurrencyrateId], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SohViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        salesorderid = Get[SalesorderheaderId].unsafeGetNullable(rs, i + 1),
        revisionnumber = Get[Int].unsafeGetNullable(rs, i + 2),
        orderdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 3),
        duedate = Get[LocalDateTime].unsafeGetNullable(rs, i + 4),
        shipdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5),
        status = Get[Int].unsafeGetNullable(rs, i + 6),
        onlineorderflag = Get[Flag].unsafeGetNonNullable(rs, i + 7),
        purchaseordernumber = Get[OrderNumber].unsafeGetNullable(rs, i + 8),
        accountnumber = Get[AccountNumber].unsafeGetNullable(rs, i + 9),
        customerid = Get[CustomerId].unsafeGetNullable(rs, i + 10),
        salespersonid = Get[BusinessentityId].unsafeGetNullable(rs, i + 11),
        territoryid = Get[SalesterritoryId].unsafeGetNullable(rs, i + 12),
        billtoaddressid = Get[AddressId].unsafeGetNullable(rs, i + 13),
        shiptoaddressid = Get[AddressId].unsafeGetNullable(rs, i + 14),
        shipmethodid = Get[ShipmethodId].unsafeGetNullable(rs, i + 15),
        creditcardid = Get[CreditcardId].unsafeGetNullable(rs, i + 16),
        creditcardapprovalcode = Get[String].unsafeGetNullable(rs, i + 17),
        currencyrateid = Get[CurrencyrateId].unsafeGetNullable(rs, i + 18),
        subtotal = Get[BigDecimal].unsafeGetNullable(rs, i + 19),
        taxamt = Get[BigDecimal].unsafeGetNullable(rs, i + 20),
        freight = Get[BigDecimal].unsafeGetNullable(rs, i + 21),
        totaldue = Get[BigDecimal].unsafeGetNullable(rs, i + 22),
        comment = Get[String].unsafeGetNullable(rs, i + 23),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 24),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 25)
      )
    )
  

}
