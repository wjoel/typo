/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime

object PppViewRepoImpl extends PppViewRepo {
  override def selectAll: Stream[ConnectionIO, PppViewRow] = {
    sql"""select productid, productphotoid, "primary", modifieddate from pr.ppp""".query[PppViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PppViewFieldOrIdValue[_]]): Stream[ConnectionIO, PppViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PppViewFieldValue.productid(value) => fr"productid = $value"
        case PppViewFieldValue.productphotoid(value) => fr"productphotoid = $value"
        case PppViewFieldValue.primary(value) => fr""""primary" = $value"""
        case PppViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pr.ppp $where".query[PppViewRow].stream
  
  }
  implicit val read: Read[PppViewRow] =
    new Read[PppViewRow](
      gets = List(
        (Get[ProductId], Nullability.Nullable),
        (Get[ProductphotoId], Nullability.Nullable),
        (Get[Flag], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PppViewRow(
        productid = Get[ProductId].unsafeGetNullable(rs, i + 0),
        productphotoid = Get[ProductphotoId].unsafeGetNullable(rs, i + 1),
        primary = Get[Flag].unsafeGetNonNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 3)
      )
    )
  

}