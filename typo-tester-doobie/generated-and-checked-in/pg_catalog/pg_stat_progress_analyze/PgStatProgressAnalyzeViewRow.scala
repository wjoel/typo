/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_analyze

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatProgressAnalyzeViewRow(
  pid: Option[Int],
  datid: Option[/* oid */ Long],
  datname: Option[String],
  relid: Option[/* oid */ Long],
  phase: Option[String],
  sampleBlksTotal: Option[Long],
  sampleBlksScanned: Option[Long],
  extStatsTotal: Option[Long],
  extStatsComputed: Option[Long],
  childTablesTotal: Option[Long],
  childTablesDone: Option[Long],
  currentChildTableRelid: Option[/* oid */ Long]
)

object PgStatProgressAnalyzeViewRow {
  implicit val decoder: Decoder[PgStatProgressAnalyzeViewRow] = Decoder.forProduct12[PgStatProgressAnalyzeViewRow, Option[Int], Option[/* oid */ Long], Option[String], Option[/* oid */ Long], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[/* oid */ Long]]("pid", "datid", "datname", "relid", "phase", "sample_blks_total", "sample_blks_scanned", "ext_stats_total", "ext_stats_computed", "child_tables_total", "child_tables_done", "current_child_table_relid")(PgStatProgressAnalyzeViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit val encoder: Encoder[PgStatProgressAnalyzeViewRow] = Encoder.forProduct12[PgStatProgressAnalyzeViewRow, Option[Int], Option[/* oid */ Long], Option[String], Option[/* oid */ Long], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[/* oid */ Long]]("pid", "datid", "datname", "relid", "phase", "sample_blks_total", "sample_blks_scanned", "ext_stats_total", "ext_stats_computed", "child_tables_total", "child_tables_done", "current_child_table_relid")(x => (x.pid, x.datid, x.datname, x.relid, x.phase, x.sampleBlksTotal, x.sampleBlksScanned, x.extStatsTotal, x.extStatsComputed, x.childTablesTotal, x.childTablesDone, x.currentChildTableRelid))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit val read: Read[PgStatProgressAnalyzeViewRow] = new Read[PgStatProgressAnalyzeViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatProgressAnalyzeViewRow(
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      datid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      datname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      phase = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      sampleBlksTotal = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      sampleBlksScanned = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      extStatsTotal = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      extStatsComputed = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      childTablesTotal = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9),
      childTablesDone = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10),
      currentChildTableRelid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 11)
    )
  )
}
