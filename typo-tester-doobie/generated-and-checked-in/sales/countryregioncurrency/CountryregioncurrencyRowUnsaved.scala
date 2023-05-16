/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.Defaulted
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import java.time.LocalDateTime

/** This class corresponds to a row in table `sales.countryregioncurrency` which has not been persisted yet */
case class CountryregioncurrencyRowUnsaved(
  /** ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** ISO standard currency code. Foreign key to Currency.CurrencyCode.
      Points to [[currency.CurrencyRow.currencycode]] */
  currencycode: CurrencyId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): CountryregioncurrencyRow =
    CountryregioncurrencyRow(
      countryregioncode = countryregioncode,
      currencycode = currencycode,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}

