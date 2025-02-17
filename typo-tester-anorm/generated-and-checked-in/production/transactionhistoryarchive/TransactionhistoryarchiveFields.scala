/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.TypoLocalDateTime
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait TransactionhistoryarchiveFields[Row] {
  val transactionid: IdField[TransactionhistoryarchiveId, Row]
  val productid: Field[Int, Row]
  val referenceorderid: Field[Int, Row]
  val referenceorderlineid: Field[Int, Row]
  val transactiondate: Field[TypoLocalDateTime, Row]
  val transactiontype: Field[/* bpchar */ String, Row]
  val quantity: Field[Int, Row]
  val actualcost: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object TransactionhistoryarchiveFields extends TransactionhistoryarchiveStructure[TransactionhistoryarchiveRow](None, identity, (_, x) => x)

