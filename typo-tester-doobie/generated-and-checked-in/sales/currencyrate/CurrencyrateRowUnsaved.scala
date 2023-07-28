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
import io.circe.Decoder
import io.circe.Encoder

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
  implicit val decoder: Decoder[CurrencyrateRowUnsaved] = Decoder.forProduct7[CurrencyrateRowUnsaved, TypoLocalDateTime, CurrencyId, CurrencyId, BigDecimal, BigDecimal, Defaulted[CurrencyrateId], Defaulted[TypoLocalDateTime]]("currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "currencyrateid", "modifieddate")(CurrencyrateRowUnsaved.apply)(TypoLocalDateTime.decoder, CurrencyId.decoder, CurrencyId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Defaulted.decoder(CurrencyrateId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[CurrencyrateRowUnsaved] = Encoder.forProduct7[CurrencyrateRowUnsaved, TypoLocalDateTime, CurrencyId, CurrencyId, BigDecimal, BigDecimal, Defaulted[CurrencyrateId], Defaulted[TypoLocalDateTime]]("currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "currencyrateid", "modifieddate")(x => (x.currencyratedate, x.fromcurrencycode, x.tocurrencycode, x.averagerate, x.endofdayrate, x.currencyrateid, x.modifieddate))(TypoLocalDateTime.encoder, CurrencyId.encoder, CurrencyId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Defaulted.encoder(CurrencyrateId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
}
