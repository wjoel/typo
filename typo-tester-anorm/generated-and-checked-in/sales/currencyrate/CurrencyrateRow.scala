/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import adventureworks.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
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

case class CurrencyrateRow(
  /** Primary key for CurrencyRate records. */
  currencyrateid: CurrencyrateId,
  /** Date and time the exchange rate was obtained. */
  currencyratedate: TypoLocalDateTime,
  /** Exchange rate was converted from this currency code.
      Points to [[currency.CurrencyRow.currencycode]] */
  fromcurrencycode: CurrencyId,
  /** Exchange rate was converted to this currency code.
      Points to [[currency.CurrencyRow.currencycode]] */
  tocurrencycode: CurrencyId,
  /** Average exchange rate for the day. */
  averagerate: BigDecimal,
  /** Final exchange rate for the day. */
  endofdayrate: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object CurrencyrateRow {
  implicit lazy val reads: Reads[CurrencyrateRow] = Reads[CurrencyrateRow](json => JsResult.fromTry(
      Try(
        CurrencyrateRow(
          currencyrateid = json.\("currencyrateid").as(CurrencyrateId.reads),
          currencyratedate = json.\("currencyratedate").as(TypoLocalDateTime.reads),
          fromcurrencycode = json.\("fromcurrencycode").as(CurrencyId.reads),
          tocurrencycode = json.\("tocurrencycode").as(CurrencyId.reads),
          averagerate = json.\("averagerate").as(Reads.bigDecReads),
          endofdayrate = json.\("endofdayrate").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CurrencyrateRow] = RowParser[CurrencyrateRow] { row =>
    Success(
      CurrencyrateRow(
        currencyrateid = row(idx + 0)(CurrencyrateId.column),
        currencyratedate = row(idx + 1)(TypoLocalDateTime.column),
        fromcurrencycode = row(idx + 2)(CurrencyId.column),
        tocurrencycode = row(idx + 3)(CurrencyId.column),
        averagerate = row(idx + 4)(Column.columnToScalaBigDecimal),
        endofdayrate = row(idx + 5)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 6)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[CurrencyrateRow] = OWrites[CurrencyrateRow](o =>
    new JsObject(ListMap[String, JsValue](
      "currencyrateid" -> CurrencyrateId.writes.writes(o.currencyrateid),
      "currencyratedate" -> TypoLocalDateTime.writes.writes(o.currencyratedate),
      "fromcurrencycode" -> CurrencyId.writes.writes(o.fromcurrencycode),
      "tocurrencycode" -> CurrencyId.writes.writes(o.tocurrencycode),
      "averagerate" -> Writes.BigDecimalWrites.writes(o.averagerate),
      "endofdayrate" -> Writes.BigDecimalWrites.writes(o.endofdayrate),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
