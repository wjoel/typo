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
import io.circe.Decoder
import io.circe.Encoder

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
  implicit val decoder: Decoder[JobcandidateRowUnsaved] = Decoder.forProduct4[JobcandidateRowUnsaved, Option[BusinessentityId], Option[TypoXml], Defaulted[JobcandidateId], Defaulted[TypoLocalDateTime]]("businessentityid", "resume", "jobcandidateid", "modifieddate")(JobcandidateRowUnsaved.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(TypoXml.decoder), Defaulted.decoder(JobcandidateId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[JobcandidateRowUnsaved] = Encoder.forProduct4[JobcandidateRowUnsaved, Option[BusinessentityId], Option[TypoXml], Defaulted[JobcandidateId], Defaulted[TypoLocalDateTime]]("businessentityid", "resume", "jobcandidateid", "modifieddate")(x => (x.businessentityid, x.resume, x.jobcandidateid, x.modifieddate))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(TypoXml.encoder), Defaulted.encoder(JobcandidateId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
}
