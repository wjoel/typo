/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PurchaseorderdetailRepoImpl extends PurchaseorderdetailRepo {
  override def delete(compositeId: PurchaseorderdetailId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.purchaseorderdetail where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow] = {
    DeleteBuilder("purchasing.purchaseorderdetail", PurchaseorderdetailFields)
  }
  override def insert(unsaved: PurchaseorderdetailRow)(implicit c: Connection): PurchaseorderdetailRow = {
    SQL"""insert into purchasing.purchaseorderdetail(purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate)
          values (${unsaved.purchaseorderid}::int4, ${unsaved.purchaseorderdetailid}::int4, ${unsaved.duedate}::timestamp, ${unsaved.orderqty}::int2, ${unsaved.productid}::int4, ${unsaved.unitprice}::numeric, ${unsaved.receivedqty}::numeric, ${unsaved.rejectedqty}::numeric, ${unsaved.modifieddate}::timestamp)
          returning purchaseorderid, purchaseorderdetailid, duedate::text, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate::text
       """
      .executeInsert(PurchaseorderdetailRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PurchaseorderdetailRowUnsaved)(implicit c: Connection): PurchaseorderdetailRow = {
    val namedParameters = List(
      Some((NamedParameter("purchaseorderid", ParameterValue.from(unsaved.purchaseorderid)), "::int4")),
      Some((NamedParameter("duedate", ParameterValue.from(unsaved.duedate)), "::timestamp")),
      Some((NamedParameter("orderqty", ParameterValue.from(unsaved.orderqty)), "::int2")),
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("unitprice", ParameterValue.from(unsaved.unitprice)), "::numeric")),
      Some((NamedParameter("receivedqty", ParameterValue.from(unsaved.receivedqty)), "::numeric")),
      Some((NamedParameter("rejectedqty", ParameterValue.from(unsaved.rejectedqty)), "::numeric")),
      unsaved.purchaseorderdetailid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("purchaseorderdetailid", ParameterValue.from[Int](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.purchaseorderdetail default values
            returning purchaseorderid, purchaseorderdetailid, duedate::text, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate::text
         """
        .executeInsert(PurchaseorderdetailRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.purchaseorderdetail(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning purchaseorderid, purchaseorderdetailid, duedate::text, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(PurchaseorderdetailRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow] = {
    SelectBuilderSql("purchasing.purchaseorderdetail", PurchaseorderdetailFields, PurchaseorderdetailRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PurchaseorderdetailRow] = {
    SQL"""select purchaseorderid, purchaseorderdetailid, duedate::text, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate::text
          from purchasing.purchaseorderdetail
       """.as(PurchaseorderdetailRow.rowParser(1).*)
  }
  override def selectById(compositeId: PurchaseorderdetailId)(implicit c: Connection): Option[PurchaseorderdetailRow] = {
    SQL"""select purchaseorderid, purchaseorderdetailid, duedate::text, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate::text
          from purchasing.purchaseorderdetail
          where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}
       """.as(PurchaseorderdetailRow.rowParser(1).singleOpt)
  }
  override def update(row: PurchaseorderdetailRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update purchasing.purchaseorderdetail
          set duedate = ${row.duedate}::timestamp,
              orderqty = ${row.orderqty}::int2,
              productid = ${row.productid}::int4,
              unitprice = ${row.unitprice}::numeric,
              receivedqty = ${row.receivedqty}::numeric,
              rejectedqty = ${row.rejectedqty}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow] = {
    UpdateBuilder("purchasing.purchaseorderdetail", PurchaseorderdetailFields, PurchaseorderdetailRow.rowParser)
  }
  override def upsert(unsaved: PurchaseorderdetailRow)(implicit c: Connection): PurchaseorderdetailRow = {
    SQL"""insert into purchasing.purchaseorderdetail(purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate)
          values (
            ${unsaved.purchaseorderid}::int4,
            ${unsaved.purchaseorderdetailid}::int4,
            ${unsaved.duedate}::timestamp,
            ${unsaved.orderqty}::int2,
            ${unsaved.productid}::int4,
            ${unsaved.unitprice}::numeric,
            ${unsaved.receivedqty}::numeric,
            ${unsaved.rejectedqty}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (purchaseorderid, purchaseorderdetailid)
          do update set
            duedate = EXCLUDED.duedate,
            orderqty = EXCLUDED.orderqty,
            productid = EXCLUDED.productid,
            unitprice = EXCLUDED.unitprice,
            receivedqty = EXCLUDED.receivedqty,
            rejectedqty = EXCLUDED.rejectedqty,
            modifieddate = EXCLUDED.modifieddate
          returning purchaseorderid, purchaseorderdetailid, duedate::text, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate::text
       """
      .executeInsert(PurchaseorderdetailRow.rowParser(1).single)
    
  }
}
