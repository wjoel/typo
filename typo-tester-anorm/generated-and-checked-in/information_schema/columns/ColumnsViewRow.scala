/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class ColumnsViewRow(
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  ordinalPosition: Option[CardinalNumber],
  columnDefault: Option[CharacterData],
  isNullable: Option[YesOrNo],
  dataType: Option[CharacterData],
  characterMaximumLength: Option[CardinalNumber],
  characterOctetLength: Option[CardinalNumber],
  numericPrecision: Option[CardinalNumber],
  numericPrecisionRadix: Option[CardinalNumber],
  numericScale: Option[CardinalNumber],
  datetimePrecision: Option[CardinalNumber],
  intervalType: Option[CharacterData],
  intervalPrecision: Option[CardinalNumber],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier],
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  domainCatalog: Option[SqlIdentifier],
  domainSchema: Option[SqlIdentifier],
  domainName: Option[SqlIdentifier],
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  scopeCatalog: Option[SqlIdentifier],
  scopeSchema: Option[SqlIdentifier],
  scopeName: Option[SqlIdentifier],
  maximumCardinality: Option[CardinalNumber],
  dtdIdentifier: Option[SqlIdentifier],
  isSelfReferencing: Option[YesOrNo],
  isIdentity: Option[YesOrNo],
  identityGeneration: Option[CharacterData],
  identityStart: Option[CharacterData],
  identityIncrement: Option[CharacterData],
  identityMaximum: Option[CharacterData],
  identityMinimum: Option[CharacterData],
  identityCycle: Option[YesOrNo],
  isGenerated: Option[CharacterData],
  generationExpression: Option[CharacterData],
  isUpdatable: Option[YesOrNo]
)

object ColumnsViewRow {
  implicit lazy val reads: Reads[ColumnsViewRow] = Reads[ColumnsViewRow](json => JsResult.fromTry(
      Try(
        ColumnsViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          columnName = json.\("column_name").toOption.map(_.as(SqlIdentifier.reads)),
          ordinalPosition = json.\("ordinal_position").toOption.map(_.as(CardinalNumber.reads)),
          columnDefault = json.\("column_default").toOption.map(_.as(CharacterData.reads)),
          isNullable = json.\("is_nullable").toOption.map(_.as(YesOrNo.reads)),
          dataType = json.\("data_type").toOption.map(_.as(CharacterData.reads)),
          characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as(CardinalNumber.reads)),
          characterOctetLength = json.\("character_octet_length").toOption.map(_.as(CardinalNumber.reads)),
          numericPrecision = json.\("numeric_precision").toOption.map(_.as(CardinalNumber.reads)),
          numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as(CardinalNumber.reads)),
          numericScale = json.\("numeric_scale").toOption.map(_.as(CardinalNumber.reads)),
          datetimePrecision = json.\("datetime_precision").toOption.map(_.as(CardinalNumber.reads)),
          intervalType = json.\("interval_type").toOption.map(_.as(CharacterData.reads)),
          intervalPrecision = json.\("interval_precision").toOption.map(_.as(CardinalNumber.reads)),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetName = json.\("character_set_name").toOption.map(_.as(SqlIdentifier.reads)),
          collationCatalog = json.\("collation_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          collationSchema = json.\("collation_schema").toOption.map(_.as(SqlIdentifier.reads)),
          collationName = json.\("collation_name").toOption.map(_.as(SqlIdentifier.reads)),
          domainCatalog = json.\("domain_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          domainSchema = json.\("domain_schema").toOption.map(_.as(SqlIdentifier.reads)),
          domainName = json.\("domain_name").toOption.map(_.as(SqlIdentifier.reads)),
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(SqlIdentifier.reads)),
          udtName = json.\("udt_name").toOption.map(_.as(SqlIdentifier.reads)),
          scopeCatalog = json.\("scope_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          scopeSchema = json.\("scope_schema").toOption.map(_.as(SqlIdentifier.reads)),
          scopeName = json.\("scope_name").toOption.map(_.as(SqlIdentifier.reads)),
          maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as(CardinalNumber.reads)),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as(SqlIdentifier.reads)),
          isSelfReferencing = json.\("is_self_referencing").toOption.map(_.as(YesOrNo.reads)),
          isIdentity = json.\("is_identity").toOption.map(_.as(YesOrNo.reads)),
          identityGeneration = json.\("identity_generation").toOption.map(_.as(CharacterData.reads)),
          identityStart = json.\("identity_start").toOption.map(_.as(CharacterData.reads)),
          identityIncrement = json.\("identity_increment").toOption.map(_.as(CharacterData.reads)),
          identityMaximum = json.\("identity_maximum").toOption.map(_.as(CharacterData.reads)),
          identityMinimum = json.\("identity_minimum").toOption.map(_.as(CharacterData.reads)),
          identityCycle = json.\("identity_cycle").toOption.map(_.as(YesOrNo.reads)),
          isGenerated = json.\("is_generated").toOption.map(_.as(CharacterData.reads)),
          generationExpression = json.\("generation_expression").toOption.map(_.as(CharacterData.reads)),
          isUpdatable = json.\("is_updatable").toOption.map(_.as(YesOrNo.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnsViewRow] = RowParser[ColumnsViewRow] { row =>
    Success(
      ColumnsViewRow(
        tableCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        columnName = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        ordinalPosition = row(idx + 4)(Column.columnToOption(CardinalNumber.column)),
        columnDefault = row(idx + 5)(Column.columnToOption(CharacterData.column)),
        isNullable = row(idx + 6)(Column.columnToOption(YesOrNo.column)),
        dataType = row(idx + 7)(Column.columnToOption(CharacterData.column)),
        characterMaximumLength = row(idx + 8)(Column.columnToOption(CardinalNumber.column)),
        characterOctetLength = row(idx + 9)(Column.columnToOption(CardinalNumber.column)),
        numericPrecision = row(idx + 10)(Column.columnToOption(CardinalNumber.column)),
        numericPrecisionRadix = row(idx + 11)(Column.columnToOption(CardinalNumber.column)),
        numericScale = row(idx + 12)(Column.columnToOption(CardinalNumber.column)),
        datetimePrecision = row(idx + 13)(Column.columnToOption(CardinalNumber.column)),
        intervalType = row(idx + 14)(Column.columnToOption(CharacterData.column)),
        intervalPrecision = row(idx + 15)(Column.columnToOption(CardinalNumber.column)),
        characterSetCatalog = row(idx + 16)(Column.columnToOption(SqlIdentifier.column)),
        characterSetSchema = row(idx + 17)(Column.columnToOption(SqlIdentifier.column)),
        characterSetName = row(idx + 18)(Column.columnToOption(SqlIdentifier.column)),
        collationCatalog = row(idx + 19)(Column.columnToOption(SqlIdentifier.column)),
        collationSchema = row(idx + 20)(Column.columnToOption(SqlIdentifier.column)),
        collationName = row(idx + 21)(Column.columnToOption(SqlIdentifier.column)),
        domainCatalog = row(idx + 22)(Column.columnToOption(SqlIdentifier.column)),
        domainSchema = row(idx + 23)(Column.columnToOption(SqlIdentifier.column)),
        domainName = row(idx + 24)(Column.columnToOption(SqlIdentifier.column)),
        udtCatalog = row(idx + 25)(Column.columnToOption(SqlIdentifier.column)),
        udtSchema = row(idx + 26)(Column.columnToOption(SqlIdentifier.column)),
        udtName = row(idx + 27)(Column.columnToOption(SqlIdentifier.column)),
        scopeCatalog = row(idx + 28)(Column.columnToOption(SqlIdentifier.column)),
        scopeSchema = row(idx + 29)(Column.columnToOption(SqlIdentifier.column)),
        scopeName = row(idx + 30)(Column.columnToOption(SqlIdentifier.column)),
        maximumCardinality = row(idx + 31)(Column.columnToOption(CardinalNumber.column)),
        dtdIdentifier = row(idx + 32)(Column.columnToOption(SqlIdentifier.column)),
        isSelfReferencing = row(idx + 33)(Column.columnToOption(YesOrNo.column)),
        isIdentity = row(idx + 34)(Column.columnToOption(YesOrNo.column)),
        identityGeneration = row(idx + 35)(Column.columnToOption(CharacterData.column)),
        identityStart = row(idx + 36)(Column.columnToOption(CharacterData.column)),
        identityIncrement = row(idx + 37)(Column.columnToOption(CharacterData.column)),
        identityMaximum = row(idx + 38)(Column.columnToOption(CharacterData.column)),
        identityMinimum = row(idx + 39)(Column.columnToOption(CharacterData.column)),
        identityCycle = row(idx + 40)(Column.columnToOption(YesOrNo.column)),
        isGenerated = row(idx + 41)(Column.columnToOption(CharacterData.column)),
        generationExpression = row(idx + 42)(Column.columnToOption(CharacterData.column)),
        isUpdatable = row(idx + 43)(Column.columnToOption(YesOrNo.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ColumnsViewRow] = OWrites[ColumnsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.columnName),
      "ordinal_position" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.ordinalPosition),
      "column_default" -> Writes.OptionWrites(CharacterData.writes).writes(o.columnDefault),
      "is_nullable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isNullable),
      "data_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.dataType),
      "character_maximum_length" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.characterMaximumLength),
      "character_octet_length" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.characterOctetLength),
      "numeric_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericPrecision),
      "numeric_precision_radix" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericPrecisionRadix),
      "numeric_scale" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericScale),
      "datetime_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.datetimePrecision),
      "interval_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.intervalType),
      "interval_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.intervalPrecision),
      "character_set_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetCatalog),
      "character_set_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetSchema),
      "character_set_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetName),
      "collation_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationCatalog),
      "collation_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationSchema),
      "collation_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationName),
      "domain_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainCatalog),
      "domain_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainSchema),
      "domain_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainName),
      "udt_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtName),
      "scope_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeCatalog),
      "scope_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeSchema),
      "scope_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeName),
      "maximum_cardinality" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.maximumCardinality),
      "dtd_identifier" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.dtdIdentifier),
      "is_self_referencing" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isSelfReferencing),
      "is_identity" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isIdentity),
      "identity_generation" -> Writes.OptionWrites(CharacterData.writes).writes(o.identityGeneration),
      "identity_start" -> Writes.OptionWrites(CharacterData.writes).writes(o.identityStart),
      "identity_increment" -> Writes.OptionWrites(CharacterData.writes).writes(o.identityIncrement),
      "identity_maximum" -> Writes.OptionWrites(CharacterData.writes).writes(o.identityMaximum),
      "identity_minimum" -> Writes.OptionWrites(CharacterData.writes).writes(o.identityMinimum),
      "identity_cycle" -> Writes.OptionWrites(YesOrNo.writes).writes(o.identityCycle),
      "is_generated" -> Writes.OptionWrites(CharacterData.writes).writes(o.isGenerated),
      "generation_expression" -> Writes.OptionWrites(CharacterData.writes).writes(o.generationExpression),
      "is_updatable" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isUpdatable)
    ))
  )
}