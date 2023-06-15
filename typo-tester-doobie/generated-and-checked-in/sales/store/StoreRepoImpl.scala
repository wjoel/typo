/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.Defaulted
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object StoreRepoImpl extends StoreRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"delete from sales.store where businessentityid = $businessentityid".update.run.map(_ > 0)
  }
  override def insert(unsaved: StoreRow): ConnectionIO[StoreRow] = {
    sql"""insert into sales.store(businessentityid, "name", salespersonid, demographics, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.salespersonid}::int4, ${unsaved.demographics}::xml, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: StoreRowUnsaved): ConnectionIO[StoreRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${unsaved.businessentityid}::int4")),
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      Some((Fragment.const(s"salespersonid"), fr"${unsaved.salespersonid}::int4")),
      Some((Fragment.const(s"demographics"), fr"${unsaved.demographics}::xml")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.store default values
            returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.store(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, StoreRow] = {
    sql"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate from sales.store""".query[StoreRow].stream
  }
  override def selectByFieldValues(fieldValues: List[StoreFieldOrIdValue[_]]): Stream[ConnectionIO, StoreRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case StoreFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case StoreFieldValue.name(value) => fr""""name" = $value"""
        case StoreFieldValue.salespersonid(value) => fr"salespersonid = $value"
        case StoreFieldValue.demographics(value) => fr"demographics = $value"
        case StoreFieldValue.rowguid(value) => fr"rowguid = $value"
        case StoreFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.store $where".query[StoreRow].stream
  
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[StoreRow]] = {
    sql"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate from sales.store where businessentityid = $businessentityid""".query[StoreRow].option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, StoreRow] = {
    sql"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate from sales.store where businessentityid = ANY($businessentityids)""".query[StoreRow].stream
  }
  override def update(row: StoreRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.store
          set "name" = ${row.name}::"public"."Name",
              salespersonid = ${row.salespersonid}::int4,
              demographics = ${row.demographics}::xml,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = $businessentityid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[StoreFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case StoreFieldValue.name(value) => fr""""name" = $value"""
            case StoreFieldValue.salespersonid(value) => fr"salespersonid = $value"
            case StoreFieldValue.demographics(value) => fr"demographics = $value"
            case StoreFieldValue.rowguid(value) => fr"rowguid = $value"
            case StoreFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.store
              $updates
              where businessentityid = $businessentityid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: StoreRow): ConnectionIO[StoreRow] = {
    sql"""insert into sales.store(businessentityid, "name", salespersonid, demographics, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.salespersonid}::int4,
            ${unsaved.demographics}::xml,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            "name" = EXCLUDED."name",
            salespersonid = EXCLUDED.salespersonid,
            demographics = EXCLUDED.demographics,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
       """.query.unique
  }
  implicit val read: Read[StoreRow] =
    new Read[StoreRow](
      gets = List(
        (Get[BusinessentityId], Nullability.NoNulls),
        (Get[Name], Nullability.NoNulls),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[TypoXml], Nullability.Nullable),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => StoreRow(
        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
        name = Get[Name].unsafeGetNonNullable(rs, i + 1),
        salespersonid = Get[BusinessentityId].unsafeGetNullable(rs, i + 2),
        demographics = Get[TypoXml].unsafeGetNullable(rs, i + 3),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 4),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 5)
      )
    )
  

}
