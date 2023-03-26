/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatReplicationSlotsRow(
  /** Points to [[PgReplicationSlotsRow.slotName]] */
  slotName: Option[String],
  spillTxns: Option[Long],
  spillCount: Option[Long],
  spillBytes: Option[Long],
  streamTxns: Option[Long],
  streamCount: Option[Long],
  streamBytes: Option[Long],
  totalTxns: Option[Long],
  totalBytes: Option[Long],
  statsReset: Option[ZonedDateTime]
)

object PgStatReplicationSlotsRow {
  def rowParser(prefix: String): RowParser[PgStatReplicationSlotsRow] = { row =>
    Success(
      PgStatReplicationSlotsRow(
        slotName = row[Option[String]](prefix + "slot_name"),
        spillTxns = row[Option[Long]](prefix + "spill_txns"),
        spillCount = row[Option[Long]](prefix + "spill_count"),
        spillBytes = row[Option[Long]](prefix + "spill_bytes"),
        streamTxns = row[Option[Long]](prefix + "stream_txns"),
        streamCount = row[Option[Long]](prefix + "stream_count"),
        streamBytes = row[Option[Long]](prefix + "stream_bytes"),
        totalTxns = row[Option[Long]](prefix + "total_txns"),
        totalBytes = row[Option[Long]](prefix + "total_bytes"),
        statsReset = row[Option[ZonedDateTime]](prefix + "stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatReplicationSlotsRow] = new OFormat[PgStatReplicationSlotsRow]{
    override def writes(o: PgStatReplicationSlotsRow): JsObject =
      Json.obj(
        "slot_name" -> o.slotName,
      "spill_txns" -> o.spillTxns,
      "spill_count" -> o.spillCount,
      "spill_bytes" -> o.spillBytes,
      "stream_txns" -> o.streamTxns,
      "stream_count" -> o.streamCount,
      "stream_bytes" -> o.streamBytes,
      "total_txns" -> o.totalTxns,
      "total_bytes" -> o.totalBytes,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatReplicationSlotsRow] = {
      JsResult.fromTry(
        Try(
          PgStatReplicationSlotsRow(
            slotName = json.\("slot_name").toOption.map(_.as[String]),
            spillTxns = json.\("spill_txns").toOption.map(_.as[Long]),
            spillCount = json.\("spill_count").toOption.map(_.as[Long]),
            spillBytes = json.\("spill_bytes").toOption.map(_.as[Long]),
            streamTxns = json.\("stream_txns").toOption.map(_.as[Long]),
            streamCount = json.\("stream_count").toOption.map(_.as[Long]),
            streamBytes = json.\("stream_bytes").toOption.map(_.as[Long]),
            totalTxns = json.\("total_txns").toOption.map(_.as[Long]),
            totalBytes = json.\("total_bytes").toOption.map(_.as[Long]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
