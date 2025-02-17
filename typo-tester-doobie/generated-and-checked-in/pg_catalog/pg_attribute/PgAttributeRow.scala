/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

import adventureworks.TypoAclItem
import adventureworks.TypoAnyArray
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

case class PgAttributeRow(
  attrelid: /* oid */ Long,
  attname: String,
  atttypid: /* oid */ Long,
  attstattarget: Int,
  attlen: Int,
  attnum: Int,
  attndims: Int,
  attcacheoff: Int,
  atttypmod: Int,
  attbyval: Boolean,
  attalign: String,
  attstorage: String,
  attcompression: String,
  attnotnull: Boolean,
  atthasdef: Boolean,
  atthasmissing: Boolean,
  attidentity: String,
  attgenerated: String,
  attisdropped: Boolean,
  attislocal: Boolean,
  attinhcount: Int,
  attcollation: /* oid */ Long,
  attacl: Option[Array[TypoAclItem]],
  attoptions: Option[Array[String]],
  attfdwoptions: Option[Array[String]],
  attmissingval: Option[TypoAnyArray]
){
   val compositeId: PgAttributeId = PgAttributeId(attrelid, attnum)
 }

object PgAttributeRow {
  implicit val decoder: Decoder[PgAttributeRow] = Decoder.instanceTry[PgAttributeRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgAttributeRow(
        attrelid = orThrow(c.get("attrelid")(Decoder.decodeLong)),
        attname = orThrow(c.get("attname")(Decoder.decodeString)),
        atttypid = orThrow(c.get("atttypid")(Decoder.decodeLong)),
        attstattarget = orThrow(c.get("attstattarget")(Decoder.decodeInt)),
        attlen = orThrow(c.get("attlen")(Decoder.decodeInt)),
        attnum = orThrow(c.get("attnum")(Decoder.decodeInt)),
        attndims = orThrow(c.get("attndims")(Decoder.decodeInt)),
        attcacheoff = orThrow(c.get("attcacheoff")(Decoder.decodeInt)),
        atttypmod = orThrow(c.get("atttypmod")(Decoder.decodeInt)),
        attbyval = orThrow(c.get("attbyval")(Decoder.decodeBoolean)),
        attalign = orThrow(c.get("attalign")(Decoder.decodeString)),
        attstorage = orThrow(c.get("attstorage")(Decoder.decodeString)),
        attcompression = orThrow(c.get("attcompression")(Decoder.decodeString)),
        attnotnull = orThrow(c.get("attnotnull")(Decoder.decodeBoolean)),
        atthasdef = orThrow(c.get("atthasdef")(Decoder.decodeBoolean)),
        atthasmissing = orThrow(c.get("atthasmissing")(Decoder.decodeBoolean)),
        attidentity = orThrow(c.get("attidentity")(Decoder.decodeString)),
        attgenerated = orThrow(c.get("attgenerated")(Decoder.decodeString)),
        attisdropped = orThrow(c.get("attisdropped")(Decoder.decodeBoolean)),
        attislocal = orThrow(c.get("attislocal")(Decoder.decodeBoolean)),
        attinhcount = orThrow(c.get("attinhcount")(Decoder.decodeInt)),
        attcollation = orThrow(c.get("attcollation")(Decoder.decodeLong)),
        attacl = orThrow(c.get("attacl")(Decoder.decodeOption(Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly)))),
        attoptions = orThrow(c.get("attoptions")(Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)))),
        attfdwoptions = orThrow(c.get("attfdwoptions")(Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)))),
        attmissingval = orThrow(c.get("attmissingval")(Decoder.decodeOption(TypoAnyArray.decoder)))
      )
    }
  )
  implicit val encoder: Encoder[PgAttributeRow] = Encoder[PgAttributeRow](row =>
    Json.obj(
      "attrelid" -> Encoder.encodeLong.apply(row.attrelid),
      "attname" -> Encoder.encodeString.apply(row.attname),
      "atttypid" -> Encoder.encodeLong.apply(row.atttypid),
      "attstattarget" -> Encoder.encodeInt.apply(row.attstattarget),
      "attlen" -> Encoder.encodeInt.apply(row.attlen),
      "attnum" -> Encoder.encodeInt.apply(row.attnum),
      "attndims" -> Encoder.encodeInt.apply(row.attndims),
      "attcacheoff" -> Encoder.encodeInt.apply(row.attcacheoff),
      "atttypmod" -> Encoder.encodeInt.apply(row.atttypmod),
      "attbyval" -> Encoder.encodeBoolean.apply(row.attbyval),
      "attalign" -> Encoder.encodeString.apply(row.attalign),
      "attstorage" -> Encoder.encodeString.apply(row.attstorage),
      "attcompression" -> Encoder.encodeString.apply(row.attcompression),
      "attnotnull" -> Encoder.encodeBoolean.apply(row.attnotnull),
      "atthasdef" -> Encoder.encodeBoolean.apply(row.atthasdef),
      "atthasmissing" -> Encoder.encodeBoolean.apply(row.atthasmissing),
      "attidentity" -> Encoder.encodeString.apply(row.attidentity),
      "attgenerated" -> Encoder.encodeString.apply(row.attgenerated),
      "attisdropped" -> Encoder.encodeBoolean.apply(row.attisdropped),
      "attislocal" -> Encoder.encodeBoolean.apply(row.attislocal),
      "attinhcount" -> Encoder.encodeInt.apply(row.attinhcount),
      "attcollation" -> Encoder.encodeLong.apply(row.attcollation),
      "attacl" -> Encoder.encodeOption(Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly)).apply(row.attacl),
      "attoptions" -> Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)).apply(row.attoptions),
      "attfdwoptions" -> Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)).apply(row.attfdwoptions),
      "attmissingval" -> Encoder.encodeOption(TypoAnyArray.encoder).apply(row.attmissingval)
    )
  )
  implicit val read: Read[PgAttributeRow] = new Read[PgAttributeRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoAclItem.arrayGet, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable),
      (TypoAnyArray.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgAttributeRow(
      attrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      attname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      atttypid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      attstattarget = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      attlen = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      attnum = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 5),
      attndims = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      attcacheoff = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      atttypmod = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 8),
      attbyval = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 9),
      attalign = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 10),
      attstorage = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 11),
      attcompression = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 12),
      attnotnull = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 13),
      atthasdef = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 14),
      atthasmissing = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 15),
      attidentity = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 16),
      attgenerated = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 17),
      attisdropped = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 18),
      attislocal = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 19),
      attinhcount = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 20),
      attcollation = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 21),
      attacl = TypoAclItem.arrayGet.unsafeGetNullable(rs, i + 22),
      attoptions = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 23),
      attfdwoptions = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 24),
      attmissingval = TypoAnyArray.get.unsafeGetNullable(rs, i + 25)
    )
  )
}
