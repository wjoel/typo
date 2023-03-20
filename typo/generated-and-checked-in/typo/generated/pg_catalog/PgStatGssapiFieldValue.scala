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



sealed abstract class PgStatGssapiFieldValue[T](val name: String, val value: T)

object PgStatGssapiFieldValue {
  case class pid(override val value: /* unknown nullability */ Option[Int]) extends PgStatGssapiFieldValue("pid", value)
  case class gssAuthenticated(override val value: /* unknown nullability */ Option[Boolean]) extends PgStatGssapiFieldValue("gss_authenticated", value)
  case class principal(override val value: /* unknown nullability */ Option[String]) extends PgStatGssapiFieldValue("principal", value)
  case class encrypted(override val value: /* unknown nullability */ Option[Boolean]) extends PgStatGssapiFieldValue("encrypted", value)
}
