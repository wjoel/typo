/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.public.Name
import java.time.LocalDateTime
import java.time.LocalTime

case class ShiftRow(
  /** Primary key for Shift records. */
  shiftid: ShiftId,
  /** Shift description. */
  name: Name,
  /** Shift start time. */
  starttime: LocalTime,
  /** Shift end time. */
  endtime: LocalTime,
  modifieddate: LocalDateTime
)


