/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ProductdescriptionRow(
  /** Primary key for ProductDescription records.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productdescription","column_name":"productdescriptionid","ordinal_position":1,"column_default":"nextval('production.productdescription_productdescriptionid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productdescription","column_name":"description","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":400,"character_octet_length":1600,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  description: String,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productdescription","column_name":"rowguid","ordinal_position":3,"column_default":"uuid_generate_v1()","is_nullable":"NO","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: UUID,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productdescription","column_name":"modifieddate","ordinal_position":4,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object ProductdescriptionRow {
  def rowParser(prefix: String): RowParser[ProductdescriptionRow] = { row =>
    Success(
      ProductdescriptionRow(
        productdescriptionid = row[ProductdescriptionId](prefix + "productdescriptionid"),
        description = row[String](prefix + "description"),
        rowguid = row[UUID](prefix + "rowguid"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[ProductdescriptionRow] = new OFormat[ProductdescriptionRow]{
    override def writes(o: ProductdescriptionRow): JsObject =
      Json.obj(
        "productdescriptionid" -> o.productdescriptionid,
        "description" -> o.description,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductdescriptionRow] = {
      JsResult.fromTry(
        Try(
          ProductdescriptionRow(
            productdescriptionid = json.\("productdescriptionid").as[ProductdescriptionId],
            description = json.\("description").as[String],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
