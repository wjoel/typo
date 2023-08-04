/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import adventureworks.TypoAnyArray
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
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
  implicit lazy val reads: Reads[PgStatisticRow] = Reads[PgStatisticRow](json => JsResult.fromTry(
      Try(
        PgStatisticRow(
          starelid = json.\("starelid").as(Reads.LongReads),
          staattnum = json.\("staattnum").as(Reads.IntReads),
          stainherit = json.\("stainherit").as(Reads.BooleanReads),
          stanullfrac = json.\("stanullfrac").as(Reads.FloatReads),
          stawidth = json.\("stawidth").as(Reads.IntReads),
          stadistinct = json.\("stadistinct").as(Reads.FloatReads),
          stakind1 = json.\("stakind1").as(Reads.IntReads),
          stakind2 = json.\("stakind2").as(Reads.IntReads),
          stakind3 = json.\("stakind3").as(Reads.IntReads),
          stakind4 = json.\("stakind4").as(Reads.IntReads),
          stakind5 = json.\("stakind5").as(Reads.IntReads),
          staop1 = json.\("staop1").as(Reads.LongReads),
          staop2 = json.\("staop2").as(Reads.LongReads),
          staop3 = json.\("staop3").as(Reads.LongReads),
          staop4 = json.\("staop4").as(Reads.LongReads),
          staop5 = json.\("staop5").as(Reads.LongReads),
          stacoll1 = json.\("stacoll1").as(Reads.LongReads),
          stacoll2 = json.\("stacoll2").as(Reads.LongReads),
          stacoll3 = json.\("stacoll3").as(Reads.LongReads),
          stacoll4 = json.\("stacoll4").as(Reads.LongReads),
          stacoll5 = json.\("stacoll5").as(Reads.LongReads),
          stanumbers1 = json.\("stanumbers1").toOption.map(_.as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly))),
          stanumbers2 = json.\("stanumbers2").toOption.map(_.as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly))),
          stanumbers3 = json.\("stanumbers3").toOption.map(_.as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly))),
          stanumbers4 = json.\("stanumbers4").toOption.map(_.as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly))),
          stanumbers5 = json.\("stanumbers5").toOption.map(_.as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly))),
          stavalues1 = json.\("stavalues1").toOption.map(_.as(TypoAnyArray.reads)),
          stavalues2 = json.\("stavalues2").toOption.map(_.as(TypoAnyArray.reads)),
          stavalues3 = json.\("stavalues3").toOption.map(_.as(TypoAnyArray.reads)),
          stavalues4 = json.\("stavalues4").toOption.map(_.as(TypoAnyArray.reads)),
          stavalues5 = json.\("stavalues5").toOption.map(_.as(TypoAnyArray.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatisticRow] = RowParser[PgStatisticRow] { row =>
    Success(
      PgStatisticRow(
        starelid = row(idx + 0)(Column.columnToLong),
        staattnum = row(idx + 1)(Column.columnToInt),
        stainherit = row(idx + 2)(Column.columnToBoolean),
        stanullfrac = row(idx + 3)(Column.columnToFloat),
        stawidth = row(idx + 4)(Column.columnToInt),
        stadistinct = row(idx + 5)(Column.columnToFloat),
        stakind1 = row(idx + 6)(Column.columnToInt),
        stakind2 = row(idx + 7)(Column.columnToInt),
        stakind3 = row(idx + 8)(Column.columnToInt),
        stakind4 = row(idx + 9)(Column.columnToInt),
        stakind5 = row(idx + 10)(Column.columnToInt),
        staop1 = row(idx + 11)(Column.columnToLong),
        staop2 = row(idx + 12)(Column.columnToLong),
        staop3 = row(idx + 13)(Column.columnToLong),
        staop4 = row(idx + 14)(Column.columnToLong),
        staop5 = row(idx + 15)(Column.columnToLong),
        stacoll1 = row(idx + 16)(Column.columnToLong),
        stacoll2 = row(idx + 17)(Column.columnToLong),
        stacoll3 = row(idx + 18)(Column.columnToLong),
        stacoll4 = row(idx + 19)(Column.columnToLong),
        stacoll5 = row(idx + 20)(Column.columnToLong),
        stanumbers1 = row(idx + 21)(Column.columnToOption(Column.columnToArray[Float](Column.columnToFloat, implicitly))),
        stanumbers2 = row(idx + 22)(Column.columnToOption(Column.columnToArray[Float](Column.columnToFloat, implicitly))),
        stanumbers3 = row(idx + 23)(Column.columnToOption(Column.columnToArray[Float](Column.columnToFloat, implicitly))),
        stanumbers4 = row(idx + 24)(Column.columnToOption(Column.columnToArray[Float](Column.columnToFloat, implicitly))),
        stanumbers5 = row(idx + 25)(Column.columnToOption(Column.columnToArray[Float](Column.columnToFloat, implicitly))),
        stavalues1 = row(idx + 26)(Column.columnToOption(TypoAnyArray.column)),
        stavalues2 = row(idx + 27)(Column.columnToOption(TypoAnyArray.column)),
        stavalues3 = row(idx + 28)(Column.columnToOption(TypoAnyArray.column)),
        stavalues4 = row(idx + 29)(Column.columnToOption(TypoAnyArray.column)),
        stavalues5 = row(idx + 30)(Column.columnToOption(TypoAnyArray.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatisticRow] = OWrites[PgStatisticRow](o =>
    new JsObject(ListMap[String, JsValue](
      "starelid" -> Writes.LongWrites.writes(o.starelid),
      "staattnum" -> Writes.IntWrites.writes(o.staattnum),
      "stainherit" -> Writes.BooleanWrites.writes(o.stainherit),
      "stanullfrac" -> Writes.FloatWrites.writes(o.stanullfrac),
      "stawidth" -> Writes.IntWrites.writes(o.stawidth),
      "stadistinct" -> Writes.FloatWrites.writes(o.stadistinct),
      "stakind1" -> Writes.IntWrites.writes(o.stakind1),
      "stakind2" -> Writes.IntWrites.writes(o.stakind2),
      "stakind3" -> Writes.IntWrites.writes(o.stakind3),
      "stakind4" -> Writes.IntWrites.writes(o.stakind4),
      "stakind5" -> Writes.IntWrites.writes(o.stakind5),
      "staop1" -> Writes.LongWrites.writes(o.staop1),
      "staop2" -> Writes.LongWrites.writes(o.staop2),
      "staop3" -> Writes.LongWrites.writes(o.staop3),
      "staop4" -> Writes.LongWrites.writes(o.staop4),
      "staop5" -> Writes.LongWrites.writes(o.staop5),
      "stacoll1" -> Writes.LongWrites.writes(o.stacoll1),
      "stacoll2" -> Writes.LongWrites.writes(o.stacoll2),
      "stacoll3" -> Writes.LongWrites.writes(o.stacoll3),
      "stacoll4" -> Writes.LongWrites.writes(o.stacoll4),
      "stacoll5" -> Writes.LongWrites.writes(o.stacoll5),
      "stanumbers1" -> Writes.OptionWrites(Writes.arrayWrites[Float](implicitly, Writes.FloatWrites)).writes(o.stanumbers1),
      "stanumbers2" -> Writes.OptionWrites(Writes.arrayWrites[Float](implicitly, Writes.FloatWrites)).writes(o.stanumbers2),
      "stanumbers3" -> Writes.OptionWrites(Writes.arrayWrites[Float](implicitly, Writes.FloatWrites)).writes(o.stanumbers3),
      "stanumbers4" -> Writes.OptionWrites(Writes.arrayWrites[Float](implicitly, Writes.FloatWrites)).writes(o.stanumbers4),
      "stanumbers5" -> Writes.OptionWrites(Writes.arrayWrites[Float](implicitly, Writes.FloatWrites)).writes(o.stanumbers5),
      "stavalues1" -> Writes.OptionWrites(TypoAnyArray.writes).writes(o.stavalues1),
      "stavalues2" -> Writes.OptionWrites(TypoAnyArray.writes).writes(o.stavalues2),
      "stavalues3" -> Writes.OptionWrites(TypoAnyArray.writes).writes(o.stavalues3),
      "stavalues4" -> Writes.OptionWrites(TypoAnyArray.writes).writes(o.stavalues4),
      "stavalues5" -> Writes.OptionWrites(TypoAnyArray.writes).writes(o.stavalues5)
    ))
  )
}
