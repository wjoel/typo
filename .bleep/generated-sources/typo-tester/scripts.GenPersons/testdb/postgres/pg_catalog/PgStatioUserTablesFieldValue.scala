package testdb
package postgres
package pg_catalog



sealed abstract class PgStatioUserTablesFieldValue[T](val name: String, val value: T)

object PgStatioUserTablesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("relid", value)
  case class schemaname(override val value: Option[String]) extends PgStatioUserTablesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatioUserTablesFieldValue("relname", value)
  case class heapBlksRead(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("heap_blks_read", value)
  case class heapBlksHit(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("heap_blks_hit", value)
  case class idxBlksRead(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("idx_blks_read", value)
  case class idxBlksHit(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("idx_blks_hit", value)
  case class toastBlksRead(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("toast_blks_read", value)
  case class toastBlksHit(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("toast_blks_hit", value)
  case class tidxBlksRead(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("tidx_blks_read", value)
  case class tidxBlksHit(override val value: Option[Long]) extends PgStatioUserTablesFieldValue("tidx_blks_hit", value)
}