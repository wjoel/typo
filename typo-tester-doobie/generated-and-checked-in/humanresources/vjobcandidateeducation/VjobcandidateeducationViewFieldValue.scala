/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import adventureworks.humanresources.jobcandidate.JobcandidateId
import java.time.LocalDate

sealed abstract class VjobcandidateeducationViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VjobcandidateeducationViewFieldValue[T](name: String, value: T) extends VjobcandidateeducationViewFieldOrIdValue(name, value)

object VjobcandidateeducationViewFieldValue {
  case class jobcandidateid(override val value: Option[JobcandidateId]) extends VjobcandidateeducationViewFieldValue("jobcandidateid", value)
  case class `Edu.Level`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Level", value)
  case class `Edu.StartDate`(override val value: Option[LocalDate]) extends VjobcandidateeducationViewFieldValue("Edu.StartDate", value)
  case class `Edu.EndDate`(override val value: Option[LocalDate]) extends VjobcandidateeducationViewFieldValue("Edu.EndDate", value)
  case class `Edu.Degree`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Degree", value)
  case class `Edu.Major`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Major", value)
  case class `Edu.Minor`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Minor", value)
  case class `Edu.GPA`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.GPA", value)
  case class `Edu.GPAScale`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.GPAScale", value)
  case class `Edu.School`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.School", value)
  case class `Edu.Loc.CountryRegion`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Loc.CountryRegion", value)
  case class `Edu.Loc.State`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Loc.State", value)
  case class `Edu.Loc.City`(override val value: Option[String]) extends VjobcandidateeducationViewFieldValue("Edu.Loc.City", value)
}
