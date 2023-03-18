package testdb
package postgres
package pg_catalog

import java.time.LocalDateTime

sealed abstract class PgStatSlruFieldValue[T](val name: String, val value: T)

object PgStatSlruFieldValue {
  case class name(override val value: /* unknown nullability */ Option[String]) extends PgStatSlruFieldValue("name", value)
  case class blksZeroed(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("blks_zeroed", value)
  case class blksHit(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("blks_hit", value)
  case class blksRead(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("blks_read", value)
  case class blksWritten(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("blks_written", value)
  case class blksExists(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("blks_exists", value)
  case class flushes(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("flushes", value)
  case class truncates(override val value: /* unknown nullability */ Option[Long]) extends PgStatSlruFieldValue("truncates", value)
  case class statsReset(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatSlruFieldValue("stats_reset", value)
}