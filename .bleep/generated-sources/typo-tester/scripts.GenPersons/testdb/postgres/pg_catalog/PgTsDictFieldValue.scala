package testdb
package postgres
package pg_catalog



sealed abstract class PgTsDictFieldValue[T](val name: String, val value: T)

object PgTsDictFieldValue {
  case class oid(override val value: PgTsDictId) extends PgTsDictFieldValue("oid", value)
  case class dictname(override val value: String) extends PgTsDictFieldValue("dictname", value)
  case class dictnamespace(override val value: Long) extends PgTsDictFieldValue("dictnamespace", value)
  case class dictowner(override val value: Long) extends PgTsDictFieldValue("dictowner", value)
  case class dicttemplate(override val value: Long) extends PgTsDictFieldValue("dicttemplate", value)
  case class dictinitoption(override val value: Option[String]) extends PgTsDictFieldValue("dictinitoption", value)
}
