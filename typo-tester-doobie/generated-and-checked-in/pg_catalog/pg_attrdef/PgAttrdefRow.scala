/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attrdef

import adventureworks.TypoPgNodeTree
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgAttrdefRow(
  oid: PgAttrdefId,
  adrelid: /* oid */ Long,
  adnum: Int,
  adbin: TypoPgNodeTree
)

object PgAttrdefRow {
  implicit val decoder: Decoder[PgAttrdefRow] = Decoder.forProduct4[PgAttrdefRow, PgAttrdefId, /* oid */ Long, Int, TypoPgNodeTree]("oid", "adrelid", "adnum", "adbin")(PgAttrdefRow.apply)(PgAttrdefId.decoder, Decoder.decodeLong, Decoder.decodeInt, TypoPgNodeTree.decoder)
  implicit val encoder: Encoder[PgAttrdefRow] = Encoder.forProduct4[PgAttrdefRow, PgAttrdefId, /* oid */ Long, Int, TypoPgNodeTree]("oid", "adrelid", "adnum", "adbin")(x => (x.oid, x.adrelid, x.adnum, x.adbin))(PgAttrdefId.encoder, Encoder.encodeLong, Encoder.encodeInt, TypoPgNodeTree.encoder)
  implicit val read: Read[PgAttrdefRow] = new Read[PgAttrdefRow](
    gets = List(
      (PgAttrdefId.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoPgNodeTree.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgAttrdefRow(
      oid = PgAttrdefId.get.unsafeGetNonNullable(rs, i + 0),
      adrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      adnum = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      adbin = TypoPgNodeTree.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
