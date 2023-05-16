/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import adventureworks.person.businessentity.BusinessentityId
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

object BeViewRepoImpl extends BeViewRepo {
  override def selectAll: Stream[ConnectionIO, BeViewRow] = {
    sql"""select "id", businessentityid, rowguid, modifieddate from pe.be""".query[BeViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[BeViewFieldOrIdValue[_]]): Stream[ConnectionIO, BeViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case BeViewFieldValue.id(value) => fr""""id" = $value"""
        case BeViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case BeViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case BeViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pe.be $where".query[BeViewRow].stream
  
  }
  implicit val read: Read[BeViewRow] =
    new Read[BeViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => BeViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 3)
      )
    )
  

}
