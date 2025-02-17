/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.Defaulted
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
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SalesorderheaderRepoImpl extends SalesorderheaderRepo {
  override def delete(salesorderid: SalesorderheaderId): ConnectionIO[Boolean] = {
    sql"delete from sales.salesorderheader where salesorderid = ${fromWrite(salesorderid)(Write.fromPut(SalesorderheaderId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    DeleteBuilder("sales.salesorderheader", SalesorderheaderFields)
  }
  override def insert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    sql"""insert into sales.salesorderheader(salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate)
          values (${fromWrite(unsaved.salesorderid)(Write.fromPut(SalesorderheaderId.put))}::int4, ${fromWrite(unsaved.revisionnumber)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.status)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.onlineorderflag)(Write.fromPut(Flag.put))}::"public"."Flag", ${fromWrite(unsaved.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::"public".OrderNumber, ${fromWrite(unsaved.accountnumber)(Write.fromPutOption(AccountNumber.put))}::"public".AccountNumber, ${fromWrite(unsaved.customerid)(Write.fromPut(CustomerId.put))}::int4, ${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4, ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4, ${fromWrite(unsaved.billtoaddressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4, ${fromWrite(unsaved.creditcardid)(Write.fromPutOption(CreditcardId.put))}::int4, ${fromWrite(unsaved.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4, ${fromWrite(unsaved.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.comment)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text
       """.query(SalesorderheaderRow.read).unique
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved): ConnectionIO[SalesorderheaderRow] = {
    val fs = List(
      Some((Fragment.const(s"duedate"), fr"${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"shipdate"), fr"${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"purchaseordernumber"), fr"""${fromWrite(unsaved.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::"public".OrderNumber""")),
      Some((Fragment.const(s"accountnumber"), fr"""${fromWrite(unsaved.accountnumber)(Write.fromPutOption(AccountNumber.put))}::"public".AccountNumber""")),
      Some((Fragment.const(s"customerid"), fr"${fromWrite(unsaved.customerid)(Write.fromPut(CustomerId.put))}::int4")),
      Some((Fragment.const(s"salespersonid"), fr"${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"territoryid"), fr"${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4")),
      Some((Fragment.const(s"billtoaddressid"), fr"${fromWrite(unsaved.billtoaddressid)(Write.fromPut(AddressId.put))}::int4")),
      Some((Fragment.const(s"shiptoaddressid"), fr"${fromWrite(unsaved.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4")),
      Some((Fragment.const(s"shipmethodid"), fr"${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4")),
      Some((Fragment.const(s"creditcardid"), fr"${fromWrite(unsaved.creditcardid)(Write.fromPutOption(CreditcardId.put))}::int4")),
      Some((Fragment.const(s"creditcardapprovalcode"), fr"${fromWrite(unsaved.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"currencyrateid"), fr"${fromWrite(unsaved.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4")),
      Some((Fragment.const(s"totaldue"), fr"${fromWrite(unsaved.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s""""comment""""), fr"${fromWrite(unsaved.comment)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.salesorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salesorderid"), fr"${fromWrite(value: SalesorderheaderId)(Write.fromPut(SalesorderheaderId.put))}::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"revisionnumber"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"orderdate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"status"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int2"))
      },
      unsaved.onlineorderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"onlineorderflag"), fr"""${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::"public"."Flag""""))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"subtotal"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"taxamt"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"freight"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesorderheader default values
            returning salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salesorderheader(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text
         """
    }
    q.query(SalesorderheaderRow.read).unique
    
  }
  override def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    SelectBuilderSql("sales.salesorderheader", SalesorderheaderFields, SalesorderheaderRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalesorderheaderRow] = {
    sql"""select salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text from sales.salesorderheader""".query(SalesorderheaderRow.read).stream
  }
  override def selectById(salesorderid: SalesorderheaderId): ConnectionIO[Option[SalesorderheaderRow]] = {
    sql"""select salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text from sales.salesorderheader where salesorderid = ${fromWrite(salesorderid)(Write.fromPut(SalesorderheaderId.put))}""".query(SalesorderheaderRow.read).option
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId]): Stream[ConnectionIO, SalesorderheaderRow] = {
    sql"""select salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text from sales.salesorderheader where salesorderid = ANY(${fromWrite(salesorderids)(Write.fromPut(SalesorderheaderId.arrayPut))})""".query(SalesorderheaderRow.read).stream
  }
  override def update(row: SalesorderheaderRow): ConnectionIO[Boolean] = {
    val salesorderid = row.salesorderid
    sql"""update sales.salesorderheader
          set revisionnumber = ${fromWrite(row.revisionnumber)(Write.fromPut(Meta.IntMeta.put))}::int2,
              orderdate = ${fromWrite(row.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              duedate = ${fromWrite(row.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              shipdate = ${fromWrite(row.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              status = ${fromWrite(row.status)(Write.fromPut(Meta.IntMeta.put))}::int2,
              onlineorderflag = ${fromWrite(row.onlineorderflag)(Write.fromPut(Flag.put))}::"public"."Flag",
              purchaseordernumber = ${fromWrite(row.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::"public".OrderNumber,
              accountnumber = ${fromWrite(row.accountnumber)(Write.fromPutOption(AccountNumber.put))}::"public".AccountNumber,
              customerid = ${fromWrite(row.customerid)(Write.fromPut(CustomerId.put))}::int4,
              salespersonid = ${fromWrite(row.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4,
              territoryid = ${fromWrite(row.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
              billtoaddressid = ${fromWrite(row.billtoaddressid)(Write.fromPut(AddressId.put))}::int4,
              shiptoaddressid = ${fromWrite(row.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4,
              shipmethodid = ${fromWrite(row.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
              creditcardid = ${fromWrite(row.creditcardid)(Write.fromPutOption(CreditcardId.put))}::int4,
              creditcardapprovalcode = ${fromWrite(row.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))},
              currencyrateid = ${fromWrite(row.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4,
              subtotal = ${fromWrite(row.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              taxamt = ${fromWrite(row.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              freight = ${fromWrite(row.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              totaldue = ${fromWrite(row.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "comment" = ${fromWrite(row.comment)(Write.fromPutOption(Meta.StringMeta.put))},
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where salesorderid = ${fromWrite(salesorderid)(Write.fromPut(SalesorderheaderId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    UpdateBuilder("sales.salesorderheader", SalesorderheaderFields, SalesorderheaderRow.read)
  }
  override def upsert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    sql"""insert into sales.salesorderheader(salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.salesorderid)(Write.fromPut(SalesorderheaderId.put))}::int4,
            ${fromWrite(unsaved.revisionnumber)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.status)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.onlineorderflag)(Write.fromPut(Flag.put))}::"public"."Flag",
            ${fromWrite(unsaved.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::"public".OrderNumber,
            ${fromWrite(unsaved.accountnumber)(Write.fromPutOption(AccountNumber.put))}::"public".AccountNumber,
            ${fromWrite(unsaved.customerid)(Write.fromPut(CustomerId.put))}::int4,
            ${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
            ${fromWrite(unsaved.billtoaddressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
            ${fromWrite(unsaved.creditcardid)(Write.fromPutOption(CreditcardId.put))}::int4,
            ${fromWrite(unsaved.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4,
            ${fromWrite(unsaved.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.comment)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (salesorderid)
          do update set
            revisionnumber = EXCLUDED.revisionnumber,
            orderdate = EXCLUDED.orderdate,
            duedate = EXCLUDED.duedate,
            shipdate = EXCLUDED.shipdate,
            status = EXCLUDED.status,
            onlineorderflag = EXCLUDED.onlineorderflag,
            purchaseordernumber = EXCLUDED.purchaseordernumber,
            accountnumber = EXCLUDED.accountnumber,
            customerid = EXCLUDED.customerid,
            salespersonid = EXCLUDED.salespersonid,
            territoryid = EXCLUDED.territoryid,
            billtoaddressid = EXCLUDED.billtoaddressid,
            shiptoaddressid = EXCLUDED.shiptoaddressid,
            shipmethodid = EXCLUDED.shipmethodid,
            creditcardid = EXCLUDED.creditcardid,
            creditcardapprovalcode = EXCLUDED.creditcardapprovalcode,
            currencyrateid = EXCLUDED.currencyrateid,
            subtotal = EXCLUDED.subtotal,
            taxamt = EXCLUDED.taxamt,
            freight = EXCLUDED.freight,
            totaldue = EXCLUDED.totaldue,
            "comment" = EXCLUDED."comment",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salesorderid, revisionnumber, orderdate::text, duedate::text, shipdate::text, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate::text
       """.query(SalesorderheaderRow.read).unique
  }
}
