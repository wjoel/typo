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

case class PgStatisticExtDataRow(
  stxoid: PgStatisticExtDataId,
  stxdndistinct: Option[String],
  stxddependencies: Option[String],
  stxdmcv: Option[String],
  stxdexpr: Option[Array[String]]
)

object PgStatisticExtDataRow {
  implicit val rowParser: RowParser[PgStatisticExtDataRow] = { row =>
    Success(
      PgStatisticExtDataRow(
        stxoid = row[PgStatisticExtDataId]("stxoid"),
        stxdndistinct = row[Option[String]]("stxdndistinct"),
        stxddependencies = row[Option[String]]("stxddependencies"),
        stxdmcv = row[Option[String]]("stxdmcv"),
        stxdexpr = row[Option[Array[String]]]("stxdexpr")
      )
    )
  }

  
}
