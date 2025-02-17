/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_copy

import typo.dsl.SqlExpr.OptField

trait PgStatProgressCopyViewFields[Row] {
  val pid: OptField[Int, Row]
  val datid: OptField[/* oid */ Long, Row]
  val datname: OptField[String, Row]
  val relid: OptField[/* oid */ Long, Row]
  val command: OptField[String, Row]
  val `type`: OptField[String, Row]
  val bytesProcessed: OptField[Long, Row]
  val bytesTotal: OptField[Long, Row]
  val tuplesProcessed: OptField[Long, Row]
  val tuplesExcluded: OptField[Long, Row]
}
object PgStatProgressCopyViewFields extends PgStatProgressCopyViewStructure[PgStatProgressCopyViewRow](None, identity, (_, x) => x)

