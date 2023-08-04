/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

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

case class PgInheritsRow(
  inhrelid: /* oid */ Long,
  inhparent: /* oid */ Long,
  inhseqno: Int,
  inhdetachpending: Boolean
){
   val compositeId: PgInheritsId = PgInheritsId(inhrelid, inhseqno)
 }

object PgInheritsRow {
  implicit lazy val reads: Reads[PgInheritsRow] = Reads[PgInheritsRow](json => JsResult.fromTry(
      Try(
        PgInheritsRow(
          inhrelid = json.\("inhrelid").as(Reads.LongReads),
          inhparent = json.\("inhparent").as(Reads.LongReads),
          inhseqno = json.\("inhseqno").as(Reads.IntReads),
          inhdetachpending = json.\("inhdetachpending").as(Reads.BooleanReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgInheritsRow] = RowParser[PgInheritsRow] { row =>
    Success(
      PgInheritsRow(
        inhrelid = row(idx + 0)(Column.columnToLong),
        inhparent = row(idx + 1)(Column.columnToLong),
        inhseqno = row(idx + 2)(Column.columnToInt),
        inhdetachpending = row(idx + 3)(Column.columnToBoolean)
      )
    )
  }
  implicit lazy val writes: OWrites[PgInheritsRow] = OWrites[PgInheritsRow](o =>
    new JsObject(ListMap[String, JsValue](
      "inhrelid" -> Writes.LongWrites.writes(o.inhrelid),
      "inhparent" -> Writes.LongWrites.writes(o.inhparent),
      "inhseqno" -> Writes.IntWrites.writes(o.inhseqno),
      "inhdetachpending" -> Writes.BooleanWrites.writes(o.inhdetachpending)
    ))
  )
}
