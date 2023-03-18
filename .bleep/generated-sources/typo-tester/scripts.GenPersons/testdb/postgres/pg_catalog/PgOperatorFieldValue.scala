package testdb
package postgres
package pg_catalog



sealed abstract class PgOperatorFieldValue[T](val name: String, val value: T)

object PgOperatorFieldValue {
  case class oid(override val value: PgOperatorId) extends PgOperatorFieldValue("oid", value)
  case class oprname(override val value: String) extends PgOperatorFieldValue("oprname", value)
  case class oprnamespace(override val value: Long) extends PgOperatorFieldValue("oprnamespace", value)
  case class oprowner(override val value: Long) extends PgOperatorFieldValue("oprowner", value)
  case class oprkind(override val value: String) extends PgOperatorFieldValue("oprkind", value)
  case class oprcanmerge(override val value: Boolean) extends PgOperatorFieldValue("oprcanmerge", value)
  case class oprcanhash(override val value: Boolean) extends PgOperatorFieldValue("oprcanhash", value)
  case class oprleft(override val value: Long) extends PgOperatorFieldValue("oprleft", value)
  case class oprright(override val value: Long) extends PgOperatorFieldValue("oprright", value)
  case class oprresult(override val value: Long) extends PgOperatorFieldValue("oprresult", value)
  case class oprcom(override val value: Long) extends PgOperatorFieldValue("oprcom", value)
  case class oprnegate(override val value: Long) extends PgOperatorFieldValue("oprnegate", value)
  case class oprcode(override val value: String) extends PgOperatorFieldValue("oprcode", value)
  case class oprrest(override val value: String) extends PgOperatorFieldValue("oprrest", value)
  case class oprjoin(override val value: String) extends PgOperatorFieldValue("oprjoin", value)
}
