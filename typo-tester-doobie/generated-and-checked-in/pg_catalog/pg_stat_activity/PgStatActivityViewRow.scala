/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_activity

import adventureworks.TypoInet
import adventureworks.TypoOffsetDateTime
import adventureworks.TypoXid
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatActivityViewRow(
  datid: Option[/* oid */ Long],
  datname: Option[String],
  pid: Option[Int],
  leaderPid: Option[Int],
  usesysid: Option[/* oid */ Long],
  usename: Option[String],
  applicationName: Option[String],
  clientAddr: Option[TypoInet],
  clientHostname: Option[String],
  clientPort: Option[Int],
  backendStart: Option[TypoOffsetDateTime],
  xactStart: Option[TypoOffsetDateTime],
  queryStart: Option[TypoOffsetDateTime],
  stateChange: Option[TypoOffsetDateTime],
  waitEventType: Option[String],
  waitEvent: Option[String],
  state: Option[String],
  backendXid: Option[TypoXid],
  backendXmin: Option[TypoXid],
  queryId: Option[Long],
  query: Option[String],
  backendType: Option[String]
)

object PgStatActivityViewRow {
  implicit val decoder: Decoder[PgStatActivityViewRow] = Decoder.forProduct22[PgStatActivityViewRow, Option[/* oid */ Long], Option[String], Option[Int], Option[Int], Option[/* oid */ Long], Option[String], Option[String], Option[TypoInet], Option[String], Option[Int], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[String], Option[String], Option[String], Option[TypoXid], Option[TypoXid], Option[Long], Option[String], Option[String]]("datid", "datname", "pid", "leader_pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start", "xact_start", "query_start", "state_change", "wait_event_type", "wait_event", "state", "backend_xid", "backend_xmin", "query_id", "query", "backend_type")(PgStatActivityViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoInet.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoXid.decoder), Decoder.decodeOption(TypoXid.decoder), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit val encoder: Encoder[PgStatActivityViewRow] = Encoder.forProduct22[PgStatActivityViewRow, Option[/* oid */ Long], Option[String], Option[Int], Option[Int], Option[/* oid */ Long], Option[String], Option[String], Option[TypoInet], Option[String], Option[Int], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[String], Option[String], Option[String], Option[TypoXid], Option[TypoXid], Option[Long], Option[String], Option[String]]("datid", "datname", "pid", "leader_pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start", "xact_start", "query_start", "state_change", "wait_event_type", "wait_event", "state", "backend_xid", "backend_xmin", "query_id", "query", "backend_type")(x => (x.datid, x.datname, x.pid, x.leaderPid, x.usesysid, x.usename, x.applicationName, x.clientAddr, x.clientHostname, x.clientPort, x.backendStart, x.xactStart, x.queryStart, x.stateChange, x.waitEventType, x.waitEvent, x.state, x.backendXid, x.backendXmin, x.queryId, x.query, x.backendType))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoInet.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoXid.encoder), Encoder.encodeOption(TypoXid.encoder), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit val read: Read[PgStatActivityViewRow] = new Read[PgStatActivityViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoInet.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoXid.get, Nullability.Nullable),
      (TypoXid.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatActivityViewRow(
      datid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      datname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 2),
      leaderPid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      usesysid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      usename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      applicationName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      clientAddr = TypoInet.get.unsafeGetNullable(rs, i + 7),
      clientHostname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      clientPort = Meta.IntMeta.get.unsafeGetNullable(rs, i + 9),
      backendStart = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 10),
      xactStart = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 11),
      queryStart = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 12),
      stateChange = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 13),
      waitEventType = Meta.StringMeta.get.unsafeGetNullable(rs, i + 14),
      waitEvent = Meta.StringMeta.get.unsafeGetNullable(rs, i + 15),
      state = Meta.StringMeta.get.unsafeGetNullable(rs, i + 16),
      backendXid = TypoXid.get.unsafeGetNullable(rs, i + 17),
      backendXmin = TypoXid.get.unsafeGetNullable(rs, i + 18),
      queryId = Meta.LongMeta.get.unsafeGetNullable(rs, i + 19),
      query = Meta.StringMeta.get.unsafeGetNullable(rs, i + 20),
      backendType = Meta.StringMeta.get.unsafeGetNullable(rs, i + 21)
    )
  )
}
