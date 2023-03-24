/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import org.postgresql.util.PGobject

sealed abstract class PgLargeobjectMetadataFieldValue[T](val name: String, val value: T)

object PgLargeobjectMetadataFieldValue {
  case class oid(override val value: PgLargeobjectMetadataId) extends PgLargeobjectMetadataFieldValue("oid", value)
  case class lomowner(override val value: Long) extends PgLargeobjectMetadataFieldValue("lomowner", value)
  case class lomacl(override val value: Option[Array[PGobject]]) extends PgLargeobjectMetadataFieldValue("lomacl", value)
}
