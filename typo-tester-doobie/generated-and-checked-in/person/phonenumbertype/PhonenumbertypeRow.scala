/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.public.Name
import java.time.LocalDateTime

case class PhonenumbertypeRow(
  /** Primary key for telephone number type records. */
  phonenumbertypeid: PhonenumbertypeId,
  /** Name of the telephone number type */
  name: Name,
  modifieddate: LocalDateTime
)


