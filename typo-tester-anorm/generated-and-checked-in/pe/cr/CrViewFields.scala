/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import typo.dsl.SqlExpr.OptField

trait CrViewFields[Row] {
  val countryregioncode: OptField[CountryregionId, Row]
  val name: OptField[Name, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object CrViewFields extends CrViewStructure[CrViewRow](None, identity, (_, x) => x)

