package testdb
package postgres
package pg_catalog



sealed abstract class PgLanguageFieldValue[T](val name: String, val value: T)

object PgLanguageFieldValue {
  case class oid(override val value: PgLanguageId) extends PgLanguageFieldValue("oid", value)
  case class lanname(override val value: String) extends PgLanguageFieldValue("lanname", value)
  case class lanowner(override val value: Long) extends PgLanguageFieldValue("lanowner", value)
  case class lanispl(override val value: Boolean) extends PgLanguageFieldValue("lanispl", value)
  case class lanpltrusted(override val value: Boolean) extends PgLanguageFieldValue("lanpltrusted", value)
  case class lanplcallfoid(override val value: Long) extends PgLanguageFieldValue("lanplcallfoid", value)
  case class laninline(override val value: Long) extends PgLanguageFieldValue("laninline", value)
  case class lanvalidator(override val value: Long) extends PgLanguageFieldValue("lanvalidator", value)
  case class lanacl(override val value: Option[Array[String]]) extends PgLanguageFieldValue("lanacl", value)
}
