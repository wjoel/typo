/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import adventureworks.production.transactionhistoryarchive.TransactionhistoryarchiveId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime

object ThaViewRepoImpl extends ThaViewRepo {
  override def selectAll: Stream[ConnectionIO, ThaViewRow] = {
    sql"""select "id", transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from pr.tha""".query[ThaViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[ThaViewFieldOrIdValue[_]]): Stream[ConnectionIO, ThaViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case ThaViewFieldValue.id(value) => fr""""id" = $value"""
        case ThaViewFieldValue.transactionid(value) => fr"transactionid = $value"
        case ThaViewFieldValue.productid(value) => fr"productid = $value"
        case ThaViewFieldValue.referenceorderid(value) => fr"referenceorderid = $value"
        case ThaViewFieldValue.referenceorderlineid(value) => fr"referenceorderlineid = $value"
        case ThaViewFieldValue.transactiondate(value) => fr"transactiondate = $value"
        case ThaViewFieldValue.transactiontype(value) => fr"transactiontype = $value"
        case ThaViewFieldValue.quantity(value) => fr"quantity = $value"
        case ThaViewFieldValue.actualcost(value) => fr"actualcost = $value"
        case ThaViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pr.tha $where".query[ThaViewRow].stream
  
  }
  implicit val read: Read[ThaViewRow] =
    new Read[ThaViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[TransactionhistoryarchiveId], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => ThaViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        transactionid = Get[TransactionhistoryarchiveId].unsafeGetNullable(rs, i + 1),
        productid = Get[Int].unsafeGetNullable(rs, i + 2),
        referenceorderid = Get[Int].unsafeGetNullable(rs, i + 3),
        referenceorderlineid = Get[Int].unsafeGetNullable(rs, i + 4),
        transactiondate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5),
        transactiontype = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 6),
        quantity = Get[Int].unsafeGetNullable(rs, i + 7),
        actualcost = Get[BigDecimal].unsafeGetNullable(rs, i + 8),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 9)
      )
    )
  

}
