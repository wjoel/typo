/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

import adventureworks.TypoAclItem
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgLargeobjectMetadataRow(
  oid: PgLargeobjectMetadataId,
  lomowner: /* oid */ Long,
  lomacl: Option[Array[TypoAclItem]]
)

object PgLargeobjectMetadataRow {
  implicit val decoder: Decoder[PgLargeobjectMetadataRow] = Decoder.forProduct3[PgLargeobjectMetadataRow, PgLargeobjectMetadataId, /* oid */ Long, Option[Array[TypoAclItem]]]("oid", "lomowner", "lomacl")(PgLargeobjectMetadataRow.apply)(PgLargeobjectMetadataId.decoder, Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly)))
  implicit val encoder: Encoder[PgLargeobjectMetadataRow] = Encoder.forProduct3[PgLargeobjectMetadataRow, PgLargeobjectMetadataId, /* oid */ Long, Option[Array[TypoAclItem]]]("oid", "lomowner", "lomacl")(x => (x.oid, x.lomowner, x.lomacl))(PgLargeobjectMetadataId.encoder, Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly)))
  implicit val read: Read[PgLargeobjectMetadataRow] = new Read[PgLargeobjectMetadataRow](
    gets = List(
      (PgLargeobjectMetadataId.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoAclItem.arrayGet, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgLargeobjectMetadataRow(
      oid = PgLargeobjectMetadataId.get.unsafeGetNonNullable(rs, i + 0),
      lomowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      lomacl = TypoAclItem.arrayGet.unsafeGetNullable(rs, i + 2)
    )
  )
}
