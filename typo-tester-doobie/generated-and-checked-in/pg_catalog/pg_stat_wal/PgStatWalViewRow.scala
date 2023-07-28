/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_wal

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatWalViewRow(
  walRecords: Option[Long],
  walFpi: Option[Long],
  walBytes: Option[BigDecimal],
  walBuffersFull: Option[Long],
  walWrite: Option[Long],
  walSync: Option[Long],
  walWriteTime: Option[Double],
  walSyncTime: Option[Double],
  statsReset: Option[TypoOffsetDateTime]
)

object PgStatWalViewRow {
  implicit val decoder: Decoder[PgStatWalViewRow] = Decoder.forProduct9[PgStatWalViewRow, Option[Long], Option[Long], Option[BigDecimal], Option[Long], Option[Long], Option[Long], Option[Double], Option[Double], Option[TypoOffsetDateTime]]("wal_records", "wal_fpi", "wal_bytes", "wal_buffers_full", "wal_write", "wal_sync", "wal_write_time", "wal_sync_time", "stats_reset")(PgStatWalViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeDouble), Decoder.decodeOption(Decoder.decodeDouble), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit val encoder: Encoder[PgStatWalViewRow] = Encoder.forProduct9[PgStatWalViewRow, Option[Long], Option[Long], Option[BigDecimal], Option[Long], Option[Long], Option[Long], Option[Double], Option[Double], Option[TypoOffsetDateTime]]("wal_records", "wal_fpi", "wal_bytes", "wal_buffers_full", "wal_write", "wal_sync", "wal_write_time", "wal_sync_time", "stats_reset")(x => (x.walRecords, x.walFpi, x.walBytes, x.walBuffersFull, x.walWrite, x.walSync, x.walWriteTime, x.walSyncTime, x.statsReset))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeDouble), Encoder.encodeOption(Encoder.encodeDouble), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit val read: Read[PgStatWalViewRow] = new Read[PgStatWalViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.DoubleMeta.get, Nullability.Nullable),
      (Meta.DoubleMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatWalViewRow(
      walRecords = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      walFpi = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      walBytes = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 2),
      walBuffersFull = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      walWrite = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      walSync = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      walWriteTime = Meta.DoubleMeta.get.unsafeGetNullable(rs, i + 6),
      walSyncTime = Meta.DoubleMeta.get.unsafeGetNullable(rs, i + 7),
      statsReset = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
