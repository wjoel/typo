/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_gssapi

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

case class PgStatGssapiViewRow(
  pid: Option[Int],
  gssAuthenticated: Option[Boolean],
  principal: Option[String],
  encrypted: Option[Boolean]
)

object PgStatGssapiViewRow {
  implicit lazy val reads: Reads[PgStatGssapiViewRow] = Reads[PgStatGssapiViewRow](json => JsResult.fromTry(
      Try(
        PgStatGssapiViewRow(
          pid = json.\("pid").toOption.map(_.as(Reads.IntReads)),
          gssAuthenticated = json.\("gss_authenticated").toOption.map(_.as(Reads.BooleanReads)),
          principal = json.\("principal").toOption.map(_.as(Reads.StringReads)),
          encrypted = json.\("encrypted").toOption.map(_.as(Reads.BooleanReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatGssapiViewRow] = RowParser[PgStatGssapiViewRow] { row =>
    Success(
      PgStatGssapiViewRow(
        pid = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        gssAuthenticated = row(idx + 1)(Column.columnToOption(Column.columnToBoolean)),
        principal = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        encrypted = row(idx + 3)(Column.columnToOption(Column.columnToBoolean))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatGssapiViewRow] = OWrites[PgStatGssapiViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "pid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.pid),
      "gss_authenticated" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.gssAuthenticated),
      "principal" -> Writes.OptionWrites(Writes.StringWrites).writes(o.principal),
      "encrypted" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.encrypted)
    ))
  )
}
