/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package s

import adventureworks.humanresources.shift.ShiftId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.time.LocalTime

sealed abstract class SFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class SFieldValue[T](name: String, value: T) extends SFieldOrIdValue(name, value)

object SFieldValue {
  case class id(override val value: Option[Int]) extends SFieldValue("id", value)
  case class shiftid(override val value: Option[ShiftId]) extends SFieldValue("shiftid", value)
  case class name(override val value: Option[Name]) extends SFieldValue("name", value)
  case class starttime(override val value: Option[LocalTime]) extends SFieldValue("starttime", value)
  case class endtime(override val value: Option[LocalTime]) extends SFieldValue("endtime", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends SFieldValue("modifieddate", value)
}
