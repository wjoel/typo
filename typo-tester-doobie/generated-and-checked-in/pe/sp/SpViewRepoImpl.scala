/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
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

object SpViewRepoImpl extends SpViewRepo {
  override def selectAll: Stream[ConnectionIO, SpViewRow] = {
    sql"""select "id", stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate from pe.sp""".query[SpViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SpViewFieldOrIdValue[_]]): Stream[ConnectionIO, SpViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SpViewFieldValue.id(value) => fr""""id" = $value"""
        case SpViewFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
        case SpViewFieldValue.stateprovincecode(value) => fr"stateprovincecode = $value"
        case SpViewFieldValue.countryregioncode(value) => fr"countryregioncode = $value"
        case SpViewFieldValue.isonlystateprovinceflag(value) => fr"isonlystateprovinceflag = $value"
        case SpViewFieldValue.name(value) => fr""""name" = $value"""
        case SpViewFieldValue.territoryid(value) => fr"territoryid = $value"
        case SpViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case SpViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pe.sp $where".query[SpViewRow].stream
  
  }
  implicit val read: Read[SpViewRow] =
    new Read[SpViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[StateprovinceId], Nullability.Nullable),
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[CountryregionId], Nullability.Nullable),
        (Get[Flag], Nullability.NoNulls),
        (Get[Name], Nullability.Nullable),
        (Get[SalesterritoryId], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SpViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        stateprovinceid = Get[StateprovinceId].unsafeGetNullable(rs, i + 1),
        stateprovincecode = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 2),
        countryregioncode = Get[CountryregionId].unsafeGetNullable(rs, i + 3),
        isonlystateprovinceflag = Get[Flag].unsafeGetNonNullable(rs, i + 4),
        name = Get[Name].unsafeGetNullable(rs, i + 5),
        territoryid = Get[SalesterritoryId].unsafeGetNullable(rs, i + 6),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 7),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 8)
      )
    )
  

}
