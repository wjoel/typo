package testdb
package postgres
package pg_catalog



sealed abstract class PgAmopFieldValue[T](val name: String, val value: T)

object PgAmopFieldValue {
  case class oid(override val value: PgAmopId) extends PgAmopFieldValue("oid", value)
  case class amopfamily(override val value: Long) extends PgAmopFieldValue("amopfamily", value)
  case class amoplefttype(override val value: Long) extends PgAmopFieldValue("amoplefttype", value)
  case class amoprighttype(override val value: Long) extends PgAmopFieldValue("amoprighttype", value)
  case class amopstrategy(override val value: Short) extends PgAmopFieldValue("amopstrategy", value)
  case class amoppurpose(override val value: String) extends PgAmopFieldValue("amoppurpose", value)
  case class amopopr(override val value: Long) extends PgAmopFieldValue("amopopr", value)
  case class amopmethod(override val value: Long) extends PgAmopFieldValue("amopmethod", value)
  case class amopsortfamily(override val value: Long) extends PgAmopFieldValue("amopsortfamily", value)
}
