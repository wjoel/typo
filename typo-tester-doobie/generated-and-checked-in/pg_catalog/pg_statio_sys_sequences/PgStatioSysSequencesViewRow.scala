/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_sequences

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatioSysSequencesViewRow(
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.blksRead]] */
  blksRead: Option[Long],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.blksHit]] */
  blksHit: Option[Long]
)

object PgStatioSysSequencesViewRow {
  implicit val decoder: Decoder[PgStatioSysSequencesViewRow] = Decoder.forProduct5[PgStatioSysSequencesViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long]]("relid", "schemaname", "relname", "blks_read", "blks_hit")(PgStatioSysSequencesViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit val encoder: Encoder[PgStatioSysSequencesViewRow] = Encoder.forProduct5[PgStatioSysSequencesViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long]]("relid", "schemaname", "relname", "blks_read", "blks_hit")(x => (x.relid, x.schemaname, x.relname, x.blksRead, x.blksHit))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit val read: Read[PgStatioSysSequencesViewRow] = new Read[PgStatioSysSequencesViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatioSysSequencesViewRow(
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      blksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      blksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
