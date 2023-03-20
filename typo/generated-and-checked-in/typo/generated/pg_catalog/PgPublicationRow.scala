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

case class PgPublicationRow(
  oid: PgPublicationId,
  pubname: String,
  pubowner: Long,
  puballtables: Boolean,
  pubinsert: Boolean,
  pubupdate: Boolean,
  pubdelete: Boolean,
  pubtruncate: Boolean,
  pubviaroot: Boolean
)

object PgPublicationRow {
  implicit val rowParser: RowParser[PgPublicationRow] = { row =>
    Success(
      PgPublicationRow(
        oid = row[PgPublicationId]("oid"),
        pubname = row[String]("pubname"),
        pubowner = row[Long]("pubowner"),
        puballtables = row[Boolean]("puballtables"),
        pubinsert = row[Boolean]("pubinsert"),
        pubupdate = row[Boolean]("pubupdate"),
        pubdelete = row[Boolean]("pubdelete"),
        pubtruncate = row[Boolean]("pubtruncate"),
        pubviaroot = row[Boolean]("pubviaroot")
      )
    )
  }

  
}
