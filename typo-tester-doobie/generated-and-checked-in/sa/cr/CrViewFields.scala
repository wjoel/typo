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
import typo.dsl.SqlExpr.OptField

trait CrViewFields[Row] {
  val currencyrateid: OptField[CurrencyrateId, Row]
  val currencyratedate: OptField[TypoLocalDateTime, Row]
  val fromcurrencycode: OptField[CurrencyId, Row]
  val tocurrencycode: OptField[CurrencyId, Row]
  val averagerate: OptField[BigDecimal, Row]
  val endofdayrate: OptField[BigDecimal, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object CrViewFields extends CrViewStructure[CrViewRow](None, identity, (_, x) => x)

