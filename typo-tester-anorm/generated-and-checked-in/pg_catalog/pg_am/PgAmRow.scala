/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

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

case class PgAmRow(
  oid: PgAmId,
  amname: String,
  amhandler: TypoRegproc,
  amtype: String
)

object PgAmRow {
  implicit lazy val reads: Reads[PgAmRow] = Reads[PgAmRow](json => JsResult.fromTry(
      Try(
        PgAmRow(
          oid = json.\("oid").as(PgAmId.reads),
          amname = json.\("amname").as(Reads.StringReads),
          amhandler = json.\("amhandler").as(TypoRegproc.reads),
          amtype = json.\("amtype").as(Reads.StringReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAmRow] = RowParser[PgAmRow] { row =>
    Success(
      PgAmRow(
        oid = row(idx + 0)(PgAmId.column),
        amname = row(idx + 1)(Column.columnToString),
        amhandler = row(idx + 2)(TypoRegproc.column),
        amtype = row(idx + 3)(Column.columnToString)
      )
    )
  }
  implicit lazy val writes: OWrites[PgAmRow] = OWrites[PgAmRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgAmId.writes.writes(o.oid),
      "amname" -> Writes.StringWrites.writes(o.amname),
      "amhandler" -> TypoRegproc.writes.writes(o.amhandler),
      "amtype" -> Writes.StringWrites.writes(o.amtype)
    ))
  )
}
