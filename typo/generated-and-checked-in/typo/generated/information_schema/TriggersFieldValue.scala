/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema

import java.time.LocalDateTime

sealed abstract class TriggersFieldValue[T](val name: String, val value: T)

object TriggersFieldValue {
  case class triggerCatalog(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("trigger_catalog", value)
  case class triggerSchema(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("trigger_schema", value)
  case class triggerName(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("trigger_name", value)
  case class eventManipulation(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("event_manipulation", value)
  case class eventObjectCatalog(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("event_object_catalog", value)
  case class eventObjectSchema(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("event_object_schema", value)
  case class eventObjectTable(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("event_object_table", value)
  case class actionOrder(override val value: /* unknown nullability */ Option[Int]) extends TriggersFieldValue("action_order", value)
  case class actionCondition(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_condition", value)
  case class actionStatement(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_statement", value)
  case class actionOrientation(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_orientation", value)
  case class actionTiming(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_timing", value)
  case class actionReferenceOldTable(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_reference_old_table", value)
  case class actionReferenceNewTable(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_reference_new_table", value)
  case class actionReferenceOldRow(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_reference_old_row", value)
  case class actionReferenceNewRow(override val value: /* unknown nullability */ Option[String]) extends TriggersFieldValue("action_reference_new_row", value)
  case class created(override val value: /* unknown nullability */ Option[LocalDateTime]) extends TriggersFieldValue("created", value)
}
