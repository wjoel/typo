/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import adventureworks.TypoLocalDateTime
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import typo.dsl.SqlExpr.OptField

trait UmViewFields[Row] {
  val id: OptField[/* bpchar */ String, Row]
  val unitmeasurecode: OptField[UnitmeasureId, Row]
  val name: OptField[Name, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object UmViewFields extends UmViewStructure[UmViewRow](None, identity, (_, x) => x)

