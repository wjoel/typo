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



sealed abstract class UserDefinedTypesFieldValue[T](val name: String, val value: T)

object UserDefinedTypesFieldValue {
  case class userDefinedTypeCatalog(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("user_defined_type_catalog", value)
  case class userDefinedTypeSchema(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("user_defined_type_schema", value)
  case class userDefinedTypeName(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("user_defined_type_name", value)
  case class userDefinedTypeCategory(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("user_defined_type_category", value)
  case class isInstantiable(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("is_instantiable", value)
  case class isFinal(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("is_final", value)
  case class orderingForm(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("ordering_form", value)
  case class orderingCategory(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("ordering_category", value)
  case class orderingRoutineCatalog(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("ordering_routine_catalog", value)
  case class orderingRoutineSchema(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("ordering_routine_schema", value)
  case class orderingRoutineName(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("ordering_routine_name", value)
  case class referenceType(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("reference_type", value)
  case class dataType(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("data_type", value)
  case class characterMaximumLength(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("character_maximum_length", value)
  case class characterOctetLength(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("character_octet_length", value)
  case class characterSetCatalog(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("character_set_catalog", value)
  case class characterSetSchema(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("character_set_schema", value)
  case class characterSetName(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("character_set_name", value)
  case class collationCatalog(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("collation_catalog", value)
  case class collationSchema(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("collation_schema", value)
  case class collationName(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("collation_name", value)
  case class numericPrecision(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("numeric_precision", value)
  case class numericPrecisionRadix(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("numeric_precision_radix", value)
  case class numericScale(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("numeric_scale", value)
  case class datetimePrecision(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("datetime_precision", value)
  case class intervalType(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("interval_type", value)
  case class intervalPrecision(override val value: /* unknown nullability */ Option[Int]) extends UserDefinedTypesFieldValue("interval_precision", value)
  case class sourceDtdIdentifier(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("source_dtd_identifier", value)
  case class refDtdIdentifier(override val value: /* unknown nullability */ Option[String]) extends UserDefinedTypesFieldValue("ref_dtd_identifier", value)
}