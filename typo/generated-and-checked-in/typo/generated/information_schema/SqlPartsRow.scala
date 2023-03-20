/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

case class SqlPartsRow(
  featureId: Option[String],
  featureName: Option[String],
  isSupported: Option[String],
  isVerifiedBy: Option[String],
  comments: Option[String]
)

object SqlPartsRow {
  implicit val rowParser: RowParser[SqlPartsRow] = { row =>
    Success(
      SqlPartsRow(
        featureId = row[Option[String]]("feature_id"),
        featureName = row[Option[String]]("feature_name"),
        isSupported = row[Option[String]]("is_supported"),
        isVerifiedBy = row[Option[String]]("is_verified_by"),
        comments = row[Option[String]]("comments")
      )
    )
  }

  
}