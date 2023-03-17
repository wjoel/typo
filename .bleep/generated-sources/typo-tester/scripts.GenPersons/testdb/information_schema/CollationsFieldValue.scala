package testdb.information_schema



sealed abstract class CollationsFieldValue[T](val name: String, val value: T)

object CollationsFieldValue {
  case class collationCatalog(override val value: /* unknown nullability */ Option[String]) extends CollationsFieldValue("collation_catalog", value)
  case class collationSchema(override val value: /* unknown nullability */ Option[String]) extends CollationsFieldValue("collation_schema", value)
  case class collationName(override val value: /* unknown nullability */ Option[String]) extends CollationsFieldValue("collation_name", value)
  case class padAttribute(override val value: /* unknown nullability */ Option[String]) extends CollationsFieldValue("pad_attribute", value)
}