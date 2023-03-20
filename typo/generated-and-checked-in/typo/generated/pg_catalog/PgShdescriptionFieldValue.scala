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



sealed abstract class PgShdescriptionFieldValue[T](val name: String, val value: T)

object PgShdescriptionFieldValue {
  case class objoid(override val value: Long) extends PgShdescriptionFieldValue("objoid", value)
  case class classoid(override val value: Long) extends PgShdescriptionFieldValue("classoid", value)
  case class description(override val value: String) extends PgShdescriptionFieldValue("description", value)
}
