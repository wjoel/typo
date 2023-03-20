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

case class PgUserMappingRow(
  oid: PgUserMappingId,
  umuser: Long,
  umserver: Long,
  umoptions: Option[Array[String]]
)

object PgUserMappingRow {
  implicit val rowParser: RowParser[PgUserMappingRow] = { row =>
    Success(
      PgUserMappingRow(
        oid = row[PgUserMappingId]("oid"),
        umuser = row[Long]("umuser"),
        umserver = row[Long]("umserver"),
        umoptions = row[Option[Array[String]]]("umoptions")
      )
    )
  }

  
}
