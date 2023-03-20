/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema



sealed abstract class PgUserMappingsFieldValue[T](val name: String, val value: T)

object PgUserMappingsFieldValue {
  case class oid(override val value: Long) extends PgUserMappingsFieldValue("oid", value)
  case class umoptions(override val value: Option[Array[String]]) extends PgUserMappingsFieldValue("umoptions", value)
  case class umuser(override val value: Long) extends PgUserMappingsFieldValue("umuser", value)
  case class authorizationIdentifier(override val value: /* unknown nullability */ Option[String]) extends PgUserMappingsFieldValue("authorization_identifier", value)
  case class foreignServerCatalog(override val value: Option[String]) extends PgUserMappingsFieldValue("foreign_server_catalog", value)
  case class foreignServerName(override val value: Option[String]) extends PgUserMappingsFieldValue("foreign_server_name", value)
  case class srvowner(override val value: Option[String]) extends PgUserMappingsFieldValue("srvowner", value)
}
