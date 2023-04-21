/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class BusinessentitycontactFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class BusinessentitycontactFieldValue[T](name: String, value: T) extends BusinessentitycontactFieldOrIdValue(name, value)

object BusinessentitycontactFieldValue {
  case class businessentityid(override val value: BusinessentityId) extends BusinessentitycontactFieldOrIdValue("businessentityid", value)
  case class personid(override val value: BusinessentityId) extends BusinessentitycontactFieldOrIdValue("personid", value)
  case class contacttypeid(override val value: ContacttypeId) extends BusinessentitycontactFieldOrIdValue("contacttypeid", value)
  case class rowguid(override val value: UUID) extends BusinessentitycontactFieldValue("rowguid", value)
  case class modifieddate(override val value: LocalDateTime) extends BusinessentitycontactFieldValue("modifieddate", value)
}