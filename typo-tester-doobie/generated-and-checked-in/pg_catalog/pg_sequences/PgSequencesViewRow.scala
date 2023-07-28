/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequences

import adventureworks.TypoRegtype
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgSequencesViewRow(
  schemaname: Option[String],
  sequencename: Option[String],
  sequenceowner: Option[String],
  dataType: Option[TypoRegtype],
  startValue: Option[Long],
  minValue: Option[Long],
  maxValue: Option[Long],
  incrementBy: Option[Long],
  cycle: Option[Boolean],
  cacheSize: Option[Long],
  lastValue: Option[Long]
)

object PgSequencesViewRow {
  implicit val decoder: Decoder[PgSequencesViewRow] = Decoder.forProduct11[PgSequencesViewRow, Option[String], Option[String], Option[String], Option[TypoRegtype], Option[Long], Option[Long], Option[Long], Option[Long], Option[Boolean], Option[Long], Option[Long]]("schemaname", "sequencename", "sequenceowner", "data_type", "start_value", "min_value", "max_value", "increment_by", "cycle", "cache_size", "last_value")(PgSequencesViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoRegtype.decoder), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit val encoder: Encoder[PgSequencesViewRow] = Encoder.forProduct11[PgSequencesViewRow, Option[String], Option[String], Option[String], Option[TypoRegtype], Option[Long], Option[Long], Option[Long], Option[Long], Option[Boolean], Option[Long], Option[Long]]("schemaname", "sequencename", "sequenceowner", "data_type", "start_value", "min_value", "max_value", "increment_by", "cycle", "cache_size", "last_value")(x => (x.schemaname, x.sequencename, x.sequenceowner, x.dataType, x.startValue, x.minValue, x.maxValue, x.incrementBy, x.cycle, x.cacheSize, x.lastValue))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoRegtype.encoder), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit val read: Read[PgSequencesViewRow] = new Read[PgSequencesViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoRegtype.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgSequencesViewRow(
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      sequencename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      sequenceowner = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      dataType = TypoRegtype.get.unsafeGetNullable(rs, i + 3),
      startValue = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      minValue = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      maxValue = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      incrementBy = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      cycle = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 8),
      cacheSize = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9),
      lastValue = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10)
    )
  )
}
