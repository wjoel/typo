/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

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

case class PgStatisticRow(
  starelid: /* oid */ Long,
  staattnum: Int,
  stainherit: Boolean,
  stanullfrac: Float,
  stawidth: Int,
  stadistinct: Float,
  stakind1: Int,
  stakind2: Int,
  stakind3: Int,
  stakind4: Int,
  stakind5: Int,
  staop1: /* oid */ Long,
  staop2: /* oid */ Long,
  staop3: /* oid */ Long,
  staop4: /* oid */ Long,
  staop5: /* oid */ Long,
  stacoll1: /* oid */ Long,
  stacoll2: /* oid */ Long,
  stacoll3: /* oid */ Long,
  stacoll4: /* oid */ Long,
  stacoll5: /* oid */ Long,
  stanumbers1: Option[Array[Float]],
  stanumbers2: Option[Array[Float]],
  stanumbers3: Option[Array[Float]],
  stanumbers4: Option[Array[Float]],
  stanumbers5: Option[Array[Float]],
  stavalues1: Option[TypoAnyArray],
  stavalues2: Option[TypoAnyArray],
  stavalues3: Option[TypoAnyArray],
  stavalues4: Option[TypoAnyArray],
  stavalues5: Option[TypoAnyArray]
){
   val compositeId: PgStatisticId = PgStatisticId(starelid, staattnum, stainherit)
 }

object PgStatisticRow {
  implicit val decoder: Decoder[PgStatisticRow] = Decoder.instanceTry[PgStatisticRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgStatisticRow(
        starelid = orThrow(c.get("starelid")(Decoder.decodeLong)),
        staattnum = orThrow(c.get("staattnum")(Decoder.decodeInt)),
        stainherit = orThrow(c.get("stainherit")(Decoder.decodeBoolean)),
        stanullfrac = orThrow(c.get("stanullfrac")(Decoder.decodeFloat)),
        stawidth = orThrow(c.get("stawidth")(Decoder.decodeInt)),
        stadistinct = orThrow(c.get("stadistinct")(Decoder.decodeFloat)),
        stakind1 = orThrow(c.get("stakind1")(Decoder.decodeInt)),
        stakind2 = orThrow(c.get("stakind2")(Decoder.decodeInt)),
        stakind3 = orThrow(c.get("stakind3")(Decoder.decodeInt)),
        stakind4 = orThrow(c.get("stakind4")(Decoder.decodeInt)),
        stakind5 = orThrow(c.get("stakind5")(Decoder.decodeInt)),
        staop1 = orThrow(c.get("staop1")(Decoder.decodeLong)),
        staop2 = orThrow(c.get("staop2")(Decoder.decodeLong)),
        staop3 = orThrow(c.get("staop3")(Decoder.decodeLong)),
        staop4 = orThrow(c.get("staop4")(Decoder.decodeLong)),
        staop5 = orThrow(c.get("staop5")(Decoder.decodeLong)),
        stacoll1 = orThrow(c.get("stacoll1")(Decoder.decodeLong)),
        stacoll2 = orThrow(c.get("stacoll2")(Decoder.decodeLong)),
        stacoll3 = orThrow(c.get("stacoll3")(Decoder.decodeLong)),
        stacoll4 = orThrow(c.get("stacoll4")(Decoder.decodeLong)),
        stacoll5 = orThrow(c.get("stacoll5")(Decoder.decodeLong)),
        stanumbers1 = orThrow(c.get("stanumbers1")(Decoder.decodeOption(Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly)))),
        stanumbers2 = orThrow(c.get("stanumbers2")(Decoder.decodeOption(Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly)))),
        stanumbers3 = orThrow(c.get("stanumbers3")(Decoder.decodeOption(Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly)))),
        stanumbers4 = orThrow(c.get("stanumbers4")(Decoder.decodeOption(Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly)))),
        stanumbers5 = orThrow(c.get("stanumbers5")(Decoder.decodeOption(Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly)))),
        stavalues1 = orThrow(c.get("stavalues1")(Decoder.decodeOption(TypoAnyArray.decoder))),
        stavalues2 = orThrow(c.get("stavalues2")(Decoder.decodeOption(TypoAnyArray.decoder))),
        stavalues3 = orThrow(c.get("stavalues3")(Decoder.decodeOption(TypoAnyArray.decoder))),
        stavalues4 = orThrow(c.get("stavalues4")(Decoder.decodeOption(TypoAnyArray.decoder))),
        stavalues5 = orThrow(c.get("stavalues5")(Decoder.decodeOption(TypoAnyArray.decoder)))
      )
    }
  )
  implicit val encoder: Encoder[PgStatisticRow] = Encoder[PgStatisticRow](row =>
    Json.obj(
      "starelid" -> Encoder.encodeLong.apply(row.starelid),
      "staattnum" -> Encoder.encodeInt.apply(row.staattnum),
      "stainherit" -> Encoder.encodeBoolean.apply(row.stainherit),
      "stanullfrac" -> Encoder.encodeFloat.apply(row.stanullfrac),
      "stawidth" -> Encoder.encodeInt.apply(row.stawidth),
      "stadistinct" -> Encoder.encodeFloat.apply(row.stadistinct),
      "stakind1" -> Encoder.encodeInt.apply(row.stakind1),
      "stakind2" -> Encoder.encodeInt.apply(row.stakind2),
      "stakind3" -> Encoder.encodeInt.apply(row.stakind3),
      "stakind4" -> Encoder.encodeInt.apply(row.stakind4),
      "stakind5" -> Encoder.encodeInt.apply(row.stakind5),
      "staop1" -> Encoder.encodeLong.apply(row.staop1),
      "staop2" -> Encoder.encodeLong.apply(row.staop2),
      "staop3" -> Encoder.encodeLong.apply(row.staop3),
      "staop4" -> Encoder.encodeLong.apply(row.staop4),
      "staop5" -> Encoder.encodeLong.apply(row.staop5),
      "stacoll1" -> Encoder.encodeLong.apply(row.stacoll1),
      "stacoll2" -> Encoder.encodeLong.apply(row.stacoll2),
      "stacoll3" -> Encoder.encodeLong.apply(row.stacoll3),
      "stacoll4" -> Encoder.encodeLong.apply(row.stacoll4),
      "stacoll5" -> Encoder.encodeLong.apply(row.stacoll5),
      "stanumbers1" -> Encoder.encodeOption(Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly)).apply(row.stanumbers1),
      "stanumbers2" -> Encoder.encodeOption(Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly)).apply(row.stanumbers2),
      "stanumbers3" -> Encoder.encodeOption(Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly)).apply(row.stanumbers3),
      "stanumbers4" -> Encoder.encodeOption(Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly)).apply(row.stanumbers4),
      "stanumbers5" -> Encoder.encodeOption(Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly)).apply(row.stanumbers5),
      "stavalues1" -> Encoder.encodeOption(TypoAnyArray.encoder).apply(row.stavalues1),
      "stavalues2" -> Encoder.encodeOption(TypoAnyArray.encoder).apply(row.stavalues2),
      "stavalues3" -> Encoder.encodeOption(TypoAnyArray.encoder).apply(row.stavalues3),
      "stavalues4" -> Encoder.encodeOption(TypoAnyArray.encoder).apply(row.stavalues4),
      "stavalues5" -> Encoder.encodeOption(TypoAnyArray.encoder).apply(row.stavalues5)
    )
  )
  implicit val read: Read[PgStatisticRow] = new Read[PgStatisticRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.FloatMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.FloatMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (adventureworks.FloatArrayMeta.get, Nullability.Nullable),
      (adventureworks.FloatArrayMeta.get, Nullability.Nullable),
      (adventureworks.FloatArrayMeta.get, Nullability.Nullable),
      (adventureworks.FloatArrayMeta.get, Nullability.Nullable),
      (adventureworks.FloatArrayMeta.get, Nullability.Nullable),
      (TypoAnyArray.get, Nullability.Nullable),
      (TypoAnyArray.get, Nullability.Nullable),
      (TypoAnyArray.get, Nullability.Nullable),
      (TypoAnyArray.get, Nullability.Nullable),
      (TypoAnyArray.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatisticRow(
      starelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      staattnum = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      stainherit = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 2),
      stanullfrac = Meta.FloatMeta.get.unsafeGetNonNullable(rs, i + 3),
      stawidth = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      stadistinct = Meta.FloatMeta.get.unsafeGetNonNullable(rs, i + 5),
      stakind1 = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      stakind2 = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      stakind3 = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 8),
      stakind4 = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 9),
      stakind5 = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 10),
      staop1 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 11),
      staop2 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 12),
      staop3 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 13),
      staop4 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 14),
      staop5 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 15),
      stacoll1 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 16),
      stacoll2 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 17),
      stacoll3 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 18),
      stacoll4 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 19),
      stacoll5 = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 20),
      stanumbers1 = adventureworks.FloatArrayMeta.get.unsafeGetNullable(rs, i + 21),
      stanumbers2 = adventureworks.FloatArrayMeta.get.unsafeGetNullable(rs, i + 22),
      stanumbers3 = adventureworks.FloatArrayMeta.get.unsafeGetNullable(rs, i + 23),
      stanumbers4 = adventureworks.FloatArrayMeta.get.unsafeGetNullable(rs, i + 24),
      stanumbers5 = adventureworks.FloatArrayMeta.get.unsafeGetNullable(rs, i + 25),
      stavalues1 = TypoAnyArray.get.unsafeGetNullable(rs, i + 26),
      stavalues2 = TypoAnyArray.get.unsafeGetNullable(rs, i + 27),
      stavalues3 = TypoAnyArray.get.unsafeGetNullable(rs, i + 28),
      stavalues4 = TypoAnyArray.get.unsafeGetNullable(rs, i + 29),
      stavalues5 = TypoAnyArray.get.unsafeGetNullable(rs, i + 30)
    )
  )
}
