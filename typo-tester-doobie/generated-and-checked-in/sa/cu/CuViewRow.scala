/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import adventureworks.public.Name
import adventureworks.sales.currency.CurrencyId
import java.time.LocalDateTime

case class CuViewRow(
  id: Option[/* bpchar */ String],
  /** Points to [[sales.currency.CurrencyRow.currencycode]] */
  currencycode: Option[CurrencyId],
  /** Points to [[sales.currency.CurrencyRow.name]] */
  name: Option[Name],
  /** Points to [[sales.currency.CurrencyRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)


