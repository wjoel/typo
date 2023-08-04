/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.currencyrate` which has not been persisted yet */
case class CurrencyrateRowUnsaved(
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
  /** Default: nextval('sales.currencyrate_currencyrateid_seq'::regclass)
      Primary key for CurrencyRate records. */
  currencyrateid: Defaulted[CurrencyrateId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(currencyrateidDefault: => CurrencyrateId, modifieddateDefault: => TypoLocalDateTime): CurrencyrateRow =
    CurrencyrateRow(
      currencyratedate = currencyratedate,
      fromcurrencycode = fromcurrencycode,
      tocurrencycode = tocurrencycode,
      averagerate = averagerate,
      endofdayrate = endofdayrate,
      currencyrateid = currencyrateid match {
                         case Defaulted.UseDefault => currencyrateidDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CurrencyrateRowUnsaved {
  implicit lazy val reads: Reads[CurrencyrateRowUnsaved] = Reads[CurrencyrateRowUnsaved](json => JsResult.fromTry(
      Try(
        CurrencyrateRowUnsaved(
          currencyratedate = json.\("currencyratedate").as(TypoLocalDateTime.reads),
          fromcurrencycode = json.\("fromcurrencycode").as(CurrencyId.reads),
          tocurrencycode = json.\("tocurrencycode").as(CurrencyId.reads),
          averagerate = json.\("averagerate").as(Reads.bigDecReads),
          endofdayrate = json.\("endofdayrate").as(Reads.bigDecReads),
          currencyrateid = json.\("currencyrateid").as(Defaulted.reads(CurrencyrateId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[CurrencyrateRowUnsaved] = OWrites[CurrencyrateRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "currencyratedate" -> TypoLocalDateTime.writes.writes(o.currencyratedate),
      "fromcurrencycode" -> CurrencyId.writes.writes(o.fromcurrencycode),
      "tocurrencycode" -> CurrencyId.writes.writes(o.tocurrencycode),
      "averagerate" -> Writes.BigDecimalWrites.writes(o.averagerate),
      "endofdayrate" -> Writes.BigDecimalWrites.writes(o.endofdayrate),
      "currencyrateid" -> Defaulted.writes(CurrencyrateId.writes).writes(o.currencyrateid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
