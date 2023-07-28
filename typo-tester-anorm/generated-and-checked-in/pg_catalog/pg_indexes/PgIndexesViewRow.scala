/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_indexes

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

case class PgIndexesViewRow(
  schemaname: Option[String],
  tablename: Option[String],
  indexname: Option[String],
  tablespace: Option[String],
  indexdef: Option[String]
)

object PgIndexesViewRow {
  implicit val reads: Reads[PgIndexesViewRow] = Reads[PgIndexesViewRow](json => JsResult.fromTry(
      Try(
        PgIndexesViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          tablename = json.\("tablename").toOption.map(_.as(Reads.StringReads)),
          indexname = json.\("indexname").toOption.map(_.as(Reads.StringReads)),
          tablespace = json.\("tablespace").toOption.map(_.as(Reads.StringReads)),
          indexdef = json.\("indexdef").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgIndexesViewRow] = RowParser[PgIndexesViewRow] { row =>
    Success(
      PgIndexesViewRow(
        schemaname = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        tablename = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        indexname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        tablespace = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        indexdef = row(idx + 4)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit val writes: OWrites[PgIndexesViewRow] = OWrites[PgIndexesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "tablename" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tablename),
      "indexname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.indexname),
      "tablespace" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tablespace),
      "indexdef" -> Writes.OptionWrites(Writes.StringWrites).writes(o.indexdef)
    ))
  )
}
