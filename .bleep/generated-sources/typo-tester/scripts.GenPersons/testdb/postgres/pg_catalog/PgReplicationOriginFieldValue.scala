package testdb
package postgres
package pg_catalog



sealed abstract class PgReplicationOriginFieldValue[T](val name: String, val value: T)

object PgReplicationOriginFieldValue {
  case class roident(override val value: PgReplicationOriginId) extends PgReplicationOriginFieldValue("roident", value)
  case class roname(override val value: String) extends PgReplicationOriginFieldValue("roname", value)
}
