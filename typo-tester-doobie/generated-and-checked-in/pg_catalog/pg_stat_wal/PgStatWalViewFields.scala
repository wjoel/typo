/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_wal

import adventureworks.TypoOffsetDateTime
import typo.dsl.SqlExpr.OptField

trait PgStatWalViewFields[Row] {
  val walRecords: OptField[Long, Row]
  val walFpi: OptField[Long, Row]
  val walBytes: OptField[BigDecimal, Row]
  val walBuffersFull: OptField[Long, Row]
  val walWrite: OptField[Long, Row]
  val walSync: OptField[Long, Row]
  val walWriteTime: OptField[Double, Row]
  val walSyncTime: OptField[Double, Row]
  val statsReset: OptField[TypoOffsetDateTime, Row]
}
object PgStatWalViewFields extends PgStatWalViewStructure[PgStatWalViewRow](None, identity, (_, x) => x)

