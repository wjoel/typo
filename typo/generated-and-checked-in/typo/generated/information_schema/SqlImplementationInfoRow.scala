/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

case class SqlImplementationInfoRow(
  implementationInfoId: Option[String],
  implementationInfoName: Option[String],
  integerValue: Option[Int],
  characterValue: Option[String],
  comments: Option[String]
)

object SqlImplementationInfoRow {
  implicit val rowParser: RowParser[SqlImplementationInfoRow] = { row =>
    Success(
      SqlImplementationInfoRow(
        implementationInfoId = row[Option[String]]("implementation_info_id"),
        implementationInfoName = row[Option[String]]("implementation_info_name"),
        integerValue = row[Option[Int]]("integer_value"),
        characterValue = row[Option[String]]("character_value"),
        comments = row[Option[String]]("comments")
      )
    )
  }

  
}
