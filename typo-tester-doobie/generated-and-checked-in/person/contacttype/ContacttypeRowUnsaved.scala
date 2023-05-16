/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime

/** This class corresponds to a row in table `person.contacttype` which has not been persisted yet */
case class ContacttypeRowUnsaved(
  /** Contact type description. */
  name: Name,
  /** Default: nextval('person.contacttype_contacttypeid_seq'::regclass)
      Primary key for ContactType records. */
  contacttypeid: Defaulted[ContacttypeId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(contacttypeidDefault: => ContacttypeId, modifieddateDefault: => LocalDateTime): ContacttypeRow =
    ContacttypeRow(
      name = name,
      contacttypeid = contacttypeid match {
                        case Defaulted.UseDefault => contacttypeidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}

