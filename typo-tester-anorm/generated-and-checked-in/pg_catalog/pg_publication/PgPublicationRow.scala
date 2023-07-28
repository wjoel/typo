/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

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

case class PgPublicationRow(
  oid: PgPublicationId,
  pubname: String,
  pubowner: /* oid */ Long,
  puballtables: Boolean,
  pubinsert: Boolean,
  pubupdate: Boolean,
  pubdelete: Boolean,
  pubtruncate: Boolean,
  pubviaroot: Boolean
)

object PgPublicationRow {
  implicit val reads: Reads[PgPublicationRow] = Reads[PgPublicationRow](json => JsResult.fromTry(
      Try(
        PgPublicationRow(
          oid = json.\("oid").as(PgPublicationId.reads),
          pubname = json.\("pubname").as(Reads.StringReads),
          pubowner = json.\("pubowner").as(Reads.LongReads),
          puballtables = json.\("puballtables").as(Reads.BooleanReads),
          pubinsert = json.\("pubinsert").as(Reads.BooleanReads),
          pubupdate = json.\("pubupdate").as(Reads.BooleanReads),
          pubdelete = json.\("pubdelete").as(Reads.BooleanReads),
          pubtruncate = json.\("pubtruncate").as(Reads.BooleanReads),
          pubviaroot = json.\("pubviaroot").as(Reads.BooleanReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPublicationRow] = RowParser[PgPublicationRow] { row =>
    Success(
      PgPublicationRow(
        oid = row(idx + 0)(PgPublicationId.column),
        pubname = row(idx + 1)(Column.columnToString),
        pubowner = row(idx + 2)(Column.columnToLong),
        puballtables = row(idx + 3)(Column.columnToBoolean),
        pubinsert = row(idx + 4)(Column.columnToBoolean),
        pubupdate = row(idx + 5)(Column.columnToBoolean),
        pubdelete = row(idx + 6)(Column.columnToBoolean),
        pubtruncate = row(idx + 7)(Column.columnToBoolean),
        pubviaroot = row(idx + 8)(Column.columnToBoolean)
      )
    )
  }
  implicit val writes: OWrites[PgPublicationRow] = OWrites[PgPublicationRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgPublicationId.writes.writes(o.oid),
      "pubname" -> Writes.StringWrites.writes(o.pubname),
      "pubowner" -> Writes.LongWrites.writes(o.pubowner),
      "puballtables" -> Writes.BooleanWrites.writes(o.puballtables),
      "pubinsert" -> Writes.BooleanWrites.writes(o.pubinsert),
      "pubupdate" -> Writes.BooleanWrites.writes(o.pubupdate),
      "pubdelete" -> Writes.BooleanWrites.writes(o.pubdelete),
      "pubtruncate" -> Writes.BooleanWrites.writes(o.pubtruncate),
      "pubviaroot" -> Writes.BooleanWrites.writes(o.pubviaroot)
    ))
  )
}
