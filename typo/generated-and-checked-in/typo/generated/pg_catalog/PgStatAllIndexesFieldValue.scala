/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog



sealed abstract class PgStatAllIndexesFieldValue[T](val name: String, val value: T)

object PgStatAllIndexesFieldValue {
  case class relid(override val value: Long) extends PgStatAllIndexesFieldValue("relid", value)
  case class indexrelid(override val value: Long) extends PgStatAllIndexesFieldValue("indexrelid", value)
  case class schemaname(override val value: String) extends PgStatAllIndexesFieldValue("schemaname", value)
  case class relname(override val value: String) extends PgStatAllIndexesFieldValue("relname", value)
  case class indexrelname(override val value: String) extends PgStatAllIndexesFieldValue("indexrelname", value)
  case class idxScan(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllIndexesFieldValue("idx_scan", value)
  case class idxTupRead(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllIndexesFieldValue("idx_tup_read", value)
  case class idxTupFetch(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllIndexesFieldValue("idx_tup_fetch", value)
}