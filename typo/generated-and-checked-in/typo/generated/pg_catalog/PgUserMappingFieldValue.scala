/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog



sealed abstract class PgUserMappingFieldValue[T](val name: String, val value: T)

object PgUserMappingFieldValue {
  case class oid(override val value: PgUserMappingId) extends PgUserMappingFieldValue("oid", value)
  case class umuser(override val value: Long) extends PgUserMappingFieldValue("umuser", value)
  case class umserver(override val value: Long) extends PgUserMappingFieldValue("umserver", value)
  case class umoptions(override val value: Option[Array[String]]) extends PgUserMappingFieldValue("umoptions", value)
}
