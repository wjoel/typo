/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ElementTypesRow(
  objectCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"object_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[DataTypePrivilegesRow.objectSchema]] */
  objectSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"object_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[DataTypePrivilegesRow.objectName]] */
  objectName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"object_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[DataTypePrivilegesRow.objectType]] */
  objectType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"object_type","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collectionTypeIdentifier: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"collection_type_identifier","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  dataType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"data_type","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterMaximumLength: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"character_maximum_length","ordinal_position":7,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterOctetLength: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"character_octet_length","ordinal_position":8,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"character_set_catalog","ordinal_position":9,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"character_set_schema","ordinal_position":10,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"character_set_name","ordinal_position":11,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collationCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"collation_catalog","ordinal_position":12,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collationSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"collation_schema","ordinal_position":13,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collationName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"collation_name","ordinal_position":14,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numericPrecision: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"numeric_precision","ordinal_position":15,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numericPrecisionRadix: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"numeric_precision_radix","ordinal_position":16,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numericScale: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"numeric_scale","ordinal_position":17,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datetimePrecision: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"datetime_precision","ordinal_position":18,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  intervalType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"interval_type","ordinal_position":19,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  intervalPrecision: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"interval_precision","ordinal_position":20,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  domainDefault: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"domain_default","ordinal_position":21,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  udtCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"udt_catalog","ordinal_position":22,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  udtSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"udt_schema","ordinal_position":23,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  udtName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"udt_name","ordinal_position":24,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"24","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  scopeCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"scope_catalog","ordinal_position":25,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"25","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  scopeSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"scope_schema","ordinal_position":26,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"26","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  scopeName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"scope_name","ordinal_position":27,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"27","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  maximumCardinality: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"maximum_cardinality","ordinal_position":28,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"28","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[DataTypePrivilegesRow.dtdIdentifier]] */
  dtdIdentifier: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"element_types","column_name":"dtd_identifier","ordinal_position":29,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"29","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object ElementTypesRow {
  def rowParser(prefix: String): RowParser[ElementTypesRow] = { row =>
    Success(
      ElementTypesRow(
        objectCatalog = row[Option[String]](prefix + "object_catalog"),
        objectSchema = row[Option[String]](prefix + "object_schema"),
        objectName = row[Option[String]](prefix + "object_name"),
        objectType = row[Option[String]](prefix + "object_type"),
        collectionTypeIdentifier = row[Option[String]](prefix + "collection_type_identifier"),
        dataType = row[Option[String]](prefix + "data_type"),
        characterMaximumLength = row[Option[Int]](prefix + "character_maximum_length"),
        characterOctetLength = row[Option[Int]](prefix + "character_octet_length"),
        characterSetCatalog = row[Option[String]](prefix + "character_set_catalog"),
        characterSetSchema = row[Option[String]](prefix + "character_set_schema"),
        characterSetName = row[Option[String]](prefix + "character_set_name"),
        collationCatalog = row[Option[String]](prefix + "collation_catalog"),
        collationSchema = row[Option[String]](prefix + "collation_schema"),
        collationName = row[Option[String]](prefix + "collation_name"),
        numericPrecision = row[Option[Int]](prefix + "numeric_precision"),
        numericPrecisionRadix = row[Option[Int]](prefix + "numeric_precision_radix"),
        numericScale = row[Option[Int]](prefix + "numeric_scale"),
        datetimePrecision = row[Option[Int]](prefix + "datetime_precision"),
        intervalType = row[Option[String]](prefix + "interval_type"),
        intervalPrecision = row[Option[Int]](prefix + "interval_precision"),
        domainDefault = row[Option[String]](prefix + "domain_default"),
        udtCatalog = row[Option[String]](prefix + "udt_catalog"),
        udtSchema = row[Option[String]](prefix + "udt_schema"),
        udtName = row[Option[String]](prefix + "udt_name"),
        scopeCatalog = row[Option[String]](prefix + "scope_catalog"),
        scopeSchema = row[Option[String]](prefix + "scope_schema"),
        scopeName = row[Option[String]](prefix + "scope_name"),
        maximumCardinality = row[Option[Int]](prefix + "maximum_cardinality"),
        dtdIdentifier = row[Option[String]](prefix + "dtd_identifier")
      )
    )
  }

  implicit val oFormat: OFormat[ElementTypesRow] = new OFormat[ElementTypesRow]{
    override def writes(o: ElementTypesRow): JsObject =
      Json.obj(
        "object_catalog" -> o.objectCatalog,
      "object_schema" -> o.objectSchema,
      "object_name" -> o.objectName,
      "object_type" -> o.objectType,
      "collection_type_identifier" -> o.collectionTypeIdentifier,
      "data_type" -> o.dataType,
      "character_maximum_length" -> o.characterMaximumLength,
      "character_octet_length" -> o.characterOctetLength,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "numeric_precision" -> o.numericPrecision,
      "numeric_precision_radix" -> o.numericPrecisionRadix,
      "numeric_scale" -> o.numericScale,
      "datetime_precision" -> o.datetimePrecision,
      "interval_type" -> o.intervalType,
      "interval_precision" -> o.intervalPrecision,
      "domain_default" -> o.domainDefault,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "scope_catalog" -> o.scopeCatalog,
      "scope_schema" -> o.scopeSchema,
      "scope_name" -> o.scopeName,
      "maximum_cardinality" -> o.maximumCardinality,
      "dtd_identifier" -> o.dtdIdentifier
      )

    override def reads(json: JsValue): JsResult[ElementTypesRow] = {
      JsResult.fromTry(
        Try(
          ElementTypesRow(
            objectCatalog = json.\("object_catalog").toOption.map(_.as[String]),
            objectSchema = json.\("object_schema").toOption.map(_.as[String]),
            objectName = json.\("object_name").toOption.map(_.as[String]),
            objectType = json.\("object_type").toOption.map(_.as[String]),
            collectionTypeIdentifier = json.\("collection_type_identifier").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[String]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[Int]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[Int]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[Int]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[Int]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[Int]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[Int]),
            intervalType = json.\("interval_type").toOption.map(_.as[String]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[Int]),
            domainDefault = json.\("domain_default").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[String]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[String]),
            scopeName = json.\("scope_name").toOption.map(_.as[String]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[Int]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
