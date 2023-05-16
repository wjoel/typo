/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import org.postgresql.jdbc.PgSQLXML

sealed abstract class VemployeeViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VemployeeViewFieldValue[T](name: String, value: T) extends VemployeeViewFieldOrIdValue(name, value)

object VemployeeViewFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VemployeeViewFieldValue("businessentityid", value)
  case class title(override val value: Option[String]) extends VemployeeViewFieldValue("title", value)
  case class firstname(override val value: Option[Name]) extends VemployeeViewFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends VemployeeViewFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends VemployeeViewFieldValue("lastname", value)
  case class suffix(override val value: Option[String]) extends VemployeeViewFieldValue("suffix", value)
  case class jobtitle(override val value: Option[String]) extends VemployeeViewFieldValue("jobtitle", value)
  case class phonenumber(override val value: Option[Phone]) extends VemployeeViewFieldValue("phonenumber", value)
  case class phonenumbertype(override val value: Option[Name]) extends VemployeeViewFieldValue("phonenumbertype", value)
  case class emailaddress(override val value: Option[String]) extends VemployeeViewFieldValue("emailaddress", value)
  case class emailpromotion(override val value: Option[Int]) extends VemployeeViewFieldValue("emailpromotion", value)
  case class addressline1(override val value: Option[String]) extends VemployeeViewFieldValue("addressline1", value)
  case class addressline2(override val value: Option[String]) extends VemployeeViewFieldValue("addressline2", value)
  case class city(override val value: Option[String]) extends VemployeeViewFieldValue("city", value)
  case class stateprovincename(override val value: Option[Name]) extends VemployeeViewFieldValue("stateprovincename", value)
  case class postalcode(override val value: Option[String]) extends VemployeeViewFieldValue("postalcode", value)
  case class countryregionname(override val value: Option[Name]) extends VemployeeViewFieldValue("countryregionname", value)
  case class additionalcontactinfo(override val value: Option[PgSQLXML]) extends VemployeeViewFieldValue("additionalcontactinfo", value)
}
