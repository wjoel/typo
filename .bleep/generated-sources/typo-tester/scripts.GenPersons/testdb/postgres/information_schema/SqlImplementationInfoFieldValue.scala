package testdb
package postgres
package information_schema



sealed abstract class SqlImplementationInfoFieldValue[T](val name: String, val value: T)

object SqlImplementationInfoFieldValue {
  case class implementationInfoId(override val value: Option[String]) extends SqlImplementationInfoFieldValue("implementation_info_id", value)
  case class implementationInfoName(override val value: Option[String]) extends SqlImplementationInfoFieldValue("implementation_info_name", value)
  case class integerValue(override val value: Option[Int]) extends SqlImplementationInfoFieldValue("integer_value", value)
  case class characterValue(override val value: Option[String]) extends SqlImplementationInfoFieldValue("character_value", value)
  case class comments(override val value: Option[String]) extends SqlImplementationInfoFieldValue("comments", value)
}