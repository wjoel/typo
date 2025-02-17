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
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VjobcandidateemploymentViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  `Emp.StartDate`: Option[TypoLocalDate],
  `Emp.EndDate`: Option[TypoLocalDate],
  `Emp.OrgName`: Option[/* max 100 chars */ String],
  `Emp.JobTitle`: Option[/* max 100 chars */ String],
  `Emp.Responsibility`: Option[String],
  `Emp.FunctionCategory`: Option[String],
  `Emp.IndustryCategory`: Option[String],
  `Emp.Loc.CountryRegion`: Option[String],
  `Emp.Loc.State`: Option[String],
  `Emp.Loc.City`: Option[String]
)

object VjobcandidateemploymentViewRow {
  implicit val decoder: Decoder[VjobcandidateemploymentViewRow] = Decoder.forProduct11[VjobcandidateemploymentViewRow, Option[JobcandidateId], Option[TypoLocalDate], Option[TypoLocalDate], Option[/* max 100 chars */ String], Option[/* max 100 chars */ String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String]]("jobcandidateid", "Emp.StartDate", "Emp.EndDate", "Emp.OrgName", "Emp.JobTitle", "Emp.Responsibility", "Emp.FunctionCategory", "Emp.IndustryCategory", "Emp.Loc.CountryRegion", "Emp.Loc.State", "Emp.Loc.City")(VjobcandidateemploymentViewRow.apply)(Decoder.decodeOption(JobcandidateId.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit val encoder: Encoder[VjobcandidateemploymentViewRow] = Encoder.forProduct11[VjobcandidateemploymentViewRow, Option[JobcandidateId], Option[TypoLocalDate], Option[TypoLocalDate], Option[/* max 100 chars */ String], Option[/* max 100 chars */ String], Option[String], Option[String], Option[String], Option[String], Option[String], Option[String]]("jobcandidateid", "Emp.StartDate", "Emp.EndDate", "Emp.OrgName", "Emp.JobTitle", "Emp.Responsibility", "Emp.FunctionCategory", "Emp.IndustryCategory", "Emp.Loc.CountryRegion", "Emp.Loc.State", "Emp.Loc.City")(x => (x.jobcandidateid, x.`Emp.StartDate`, x.`Emp.EndDate`, x.`Emp.OrgName`, x.`Emp.JobTitle`, x.`Emp.Responsibility`, x.`Emp.FunctionCategory`, x.`Emp.IndustryCategory`, x.`Emp.Loc.CountryRegion`, x.`Emp.Loc.State`, x.`Emp.Loc.City`))(Encoder.encodeOption(JobcandidateId.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit val read: Read[VjobcandidateemploymentViewRow] = new Read[VjobcandidateemploymentViewRow](
    gets = List(
      (JobcandidateId.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VjobcandidateemploymentViewRow(
      jobcandidateid = JobcandidateId.get.unsafeGetNullable(rs, i + 0),
      `Emp.StartDate` = TypoLocalDate.get.unsafeGetNullable(rs, i + 1),
      `Emp.EndDate` = TypoLocalDate.get.unsafeGetNullable(rs, i + 2),
      `Emp.OrgName` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      `Emp.JobTitle` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      `Emp.Responsibility` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      `Emp.FunctionCategory` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      `Emp.IndustryCategory` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      `Emp.Loc.CountryRegion` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      `Emp.Loc.State` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      `Emp.Loc.City` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10)
    )
  )
}
