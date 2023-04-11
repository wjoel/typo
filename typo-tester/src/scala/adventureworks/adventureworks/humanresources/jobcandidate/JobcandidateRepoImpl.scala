/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object JobcandidateRepoImpl extends JobcandidateRepo {
  override def delete(jobcandidateid: JobcandidateId)(implicit c: Connection): Boolean = {
    SQL"""delete from humanresources.jobcandidate where jobcandidateid = $jobcandidateid""".executeUpdate() > 0
  }
  override def insert(unsaved: JobcandidateRowUnsaved)(implicit c: Connection): JobcandidateId = {
    val namedParameters = List(
      Some(NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid))),
      Some(NamedParameter("resume", ParameterValue.from(unsaved.resume))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into humanresources.jobcandidate(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning jobcandidateid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[JobcandidateRow] = {
    SQL"""select jobcandidateid, businessentityid, resume, modifieddate from humanresources.jobcandidate""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[JobcandidateFieldOrIdValue[_]])(implicit c: Connection): List[JobcandidateRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case JobcandidateFieldValue.jobcandidateid(value) => NamedParameter("jobcandidateid", ParameterValue.from(value))
          case JobcandidateFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case JobcandidateFieldValue.resume(value) => NamedParameter("resume", ParameterValue.from(value))
          case JobcandidateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from humanresources.jobcandidate where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(jobcandidateid: JobcandidateId)(implicit c: Connection): Option[JobcandidateRow] = {
    SQL"""select jobcandidateid, businessentityid, resume, modifieddate from humanresources.jobcandidate where jobcandidateid = $jobcandidateid""".as(rowParser.singleOpt)
  }
  override def selectByIds(jobcandidateids: List[JobcandidateId])(implicit c: Connection): List[JobcandidateRow] = {
    SQL"""select jobcandidateid, businessentityid, resume, modifieddate from humanresources.jobcandidate where jobcandidateid in $jobcandidateids""".as(rowParser.*)
  }
  override def update(row: JobcandidateRow)(implicit c: Connection): Boolean = {
    val jobcandidateid = row.jobcandidateid
    SQL"""update humanresources.jobcandidate
          set businessentityid = ${row.businessentityid},
              resume = ${row.resume},
              modifieddate = ${row.modifieddate}
          where jobcandidateid = $jobcandidateid""".executeUpdate() > 0
  }
  override def updateFieldValues(jobcandidateid: JobcandidateId, fieldValues: List[JobcandidateFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case JobcandidateFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case JobcandidateFieldValue.resume(value) => NamedParameter("resume", ParameterValue.from(value))
          case JobcandidateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update humanresources.jobcandidate
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where jobcandidateid = $jobcandidateid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[JobcandidateRow] =
    RowParser[JobcandidateRow] { row =>
      Success(
        JobcandidateRow(
          jobcandidateid = row[JobcandidateId]("jobcandidateid"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          resume = row[Option[/* xml */ String]]("resume"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[JobcandidateId] =
    SqlParser.get[JobcandidateId]("jobcandidateid")
}
