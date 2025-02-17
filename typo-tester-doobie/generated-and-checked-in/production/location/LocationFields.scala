/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait LocationFields[Row] {
  val locationid: IdField[LocationId, Row]
  val name: Field[Name, Row]
  val costrate: Field[BigDecimal, Row]
  val availability: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object LocationFields extends LocationStructure[LocationRow](None, identity, (_, x) => x)

