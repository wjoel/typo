/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_transform

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

case class PgTransformRow(
  oid: PgTransformId,
  trftype: /* oid */ Long,
  trflang: /* oid */ Long,
  trffromsql: TypoRegproc,
  trftosql: TypoRegproc
)

object PgTransformRow {
  implicit val reads: Reads[PgTransformRow] = Reads[PgTransformRow](json => JsResult.fromTry(
      Try(
        PgTransformRow(
          oid = json.\("oid").as(PgTransformId.reads),
          trftype = json.\("trftype").as(Reads.LongReads),
          trflang = json.\("trflang").as(Reads.LongReads),
          trffromsql = json.\("trffromsql").as(TypoRegproc.reads),
          trftosql = json.\("trftosql").as(TypoRegproc.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgTransformRow] = RowParser[PgTransformRow] { row =>
    Success(
      PgTransformRow(
        oid = row(idx + 0)(PgTransformId.column),
        trftype = row(idx + 1)(Column.columnToLong),
        trflang = row(idx + 2)(Column.columnToLong),
        trffromsql = row(idx + 3)(TypoRegproc.column),
        trftosql = row(idx + 4)(TypoRegproc.column)
      )
    )
  }
  implicit val writes: OWrites[PgTransformRow] = OWrites[PgTransformRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgTransformId.writes.writes(o.oid),
      "trftype" -> Writes.LongWrites.writes(o.trftype),
      "trflang" -> Writes.LongWrites.writes(o.trflang),
      "trffromsql" -> TypoRegproc.writes.writes(o.trffromsql),
      "trftosql" -> TypoRegproc.writes.writes(o.trftosql)
    ))
  )
}
