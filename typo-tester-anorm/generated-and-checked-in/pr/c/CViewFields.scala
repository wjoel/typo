/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import adventureworks.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.public.Name
import typo.dsl.SqlExpr.OptField

trait CViewFields[Row] {
  val id: OptField[/* bpchar */ String, Row]
  val cultureid: OptField[CultureId, Row]
  val name: OptField[Name, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object CViewFields extends CViewStructure[CViewRow](None, identity, (_, x) => x)

