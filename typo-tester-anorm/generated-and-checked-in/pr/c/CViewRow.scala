/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import adventureworks.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.public.Name
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

case class CViewRow(
  id: Option[/* bpchar */ String],
  /** Points to [[production.culture.CultureRow.cultureid]] */
  cultureid: Option[CultureId],
  /** Points to [[production.culture.CultureRow.name]] */
  name: Option[Name],
  /** Points to [[production.culture.CultureRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CViewRow {
  implicit lazy val reads: Reads[CViewRow] = Reads[CViewRow](json => JsResult.fromTry(
      Try(
        CViewRow(
          id = json.\("id").toOption.map(_.as(Reads.StringReads)),
          cultureid = json.\("cultureid").toOption.map(_.as(CultureId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CViewRow] = RowParser[CViewRow] { row =>
    Success(
      CViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        cultureid = row(idx + 1)(Column.columnToOption(CultureId.column)),
        name = row(idx + 2)(Column.columnToOption(Name.column)),
        modifieddate = row(idx + 3)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[CViewRow] = OWrites[CViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.StringWrites).writes(o.id),
      "cultureid" -> Writes.OptionWrites(CultureId.writes).writes(o.cultureid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
