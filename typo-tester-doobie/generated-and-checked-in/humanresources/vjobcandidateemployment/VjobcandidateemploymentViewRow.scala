/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateemployment

import adventureworks.humanresources.jobcandidate.JobcandidateId
import java.time.LocalDate

case class VjobcandidateemploymentViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  `Emp.StartDate`: Option[LocalDate],
  `Emp.EndDate`: Option[LocalDate],
  `Emp.OrgName`: Option[String],
  `Emp.JobTitle`: Option[String],
  `Emp.Responsibility`: Option[String],
  `Emp.FunctionCategory`: Option[String],
  `Emp.IndustryCategory`: Option[String],
  `Emp.Loc.CountryRegion`: Option[String],
  `Emp.Loc.State`: Option[String],
  `Emp.Loc.City`: Option[String]
)


