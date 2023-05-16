/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package tr

import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import adventureworks.sales.salestaxrate.SalestaxrateId
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

object TrViewRepoImpl extends TrViewRepo {
  override def selectAll: Stream[ConnectionIO, TrViewRow] = {
    sql"""select "id", salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sa.tr""".query[TrViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[TrViewFieldOrIdValue[_]]): Stream[ConnectionIO, TrViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case TrViewFieldValue.id(value) => fr""""id" = $value"""
        case TrViewFieldValue.salestaxrateid(value) => fr"salestaxrateid = $value"
        case TrViewFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
        case TrViewFieldValue.taxtype(value) => fr"taxtype = $value"
        case TrViewFieldValue.taxrate(value) => fr"taxrate = $value"
        case TrViewFieldValue.name(value) => fr""""name" = $value"""
        case TrViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case TrViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.tr $where".query[TrViewRow].stream
  
  }
  implicit val read: Read[TrViewRow] =
    new Read[TrViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[SalestaxrateId], Nullability.Nullable),
        (Get[StateprovinceId], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => TrViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        salestaxrateid = Get[SalestaxrateId].unsafeGetNullable(rs, i + 1),
        stateprovinceid = Get[StateprovinceId].unsafeGetNullable(rs, i + 2),
        taxtype = Get[Int].unsafeGetNullable(rs, i + 3),
        taxrate = Get[BigDecimal].unsafeGetNullable(rs, i + 4),
        name = Get[Name].unsafeGetNullable(rs, i + 5),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 6),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 7)
      )
    )
  

}
