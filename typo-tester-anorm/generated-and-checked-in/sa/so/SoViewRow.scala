/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import adventureworks.TypoLocalDateTime
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class SoViewRow(
  id: Option[Int],
  /** Points to [[sales.specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: Option[SpecialofferId],
  /** Points to [[sales.specialoffer.SpecialofferRow.description]] */
  description: Option[/* max 255 chars */ String],
  /** Points to [[sales.specialoffer.SpecialofferRow.discountpct]] */
  discountpct: Option[BigDecimal],
  /** Points to [[sales.specialoffer.SpecialofferRow.type]] */
  `type`: Option[/* max 50 chars */ String],
  /** Points to [[sales.specialoffer.SpecialofferRow.category]] */
  category: Option[/* max 50 chars */ String],
  /** Points to [[sales.specialoffer.SpecialofferRow.startdate]] */
  startdate: Option[TypoLocalDateTime],
  /** Points to [[sales.specialoffer.SpecialofferRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[sales.specialoffer.SpecialofferRow.minqty]] */
  minqty: Option[Int],
  /** Points to [[sales.specialoffer.SpecialofferRow.maxqty]] */
  maxqty: Option[Int],
  /** Points to [[sales.specialoffer.SpecialofferRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.specialoffer.SpecialofferRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SoViewRow {
  implicit lazy val reads: Reads[SoViewRow] = Reads[SoViewRow](json => JsResult.fromTry(
      Try(
        SoViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          specialofferid = json.\("specialofferid").toOption.map(_.as(SpecialofferId.reads)),
          description = json.\("description").toOption.map(_.as(Reads.StringReads)),
          discountpct = json.\("discountpct").toOption.map(_.as(Reads.bigDecReads)),
          `type` = json.\("type").toOption.map(_.as(Reads.StringReads)),
          category = json.\("category").toOption.map(_.as(Reads.StringReads)),
          startdate = json.\("startdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          minqty = json.\("minqty").toOption.map(_.as(Reads.IntReads)),
          maxqty = json.\("maxqty").toOption.map(_.as(Reads.IntReads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SoViewRow] = RowParser[SoViewRow] { row =>
    Success(
      SoViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        specialofferid = row(idx + 1)(Column.columnToOption(SpecialofferId.column)),
        description = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        discountpct = row(idx + 3)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        `type` = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        category = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        startdate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column)),
        enddate = row(idx + 7)(Column.columnToOption(TypoLocalDateTime.column)),
        minqty = row(idx + 8)(Column.columnToOption(Column.columnToInt)),
        maxqty = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        rowguid = row(idx + 10)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 11)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[SoViewRow] = OWrites[SoViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "specialofferid" -> Writes.OptionWrites(SpecialofferId.writes).writes(o.specialofferid),
      "description" -> Writes.OptionWrites(Writes.StringWrites).writes(o.description),
      "discountpct" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.discountpct),
      "type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`type`),
      "category" -> Writes.OptionWrites(Writes.StringWrites).writes(o.category),
      "startdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "minqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.minqty),
      "maxqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.maxqty),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
