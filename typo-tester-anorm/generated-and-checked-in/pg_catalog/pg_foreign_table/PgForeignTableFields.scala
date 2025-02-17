/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_table

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgForeignTableFields[Row] {
  val ftrelid: IdField[PgForeignTableId, Row]
  val ftserver: Field[/* oid */ Long, Row]
  val ftoptions: OptField[Array[String], Row]
}
object PgForeignTableFields extends PgForeignTableStructure[PgForeignTableRow](None, identity, (_, x) => x)

