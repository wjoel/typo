/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import org.postgresql.util.PGobject

sealed abstract class PgDatabaseFieldValue[T](val name: String, val value: T)

object PgDatabaseFieldValue {
  case class oid(override val value: PgDatabaseId) extends PgDatabaseFieldValue("oid", value)
  case class datname(override val value: String) extends PgDatabaseFieldValue("datname", value)
  case class datdba(override val value: Long) extends PgDatabaseFieldValue("datdba", value)
  case class encoding(override val value: Int) extends PgDatabaseFieldValue("encoding", value)
  case class datcollate(override val value: String) extends PgDatabaseFieldValue("datcollate", value)
  case class datctype(override val value: String) extends PgDatabaseFieldValue("datctype", value)
  case class datistemplate(override val value: Boolean) extends PgDatabaseFieldValue("datistemplate", value)
  case class datallowconn(override val value: Boolean) extends PgDatabaseFieldValue("datallowconn", value)
  case class datconnlimit(override val value: Int) extends PgDatabaseFieldValue("datconnlimit", value)
  case class datlastsysoid(override val value: Long) extends PgDatabaseFieldValue("datlastsysoid", value)
  case class datfrozenxid(override val value: Int) extends PgDatabaseFieldValue("datfrozenxid", value)
  case class datminmxid(override val value: Int) extends PgDatabaseFieldValue("datminmxid", value)
  case class dattablespace(override val value: Long) extends PgDatabaseFieldValue("dattablespace", value)
  case class datacl(override val value: Option[Array[PGobject]]) extends PgDatabaseFieldValue("datacl", value)
}
