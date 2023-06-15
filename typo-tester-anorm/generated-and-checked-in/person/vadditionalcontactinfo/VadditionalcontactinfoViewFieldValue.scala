/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class VadditionalcontactinfoViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VadditionalcontactinfoViewFieldValue[T](name: String, value: T) extends VadditionalcontactinfoViewFieldOrIdValue(name, value)

object VadditionalcontactinfoViewFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VadditionalcontactinfoViewFieldValue("businessentityid", value)
  case class firstname(override val value: Option[Name]) extends VadditionalcontactinfoViewFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends VadditionalcontactinfoViewFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends VadditionalcontactinfoViewFieldValue("lastname", value)
  case class telephonenumber(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("telephonenumber", value)
  case class telephonespecialinstructions(override val value: Option[String]) extends VadditionalcontactinfoViewFieldValue("telephonespecialinstructions", value)
  case class street(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("street", value)
  case class city(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("city", value)
  case class stateprovince(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("stateprovince", value)
  case class postalcode(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("postalcode", value)
  case class countryregion(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("countryregion", value)
  case class homeaddressspecialinstructions(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("homeaddressspecialinstructions", value)
  case class emailaddress(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("emailaddress", value)
  case class emailspecialinstructions(override val value: Option[String]) extends VadditionalcontactinfoViewFieldValue("emailspecialinstructions", value)
  case class emailtelephonenumber(override val value: Option[TypoXml]) extends VadditionalcontactinfoViewFieldValue("emailtelephonenumber", value)
  case class rowguid(override val value: Option[UUID]) extends VadditionalcontactinfoViewFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends VadditionalcontactinfoViewFieldValue("modifieddate", value)
}
