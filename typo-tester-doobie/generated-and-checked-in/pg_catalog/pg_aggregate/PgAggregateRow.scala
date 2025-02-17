/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import adventureworks.TypoRegproc
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgAggregateRow(
  aggfnoid: PgAggregateId,
  aggkind: String,
  aggnumdirectargs: Int,
  aggtransfn: TypoRegproc,
  aggfinalfn: TypoRegproc,
  aggcombinefn: TypoRegproc,
  aggserialfn: TypoRegproc,
  aggdeserialfn: TypoRegproc,
  aggmtransfn: TypoRegproc,
  aggminvtransfn: TypoRegproc,
  aggmfinalfn: TypoRegproc,
  aggfinalextra: Boolean,
  aggmfinalextra: Boolean,
  aggfinalmodify: String,
  aggmfinalmodify: String,
  aggsortop: /* oid */ Long,
  aggtranstype: /* oid */ Long,
  aggtransspace: Int,
  aggmtranstype: /* oid */ Long,
  aggmtransspace: Int,
  agginitval: Option[String],
  aggminitval: Option[String]
)

object PgAggregateRow {
  implicit val decoder: Decoder[PgAggregateRow] = Decoder.forProduct22[PgAggregateRow, PgAggregateId, String, Int, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, Boolean, Boolean, String, String, /* oid */ Long, /* oid */ Long, Int, /* oid */ Long, Int, Option[String], Option[String]]("aggfnoid", "aggkind", "aggnumdirectargs", "aggtransfn", "aggfinalfn", "aggcombinefn", "aggserialfn", "aggdeserialfn", "aggmtransfn", "aggminvtransfn", "aggmfinalfn", "aggfinalextra", "aggmfinalextra", "aggfinalmodify", "aggmfinalmodify", "aggsortop", "aggtranstype", "aggtransspace", "aggmtranstype", "aggmtransspace", "agginitval", "aggminitval")(PgAggregateRow.apply)(PgAggregateId.decoder, Decoder.decodeString, Decoder.decodeInt, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeString, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit val encoder: Encoder[PgAggregateRow] = Encoder.forProduct22[PgAggregateRow, PgAggregateId, String, Int, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, TypoRegproc, Boolean, Boolean, String, String, /* oid */ Long, /* oid */ Long, Int, /* oid */ Long, Int, Option[String], Option[String]]("aggfnoid", "aggkind", "aggnumdirectargs", "aggtransfn", "aggfinalfn", "aggcombinefn", "aggserialfn", "aggdeserialfn", "aggmtransfn", "aggminvtransfn", "aggmfinalfn", "aggfinalextra", "aggmfinalextra", "aggfinalmodify", "aggmfinalmodify", "aggsortop", "aggtranstype", "aggtransspace", "aggmtranstype", "aggmtransspace", "agginitval", "aggminitval")(x => (x.aggfnoid, x.aggkind, x.aggnumdirectargs, x.aggtransfn, x.aggfinalfn, x.aggcombinefn, x.aggserialfn, x.aggdeserialfn, x.aggmtransfn, x.aggminvtransfn, x.aggmfinalfn, x.aggfinalextra, x.aggmfinalextra, x.aggfinalmodify, x.aggmfinalmodify, x.aggsortop, x.aggtranstype, x.aggtransspace, x.aggmtranstype, x.aggmtransspace, x.agginitval, x.aggminitval))(PgAggregateId.encoder, Encoder.encodeString, Encoder.encodeInt, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeString, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit val read: Read[PgAggregateRow] = new Read[PgAggregateRow](
    gets = List(
      (PgAggregateId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgAggregateRow(
      aggfnoid = PgAggregateId.get.unsafeGetNonNullable(rs, i + 0),
      aggkind = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      aggnumdirectargs = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      aggtransfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 3),
      aggfinalfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 4),
      aggcombinefn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 5),
      aggserialfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 6),
      aggdeserialfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 7),
      aggmtransfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 8),
      aggminvtransfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 9),
      aggmfinalfn = TypoRegproc.get.unsafeGetNonNullable(rs, i + 10),
      aggfinalextra = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 11),
      aggmfinalextra = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 12),
      aggfinalmodify = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 13),
      aggmfinalmodify = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 14),
      aggsortop = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 15),
      aggtranstype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 16),
      aggtransspace = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 17),
      aggmtranstype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 18),
      aggmtransspace = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 19),
      agginitval = Meta.StringMeta.get.unsafeGetNullable(rs, i + 20),
      aggminitval = Meta.StringMeta.get.unsafeGetNullable(rs, i + 21)
    )
  )
}
