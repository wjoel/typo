/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait CustomerFields[Row] {
  val customerid: IdField[CustomerId, Row]
  val personid: OptField[BusinessentityId, Row]
  val storeid: OptField[BusinessentityId, Row]
  val territoryid: OptField[SalesterritoryId, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object CustomerFields extends CustomerStructure[CustomerRow](None, identity, (_, x) => x)
