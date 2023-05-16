/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime

/** This class corresponds to a row in table `sales.currency` which has not been persisted yet */
case class CurrencyRowUnsaved(
  /** The ISO code for the Currency. */
  currencycode: CurrencyId,
  /** Currency name. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): CurrencyRow =
    CurrencyRow(
      currencycode = currencycode,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}

