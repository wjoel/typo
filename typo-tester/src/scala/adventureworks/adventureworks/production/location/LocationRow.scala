/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class LocationRow(
  /** Primary key for Location records.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"location","column_name":"locationid","ordinal_position":1,"column_default":"nextval('production.location_locationid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  locationid: LocationId,
  /** Location description.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"location","column_name":"name","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  name: Name,
  /** Standard hourly cost of the manufacturing location.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"location","column_name":"costrate","ordinal_position":3,"column_default":"0.00","is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  costrate: BigDecimal,
  /** Work capacity (in hours) of the manufacturing location.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"location","column_name":"availability","ordinal_position":4,"column_default":"0.00","is_nullable":"NO","data_type":"numeric","numeric_precision":8,"numeric_precision_radix":10,"numeric_scale":2,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  availability: BigDecimal,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"location","column_name":"modifieddate","ordinal_position":5,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object LocationRow {
  def rowParser(prefix: String): RowParser[LocationRow] = { row =>
    Success(
      LocationRow(
        locationid = row[LocationId](prefix + "locationid"),
        name = row[Name](prefix + "name"),
        costrate = row[BigDecimal](prefix + "costrate"),
        availability = row[BigDecimal](prefix + "availability"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[LocationRow] = new OFormat[LocationRow]{
    override def writes(o: LocationRow): JsObject =
      Json.obj(
        "locationid" -> o.locationid,
        "name" -> o.name,
        "costrate" -> o.costrate,
        "availability" -> o.availability,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[LocationRow] = {
      JsResult.fromTry(
        Try(
          LocationRow(
            locationid = json.\("locationid").as[LocationId],
            name = json.\("name").as[Name],
            costrate = json.\("costrate").as[BigDecimal],
            availability = json.\("availability").as[BigDecimal],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
