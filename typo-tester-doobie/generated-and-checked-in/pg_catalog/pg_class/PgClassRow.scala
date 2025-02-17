/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import adventureworks.TypoAclItem
import adventureworks.TypoPgNodeTree
import adventureworks.TypoXid
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

case class PgClassRow(
  oid: PgClassId,
  relname: String,
  relnamespace: /* oid */ Long,
  reltype: /* oid */ Long,
  reloftype: /* oid */ Long,
  relowner: /* oid */ Long,
  relam: /* oid */ Long,
  relfilenode: /* oid */ Long,
  reltablespace: /* oid */ Long,
  relpages: Int,
  reltuples: Float,
  relallvisible: Int,
  reltoastrelid: /* oid */ Long,
  relhasindex: Boolean,
  relisshared: Boolean,
  relpersistence: String,
  relkind: String,
  relnatts: Int,
  relchecks: Int,
  relhasrules: Boolean,
  relhastriggers: Boolean,
  relhassubclass: Boolean,
  relrowsecurity: Boolean,
  relforcerowsecurity: Boolean,
  relispopulated: Boolean,
  relreplident: String,
  relispartition: Boolean,
  relrewrite: /* oid */ Long,
  relfrozenxid: TypoXid,
  relminmxid: TypoXid,
  relacl: Option[Array[TypoAclItem]],
  reloptions: Option[Array[String]],
  relpartbound: Option[TypoPgNodeTree]
)

object PgClassRow {
  implicit val decoder: Decoder[PgClassRow] = Decoder.instanceTry[PgClassRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgClassRow(
        oid = orThrow(c.get("oid")(PgClassId.decoder)),
        relname = orThrow(c.get("relname")(Decoder.decodeString)),
        relnamespace = orThrow(c.get("relnamespace")(Decoder.decodeLong)),
        reltype = orThrow(c.get("reltype")(Decoder.decodeLong)),
        reloftype = orThrow(c.get("reloftype")(Decoder.decodeLong)),
        relowner = orThrow(c.get("relowner")(Decoder.decodeLong)),
        relam = orThrow(c.get("relam")(Decoder.decodeLong)),
        relfilenode = orThrow(c.get("relfilenode")(Decoder.decodeLong)),
        reltablespace = orThrow(c.get("reltablespace")(Decoder.decodeLong)),
        relpages = orThrow(c.get("relpages")(Decoder.decodeInt)),
        reltuples = orThrow(c.get("reltuples")(Decoder.decodeFloat)),
        relallvisible = orThrow(c.get("relallvisible")(Decoder.decodeInt)),
        reltoastrelid = orThrow(c.get("reltoastrelid")(Decoder.decodeLong)),
        relhasindex = orThrow(c.get("relhasindex")(Decoder.decodeBoolean)),
        relisshared = orThrow(c.get("relisshared")(Decoder.decodeBoolean)),
        relpersistence = orThrow(c.get("relpersistence")(Decoder.decodeString)),
        relkind = orThrow(c.get("relkind")(Decoder.decodeString)),
        relnatts = orThrow(c.get("relnatts")(Decoder.decodeInt)),
        relchecks = orThrow(c.get("relchecks")(Decoder.decodeInt)),
        relhasrules = orThrow(c.get("relhasrules")(Decoder.decodeBoolean)),
        relhastriggers = orThrow(c.get("relhastriggers")(Decoder.decodeBoolean)),
        relhassubclass = orThrow(c.get("relhassubclass")(Decoder.decodeBoolean)),
        relrowsecurity = orThrow(c.get("relrowsecurity")(Decoder.decodeBoolean)),
        relforcerowsecurity = orThrow(c.get("relforcerowsecurity")(Decoder.decodeBoolean)),
        relispopulated = orThrow(c.get("relispopulated")(Decoder.decodeBoolean)),
        relreplident = orThrow(c.get("relreplident")(Decoder.decodeString)),
        relispartition = orThrow(c.get("relispartition")(Decoder.decodeBoolean)),
        relrewrite = orThrow(c.get("relrewrite")(Decoder.decodeLong)),
        relfrozenxid = orThrow(c.get("relfrozenxid")(TypoXid.decoder)),
        relminmxid = orThrow(c.get("relminmxid")(TypoXid.decoder)),
        relacl = orThrow(c.get("relacl")(Decoder.decodeOption(Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly)))),
        reloptions = orThrow(c.get("reloptions")(Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)))),
        relpartbound = orThrow(c.get("relpartbound")(Decoder.decodeOption(TypoPgNodeTree.decoder)))
      )
    }
  )
  implicit val encoder: Encoder[PgClassRow] = Encoder[PgClassRow](row =>
    Json.obj(
      "oid" -> PgClassId.encoder.apply(row.oid),
      "relname" -> Encoder.encodeString.apply(row.relname),
      "relnamespace" -> Encoder.encodeLong.apply(row.relnamespace),
      "reltype" -> Encoder.encodeLong.apply(row.reltype),
      "reloftype" -> Encoder.encodeLong.apply(row.reloftype),
      "relowner" -> Encoder.encodeLong.apply(row.relowner),
      "relam" -> Encoder.encodeLong.apply(row.relam),
      "relfilenode" -> Encoder.encodeLong.apply(row.relfilenode),
      "reltablespace" -> Encoder.encodeLong.apply(row.reltablespace),
      "relpages" -> Encoder.encodeInt.apply(row.relpages),
      "reltuples" -> Encoder.encodeFloat.apply(row.reltuples),
      "relallvisible" -> Encoder.encodeInt.apply(row.relallvisible),
      "reltoastrelid" -> Encoder.encodeLong.apply(row.reltoastrelid),
      "relhasindex" -> Encoder.encodeBoolean.apply(row.relhasindex),
      "relisshared" -> Encoder.encodeBoolean.apply(row.relisshared),
      "relpersistence" -> Encoder.encodeString.apply(row.relpersistence),
      "relkind" -> Encoder.encodeString.apply(row.relkind),
      "relnatts" -> Encoder.encodeInt.apply(row.relnatts),
      "relchecks" -> Encoder.encodeInt.apply(row.relchecks),
      "relhasrules" -> Encoder.encodeBoolean.apply(row.relhasrules),
      "relhastriggers" -> Encoder.encodeBoolean.apply(row.relhastriggers),
      "relhassubclass" -> Encoder.encodeBoolean.apply(row.relhassubclass),
      "relrowsecurity" -> Encoder.encodeBoolean.apply(row.relrowsecurity),
      "relforcerowsecurity" -> Encoder.encodeBoolean.apply(row.relforcerowsecurity),
      "relispopulated" -> Encoder.encodeBoolean.apply(row.relispopulated),
      "relreplident" -> Encoder.encodeString.apply(row.relreplident),
      "relispartition" -> Encoder.encodeBoolean.apply(row.relispartition),
      "relrewrite" -> Encoder.encodeLong.apply(row.relrewrite),
      "relfrozenxid" -> TypoXid.encoder.apply(row.relfrozenxid),
      "relminmxid" -> TypoXid.encoder.apply(row.relminmxid),
      "relacl" -> Encoder.encodeOption(Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly)).apply(row.relacl),
      "reloptions" -> Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)).apply(row.reloptions),
      "relpartbound" -> Encoder.encodeOption(TypoPgNodeTree.encoder).apply(row.relpartbound)
    )
  )
  implicit val read: Read[PgClassRow] = new Read[PgClassRow](
    gets = List(
      (PgClassId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.FloatMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoXid.get, Nullability.NoNulls),
      (TypoXid.get, Nullability.NoNulls),
      (TypoAclItem.arrayGet, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable),
      (TypoPgNodeTree.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgClassRow(
      oid = PgClassId.get.unsafeGetNonNullable(rs, i + 0),
      relname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      relnamespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      reltype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      reloftype = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      relowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 5),
      relam = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 6),
      relfilenode = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 7),
      reltablespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 8),
      relpages = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 9),
      reltuples = Meta.FloatMeta.get.unsafeGetNonNullable(rs, i + 10),
      relallvisible = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 11),
      reltoastrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 12),
      relhasindex = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 13),
      relisshared = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 14),
      relpersistence = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 15),
      relkind = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 16),
      relnatts = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 17),
      relchecks = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 18),
      relhasrules = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 19),
      relhastriggers = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 20),
      relhassubclass = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 21),
      relrowsecurity = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 22),
      relforcerowsecurity = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 23),
      relispopulated = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 24),
      relreplident = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 25),
      relispartition = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 26),
      relrewrite = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 27),
      relfrozenxid = TypoXid.get.unsafeGetNonNullable(rs, i + 28),
      relminmxid = TypoXid.get.unsafeGetNonNullable(rs, i + 29),
      relacl = TypoAclItem.arrayGet.unsafeGetNullable(rs, i + 30),
      reloptions = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 31),
      relpartbound = TypoPgNodeTree.get.unsafeGetNullable(rs, i + 32)
    )
  )
}
