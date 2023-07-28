/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import adventureworks.TypoRegproc
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgRangeRow(
  rngtypid: PgRangeId,
  rngsubtype: /* oid */ Long,
  rngmultitypid: /* oid */ Long,
  rngcollation: /* oid */ Long,
  rngsubopc: /* oid */ Long,
  rngcanonical: TypoRegproc,
  rngsubdiff: TypoRegproc
)

object PgRangeRow {
  implicit val decoder: Decoder[PgRangeRow] = Decoder.forProduct7[PgRangeRow, PgRangeId, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, TypoRegproc, TypoRegproc]("rngtypid", "rngsubtype", "rngmultitypid", "rngcollation", "rngsubopc", "rngcanonical", "rngsubdiff")(PgRangeRow.apply)(PgRangeId.decoder, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, TypoRegproc.decoder, TypoRegproc.decoder)
  implicit val encoder: Encoder[PgRangeRow] = Encoder.forProduct7[PgRangeRow, PgRangeId, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, TypoRegproc, TypoRegproc]("rngtypid", "rngsubtype", "rngmultitypid", "rngcollation", "rngsubopc", "rngcanonical", "rngsubdiff")(x => (x.rngtypid, x.rngsubtype, x.rngmultitypid, x.rngcollation, x.rngsubopc, x.rngcanonical, x.rngsubdiff))(PgRangeId.encoder, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, TypoRegproc.encoder, TypoRegproc.encoder)
  implicit val read: Read[PgRangeRow] = new Read[PgRangeRow](
    gets = List(
      (PgRangeId.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgRangeRow(
      rngtypid = PgRangeId.get.unsafeGetNonNullable(rs, i + 0),
      rngsubtype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      rngmultitypid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      rngcollation = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      rngsubopc = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      rngcanonical = TypoRegproc.get.unsafeGetNonNullable(rs, i + 5),
      rngsubdiff = TypoRegproc.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
