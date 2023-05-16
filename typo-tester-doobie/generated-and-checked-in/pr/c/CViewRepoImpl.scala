/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import adventureworks.production.culture.CultureId
import adventureworks.public.Name
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime

object CViewRepoImpl extends CViewRepo {
  override def selectAll: Stream[ConnectionIO, CViewRow] = {
    sql"""select "id", cultureid, "name", modifieddate from pr."c"""".query[CViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[CViewFieldOrIdValue[_]]): Stream[ConnectionIO, CViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case CViewFieldValue.id(value) => fr""""id" = $value"""
        case CViewFieldValue.cultureid(value) => fr"cultureid = $value"
        case CViewFieldValue.name(value) => fr""""name" = $value"""
        case CViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"""select * from pr."c" $where""".query[CViewRow].stream
  
  }
  implicit val read: Read[CViewRow] =
    new Read[CViewRow](
      gets = List(
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[CultureId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CViewRow(
        id = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 0),
        cultureid = Get[CultureId].unsafeGetNullable(rs, i + 1),
        name = Get[Name].unsafeGetNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 3)
      )
    )
  

}
