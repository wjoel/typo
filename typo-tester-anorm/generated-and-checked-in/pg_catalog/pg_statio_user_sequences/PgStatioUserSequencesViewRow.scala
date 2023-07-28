/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_sequences

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

case class PgStatioUserSequencesViewRow(
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.blksRead]] */
  blksRead: Option[Long],
  /** Points to [[pg_statio_all_sequences.PgStatioAllSequencesViewRow.blksHit]] */
  blksHit: Option[Long]
)

object PgStatioUserSequencesViewRow {
  implicit val reads: Reads[PgStatioUserSequencesViewRow] = Reads[PgStatioUserSequencesViewRow](json => JsResult.fromTry(
      Try(
        PgStatioUserSequencesViewRow(
          relid = json.\("relid").toOption.map(_.as(Reads.LongReads)),
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          relname = json.\("relname").toOption.map(_.as(Reads.StringReads)),
          blksRead = json.\("blks_read").toOption.map(_.as(Reads.LongReads)),
          blksHit = json.\("blks_hit").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatioUserSequencesViewRow] = RowParser[PgStatioUserSequencesViewRow] { row =>
    Success(
      PgStatioUserSequencesViewRow(
        relid = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        schemaname = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        relname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        blksRead = row(idx + 3)(Column.columnToOption(Column.columnToLong)),
        blksHit = row(idx + 4)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit val writes: OWrites[PgStatioUserSequencesViewRow] = OWrites[PgStatioUserSequencesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.relid),
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "relname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.relname),
      "blks_read" -> Writes.OptionWrites(Writes.LongWrites).writes(o.blksRead),
      "blks_hit" -> Writes.OptionWrites(Writes.LongWrites).writes(o.blksHit)
    ))
  )
}
