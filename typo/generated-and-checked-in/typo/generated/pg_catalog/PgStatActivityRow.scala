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
import java.time.LocalDateTime

case class PgStatActivityRow(
  datid: /* unknown nullability */ Option[Long],
  /** Points to [[PgDatabaseRow.datname]] */
  datname: String,
  pid: /* unknown nullability */ Option[Int],
  leaderPid: /* unknown nullability */ Option[Int],
  usesysid: /* unknown nullability */ Option[Long],
  /** Points to [[PgAuthidRow.rolname]] */
  usename: String,
  applicationName: /* unknown nullability */ Option[String],
  clientAddr: /* unknown nullability */ Option[/* inet */ String],
  clientHostname: /* unknown nullability */ Option[String],
  clientPort: /* unknown nullability */ Option[Int],
  backendStart: /* unknown nullability */ Option[LocalDateTime],
  xactStart: /* unknown nullability */ Option[LocalDateTime],
  queryStart: /* unknown nullability */ Option[LocalDateTime],
  stateChange: /* unknown nullability */ Option[LocalDateTime],
  waitEventType: /* unknown nullability */ Option[String],
  waitEvent: /* unknown nullability */ Option[String],
  state: /* unknown nullability */ Option[String],
  backendXid: /* unknown nullability */ Option[/* xid */ String],
  backendXmin: /* unknown nullability */ Option[/* xid */ String],
  queryId: /* unknown nullability */ Option[Long],
  query: /* unknown nullability */ Option[String],
  backendType: /* unknown nullability */ Option[String]
)

object PgStatActivityRow {
  implicit val rowParser: RowParser[PgStatActivityRow] = { row =>
    Success(
      PgStatActivityRow(
        datid = row[/* unknown nullability */ Option[Long]]("datid"),
        datname = row[String]("datname"),
        pid = row[/* unknown nullability */ Option[Int]]("pid"),
        leaderPid = row[/* unknown nullability */ Option[Int]]("leader_pid"),
        usesysid = row[/* unknown nullability */ Option[Long]]("usesysid"),
        usename = row[String]("usename"),
        applicationName = row[/* unknown nullability */ Option[String]]("application_name"),
        clientAddr = row[/* unknown nullability */ Option[/* inet */ String]]("client_addr"),
        clientHostname = row[/* unknown nullability */ Option[String]]("client_hostname"),
        clientPort = row[/* unknown nullability */ Option[Int]]("client_port"),
        backendStart = row[/* unknown nullability */ Option[LocalDateTime]]("backend_start"),
        xactStart = row[/* unknown nullability */ Option[LocalDateTime]]("xact_start"),
        queryStart = row[/* unknown nullability */ Option[LocalDateTime]]("query_start"),
        stateChange = row[/* unknown nullability */ Option[LocalDateTime]]("state_change"),
        waitEventType = row[/* unknown nullability */ Option[String]]("wait_event_type"),
        waitEvent = row[/* unknown nullability */ Option[String]]("wait_event"),
        state = row[/* unknown nullability */ Option[String]]("state"),
        backendXid = row[/* unknown nullability */ Option[/* xid */ String]]("backend_xid"),
        backendXmin = row[/* unknown nullability */ Option[/* xid */ String]]("backend_xmin"),
        queryId = row[/* unknown nullability */ Option[Long]]("query_id"),
        query = row[/* unknown nullability */ Option[String]]("query"),
        backendType = row[/* unknown nullability */ Option[String]]("backend_type")
      )
    )
  }

  
}