/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_group

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

case class PgGroupViewRow(
  groname: Option[String],
  grosysid: Option[/* oid */ Long],
  grolist: Option[Array[/* oid */ Long]]
)

object PgGroupViewRow {
  implicit lazy val reads: Reads[PgGroupViewRow] = Reads[PgGroupViewRow](json => JsResult.fromTry(
      Try(
        PgGroupViewRow(
          groname = json.\("groname").toOption.map(_.as(Reads.StringReads)),
          grosysid = json.\("grosysid").toOption.map(_.as(Reads.LongReads)),
          grolist = json.\("grolist").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgGroupViewRow] = RowParser[PgGroupViewRow] { row =>
    Success(
      PgGroupViewRow(
        groname = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        grosysid = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        grolist = row(idx + 2)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly)))
      )
    )
  }
  implicit lazy val writes: OWrites[PgGroupViewRow] = OWrites[PgGroupViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "groname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.groname),
      "grosysid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.grosysid),
      "grolist" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.grolist)
    ))
  )
}
