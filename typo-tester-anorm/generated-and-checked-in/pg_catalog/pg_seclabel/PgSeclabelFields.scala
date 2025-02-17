/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgSeclabelFields[Row] {
  val objoid: IdField[/* oid */ Long, Row]
  val classoid: IdField[/* oid */ Long, Row]
  val objsubid: IdField[Int, Row]
  val provider: IdField[String, Row]
  val label: Field[String, Row]
}
object PgSeclabelFields extends PgSeclabelStructure[PgSeclabelRow](None, identity, (_, x) => x)

