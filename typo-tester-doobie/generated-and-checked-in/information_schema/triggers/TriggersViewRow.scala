/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.TimeStamp
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class TriggersViewRow(
  triggerCatalog: Option[SqlIdentifier],
  triggerSchema: Option[SqlIdentifier],
  triggerName: Option[SqlIdentifier],
  eventManipulation: Option[CharacterData],
  eventObjectCatalog: Option[SqlIdentifier],
  eventObjectSchema: Option[SqlIdentifier],
  eventObjectTable: Option[SqlIdentifier],
  actionOrder: Option[CardinalNumber],
  actionCondition: Option[CharacterData],
  actionStatement: Option[CharacterData],
  actionOrientation: Option[CharacterData],
  actionTiming: Option[CharacterData],
  actionReferenceOldTable: Option[SqlIdentifier],
  actionReferenceNewTable: Option[SqlIdentifier],
  actionReferenceOldRow: Option[SqlIdentifier],
  actionReferenceNewRow: Option[SqlIdentifier],
  created: Option[TimeStamp]
)

object TriggersViewRow {
  implicit val decoder: Decoder[TriggersViewRow] = Decoder.forProduct17[TriggersViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CardinalNumber], Option[CharacterData], Option[CharacterData], Option[CharacterData], Option[CharacterData], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[TimeStamp]]("trigger_catalog", "trigger_schema", "trigger_name", "event_manipulation", "event_object_catalog", "event_object_schema", "event_object_table", "action_order", "action_condition", "action_statement", "action_orientation", "action_timing", "action_reference_old_table", "action_reference_new_table", "action_reference_old_row", "action_reference_new_row", "created")(TriggersViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CardinalNumber.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(TimeStamp.decoder))
  implicit val encoder: Encoder[TriggersViewRow] = Encoder.forProduct17[TriggersViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CardinalNumber], Option[CharacterData], Option[CharacterData], Option[CharacterData], Option[CharacterData], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[TimeStamp]]("trigger_catalog", "trigger_schema", "trigger_name", "event_manipulation", "event_object_catalog", "event_object_schema", "event_object_table", "action_order", "action_condition", "action_statement", "action_orientation", "action_timing", "action_reference_old_table", "action_reference_new_table", "action_reference_old_row", "action_reference_new_row", "created")(x => (x.triggerCatalog, x.triggerSchema, x.triggerName, x.eventManipulation, x.eventObjectCatalog, x.eventObjectSchema, x.eventObjectTable, x.actionOrder, x.actionCondition, x.actionStatement, x.actionOrientation, x.actionTiming, x.actionReferenceOldTable, x.actionReferenceNewTable, x.actionReferenceOldRow, x.actionReferenceNewRow, x.created))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CardinalNumber.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(TimeStamp.encoder))
  implicit val read: Read[TriggersViewRow] = new Read[TriggersViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (TimeStamp.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => TriggersViewRow(
      triggerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      triggerSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      triggerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      eventManipulation = CharacterData.get.unsafeGetNullable(rs, i + 3),
      eventObjectCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      eventObjectSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      eventObjectTable = SqlIdentifier.get.unsafeGetNullable(rs, i + 6),
      actionOrder = CardinalNumber.get.unsafeGetNullable(rs, i + 7),
      actionCondition = CharacterData.get.unsafeGetNullable(rs, i + 8),
      actionStatement = CharacterData.get.unsafeGetNullable(rs, i + 9),
      actionOrientation = CharacterData.get.unsafeGetNullable(rs, i + 10),
      actionTiming = CharacterData.get.unsafeGetNullable(rs, i + 11),
      actionReferenceOldTable = SqlIdentifier.get.unsafeGetNullable(rs, i + 12),
      actionReferenceNewTable = SqlIdentifier.get.unsafeGetNullable(rs, i + 13),
      actionReferenceOldRow = SqlIdentifier.get.unsafeGetNullable(rs, i + 14),
      actionReferenceNewRow = SqlIdentifier.get.unsafeGetNullable(rs, i + 15),
      created = TimeStamp.get.unsafeGetNullable(rs, i + 16)
    )
  )
}
