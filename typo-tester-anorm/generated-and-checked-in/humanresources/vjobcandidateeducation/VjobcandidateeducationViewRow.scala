/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import adventureworks.TypoLocalDate
import adventureworks.humanresources.jobcandidate.JobcandidateId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VjobcandidateeducationViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  `Edu.Level`: Option[/* max 50 chars */ String],
  `Edu.StartDate`: Option[TypoLocalDate],
  `Edu.EndDate`: Option[TypoLocalDate],
  `Edu.Degree`: Option[/* max 50 chars */ String],
  `Edu.Major`: Option[/* max 50 chars */ String],
  `Edu.Minor`: Option[/* max 50 chars */ String],
  `Edu.GPA`: Option[/* max 5 chars */ String],
  `Edu.GPAScale`: Option[/* max 5 chars */ String],
  `Edu.School`: Option[/* max 100 chars */ String],
  `Edu.Loc.CountryRegion`: Option[/* max 100 chars */ String],
  `Edu.Loc.State`: Option[/* max 100 chars */ String],
  `Edu.Loc.City`: Option[/* max 100 chars */ String]
)

object VjobcandidateeducationViewRow {
  implicit val reads: Reads[VjobcandidateeducationViewRow] = Reads[VjobcandidateeducationViewRow](json => JsResult.fromTry(
      Try(
        VjobcandidateeducationViewRow(
          jobcandidateid = json.\("jobcandidateid").toOption.map(_.as(JobcandidateId.reads)),
          `Edu.Level` = json.\("Edu.Level").toOption.map(_.as(Reads.StringReads)),
          `Edu.StartDate` = json.\("Edu.StartDate").toOption.map(_.as(TypoLocalDate.reads)),
          `Edu.EndDate` = json.\("Edu.EndDate").toOption.map(_.as(TypoLocalDate.reads)),
          `Edu.Degree` = json.\("Edu.Degree").toOption.map(_.as(Reads.StringReads)),
          `Edu.Major` = json.\("Edu.Major").toOption.map(_.as(Reads.StringReads)),
          `Edu.Minor` = json.\("Edu.Minor").toOption.map(_.as(Reads.StringReads)),
          `Edu.GPA` = json.\("Edu.GPA").toOption.map(_.as(Reads.StringReads)),
          `Edu.GPAScale` = json.\("Edu.GPAScale").toOption.map(_.as(Reads.StringReads)),
          `Edu.School` = json.\("Edu.School").toOption.map(_.as(Reads.StringReads)),
          `Edu.Loc.CountryRegion` = json.\("Edu.Loc.CountryRegion").toOption.map(_.as(Reads.StringReads)),
          `Edu.Loc.State` = json.\("Edu.Loc.State").toOption.map(_.as(Reads.StringReads)),
          `Edu.Loc.City` = json.\("Edu.Loc.City").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VjobcandidateeducationViewRow] = RowParser[VjobcandidateeducationViewRow] { row =>
    Success(
      VjobcandidateeducationViewRow(
        jobcandidateid = row(idx + 0)(Column.columnToOption(JobcandidateId.column)),
        `Edu.Level` = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        `Edu.StartDate` = row(idx + 2)(Column.columnToOption(TypoLocalDate.column)),
        `Edu.EndDate` = row(idx + 3)(Column.columnToOption(TypoLocalDate.column)),
        `Edu.Degree` = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        `Edu.Major` = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        `Edu.Minor` = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        `Edu.GPA` = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        `Edu.GPAScale` = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        `Edu.School` = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        `Edu.Loc.CountryRegion` = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        `Edu.Loc.State` = row(idx + 11)(Column.columnToOption(Column.columnToString)),
        `Edu.Loc.City` = row(idx + 12)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit val writes: OWrites[VjobcandidateeducationViewRow] = OWrites[VjobcandidateeducationViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "jobcandidateid" -> Writes.OptionWrites(JobcandidateId.writes).writes(o.jobcandidateid),
      "Edu.Level" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Level`),
      "Edu.StartDate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.`Edu.StartDate`),
      "Edu.EndDate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.`Edu.EndDate`),
      "Edu.Degree" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Degree`),
      "Edu.Major" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Major`),
      "Edu.Minor" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Minor`),
      "Edu.GPA" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.GPA`),
      "Edu.GPAScale" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.GPAScale`),
      "Edu.School" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.School`),
      "Edu.Loc.CountryRegion" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Loc.CountryRegion`),
      "Edu.Loc.State" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Loc.State`),
      "Edu.Loc.City" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Edu.Loc.City`)
    ))
  )
}
