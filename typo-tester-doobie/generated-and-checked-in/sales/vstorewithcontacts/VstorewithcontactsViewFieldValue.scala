/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone

sealed abstract class VstorewithcontactsViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VstorewithcontactsViewFieldValue[T](name: String, value: T) extends VstorewithcontactsViewFieldOrIdValue(name, value)

object VstorewithcontactsViewFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VstorewithcontactsViewFieldValue("businessentityid", value)
  case class name(override val value: Option[Name]) extends VstorewithcontactsViewFieldValue("name", value)
  case class contacttype(override val value: Option[Name]) extends VstorewithcontactsViewFieldValue("contacttype", value)
  case class title(override val value: Option[String]) extends VstorewithcontactsViewFieldValue("title", value)
  case class firstname(override val value: Option[Name]) extends VstorewithcontactsViewFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends VstorewithcontactsViewFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends VstorewithcontactsViewFieldValue("lastname", value)
  case class suffix(override val value: Option[String]) extends VstorewithcontactsViewFieldValue("suffix", value)
  case class phonenumber(override val value: Option[Phone]) extends VstorewithcontactsViewFieldValue("phonenumber", value)
  case class phonenumbertype(override val value: Option[Name]) extends VstorewithcontactsViewFieldValue("phonenumbertype", value)
  case class emailaddress(override val value: Option[String]) extends VstorewithcontactsViewFieldValue("emailaddress", value)
  case class emailpromotion(override val value: Option[Int]) extends VstorewithcontactsViewFieldValue("emailpromotion", value)
}
