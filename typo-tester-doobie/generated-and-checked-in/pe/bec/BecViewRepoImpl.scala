/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
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

object BecViewRepoImpl extends BecViewRepo {
  override def selectAll: Stream[ConnectionIO, BecViewRow] = {
    sql"""select "id", businessentityid, personid, contacttypeid, rowguid, modifieddate from pe.bec""".query[BecViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[BecViewFieldOrIdValue[_]]): Stream[ConnectionIO, BecViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case BecViewFieldValue.id(value) => fr""""id" = $value"""
        case BecViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case BecViewFieldValue.personid(value) => fr"personid = $value"
        case BecViewFieldValue.contacttypeid(value) => fr"contacttypeid = $value"
        case BecViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case BecViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pe.bec $where".query[BecViewRow].stream
  
  }
  implicit val read: Read[BecViewRow] =
    new Read[BecViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[ContacttypeId], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => BecViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        personid = Get[BusinessentityId].unsafeGetNullable(rs, i + 2),
        contacttypeid = Get[ContacttypeId].unsafeGetNullable(rs, i + 3),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 4),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5)
      )
    )
  

}