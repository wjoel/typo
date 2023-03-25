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

case class PgStatWalReceiverRow(
  pid: Option[Int],
  status: Option[String],
  receiveStartLsn: Option[String],
  receiveStartTli: Option[Int],
  writtenLsn: Option[String],
  flushedLsn: Option[String],
  receivedTli: Option[Int],
  lastMsgSendTime: Option[ZonedDateTime],
  lastMsgReceiptTime: Option[ZonedDateTime],
  latestEndLsn: Option[String],
  latestEndTime: Option[ZonedDateTime],
  slotName: Option[String],
  senderHost: Option[String],
  senderPort: Option[Int],
  conninfo: Option[String]
)

object PgStatWalReceiverRow {
  def rowParser(prefix: String): RowParser[PgStatWalReceiverRow] = { row =>
    Success(
      PgStatWalReceiverRow(
        pid = row[Option[Int]](prefix + "pid"),
        status = row[Option[String]](prefix + "status"),
        receiveStartLsn = row[Option[String]](prefix + "receive_start_lsn"),
        receiveStartTli = row[Option[Int]](prefix + "receive_start_tli"),
        writtenLsn = row[Option[String]](prefix + "written_lsn"),
        flushedLsn = row[Option[String]](prefix + "flushed_lsn"),
        receivedTli = row[Option[Int]](prefix + "received_tli"),
        lastMsgSendTime = row[Option[ZonedDateTime]](prefix + "last_msg_send_time"),
        lastMsgReceiptTime = row[Option[ZonedDateTime]](prefix + "last_msg_receipt_time"),
        latestEndLsn = row[Option[String]](prefix + "latest_end_lsn"),
        latestEndTime = row[Option[ZonedDateTime]](prefix + "latest_end_time"),
        slotName = row[Option[String]](prefix + "slot_name"),
        senderHost = row[Option[String]](prefix + "sender_host"),
        senderPort = row[Option[Int]](prefix + "sender_port"),
        conninfo = row[Option[String]](prefix + "conninfo")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatWalReceiverRow] = new OFormat[PgStatWalReceiverRow]{
    override def writes(o: PgStatWalReceiverRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
      "status" -> o.status,
      "receive_start_lsn" -> o.receiveStartLsn,
      "receive_start_tli" -> o.receiveStartTli,
      "written_lsn" -> o.writtenLsn,
      "flushed_lsn" -> o.flushedLsn,
      "received_tli" -> o.receivedTli,
      "last_msg_send_time" -> o.lastMsgSendTime,
      "last_msg_receipt_time" -> o.lastMsgReceiptTime,
      "latest_end_lsn" -> o.latestEndLsn,
      "latest_end_time" -> o.latestEndTime,
      "slot_name" -> o.slotName,
      "sender_host" -> o.senderHost,
      "sender_port" -> o.senderPort,
      "conninfo" -> o.conninfo
      )

    override def reads(json: JsValue): JsResult[PgStatWalReceiverRow] = {
      JsResult.fromTry(
        Try(
          PgStatWalReceiverRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            status = json.\("status").toOption.map(_.as[String]),
            receiveStartLsn = json.\("receive_start_lsn").toOption.map(_.as[String]),
            receiveStartTli = json.\("receive_start_tli").toOption.map(_.as[Int]),
            writtenLsn = json.\("written_lsn").toOption.map(_.as[String]),
            flushedLsn = json.\("flushed_lsn").toOption.map(_.as[String]),
            receivedTli = json.\("received_tli").toOption.map(_.as[Int]),
            lastMsgSendTime = json.\("last_msg_send_time").toOption.map(_.as[ZonedDateTime]),
            lastMsgReceiptTime = json.\("last_msg_receipt_time").toOption.map(_.as[ZonedDateTime]),
            latestEndLsn = json.\("latest_end_lsn").toOption.map(_.as[String]),
            latestEndTime = json.\("latest_end_time").toOption.map(_.as[ZonedDateTime]),
            slotName = json.\("slot_name").toOption.map(_.as[String]),
            senderHost = json.\("sender_host").toOption.map(_.as[String]),
            senderPort = json.\("sender_port").toOption.map(_.as[Int]),
            conninfo = json.\("conninfo").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
