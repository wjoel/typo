/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_defined_types

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

case class UserDefinedTypesViewRow(
  userDefinedTypeCatalog: Option[SqlIdentifier],
  userDefinedTypeSchema: Option[SqlIdentifier],
  userDefinedTypeName: Option[SqlIdentifier],
  userDefinedTypeCategory: Option[CharacterData],
  isInstantiable: Option[YesOrNo],
  isFinal: Option[YesOrNo],
  orderingForm: Option[CharacterData],
  orderingCategory: Option[CharacterData],
  orderingRoutineCatalog: Option[SqlIdentifier],
  orderingRoutineSchema: Option[SqlIdentifier],
  orderingRoutineName: Option[SqlIdentifier],
  referenceType: Option[CharacterData],
  dataType: Option[CharacterData],
  characterMaximumLength: Option[CardinalNumber],
  characterOctetLength: Option[CardinalNumber],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier],
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  numericPrecision: Option[CardinalNumber],
  numericPrecisionRadix: Option[CardinalNumber],
  numericScale: Option[CardinalNumber],
  datetimePrecision: Option[CardinalNumber],
  intervalType: Option[CharacterData],
  intervalPrecision: Option[CardinalNumber],
  sourceDtdIdentifier: Option[SqlIdentifier],
  refDtdIdentifier: Option[SqlIdentifier]
)

object UserDefinedTypesViewRow {
  implicit val decoder: Decoder[UserDefinedTypesViewRow] = Decoder.instanceTry[UserDefinedTypesViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      UserDefinedTypesViewRow(
        userDefinedTypeCatalog = orThrow(c.get("user_defined_type_catalog")(Decoder.decodeOption(SqlIdentifier.decoder))),
        userDefinedTypeSchema = orThrow(c.get("user_defined_type_schema")(Decoder.decodeOption(SqlIdentifier.decoder))),
        userDefinedTypeName = orThrow(c.get("user_defined_type_name")(Decoder.decodeOption(SqlIdentifier.decoder))),
        userDefinedTypeCategory = orThrow(c.get("user_defined_type_category")(Decoder.decodeOption(CharacterData.decoder))),
        isInstantiable = orThrow(c.get("is_instantiable")(Decoder.decodeOption(YesOrNo.decoder))),
        isFinal = orThrow(c.get("is_final")(Decoder.decodeOption(YesOrNo.decoder))),
        orderingForm = orThrow(c.get("ordering_form")(Decoder.decodeOption(CharacterData.decoder))),
        orderingCategory = orThrow(c.get("ordering_category")(Decoder.decodeOption(CharacterData.decoder))),
        orderingRoutineCatalog = orThrow(c.get("ordering_routine_catalog")(Decoder.decodeOption(SqlIdentifier.decoder))),
        orderingRoutineSchema = orThrow(c.get("ordering_routine_schema")(Decoder.decodeOption(SqlIdentifier.decoder))),
        orderingRoutineName = orThrow(c.get("ordering_routine_name")(Decoder.decodeOption(SqlIdentifier.decoder))),
        referenceType = orThrow(c.get("reference_type")(Decoder.decodeOption(CharacterData.decoder))),
        dataType = orThrow(c.get("data_type")(Decoder.decodeOption(CharacterData.decoder))),
        characterMaximumLength = orThrow(c.get("character_maximum_length")(Decoder.decodeOption(CardinalNumber.decoder))),
        characterOctetLength = orThrow(c.get("character_octet_length")(Decoder.decodeOption(CardinalNumber.decoder))),
        characterSetCatalog = orThrow(c.get("character_set_catalog")(Decoder.decodeOption(SqlIdentifier.decoder))),
        characterSetSchema = orThrow(c.get("character_set_schema")(Decoder.decodeOption(SqlIdentifier.decoder))),
        characterSetName = orThrow(c.get("character_set_name")(Decoder.decodeOption(SqlIdentifier.decoder))),
        collationCatalog = orThrow(c.get("collation_catalog")(Decoder.decodeOption(SqlIdentifier.decoder))),
        collationSchema = orThrow(c.get("collation_schema")(Decoder.decodeOption(SqlIdentifier.decoder))),
        collationName = orThrow(c.get("collation_name")(Decoder.decodeOption(SqlIdentifier.decoder))),
        numericPrecision = orThrow(c.get("numeric_precision")(Decoder.decodeOption(CardinalNumber.decoder))),
        numericPrecisionRadix = orThrow(c.get("numeric_precision_radix")(Decoder.decodeOption(CardinalNumber.decoder))),
        numericScale = orThrow(c.get("numeric_scale")(Decoder.decodeOption(CardinalNumber.decoder))),
        datetimePrecision = orThrow(c.get("datetime_precision")(Decoder.decodeOption(CardinalNumber.decoder))),
        intervalType = orThrow(c.get("interval_type")(Decoder.decodeOption(CharacterData.decoder))),
        intervalPrecision = orThrow(c.get("interval_precision")(Decoder.decodeOption(CardinalNumber.decoder))),
        sourceDtdIdentifier = orThrow(c.get("source_dtd_identifier")(Decoder.decodeOption(SqlIdentifier.decoder))),
        refDtdIdentifier = orThrow(c.get("ref_dtd_identifier")(Decoder.decodeOption(SqlIdentifier.decoder)))
      )
    }
  )
  implicit val encoder: Encoder[UserDefinedTypesViewRow] = Encoder[UserDefinedTypesViewRow](row =>
    Json.obj(
      "user_defined_type_catalog" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.userDefinedTypeCatalog),
      "user_defined_type_schema" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.userDefinedTypeSchema),
      "user_defined_type_name" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.userDefinedTypeName),
      "user_defined_type_category" -> Encoder.encodeOption(CharacterData.encoder).apply(row.userDefinedTypeCategory),
      "is_instantiable" -> Encoder.encodeOption(YesOrNo.encoder).apply(row.isInstantiable),
      "is_final" -> Encoder.encodeOption(YesOrNo.encoder).apply(row.isFinal),
      "ordering_form" -> Encoder.encodeOption(CharacterData.encoder).apply(row.orderingForm),
      "ordering_category" -> Encoder.encodeOption(CharacterData.encoder).apply(row.orderingCategory),
      "ordering_routine_catalog" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.orderingRoutineCatalog),
      "ordering_routine_schema" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.orderingRoutineSchema),
      "ordering_routine_name" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.orderingRoutineName),
      "reference_type" -> Encoder.encodeOption(CharacterData.encoder).apply(row.referenceType),
      "data_type" -> Encoder.encodeOption(CharacterData.encoder).apply(row.dataType),
      "character_maximum_length" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.characterMaximumLength),
      "character_octet_length" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.characterOctetLength),
      "character_set_catalog" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.characterSetCatalog),
      "character_set_schema" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.characterSetSchema),
      "character_set_name" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.characterSetName),
      "collation_catalog" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.collationCatalog),
      "collation_schema" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.collationSchema),
      "collation_name" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.collationName),
      "numeric_precision" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.numericPrecision),
      "numeric_precision_radix" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.numericPrecisionRadix),
      "numeric_scale" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.numericScale),
      "datetime_precision" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.datetimePrecision),
      "interval_type" -> Encoder.encodeOption(CharacterData.encoder).apply(row.intervalType),
      "interval_precision" -> Encoder.encodeOption(CardinalNumber.encoder).apply(row.intervalPrecision),
      "source_dtd_identifier" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.sourceDtdIdentifier),
      "ref_dtd_identifier" -> Encoder.encodeOption(SqlIdentifier.encoder).apply(row.refDtdIdentifier)
    )
  )
  implicit val read: Read[UserDefinedTypesViewRow] = new Read[UserDefinedTypesViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (YesOrNo.get, Nullability.Nullable),
      (YesOrNo.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (CardinalNumber.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => UserDefinedTypesViewRow(
      userDefinedTypeCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      userDefinedTypeSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      userDefinedTypeName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      userDefinedTypeCategory = CharacterData.get.unsafeGetNullable(rs, i + 3),
      isInstantiable = YesOrNo.get.unsafeGetNullable(rs, i + 4),
      isFinal = YesOrNo.get.unsafeGetNullable(rs, i + 5),
      orderingForm = CharacterData.get.unsafeGetNullable(rs, i + 6),
      orderingCategory = CharacterData.get.unsafeGetNullable(rs, i + 7),
      orderingRoutineCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 8),
      orderingRoutineSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 9),
      orderingRoutineName = SqlIdentifier.get.unsafeGetNullable(rs, i + 10),
      referenceType = CharacterData.get.unsafeGetNullable(rs, i + 11),
      dataType = CharacterData.get.unsafeGetNullable(rs, i + 12),
      characterMaximumLength = CardinalNumber.get.unsafeGetNullable(rs, i + 13),
      characterOctetLength = CardinalNumber.get.unsafeGetNullable(rs, i + 14),
      characterSetCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 15),
      characterSetSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 16),
      characterSetName = SqlIdentifier.get.unsafeGetNullable(rs, i + 17),
      collationCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 18),
      collationSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 19),
      collationName = SqlIdentifier.get.unsafeGetNullable(rs, i + 20),
      numericPrecision = CardinalNumber.get.unsafeGetNullable(rs, i + 21),
      numericPrecisionRadix = CardinalNumber.get.unsafeGetNullable(rs, i + 22),
      numericScale = CardinalNumber.get.unsafeGetNullable(rs, i + 23),
      datetimePrecision = CardinalNumber.get.unsafeGetNullable(rs, i + 24),
      intervalType = CharacterData.get.unsafeGetNullable(rs, i + 25),
      intervalPrecision = CardinalNumber.get.unsafeGetNullable(rs, i + 26),
      sourceDtdIdentifier = SqlIdentifier.get.unsafeGetNullable(rs, i + 27),
      refDtdIdentifier = SqlIdentifier.get.unsafeGetNullable(rs, i + 28)
    )
  )
}
