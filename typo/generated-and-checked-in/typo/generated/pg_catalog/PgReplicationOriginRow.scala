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

case class PgReplicationOriginRow(
  roident: PgReplicationOriginId,
  roname: String
)

object PgReplicationOriginRow {
  implicit val rowParser: RowParser[PgReplicationOriginRow] = { row =>
    Success(
      PgReplicationOriginRow(
        roident = row[PgReplicationOriginId]("roident"),
        roname = row[String]("roname")
      )
    )
  }

  
}