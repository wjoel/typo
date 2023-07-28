/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgPublicationRow(
  oid: PgPublicationId,
  pubname: String,
  pubowner: /* oid */ Long,
  puballtables: Boolean,
  pubinsert: Boolean,
  pubupdate: Boolean,
  pubdelete: Boolean,
  pubtruncate: Boolean,
  pubviaroot: Boolean
)

object PgPublicationRow {
  implicit val decoder: Decoder[PgPublicationRow] = Decoder.forProduct9[PgPublicationRow, PgPublicationId, String, /* oid */ Long, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean]("oid", "pubname", "pubowner", "puballtables", "pubinsert", "pubupdate", "pubdelete", "pubtruncate", "pubviaroot")(PgPublicationRow.apply)(PgPublicationId.decoder, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeBoolean)
  implicit val encoder: Encoder[PgPublicationRow] = Encoder.forProduct9[PgPublicationRow, PgPublicationId, String, /* oid */ Long, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean]("oid", "pubname", "pubowner", "puballtables", "pubinsert", "pubupdate", "pubdelete", "pubtruncate", "pubviaroot")(x => (x.oid, x.pubname, x.pubowner, x.puballtables, x.pubinsert, x.pubupdate, x.pubdelete, x.pubtruncate, x.pubviaroot))(PgPublicationId.encoder, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeBoolean)
  implicit val read: Read[PgPublicationRow] = new Read[PgPublicationRow](
    gets = List(
      (PgPublicationId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgPublicationRow(
      oid = PgPublicationId.get.unsafeGetNonNullable(rs, i + 0),
      pubname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      pubowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      puballtables = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 3),
      pubinsert = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 4),
      pubupdate = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 5),
      pubdelete = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 6),
      pubtruncate = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 7),
      pubviaroot = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
