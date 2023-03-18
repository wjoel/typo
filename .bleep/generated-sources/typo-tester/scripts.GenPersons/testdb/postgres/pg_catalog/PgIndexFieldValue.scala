package testdb
package postgres
package pg_catalog



sealed abstract class PgIndexFieldValue[T](val name: String, val value: T)

object PgIndexFieldValue {
  case class indexrelid(override val value: PgIndexId) extends PgIndexFieldValue("indexrelid", value)
  case class indrelid(override val value: Long) extends PgIndexFieldValue("indrelid", value)
  case class indnatts(override val value: Short) extends PgIndexFieldValue("indnatts", value)
  case class indnkeyatts(override val value: Short) extends PgIndexFieldValue("indnkeyatts", value)
  case class indisunique(override val value: Boolean) extends PgIndexFieldValue("indisunique", value)
  case class indisprimary(override val value: Boolean) extends PgIndexFieldValue("indisprimary", value)
  case class indisexclusion(override val value: Boolean) extends PgIndexFieldValue("indisexclusion", value)
  case class indimmediate(override val value: Boolean) extends PgIndexFieldValue("indimmediate", value)
  case class indisclustered(override val value: Boolean) extends PgIndexFieldValue("indisclustered", value)
  case class indisvalid(override val value: Boolean) extends PgIndexFieldValue("indisvalid", value)
  case class indcheckxmin(override val value: Boolean) extends PgIndexFieldValue("indcheckxmin", value)
  case class indisready(override val value: Boolean) extends PgIndexFieldValue("indisready", value)
  case class indislive(override val value: Boolean) extends PgIndexFieldValue("indislive", value)
  case class indisreplident(override val value: Boolean) extends PgIndexFieldValue("indisreplident", value)
  case class indkey(override val value: String) extends PgIndexFieldValue("indkey", value)
  case class indcollation(override val value: String) extends PgIndexFieldValue("indcollation", value)
  case class indclass(override val value: String) extends PgIndexFieldValue("indclass", value)
  case class indoption(override val value: String) extends PgIndexFieldValue("indoption", value)
  case class indexprs(override val value: Option[String]) extends PgIndexFieldValue("indexprs", value)
  case class indpred(override val value: Option[String]) extends PgIndexFieldValue("indpred", value)
}
