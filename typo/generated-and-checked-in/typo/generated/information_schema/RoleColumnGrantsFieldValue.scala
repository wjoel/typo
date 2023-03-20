/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema



sealed abstract class RoleColumnGrantsFieldValue[T](val name: String, val value: T)

object RoleColumnGrantsFieldValue {
  case class grantor(override val value: Option[String]) extends RoleColumnGrantsFieldValue("grantor", value)
  case class grantee(override val value: Option[String]) extends RoleColumnGrantsFieldValue("grantee", value)
  case class tableCatalog(override val value: Option[String]) extends RoleColumnGrantsFieldValue("table_catalog", value)
  case class tableSchema(override val value: Option[String]) extends RoleColumnGrantsFieldValue("table_schema", value)
  case class tableName(override val value: Option[String]) extends RoleColumnGrantsFieldValue("table_name", value)
  case class columnName(override val value: Option[String]) extends RoleColumnGrantsFieldValue("column_name", value)
  case class privilegeType(override val value: Option[String]) extends RoleColumnGrantsFieldValue("privilege_type", value)
  case class isGrantable(override val value: Option[String]) extends RoleColumnGrantsFieldValue("is_grantable", value)
}
