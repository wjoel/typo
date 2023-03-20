/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success

case class PgLanguageRow(
  oid: PgLanguageId,
  lanname: String,
  lanowner: Long,
  lanispl: Boolean,
  lanpltrusted: Boolean,
  lanplcallfoid: Long,
  laninline: Long,
  lanvalidator: Long,
  lanacl: Option[Array[String]]
)

object PgLanguageRow {
  implicit val rowParser: RowParser[PgLanguageRow] = { row =>
    Success(
      PgLanguageRow(
        oid = row[PgLanguageId]("oid"),
        lanname = row[String]("lanname"),
        lanowner = row[Long]("lanowner"),
        lanispl = row[Boolean]("lanispl"),
        lanpltrusted = row[Boolean]("lanpltrusted"),
        lanplcallfoid = row[Long]("lanplcallfoid"),
        laninline = row[Long]("laninline"),
        lanvalidator = row[Long]("lanvalidator"),
        lanacl = row[Option[Array[String]]]("lanacl")
      )
    )
  }

  
}
