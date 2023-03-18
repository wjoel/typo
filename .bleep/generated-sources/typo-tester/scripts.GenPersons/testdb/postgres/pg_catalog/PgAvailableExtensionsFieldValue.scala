package testdb
package postgres
package pg_catalog



sealed abstract class PgAvailableExtensionsFieldValue[T](val name: String, val value: T)

object PgAvailableExtensionsFieldValue {
  case class name(override val value: /* unknown nullability */ Option[String]) extends PgAvailableExtensionsFieldValue("name", value)
  case class defaultVersion(override val value: /* unknown nullability */ Option[String]) extends PgAvailableExtensionsFieldValue("default_version", value)
  case class installedVersion(override val value: String) extends PgAvailableExtensionsFieldValue("installed_version", value)
  case class comment(override val value: /* unknown nullability */ Option[String]) extends PgAvailableExtensionsFieldValue("comment", value)
}