/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `humanresources.jobcandidate` which has not been persisted yet */
case class JobcandidateRowUnsaved(
  /** Employee identification number if applicant was hired. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** RÃ©sumÃ© in XML format. */
  resume: Option[TypoXml],
  /** Default: nextval('humanresources.jobcandidate_jobcandidateid_seq'::regclass)
      Primary key for JobCandidate records. */
  jobcandidateid: Defaulted[JobcandidateId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(jobcandidateidDefault: => JobcandidateId, modifieddateDefault: => TypoLocalDateTime): JobcandidateRow =
    JobcandidateRow(
      businessentityid = businessentityid,
      resume = resume,
      jobcandidateid = jobcandidateid match {
                         case Defaulted.UseDefault => jobcandidateidDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object JobcandidateRowUnsaved {
  implicit lazy val reads: Reads[JobcandidateRowUnsaved] = Reads[JobcandidateRowUnsaved](json => JsResult.fromTry(
      Try(
        JobcandidateRowUnsaved(
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          resume = json.\("resume").toOption.map(_.as(TypoXml.reads)),
          jobcandidateid = json.\("jobcandidateid").as(Defaulted.reads(JobcandidateId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[JobcandidateRowUnsaved] = OWrites[JobcandidateRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "resume" -> Writes.OptionWrites(TypoXml.writes).writes(o.resume),
      "jobcandidateid" -> Defaulted.writes(JobcandidateId.writes).writes(o.jobcandidateid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
