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



sealed abstract class PgForeignServerFieldValue[T](val name: String, val value: T)

object PgForeignServerFieldValue {
  case class oid(override val value: PgForeignServerId) extends PgForeignServerFieldValue("oid", value)
  case class srvname(override val value: String) extends PgForeignServerFieldValue("srvname", value)
  case class srvowner(override val value: Long) extends PgForeignServerFieldValue("srvowner", value)
  case class srvfdw(override val value: Long) extends PgForeignServerFieldValue("srvfdw", value)
  case class srvtype(override val value: Option[String]) extends PgForeignServerFieldValue("srvtype", value)
  case class srvversion(override val value: Option[String]) extends PgForeignServerFieldValue("srvversion", value)
  case class srvacl(override val value: Option[Array[String]]) extends PgForeignServerFieldValue("srvacl", value)
  case class srvoptions(override val value: Option[Array[String]]) extends PgForeignServerFieldValue("srvoptions", value)
}
