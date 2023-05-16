/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
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

object EmployeepayhistoryRepoImpl extends EmployeepayhistoryRepo {
  override def delete(compositeId: EmployeepayhistoryId): ConnectionIO[Boolean] = {
    sql"delete from humanresources.employeepayhistory where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}".update.run.map(_ > 0)
  }
  override def insert(unsaved: EmployeepayhistoryRow): ConnectionIO[EmployeepayhistoryRow] = {
    sql"""insert into humanresources.employeepayhistory(businessentityid, ratechangedate, rate, payfrequency, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.ratechangedate}::timestamp, ${unsaved.rate}::numeric, ${unsaved.payfrequency}::int2, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, ratechangedate, rate, payfrequency, modifieddate
       """.query.unique
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved): ConnectionIO[EmployeepayhistoryRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${unsaved.businessentityid}::int4")),
      Some((Fragment.const(s"ratechangedate"), fr"${unsaved.ratechangedate}::timestamp")),
      Some((Fragment.const(s"rate"), fr"${unsaved.rate}::numeric")),
      Some((Fragment.const(s"payfrequency"), fr"${unsaved.payfrequency}::int2")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employeepayhistory default values
            returning businessentityid, ratechangedate, rate, payfrequency, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into humanresources.employeepayhistory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, ratechangedate, rate, payfrequency, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, EmployeepayhistoryRow] = {
    sql"select businessentityid, ratechangedate, rate, payfrequency, modifieddate from humanresources.employeepayhistory".query[EmployeepayhistoryRow].stream
  }
  override def selectByFieldValues(fieldValues: List[EmployeepayhistoryFieldOrIdValue[_]]): Stream[ConnectionIO, EmployeepayhistoryRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case EmployeepayhistoryFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case EmployeepayhistoryFieldValue.ratechangedate(value) => fr"ratechangedate = $value"
        case EmployeepayhistoryFieldValue.rate(value) => fr"rate = $value"
        case EmployeepayhistoryFieldValue.payfrequency(value) => fr"payfrequency = $value"
        case EmployeepayhistoryFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from humanresources.employeepayhistory $where".query[EmployeepayhistoryRow].stream
  
  }
  override def selectById(compositeId: EmployeepayhistoryId): ConnectionIO[Option[EmployeepayhistoryRow]] = {
    sql"select businessentityid, ratechangedate, rate, payfrequency, modifieddate from humanresources.employeepayhistory where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}".query[EmployeepayhistoryRow].option
  }
  override def update(row: EmployeepayhistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update humanresources.employeepayhistory
          set rate = ${row.rate}::numeric,
              payfrequency = ${row.payfrequency}::int2,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(compositeId: EmployeepayhistoryId, fieldValues: List[EmployeepayhistoryFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case EmployeepayhistoryFieldValue.rate(value) => fr"rate = $value"
            case EmployeepayhistoryFieldValue.payfrequency(value) => fr"payfrequency = $value"
            case EmployeepayhistoryFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update humanresources.employeepayhistory
              $updates
              where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: EmployeepayhistoryRow): ConnectionIO[EmployeepayhistoryRow] = {
    sql"""insert into humanresources.employeepayhistory(businessentityid, ratechangedate, rate, payfrequency, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.ratechangedate}::timestamp,
            ${unsaved.rate}::numeric,
            ${unsaved.payfrequency}::int2,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, ratechangedate)
          do update set
            rate = EXCLUDED.rate,
            payfrequency = EXCLUDED.payfrequency,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, ratechangedate, rate, payfrequency, modifieddate
       """.query.unique
  }
  implicit val read: Read[EmployeepayhistoryRow] =
    new Read[EmployeepayhistoryRow](
      gets = List(
        (Get[BusinessentityId], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls),
        (Get[BigDecimal], Nullability.NoNulls),
        (Get[Int], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => EmployeepayhistoryRow(
        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
        ratechangedate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 1),
        rate = Get[BigDecimal].unsafeGetNonNullable(rs, i + 2),
        payfrequency = Get[Int].unsafeGetNonNullable(rs, i + 3),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 4)
      )
    )
  

}
