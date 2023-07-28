/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_indexes

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

case class PgStatUserIndexesViewRow(
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.indexrelid]] */
  indexrelid: Option[/* oid */ Long],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.indexrelname]] */
  indexrelname: Option[String],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxScan]] */
  idxScan: Option[Long],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxTupRead]] */
  idxTupRead: Option[Long],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxTupFetch]] */
  idxTupFetch: Option[Long]
)

object PgStatUserIndexesViewRow {
  implicit val reads: Reads[PgStatUserIndexesViewRow] = Reads[PgStatUserIndexesViewRow](json => JsResult.fromTry(
      Try(
        PgStatUserIndexesViewRow(
          relid = json.\("relid").toOption.map(_.as(Reads.LongReads)),
          indexrelid = json.\("indexrelid").toOption.map(_.as(Reads.LongReads)),
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          relname = json.\("relname").toOption.map(_.as(Reads.StringReads)),
          indexrelname = json.\("indexrelname").toOption.map(_.as(Reads.StringReads)),
          idxScan = json.\("idx_scan").toOption.map(_.as(Reads.LongReads)),
          idxTupRead = json.\("idx_tup_read").toOption.map(_.as(Reads.LongReads)),
          idxTupFetch = json.\("idx_tup_fetch").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatUserIndexesViewRow] = RowParser[PgStatUserIndexesViewRow] { row =>
    Success(
      PgStatUserIndexesViewRow(
        relid = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        indexrelid = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        schemaname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        relname = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        indexrelname = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        idxScan = row(idx + 5)(Column.columnToOption(Column.columnToLong)),
        idxTupRead = row(idx + 6)(Column.columnToOption(Column.columnToLong)),
        idxTupFetch = row(idx + 7)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit val writes: OWrites[PgStatUserIndexesViewRow] = OWrites[PgStatUserIndexesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.relid),
      "indexrelid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.indexrelid),
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "relname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.relname),
      "indexrelname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.indexrelname),
      "idx_scan" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxScan),
      "idx_tup_read" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxTupRead),
      "idx_tup_fetch" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxTupFetch)
    ))
  )
}
