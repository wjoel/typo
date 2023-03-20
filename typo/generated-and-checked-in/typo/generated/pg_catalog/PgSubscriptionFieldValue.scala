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



sealed abstract class PgSubscriptionFieldValue[T](val name: String, val value: T)

object PgSubscriptionFieldValue {
  case class oid(override val value: PgSubscriptionId) extends PgSubscriptionFieldValue("oid", value)
  case class subdbid(override val value: Long) extends PgSubscriptionFieldValue("subdbid", value)
  case class subname(override val value: String) extends PgSubscriptionFieldValue("subname", value)
  case class subowner(override val value: Long) extends PgSubscriptionFieldValue("subowner", value)
  case class subenabled(override val value: Boolean) extends PgSubscriptionFieldValue("subenabled", value)
  case class subbinary(override val value: Boolean) extends PgSubscriptionFieldValue("subbinary", value)
  case class substream(override val value: Boolean) extends PgSubscriptionFieldValue("substream", value)
  case class subconninfo(override val value: String) extends PgSubscriptionFieldValue("subconninfo", value)
  case class subslotname(override val value: Option[String]) extends PgSubscriptionFieldValue("subslotname", value)
  case class subsynccommit(override val value: String) extends PgSubscriptionFieldValue("subsynccommit", value)
  case class subpublications(override val value: Array[String]) extends PgSubscriptionFieldValue("subpublications", value)
}
