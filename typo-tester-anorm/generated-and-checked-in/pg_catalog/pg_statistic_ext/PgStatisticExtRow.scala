/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
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

case class PgStatisticExtRow(
  oid: PgStatisticExtId,
  stxrelid: /* oid */ Long,
  stxname: String,
  stxnamespace: /* oid */ Long,
  stxowner: /* oid */ Long,
  stxstattarget: Int,
  stxkeys: TypoInt2Vector,
  stxkind: Array[String],
  stxexprs: Option[TypoPgNodeTree]
)

object PgStatisticExtRow {
  implicit lazy val reads: Reads[PgStatisticExtRow] = Reads[PgStatisticExtRow](json => JsResult.fromTry(
      Try(
        PgStatisticExtRow(
          oid = json.\("oid").as(PgStatisticExtId.reads),
          stxrelid = json.\("stxrelid").as(Reads.LongReads),
          stxname = json.\("stxname").as(Reads.StringReads),
          stxnamespace = json.\("stxnamespace").as(Reads.LongReads),
          stxowner = json.\("stxowner").as(Reads.LongReads),
          stxstattarget = json.\("stxstattarget").as(Reads.IntReads),
          stxkeys = json.\("stxkeys").as(TypoInt2Vector.reads),
          stxkind = json.\("stxkind").as(Reads.ArrayReads[String](Reads.StringReads, implicitly)),
          stxexprs = json.\("stxexprs").toOption.map(_.as(TypoPgNodeTree.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatisticExtRow] = RowParser[PgStatisticExtRow] { row =>
    Success(
      PgStatisticExtRow(
        oid = row(idx + 0)(PgStatisticExtId.column),
        stxrelid = row(idx + 1)(Column.columnToLong),
        stxname = row(idx + 2)(Column.columnToString),
        stxnamespace = row(idx + 3)(Column.columnToLong),
        stxowner = row(idx + 4)(Column.columnToLong),
        stxstattarget = row(idx + 5)(Column.columnToInt),
        stxkeys = row(idx + 6)(TypoInt2Vector.column),
        stxkind = row(idx + 7)(Column.columnToArray[String](Column.columnToString, implicitly)),
        stxexprs = row(idx + 8)(Column.columnToOption(TypoPgNodeTree.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatisticExtRow] = OWrites[PgStatisticExtRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgStatisticExtId.writes.writes(o.oid),
      "stxrelid" -> Writes.LongWrites.writes(o.stxrelid),
      "stxname" -> Writes.StringWrites.writes(o.stxname),
      "stxnamespace" -> Writes.LongWrites.writes(o.stxnamespace),
      "stxowner" -> Writes.LongWrites.writes(o.stxowner),
      "stxstattarget" -> Writes.IntWrites.writes(o.stxstattarget),
      "stxkeys" -> TypoInt2Vector.writes.writes(o.stxkeys),
      "stxkind" -> Writes.arrayWrites[String](implicitly, Writes.StringWrites).writes(o.stxkind),
      "stxexprs" -> Writes.OptionWrites(TypoPgNodeTree.writes).writes(o.stxexprs)
    ))
  )
}
