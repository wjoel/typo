/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import java.util.UUID
import typo.dsl.SqlExpr.OptField

trait PaViewFields[Row] {
  val id: OptField[Int, Row]
  val businessentityid: OptField[BusinessentityId, Row]
  val passwordhash: OptField[/* max 128 chars */ String, Row]
  val passwordsalt: OptField[/* max 10 chars */ String, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object PaViewFields extends PaViewStructure[PaViewRow](None, identity, (_, x) => x)

