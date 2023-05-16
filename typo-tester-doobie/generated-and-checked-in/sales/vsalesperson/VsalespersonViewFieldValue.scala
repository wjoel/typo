/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone

sealed abstract class VsalespersonViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VsalespersonViewFieldValue[T](name: String, value: T) extends VsalespersonViewFieldOrIdValue(name, value)

object VsalespersonViewFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VsalespersonViewFieldValue("businessentityid", value)
  case class title(override val value: Option[String]) extends VsalespersonViewFieldValue("title", value)
  case class firstname(override val value: Option[Name]) extends VsalespersonViewFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends VsalespersonViewFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends VsalespersonViewFieldValue("lastname", value)
  case class suffix(override val value: Option[String]) extends VsalespersonViewFieldValue("suffix", value)
  case class jobtitle(override val value: Option[String]) extends VsalespersonViewFieldValue("jobtitle", value)
  case class phonenumber(override val value: Option[Phone]) extends VsalespersonViewFieldValue("phonenumber", value)
  case class phonenumbertype(override val value: Option[Name]) extends VsalespersonViewFieldValue("phonenumbertype", value)
  case class emailaddress(override val value: Option[String]) extends VsalespersonViewFieldValue("emailaddress", value)
  case class emailpromotion(override val value: Option[Int]) extends VsalespersonViewFieldValue("emailpromotion", value)
  case class addressline1(override val value: Option[String]) extends VsalespersonViewFieldValue("addressline1", value)
  case class addressline2(override val value: Option[String]) extends VsalespersonViewFieldValue("addressline2", value)
  case class city(override val value: Option[String]) extends VsalespersonViewFieldValue("city", value)
  case class stateprovincename(override val value: Option[Name]) extends VsalespersonViewFieldValue("stateprovincename", value)
  case class postalcode(override val value: Option[String]) extends VsalespersonViewFieldValue("postalcode", value)
  case class countryregionname(override val value: Option[Name]) extends VsalespersonViewFieldValue("countryregionname", value)
  case class territoryname(override val value: Option[Name]) extends VsalespersonViewFieldValue("territoryname", value)
  case class territorygroup(override val value: Option[String]) extends VsalespersonViewFieldValue("territorygroup", value)
  case class salesquota(override val value: Option[BigDecimal]) extends VsalespersonViewFieldValue("salesquota", value)
  case class salesytd(override val value: Option[BigDecimal]) extends VsalespersonViewFieldValue("salesytd", value)
  case class saleslastyear(override val value: Option[BigDecimal]) extends VsalespersonViewFieldValue("saleslastyear", value)
}
