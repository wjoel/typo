/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import org.postgresql.util.PGInterval

case class PgTimezoneAbbrevsRow(
  abbrev: /* unknown nullability */ Option[String],
  utcOffset: /* unknown nullability */ Option[/* interval */ PGInterval],
  isDst: /* unknown nullability */ Option[Boolean]
)

object PgTimezoneAbbrevsRow {
  implicit val rowParser: RowParser[PgTimezoneAbbrevsRow] = { row =>
    Success(
      PgTimezoneAbbrevsRow(
        abbrev = row[/* unknown nullability */ Option[String]]("abbrev"),
        utcOffset = row[/* unknown nullability */ Option[/* interval */ PGInterval]]("utc_offset"),
        isDst = row[/* unknown nullability */ Option[Boolean]]("is_dst")
      )
    )
  }

  
}