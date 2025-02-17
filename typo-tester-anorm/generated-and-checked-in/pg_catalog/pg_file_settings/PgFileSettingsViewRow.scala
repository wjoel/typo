/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_file_settings

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

case class PgFileSettingsViewRow(
  sourcefile: Option[String],
  sourceline: Option[Int],
  seqno: Option[Int],
  name: Option[String],
  setting: Option[String],
  applied: Option[Boolean],
  error: Option[String]
)

object PgFileSettingsViewRow {
  implicit lazy val reads: Reads[PgFileSettingsViewRow] = Reads[PgFileSettingsViewRow](json => JsResult.fromTry(
      Try(
        PgFileSettingsViewRow(
          sourcefile = json.\("sourcefile").toOption.map(_.as(Reads.StringReads)),
          sourceline = json.\("sourceline").toOption.map(_.as(Reads.IntReads)),
          seqno = json.\("seqno").toOption.map(_.as(Reads.IntReads)),
          name = json.\("name").toOption.map(_.as(Reads.StringReads)),
          setting = json.\("setting").toOption.map(_.as(Reads.StringReads)),
          applied = json.\("applied").toOption.map(_.as(Reads.BooleanReads)),
          error = json.\("error").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgFileSettingsViewRow] = RowParser[PgFileSettingsViewRow] { row =>
    Success(
      PgFileSettingsViewRow(
        sourcefile = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        sourceline = row(idx + 1)(Column.columnToOption(Column.columnToInt)),
        seqno = row(idx + 2)(Column.columnToOption(Column.columnToInt)),
        name = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        setting = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        applied = row(idx + 5)(Column.columnToOption(Column.columnToBoolean)),
        error = row(idx + 6)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgFileSettingsViewRow] = OWrites[PgFileSettingsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "sourcefile" -> Writes.OptionWrites(Writes.StringWrites).writes(o.sourcefile),
      "sourceline" -> Writes.OptionWrites(Writes.IntWrites).writes(o.sourceline),
      "seqno" -> Writes.OptionWrites(Writes.IntWrites).writes(o.seqno),
      "name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.name),
      "setting" -> Writes.OptionWrites(Writes.StringWrites).writes(o.setting),
      "applied" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.applied),
      "error" -> Writes.OptionWrites(Writes.StringWrites).writes(o.error)
    ))
  )
}
