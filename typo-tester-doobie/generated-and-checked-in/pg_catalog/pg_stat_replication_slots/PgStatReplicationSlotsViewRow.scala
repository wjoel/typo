/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication_slots

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatReplicationSlotsViewRow(
  /** Points to [[pg_replication_slots.PgReplicationSlotsViewRow.slotName]] */
  slotName: Option[String],
  spillTxns: Option[Long],
  spillCount: Option[Long],
  spillBytes: Option[Long],
  streamTxns: Option[Long],
  streamCount: Option[Long],
  streamBytes: Option[Long],
  totalTxns: Option[Long],
  totalBytes: Option[Long],
  statsReset: Option[TypoOffsetDateTime]
)

object PgStatReplicationSlotsViewRow {
  implicit val decoder: Decoder[PgStatReplicationSlotsViewRow] = Decoder.forProduct10[PgStatReplicationSlotsViewRow, Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[TypoOffsetDateTime]]("slot_name", "spill_txns", "spill_count", "spill_bytes", "stream_txns", "stream_count", "stream_bytes", "total_txns", "total_bytes", "stats_reset")(PgStatReplicationSlotsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit val encoder: Encoder[PgStatReplicationSlotsViewRow] = Encoder.forProduct10[PgStatReplicationSlotsViewRow, Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[TypoOffsetDateTime]]("slot_name", "spill_txns", "spill_count", "spill_bytes", "stream_txns", "stream_count", "stream_bytes", "total_txns", "total_bytes", "stats_reset")(x => (x.slotName, x.spillTxns, x.spillCount, x.spillBytes, x.streamTxns, x.streamCount, x.streamBytes, x.totalTxns, x.totalBytes, x.statsReset))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit val read: Read[PgStatReplicationSlotsViewRow] = new Read[PgStatReplicationSlotsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatReplicationSlotsViewRow(
      slotName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      spillTxns = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      spillCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 2),
      spillBytes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      streamTxns = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      streamCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      streamBytes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      totalTxns = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      totalBytes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      statsReset = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 9)
    )
  )
}
