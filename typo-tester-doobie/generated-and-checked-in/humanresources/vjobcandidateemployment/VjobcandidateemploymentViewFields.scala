/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateemployment

import adventureworks.TypoLocalDate
import adventureworks.humanresources.jobcandidate.JobcandidateId
import typo.dsl.SqlExpr.OptField

trait VjobcandidateemploymentViewFields[Row] {
  val jobcandidateid: OptField[JobcandidateId, Row]
  val `Emp.StartDate`: OptField[TypoLocalDate, Row]
  val `Emp.EndDate`: OptField[TypoLocalDate, Row]
  val `Emp.OrgName`: OptField[/* max 100 chars */ String, Row]
  val `Emp.JobTitle`: OptField[/* max 100 chars */ String, Row]
  val `Emp.Responsibility`: OptField[String, Row]
  val `Emp.FunctionCategory`: OptField[String, Row]
  val `Emp.IndustryCategory`: OptField[String, Row]
  val `Emp.Loc.CountryRegion`: OptField[String, Row]
  val `Emp.Loc.State`: OptField[String, Row]
  val `Emp.Loc.City`: OptField[String, Row]
}
object VjobcandidateemploymentViewFields extends VjobcandidateemploymentViewStructure[VjobcandidateemploymentViewRow](None, identity, (_, x) => x)

