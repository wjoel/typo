/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

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

case class PgAmopRow(
  oid: PgAmopId,
  amopfamily: /* oid */ Long,
  amoplefttype: /* oid */ Long,
  amoprighttype: /* oid */ Long,
  amopstrategy: Int,
  amoppurpose: String,
  amopopr: /* oid */ Long,
  amopmethod: /* oid */ Long,
  amopsortfamily: /* oid */ Long
)

object PgAmopRow {
  implicit lazy val reads: Reads[PgAmopRow] = Reads[PgAmopRow](json => JsResult.fromTry(
      Try(
        PgAmopRow(
          oid = json.\("oid").as(PgAmopId.reads),
          amopfamily = json.\("amopfamily").as(Reads.LongReads),
          amoplefttype = json.\("amoplefttype").as(Reads.LongReads),
          amoprighttype = json.\("amoprighttype").as(Reads.LongReads),
          amopstrategy = json.\("amopstrategy").as(Reads.IntReads),
          amoppurpose = json.\("amoppurpose").as(Reads.StringReads),
          amopopr = json.\("amopopr").as(Reads.LongReads),
          amopmethod = json.\("amopmethod").as(Reads.LongReads),
          amopsortfamily = json.\("amopsortfamily").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAmopRow] = RowParser[PgAmopRow] { row =>
    Success(
      PgAmopRow(
        oid = row(idx + 0)(PgAmopId.column),
        amopfamily = row(idx + 1)(Column.columnToLong),
        amoplefttype = row(idx + 2)(Column.columnToLong),
        amoprighttype = row(idx + 3)(Column.columnToLong),
        amopstrategy = row(idx + 4)(Column.columnToInt),
        amoppurpose = row(idx + 5)(Column.columnToString),
        amopopr = row(idx + 6)(Column.columnToLong),
        amopmethod = row(idx + 7)(Column.columnToLong),
        amopsortfamily = row(idx + 8)(Column.columnToLong)
      )
    )
  }
  implicit lazy val writes: OWrites[PgAmopRow] = OWrites[PgAmopRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgAmopId.writes.writes(o.oid),
      "amopfamily" -> Writes.LongWrites.writes(o.amopfamily),
      "amoplefttype" -> Writes.LongWrites.writes(o.amoplefttype),
      "amoprighttype" -> Writes.LongWrites.writes(o.amoprighttype),
      "amopstrategy" -> Writes.IntWrites.writes(o.amopstrategy),
      "amoppurpose" -> Writes.StringWrites.writes(o.amoppurpose),
      "amopopr" -> Writes.LongWrites.writes(o.amopopr),
      "amopmethod" -> Writes.LongWrites.writes(o.amopmethod),
      "amopsortfamily" -> Writes.LongWrites.writes(o.amopsortfamily)
    ))
  )
}
