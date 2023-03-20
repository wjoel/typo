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



sealed abstract class PgDefaultAclFieldValue[T](val name: String, val value: T)

object PgDefaultAclFieldValue {
  case class oid(override val value: PgDefaultAclId) extends PgDefaultAclFieldValue("oid", value)
  case class defaclrole(override val value: Long) extends PgDefaultAclFieldValue("defaclrole", value)
  case class defaclnamespace(override val value: Long) extends PgDefaultAclFieldValue("defaclnamespace", value)
  case class defaclobjtype(override val value: String) extends PgDefaultAclFieldValue("defaclobjtype", value)
  case class defaclacl(override val value: Array[String]) extends PgDefaultAclFieldValue("defaclacl", value)
}
