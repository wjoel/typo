/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.public.Name
import java.time.LocalDateTime

case class ContacttypeRow(
  /** Primary key for ContactType records. */
  contacttypeid: ContacttypeId,
  /** Contact type description. */
  name: Name,
  modifieddate: LocalDateTime
)


