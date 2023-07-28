/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class CurrencyRow(
  /** The ISO code for the Currency. */
  currencycode: CurrencyId,
  /** Currency name. */
  name: Name,
  modifieddate: TypoLocalDateTime
)

object CurrencyRow {
  implicit val reads: Reads[CurrencyRow] = Reads[CurrencyRow](json => JsResult.fromTry(
      Try(
        CurrencyRow(
          currencycode = json.\("currencycode").as(CurrencyId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CurrencyRow] = RowParser[CurrencyRow] { row =>
    Success(
      CurrencyRow(
        currencycode = row(idx + 0)(CurrencyId.column),
        name = row(idx + 1)(Name.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit val writes: OWrites[CurrencyRow] = OWrites[CurrencyRow](o =>
    new JsObject(ListMap[String, JsValue](
      "currencycode" -> CurrencyId.writes.writes(o.currencycode),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
