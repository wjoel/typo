/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import adventureworks.TypoRegproc
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgOperatorRow(
  oid: PgOperatorId,
  oprname: String,
  oprnamespace: /* oid */ Long,
  oprowner: /* oid */ Long,
  oprkind: String,
  oprcanmerge: Boolean,
  oprcanhash: Boolean,
  oprleft: /* oid */ Long,
  oprright: /* oid */ Long,
  oprresult: /* oid */ Long,
  oprcom: /* oid */ Long,
  oprnegate: /* oid */ Long,
  oprcode: TypoRegproc,
  oprrest: TypoRegproc,
  oprjoin: TypoRegproc
)

object PgOperatorRow {
  implicit val decoder: Decoder[PgOperatorRow] = Decoder.forProduct15[PgOperatorRow, PgOperatorId, String, /* oid */ Long, /* oid */ Long, String, Boolean, Boolean, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, TypoRegproc, TypoRegproc, TypoRegproc]("oid", "oprname", "oprnamespace", "oprowner", "oprkind", "oprcanmerge", "oprcanhash", "oprleft", "oprright", "oprresult", "oprcom", "oprnegate", "oprcode", "oprrest", "oprjoin")(PgOperatorRow.apply)(PgOperatorId.decoder, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, TypoRegproc.decoder, TypoRegproc.decoder, TypoRegproc.decoder)
  implicit val encoder: Encoder[PgOperatorRow] = Encoder.forProduct15[PgOperatorRow, PgOperatorId, String, /* oid */ Long, /* oid */ Long, String, Boolean, Boolean, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, TypoRegproc, TypoRegproc, TypoRegproc]("oid", "oprname", "oprnamespace", "oprowner", "oprkind", "oprcanmerge", "oprcanhash", "oprleft", "oprright", "oprresult", "oprcom", "oprnegate", "oprcode", "oprrest", "oprjoin")(x => (x.oid, x.oprname, x.oprnamespace, x.oprowner, x.oprkind, x.oprcanmerge, x.oprcanhash, x.oprleft, x.oprright, x.oprresult, x.oprcom, x.oprnegate, x.oprcode, x.oprrest, x.oprjoin))(PgOperatorId.encoder, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, TypoRegproc.encoder, TypoRegproc.encoder, TypoRegproc.encoder)
  implicit val read: Read[PgOperatorRow] = new Read[PgOperatorRow](
    gets = List(
      (PgOperatorId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgOperatorRow(
      oid = PgOperatorId.get.unsafeGetNonNullable(rs, i + 0),
      oprname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      oprnamespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      oprowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      oprkind = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      oprcanmerge = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 5),
      oprcanhash = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 6),
      oprleft = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 7),
      oprright = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 8),
      oprresult = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 9),
      oprcom = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 10),
      oprnegate = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 11),
      oprcode = TypoRegproc.get.unsafeGetNonNullable(rs, i + 12),
      oprrest = TypoRegproc.get.unsafeGetNonNullable(rs, i + 13),
      oprjoin = TypoRegproc.get.unsafeGetNonNullable(rs, i + 14)
    )
  )
}
