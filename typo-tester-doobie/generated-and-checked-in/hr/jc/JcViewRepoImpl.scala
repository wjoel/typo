/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package jc

import adventureworks.humanresources.jobcandidate.JobcandidateId
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
import org.postgresql.jdbc.PgSQLXML

object JcViewRepoImpl extends JcViewRepo {
  override def selectAll: Stream[ConnectionIO, JcViewRow] = {
    sql"""select "id", jobcandidateid, businessentityid, resume, modifieddate from hr.jc""".query[JcViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[JcViewFieldOrIdValue[_]]): Stream[ConnectionIO, JcViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case JcViewFieldValue.id(value) => fr""""id" = $value"""
        case JcViewFieldValue.jobcandidateid(value) => fr"jobcandidateid = $value"
        case JcViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case JcViewFieldValue.resume(value) => fr"resume = $value"
        case JcViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from hr.jc $where".query[JcViewRow].stream
  
  }
  implicit val read: Read[JcViewRow] =
    new Read[JcViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[JobcandidateId], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[PgSQLXML], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => JcViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        jobcandidateid = Get[JobcandidateId].unsafeGetNullable(rs, i + 1),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 2),
        resume = Get[PgSQLXML].unsafeGetNullable(rs, i + 3),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 4)
      )
    )
  

}
