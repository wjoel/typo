/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema



sealed abstract class ForeignTableOptionsFieldValue[T](val name: String, val value: T)

object ForeignTableOptionsFieldValue {
  case class foreignTableCatalog(override val value: Option[String]) extends ForeignTableOptionsFieldValue("foreign_table_catalog", value)
  case class foreignTableSchema(override val value: Option[String]) extends ForeignTableOptionsFieldValue("foreign_table_schema", value)
  case class foreignTableName(override val value: Option[String]) extends ForeignTableOptionsFieldValue("foreign_table_name", value)
  case class optionName(override val value: /* unknown nullability */ Option[String]) extends ForeignTableOptionsFieldValue("option_name", value)
  case class optionValue(override val value: /* unknown nullability */ Option[String]) extends ForeignTableOptionsFieldValue("option_value", value)
}