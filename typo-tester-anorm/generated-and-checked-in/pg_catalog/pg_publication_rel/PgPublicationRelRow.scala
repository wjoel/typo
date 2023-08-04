/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

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

case class PgPublicationRelRow(
  oid: PgPublicationRelId,
  prpubid: /* oid */ Long,
  prrelid: /* oid */ Long
)

object PgPublicationRelRow {
  implicit lazy val reads: Reads[PgPublicationRelRow] = Reads[PgPublicationRelRow](json => JsResult.fromTry(
      Try(
        PgPublicationRelRow(
          oid = json.\("oid").as(PgPublicationRelId.reads),
          prpubid = json.\("prpubid").as(Reads.LongReads),
          prrelid = json.\("prrelid").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPublicationRelRow] = RowParser[PgPublicationRelRow] { row =>
    Success(
      PgPublicationRelRow(
        oid = row(idx + 0)(PgPublicationRelId.column),
        prpubid = row(idx + 1)(Column.columnToLong),
        prrelid = row(idx + 2)(Column.columnToLong)
      )
    )
  }
  implicit lazy val writes: OWrites[PgPublicationRelRow] = OWrites[PgPublicationRelRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgPublicationRelId.writes.writes(o.oid),
      "prpubid" -> Writes.LongWrites.writes(o.prpubid),
      "prrelid" -> Writes.LongWrites.writes(o.prrelid)
    ))
  )
}