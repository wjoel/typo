/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_dict

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

case class PgTsDictRow(
  oid: PgTsDictId,
  dictname: String,
  dictnamespace: /* oid */ Long,
  dictowner: /* oid */ Long,
  dicttemplate: /* oid */ Long,
  dictinitoption: Option[String]
)

object PgTsDictRow {
  implicit val reads: Reads[PgTsDictRow] = Reads[PgTsDictRow](json => JsResult.fromTry(
      Try(
        PgTsDictRow(
          oid = json.\("oid").as(PgTsDictId.reads),
          dictname = json.\("dictname").as(Reads.StringReads),
          dictnamespace = json.\("dictnamespace").as(Reads.LongReads),
          dictowner = json.\("dictowner").as(Reads.LongReads),
          dicttemplate = json.\("dicttemplate").as(Reads.LongReads),
          dictinitoption = json.\("dictinitoption").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgTsDictRow] = RowParser[PgTsDictRow] { row =>
    Success(
      PgTsDictRow(
        oid = row(idx + 0)(PgTsDictId.column),
        dictname = row(idx + 1)(Column.columnToString),
        dictnamespace = row(idx + 2)(Column.columnToLong),
        dictowner = row(idx + 3)(Column.columnToLong),
        dicttemplate = row(idx + 4)(Column.columnToLong),
        dictinitoption = row(idx + 5)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit val writes: OWrites[PgTsDictRow] = OWrites[PgTsDictRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgTsDictId.writes.writes(o.oid),
      "dictname" -> Writes.StringWrites.writes(o.dictname),
      "dictnamespace" -> Writes.LongWrites.writes(o.dictnamespace),
      "dictowner" -> Writes.LongWrites.writes(o.dictowner),
      "dicttemplate" -> Writes.LongWrites.writes(o.dicttemplate),
      "dictinitoption" -> Writes.OptionWrites(Writes.StringWrites).writes(o.dictinitoption)
    ))
  )
}
