/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opclass

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgOpclassRow(
  oid: PgOpclassId,
  opcmethod: /* oid */ Long,
  opcname: String,
  opcnamespace: /* oid */ Long,
  opcowner: /* oid */ Long,
  opcfamily: /* oid */ Long,
  opcintype: /* oid */ Long,
  opcdefault: Boolean,
  opckeytype: /* oid */ Long
)

object PgOpclassRow {
  implicit val decoder: Decoder[PgOpclassRow] = Decoder.forProduct9[PgOpclassRow, PgOpclassId, /* oid */ Long, String, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, Boolean, /* oid */ Long]("oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype")(PgOpclassRow.apply)(PgOpclassId.decoder, Decoder.decodeLong, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeBoolean, Decoder.decodeLong)
  implicit val encoder: Encoder[PgOpclassRow] = Encoder.forProduct9[PgOpclassRow, PgOpclassId, /* oid */ Long, String, /* oid */ Long, /* oid */ Long, /* oid */ Long, /* oid */ Long, Boolean, /* oid */ Long]("oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype")(x => (x.oid, x.opcmethod, x.opcname, x.opcnamespace, x.opcowner, x.opcfamily, x.opcintype, x.opcdefault, x.opckeytype))(PgOpclassId.encoder, Encoder.encodeLong, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeBoolean, Encoder.encodeLong)
  implicit val read: Read[PgOpclassRow] = new Read[PgOpclassRow](
    gets = List(
      (PgOpclassId.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgOpclassRow(
      oid = PgOpclassId.get.unsafeGetNonNullable(rs, i + 0),
      opcmethod = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      opcname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      opcnamespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      opcowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      opcfamily = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 5),
      opcintype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 6),
      opcdefault = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 7),
      opckeytype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}