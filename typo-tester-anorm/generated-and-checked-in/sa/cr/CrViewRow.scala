/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import adventureworks.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
import adventureworks.sales.currencyrate.CurrencyrateId
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

case class CrViewRow(
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyratedate]] */
  currencyratedate: Option[TypoLocalDateTime],
  /** Points to [[sales.currencyrate.CurrencyrateRow.fromcurrencycode]] */
  fromcurrencycode: Option[CurrencyId],
  /** Points to [[sales.currencyrate.CurrencyrateRow.tocurrencycode]] */
  tocurrencycode: Option[CurrencyId],
  /** Points to [[sales.currencyrate.CurrencyrateRow.averagerate]] */
  averagerate: Option[BigDecimal],
  /** Points to [[sales.currencyrate.CurrencyrateRow.endofdayrate]] */
  endofdayrate: Option[BigDecimal],
  /** Points to [[sales.currencyrate.CurrencyrateRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CrViewRow {
  implicit val reads: Reads[CrViewRow] = Reads[CrViewRow](json => JsResult.fromTry(
      Try(
        CrViewRow(
          currencyrateid = json.\("currencyrateid").toOption.map(_.as(CurrencyrateId.reads)),
          currencyratedate = json.\("currencyratedate").toOption.map(_.as(TypoLocalDateTime.reads)),
          fromcurrencycode = json.\("fromcurrencycode").toOption.map(_.as(CurrencyId.reads)),
          tocurrencycode = json.\("tocurrencycode").toOption.map(_.as(CurrencyId.reads)),
          averagerate = json.\("averagerate").toOption.map(_.as(Reads.bigDecReads)),
          endofdayrate = json.\("endofdayrate").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CrViewRow] = RowParser[CrViewRow] { row =>
    Success(
      CrViewRow(
        currencyrateid = row(idx + 0)(Column.columnToOption(CurrencyrateId.column)),
        currencyratedate = row(idx + 1)(Column.columnToOption(TypoLocalDateTime.column)),
        fromcurrencycode = row(idx + 2)(Column.columnToOption(CurrencyId.column)),
        tocurrencycode = row(idx + 3)(Column.columnToOption(CurrencyId.column)),
        averagerate = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        endofdayrate = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit val writes: OWrites[CrViewRow] = OWrites[CrViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "currencyrateid" -> Writes.OptionWrites(CurrencyrateId.writes).writes(o.currencyrateid),
      "currencyratedate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.currencyratedate),
      "fromcurrencycode" -> Writes.OptionWrites(CurrencyId.writes).writes(o.fromcurrencycode),
      "tocurrencycode" -> Writes.OptionWrites(CurrencyId.writes).writes(o.tocurrencycode),
      "averagerate" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.averagerate),
      "endofdayrate" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.endofdayrate),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
