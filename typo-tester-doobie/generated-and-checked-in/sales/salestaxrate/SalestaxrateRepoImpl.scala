/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.Defaulted
import adventureworks.person.stateprovince.StateprovinceId
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

object SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete(salestaxrateid: SalestaxrateId): ConnectionIO[Boolean] = {
    sql"delete from sales.salestaxrate where salestaxrateid = $salestaxrateid".update.run.map(_ > 0)
  }
  override def insert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate(salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate)
          values (${unsaved.salestaxrateid}::int4, ${unsaved.stateprovinceid}::int4, ${unsaved.taxtype}::int2, ${unsaved.taxrate}::numeric, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: SalestaxrateRowUnsaved): ConnectionIO[SalestaxrateRow] = {
    val fs = List(
      Some((Fragment.const(s"stateprovinceid"), fr"${unsaved.stateprovinceid}::int4")),
      Some((Fragment.const(s"taxtype"), fr"${unsaved.taxtype}::int2")),
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.salestaxrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salestaxrateid"), fr"${value: SalestaxrateId}::int4"))
      },
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"taxrate"), fr"${value: BigDecimal}::numeric"))
      },
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
      sql"""insert into sales.salestaxrate default values
            returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salestaxrate(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sales.salestaxrate""".query[SalestaxrateRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SalestaxrateFieldOrIdValue[_]]): Stream[ConnectionIO, SalestaxrateRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SalestaxrateFieldValue.salestaxrateid(value) => fr"salestaxrateid = $value"
        case SalestaxrateFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
        case SalestaxrateFieldValue.taxtype(value) => fr"taxtype = $value"
        case SalestaxrateFieldValue.taxrate(value) => fr"taxrate = $value"
        case SalestaxrateFieldValue.name(value) => fr""""name" = $value"""
        case SalestaxrateFieldValue.rowguid(value) => fr"rowguid = $value"
        case SalestaxrateFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.salestaxrate $where".query[SalestaxrateRow].stream
  
  }
  override def selectById(salestaxrateid: SalestaxrateId): ConnectionIO[Option[SalestaxrateRow]] = {
    sql"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sales.salestaxrate where salestaxrateid = $salestaxrateid""".query[SalestaxrateRow].option
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId]): Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sales.salestaxrate where salestaxrateid = ANY($salestaxrateids)""".query[SalestaxrateRow].stream
  }
  override def update(row: SalestaxrateRow): ConnectionIO[Boolean] = {
    val salestaxrateid = row.salestaxrateid
    sql"""update sales.salestaxrate
          set stateprovinceid = ${row.stateprovinceid}::int4,
              taxtype = ${row.taxtype}::int2,
              taxrate = ${row.taxrate}::numeric,
              "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where salestaxrateid = $salestaxrateid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(salestaxrateid: SalestaxrateId, fieldValues: List[SalestaxrateFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case SalestaxrateFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
            case SalestaxrateFieldValue.taxtype(value) => fr"taxtype = $value"
            case SalestaxrateFieldValue.taxrate(value) => fr"taxrate = $value"
            case SalestaxrateFieldValue.name(value) => fr""""name" = $value"""
            case SalestaxrateFieldValue.rowguid(value) => fr"rowguid = $value"
            case SalestaxrateFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.salestaxrate
              $updates
              where salestaxrateid = $salestaxrateid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate(salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate)
          values (
            ${unsaved.salestaxrateid}::int4,
            ${unsaved.stateprovinceid}::int4,
            ${unsaved.taxtype}::int2,
            ${unsaved.taxrate}::numeric,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (salestaxrateid)
          do update set
            stateprovinceid = EXCLUDED.stateprovinceid,
            taxtype = EXCLUDED.taxtype,
            taxrate = EXCLUDED.taxrate,
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
       """.query.unique
  }
  implicit val read: Read[SalestaxrateRow] =
    new Read[SalestaxrateRow](
      gets = List(
        (Get[SalestaxrateId], Nullability.NoNulls),
        (Get[StateprovinceId], Nullability.NoNulls),
        (Get[Int], Nullability.NoNulls),
        (Get[BigDecimal], Nullability.NoNulls),
        (Get[Name], Nullability.NoNulls),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SalestaxrateRow(
        salestaxrateid = Get[SalestaxrateId].unsafeGetNonNullable(rs, i + 0),
        stateprovinceid = Get[StateprovinceId].unsafeGetNonNullable(rs, i + 1),
        taxtype = Get[Int].unsafeGetNonNullable(rs, i + 2),
        taxrate = Get[BigDecimal].unsafeGetNonNullable(rs, i + 3),
        name = Get[Name].unsafeGetNonNullable(rs, i + 4),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 5),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 6)
      )
    )
  

}
