/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import adventureworks.TypoRegproc
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

case class PgConversionRow(
  oid: PgConversionId,
  conname: String,
  connamespace: /* oid */ Long,
  conowner: /* oid */ Long,
  conforencoding: Int,
  contoencoding: Int,
  conproc: TypoRegproc,
  condefault: Boolean
)

object PgConversionRow {
  implicit lazy val reads: Reads[PgConversionRow] = Reads[PgConversionRow](json => JsResult.fromTry(
      Try(
        PgConversionRow(
          oid = json.\("oid").as(PgConversionId.reads),
          conname = json.\("conname").as(Reads.StringReads),
          connamespace = json.\("connamespace").as(Reads.LongReads),
          conowner = json.\("conowner").as(Reads.LongReads),
          conforencoding = json.\("conforencoding").as(Reads.IntReads),
          contoencoding = json.\("contoencoding").as(Reads.IntReads),
          conproc = json.\("conproc").as(TypoRegproc.reads),
          condefault = json.\("condefault").as(Reads.BooleanReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgConversionRow] = RowParser[PgConversionRow] { row =>
    Success(
      PgConversionRow(
        oid = row(idx + 0)(PgConversionId.column),
        conname = row(idx + 1)(Column.columnToString),
        connamespace = row(idx + 2)(Column.columnToLong),
        conowner = row(idx + 3)(Column.columnToLong),
        conforencoding = row(idx + 4)(Column.columnToInt),
        contoencoding = row(idx + 5)(Column.columnToInt),
        conproc = row(idx + 6)(TypoRegproc.column),
        condefault = row(idx + 7)(Column.columnToBoolean)
      )
    )
  }
  implicit lazy val writes: OWrites[PgConversionRow] = OWrites[PgConversionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgConversionId.writes.writes(o.oid),
      "conname" -> Writes.StringWrites.writes(o.conname),
      "connamespace" -> Writes.LongWrites.writes(o.connamespace),
      "conowner" -> Writes.LongWrites.writes(o.conowner),
      "conforencoding" -> Writes.IntWrites.writes(o.conforencoding),
      "contoencoding" -> Writes.IntWrites.writes(o.contoencoding),
      "conproc" -> TypoRegproc.writes.writes(o.conproc),
      "condefault" -> Writes.BooleanWrites.writes(o.condefault)
    ))
  )
}
