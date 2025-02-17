/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_tables

import typo.dsl.SqlExpr.OptField

trait PgStatioAllTablesViewFields[Row] {
  val relid: OptField[/* oid */ Long, Row]
  val schemaname: OptField[String, Row]
  val relname: OptField[String, Row]
  val heapBlksRead: OptField[Long, Row]
  val heapBlksHit: OptField[Long, Row]
  val idxBlksRead: OptField[Long, Row]
  val idxBlksHit: OptField[Long, Row]
  val toastBlksRead: OptField[Long, Row]
  val toastBlksHit: OptField[Long, Row]
  val tidxBlksRead: OptField[Long, Row]
  val tidxBlksHit: OptField[Long, Row]
}
object PgStatioAllTablesViewFields extends PgStatioAllTablesViewStructure[PgStatioAllTablesViewRow](None, identity, (_, x) => x)

