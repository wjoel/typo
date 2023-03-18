package testdb
package postgres
package pg_catalog



sealed abstract class PgClassFieldValue[T](val name: String, val value: T)

object PgClassFieldValue {
  case class oid(override val value: PgClassId) extends PgClassFieldValue("oid", value)
  case class relname(override val value: String) extends PgClassFieldValue("relname", value)
  case class relnamespace(override val value: Long) extends PgClassFieldValue("relnamespace", value)
  case class reltype(override val value: Long) extends PgClassFieldValue("reltype", value)
  case class reloftype(override val value: Long) extends PgClassFieldValue("reloftype", value)
  case class relowner(override val value: Long) extends PgClassFieldValue("relowner", value)
  case class relam(override val value: Long) extends PgClassFieldValue("relam", value)
  case class relfilenode(override val value: Long) extends PgClassFieldValue("relfilenode", value)
  case class reltablespace(override val value: Long) extends PgClassFieldValue("reltablespace", value)
  case class relpages(override val value: Int) extends PgClassFieldValue("relpages", value)
  case class reltuples(override val value: Float) extends PgClassFieldValue("reltuples", value)
  case class relallvisible(override val value: Int) extends PgClassFieldValue("relallvisible", value)
  case class reltoastrelid(override val value: Long) extends PgClassFieldValue("reltoastrelid", value)
  case class relhasindex(override val value: Boolean) extends PgClassFieldValue("relhasindex", value)
  case class relisshared(override val value: Boolean) extends PgClassFieldValue("relisshared", value)
  case class relpersistence(override val value: String) extends PgClassFieldValue("relpersistence", value)
  case class relkind(override val value: String) extends PgClassFieldValue("relkind", value)
  case class relnatts(override val value: Short) extends PgClassFieldValue("relnatts", value)
  case class relchecks(override val value: Short) extends PgClassFieldValue("relchecks", value)
  case class relhasrules(override val value: Boolean) extends PgClassFieldValue("relhasrules", value)
  case class relhastriggers(override val value: Boolean) extends PgClassFieldValue("relhastriggers", value)
  case class relhassubclass(override val value: Boolean) extends PgClassFieldValue("relhassubclass", value)
  case class relrowsecurity(override val value: Boolean) extends PgClassFieldValue("relrowsecurity", value)
  case class relforcerowsecurity(override val value: Boolean) extends PgClassFieldValue("relforcerowsecurity", value)
  case class relispopulated(override val value: Boolean) extends PgClassFieldValue("relispopulated", value)
  case class relreplident(override val value: String) extends PgClassFieldValue("relreplident", value)
  case class relispartition(override val value: Boolean) extends PgClassFieldValue("relispartition", value)
  case class relrewrite(override val value: Long) extends PgClassFieldValue("relrewrite", value)
  case class relfrozenxid(override val value: String) extends PgClassFieldValue("relfrozenxid", value)
  case class relminmxid(override val value: String) extends PgClassFieldValue("relminmxid", value)
  case class relacl(override val value: Option[Array[String]]) extends PgClassFieldValue("relacl", value)
  case class reloptions(override val value: Option[Array[String]]) extends PgClassFieldValue("reloptions", value)
  case class relpartbound(override val value: Option[String]) extends PgClassFieldValue("relpartbound", value)
}
