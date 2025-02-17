/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.TypoLocalDateTime
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait SpecialofferFields[Row] {
  val specialofferid: IdField[SpecialofferId, Row]
  val description: Field[/* max 255 chars */ String, Row]
  val discountpct: Field[BigDecimal, Row]
  val `type`: Field[/* max 50 chars */ String, Row]
  val category: Field[/* max 50 chars */ String, Row]
  val startdate: Field[TypoLocalDateTime, Row]
  val enddate: Field[TypoLocalDateTime, Row]
  val minqty: Field[Int, Row]
  val maxqty: OptField[Int, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SpecialofferFields extends SpecialofferStructure[SpecialofferRow](None, identity, (_, x) => x)

