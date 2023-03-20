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

case class PgStatioAllSequencesRow(
  /** Points to [[PgClassRow.oid]] */
  relid: Long,
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  relname: String,
  blksRead: /* unknown nullability */ Option[Long],
  blksHit: /* unknown nullability */ Option[Long]
)

object PgStatioAllSequencesRow {
  implicit val rowParser: RowParser[PgStatioAllSequencesRow] = { row =>
    Success(
      PgStatioAllSequencesRow(
        relid = row[Long]("relid"),
        schemaname = row[String]("schemaname"),
        relname = row[String]("relname"),
        blksRead = row[/* unknown nullability */ Option[Long]]("blks_read"),
        blksHit = row[/* unknown nullability */ Option[Long]]("blks_hit")
      )
    )
  }

  
}
