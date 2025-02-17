/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_type

import adventureworks.TypoAclItem
import adventureworks.TypoPgNodeTree
import adventureworks.TypoRegproc
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

case class PgTypeRow(
  oid: PgTypeId,
  typname: String,
  typnamespace: /* oid */ Long,
  typowner: /* oid */ Long,
  typlen: Int,
  typbyval: Boolean,
  typtype: String,
  typcategory: String,
  typispreferred: Boolean,
  typisdefined: Boolean,
  typdelim: String,
  typrelid: /* oid */ Long,
  typsubscript: TypoRegproc,
  typelem: /* oid */ Long,
  typarray: /* oid */ Long,
  typinput: TypoRegproc,
  typoutput: TypoRegproc,
  typreceive: TypoRegproc,
  typsend: TypoRegproc,
  typmodin: TypoRegproc,
  typmodout: TypoRegproc,
  typanalyze: TypoRegproc,
  typalign: String,
  typstorage: String,
  typnotnull: Boolean,
  typbasetype: /* oid */ Long,
  typtypmod: Int,
  typndims: Int,
  typcollation: /* oid */ Long,
  typdefaultbin: Option[TypoPgNodeTree],
  typdefault: Option[String],
  typacl: Option[Array[TypoAclItem]]
)

object PgTypeRow {
  implicit val decoder: Decoder[PgTypeRow] = Decoder.instanceTry[PgTypeRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgTypeRow(
        oid = orThrow(c.get("oid")(PgTypeId.decoder)),
        typname = orThrow(c.get("typname")(Decoder.decodeString)),
        typnamespace = orThrow(c.get("typnamespace")(Decoder.decodeLong)),
        typowner = orThrow(c.get("typowner")(Decoder.decodeLong)),
        typlen = orThrow(c.get("typlen")(Decoder.decodeInt)),
        typbyval = orThrow(c.get("typbyval")(Decoder.decodeBoolean)),
        typtype = orThrow(c.get("typtype")(Decoder.decodeString)),
        typcategory = orThrow(c.get("typcategory")(Decoder.decodeString)),
        typispreferred = orThrow(c.get("typispreferred")(Decoder.decodeBoolean)),
        typisdefined = orThrow(c.get("typisdefined")(Decoder.decodeBoolean)),
        typdelim = orThrow(c.get("typdelim")(Decoder.decodeString)),
        typrelid = orThrow(c.get("typrelid")(Decoder.decodeLong)),
        typsubscript = orThrow(c.get("typsubscript")(TypoRegproc.decoder)),
        typelem = orThrow(c.get("typelem")(Decoder.decodeLong)),
        typarray = orThrow(c.get("typarray")(Decoder.decodeLong)),
        typinput = orThrow(c.get("typinput")(TypoRegproc.decoder)),
        typoutput = orThrow(c.get("typoutput")(TypoRegproc.decoder)),
        typreceive = orThrow(c.get("typreceive")(TypoRegproc.decoder)),
        typsend = orThrow(c.get("typsend")(TypoRegproc.decoder)),
        typmodin = orThrow(c.get("typmodin")(TypoRegproc.decoder)),
        typmodout = orThrow(c.get("typmodout")(TypoRegproc.decoder)),
        typanalyze = orThrow(c.get("typanalyze")(TypoRegproc.decoder)),
        typalign = orThrow(c.get("typalign")(Decoder.decodeString)),
        typstorage = orThrow(c.get("typstorage")(Decoder.decodeString)),
        typnotnull = orThrow(c.get("typnotnull")(Decoder.decodeBoolean)),
        typbasetype = orThrow(c.get("typbasetype")(Decoder.decodeLong)),
        typtypmod = orThrow(c.get("typtypmod")(Decoder.decodeInt)),
        typndims = orThrow(c.get("typndims")(Decoder.decodeInt)),
        typcollation = orThrow(c.get("typcollation")(Decoder.decodeLong)),
        typdefaultbin = orThrow(c.get("typdefaultbin")(Decoder.decodeOption(TypoPgNodeTree.decoder))),
        typdefault = orThrow(c.get("typdefault")(Decoder.decodeOption(Decoder.decodeString))),
        typacl = orThrow(c.get("typacl")(Decoder.decodeOption(Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly))))
      )
    }
  )
  implicit val encoder: Encoder[PgTypeRow] = Encoder[PgTypeRow](row =>
    Json.obj(
      "oid" -> PgTypeId.encoder.apply(row.oid),
      "typname" -> Encoder.encodeString.apply(row.typname),
      "typnamespace" -> Encoder.encodeLong.apply(row.typnamespace),
      "typowner" -> Encoder.encodeLong.apply(row.typowner),
      "typlen" -> Encoder.encodeInt.apply(row.typlen),
      "typbyval" -> Encoder.encodeBoolean.apply(row.typbyval),
      "typtype" -> Encoder.encodeString.apply(row.typtype),
      "typcategory" -> Encoder.encodeString.apply(row.typcategory),
      "typispreferred" -> Encoder.encodeBoolean.apply(row.typispreferred),
      "typisdefined" -> Encoder.encodeBoolean.apply(row.typisdefined),
      "typdelim" -> Encoder.encodeString.apply(row.typdelim),
      "typrelid" -> Encoder.encodeLong.apply(row.typrelid),
      "typsubscript" -> TypoRegproc.encoder.apply(row.typsubscript),
      "typelem" -> Encoder.encodeLong.apply(row.typelem),
      "typarray" -> Encoder.encodeLong.apply(row.typarray),
      "typinput" -> TypoRegproc.encoder.apply(row.typinput),
      "typoutput" -> TypoRegproc.encoder.apply(row.typoutput),
      "typreceive" -> TypoRegproc.encoder.apply(row.typreceive),
      "typsend" -> TypoRegproc.encoder.apply(row.typsend),
      "typmodin" -> TypoRegproc.encoder.apply(row.typmodin),
      "typmodout" -> TypoRegproc.encoder.apply(row.typmodout),
      "typanalyze" -> TypoRegproc.encoder.apply(row.typanalyze),
      "typalign" -> Encoder.encodeString.apply(row.typalign),
      "typstorage" -> Encoder.encodeString.apply(row.typstorage),
      "typnotnull" -> Encoder.encodeBoolean.apply(row.typnotnull),
      "typbasetype" -> Encoder.encodeLong.apply(row.typbasetype),
      "typtypmod" -> Encoder.encodeInt.apply(row.typtypmod),
      "typndims" -> Encoder.encodeInt.apply(row.typndims),
      "typcollation" -> Encoder.encodeLong.apply(row.typcollation),
      "typdefaultbin" -> Encoder.encodeOption(TypoPgNodeTree.encoder).apply(row.typdefaultbin),
      "typdefault" -> Encoder.encodeOption(Encoder.encodeString).apply(row.typdefault),
      "typacl" -> Encoder.encodeOption(Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly)).apply(row.typacl)
    )
  )
  implicit val read: Read[PgTypeRow] = new Read[PgTypeRow](
    gets = List(
      (PgTypeId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoPgNodeTree.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoAclItem.arrayGet, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgTypeRow(
      oid = PgTypeId.get.unsafeGetNonNullable(rs, i + 0),
      typname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      typnamespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      typowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      typlen = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      typbyval = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 5),
      typtype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      typcategory = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 7),
      typispreferred = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 8),
      typisdefined = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 9),
      typdelim = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 10),
      typrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 11),
      typsubscript = TypoRegproc.get.unsafeGetNonNullable(rs, i + 12),
      typelem = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 13),
      typarray = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 14),
      typinput = TypoRegproc.get.unsafeGetNonNullable(rs, i + 15),
      typoutput = TypoRegproc.get.unsafeGetNonNullable(rs, i + 16),
      typreceive = TypoRegproc.get.unsafeGetNonNullable(rs, i + 17),
      typsend = TypoRegproc.get.unsafeGetNonNullable(rs, i + 18),
      typmodin = TypoRegproc.get.unsafeGetNonNullable(rs, i + 19),
      typmodout = TypoRegproc.get.unsafeGetNonNullable(rs, i + 20),
      typanalyze = TypoRegproc.get.unsafeGetNonNullable(rs, i + 21),
      typalign = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 22),
      typstorage = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 23),
      typnotnull = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 24),
      typbasetype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 25),
      typtypmod = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 26),
      typndims = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 27),
      typcollation = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 28),
      typdefaultbin = TypoPgNodeTree.get.unsafeGetNullable(rs, i + 29),
      typdefault = Meta.StringMeta.get.unsafeGetNullable(rs, i + 30),
      typacl = TypoAclItem.arrayGet.unsafeGetNullable(rs, i + 31)
    )
  )
}
