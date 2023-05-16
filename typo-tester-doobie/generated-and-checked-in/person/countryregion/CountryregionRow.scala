/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.public.Name
import java.time.LocalDateTime

case class CountryregionRow(
  /** ISO standard code for countries and regions. */
  countryregioncode: CountryregionId,
  /** Country or region name. */
  name: Name,
  modifieddate: LocalDateTime
)


