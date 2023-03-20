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

case class PgReplicationSlotsRow(
  slotName: /* unknown nullability */ Option[String],
  plugin: /* unknown nullability */ Option[String],
  slotType: /* unknown nullability */ Option[String],
  datoid: /* unknown nullability */ Option[Long],
  /** Points to [[PgDatabaseRow.datname]] */
  database: String,
  temporary: /* unknown nullability */ Option[Boolean],
  active: /* unknown nullability */ Option[Boolean],
  activePid: /* unknown nullability */ Option[Int],
  xmin: /* unknown nullability */ Option[/* xid */ String],
  catalogXmin: /* unknown nullability */ Option[/* xid */ String],
  restartLsn: /* unknown nullability */ Option[/* pg_lsn */ String],
  confirmedFlushLsn: /* unknown nullability */ Option[/* pg_lsn */ String],
  walStatus: /* unknown nullability */ Option[String],
  safeWalSize: /* unknown nullability */ Option[Long],
  twoPhase: /* unknown nullability */ Option[Boolean]
)

object PgReplicationSlotsRow {
  implicit val rowParser: RowParser[PgReplicationSlotsRow] = { row =>
    Success(
      PgReplicationSlotsRow(
        slotName = row[/* unknown nullability */ Option[String]]("slot_name"),
        plugin = row[/* unknown nullability */ Option[String]]("plugin"),
        slotType = row[/* unknown nullability */ Option[String]]("slot_type"),
        datoid = row[/* unknown nullability */ Option[Long]]("datoid"),
        database = row[String]("database"),
        temporary = row[/* unknown nullability */ Option[Boolean]]("temporary"),
        active = row[/* unknown nullability */ Option[Boolean]]("active"),
        activePid = row[/* unknown nullability */ Option[Int]]("active_pid"),
        xmin = row[/* unknown nullability */ Option[/* xid */ String]]("xmin"),
        catalogXmin = row[/* unknown nullability */ Option[/* xid */ String]]("catalog_xmin"),
        restartLsn = row[/* unknown nullability */ Option[/* pg_lsn */ String]]("restart_lsn"),
        confirmedFlushLsn = row[/* unknown nullability */ Option[/* pg_lsn */ String]]("confirmed_flush_lsn"),
        walStatus = row[/* unknown nullability */ Option[String]]("wal_status"),
        safeWalSize = row[/* unknown nullability */ Option[Long]]("safe_wal_size"),
        twoPhase = row[/* unknown nullability */ Option[Boolean]]("two_phase")
      )
    )
  }

  
}
