/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

import adventureworks.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgAmFields[Row] {
  val oid: IdField[PgAmId, Row]
  val amname: Field[String, Row]
  val amhandler: Field[TypoRegproc, Row]
  val amtype: Field[String, Row]
}
object PgAmFields extends PgAmStructure[PgAmRow](None, identity, (_, x) => x)

