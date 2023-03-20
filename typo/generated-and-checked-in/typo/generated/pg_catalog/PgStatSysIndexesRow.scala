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

case class PgStatSysIndexesRow(
  /** Points to [[PgStatAllIndexesRow.relid]] */
  relid: Option[Long],
  /** Points to [[PgStatAllIndexesRow.indexrelid]] */
  indexrelid: Option[Long],
  /** Points to [[PgStatAllIndexesRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[PgStatAllIndexesRow.relname]] */
  relname: Option[String],
  /** Points to [[PgStatAllIndexesRow.indexrelname]] */
  indexrelname: Option[String],
  /** Points to [[PgStatAllIndexesRow.idxScan]] */
  idxScan: Option[Long],
  /** Points to [[PgStatAllIndexesRow.idxTupRead]] */
  idxTupRead: Option[Long],
  /** Points to [[PgStatAllIndexesRow.idxTupFetch]] */
  idxTupFetch: Option[Long]
)

object PgStatSysIndexesRow {
  implicit val rowParser: RowParser[PgStatSysIndexesRow] = { row =>
    Success(
      PgStatSysIndexesRow(
        relid = row[Option[Long]]("relid"),
        indexrelid = row[Option[Long]]("indexrelid"),
        schemaname = row[Option[String]]("schemaname"),
        relname = row[Option[String]]("relname"),
        indexrelname = row[Option[String]]("indexrelname"),
        idxScan = row[Option[Long]]("idx_scan"),
        idxTupRead = row[Option[Long]]("idx_tup_read"),
        idxTupFetch = row[Option[Long]]("idx_tup_fetch")
      )
    )
  }

  
}
