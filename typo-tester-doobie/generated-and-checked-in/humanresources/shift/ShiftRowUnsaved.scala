/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import java.time.LocalTime

/** This class corresponds to a row in table `humanresources.shift` which has not been persisted yet */
case class ShiftRowUnsaved(
  /** Shift description. */
  name: Name,
  /** Shift start time. */
  starttime: LocalTime,
  /** Shift end time. */
  endtime: LocalTime,
  /** Default: nextval('humanresources.shift_shiftid_seq'::regclass)
      Primary key for Shift records. */
  shiftid: Defaulted[ShiftId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shiftidDefault: => ShiftId, modifieddateDefault: => LocalDateTime): ShiftRow =
    ShiftRow(
      name = name,
      starttime = starttime,
      endtime = endtime,
      shiftid = shiftid match {
                  case Defaulted.UseDefault => shiftidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}

