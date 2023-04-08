/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.person.stateprovince.StateprovinceId
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

case class AddressRow(
  /** Primary key for Address records.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"addressid","ordinal_position":1,"column_default":"nextval('person.address_addressid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  addressid: AddressId,
  /** First street address line.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"addressline1","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":60,"character_octet_length":240,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  addressline1: String,
  /** Second street address line.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"addressline2","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":60,"character_octet_length":240,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  addressline2: Option[String],
  /** Name of the city.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"city","ordinal_position":4,"is_nullable":"NO","data_type":"character varying","character_maximum_length":30,"character_octet_length":120,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  city: String,
  /** Unique identification number for the state or province. Foreign key to StateProvince table.
      Points to [[stateprovince.StateprovinceRow.stateprovinceid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"stateprovinceid","ordinal_position":5,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  stateprovinceid: StateprovinceId,
  /** Postal code for the street address.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"postalcode","ordinal_position":6,"is_nullable":"NO","data_type":"character varying","character_maximum_length":15,"character_octet_length":60,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  postalcode: String,
  /** Latitude and longitude of this address.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"spatiallocation","ordinal_position":7,"is_nullable":"YES","data_type":"bytea","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bytea","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  spatiallocation: Option[Array[Byte]],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"rowguid","ordinal_position":8,"column_default":"uuid_generate_v1()","is_nullable":"NO","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: UUID,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"address","column_name":"modifieddate","ordinal_position":9,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object AddressRow {
  def rowParser(prefix: String): RowParser[AddressRow] = { row =>
    Success(
      AddressRow(
        addressid = row[AddressId](prefix + "addressid"),
        addressline1 = row[String](prefix + "addressline1"),
        addressline2 = row[Option[String]](prefix + "addressline2"),
        city = row[String](prefix + "city"),
        stateprovinceid = row[StateprovinceId](prefix + "stateprovinceid"),
        postalcode = row[String](prefix + "postalcode"),
        spatiallocation = row[Option[Array[Byte]]](prefix + "spatiallocation"),
        rowguid = row[UUID](prefix + "rowguid"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[AddressRow] = new OFormat[AddressRow]{
    override def writes(o: AddressRow): JsObject =
      Json.obj(
        "addressid" -> o.addressid,
        "addressline1" -> o.addressline1,
        "addressline2" -> o.addressline2,
        "city" -> o.city,
        "stateprovinceid" -> o.stateprovinceid,
        "postalcode" -> o.postalcode,
        "spatiallocation" -> o.spatiallocation,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[AddressRow] = {
      JsResult.fromTry(
        Try(
          AddressRow(
            addressid = json.\("addressid").as[AddressId],
            addressline1 = json.\("addressline1").as[String],
            addressline2 = json.\("addressline2").toOption.map(_.as[String]),
            city = json.\("city").as[String],
            stateprovinceid = json.\("stateprovinceid").as[StateprovinceId],
            postalcode = json.\("postalcode").as[String],
            spatiallocation = json.\("spatiallocation").toOption.map(_.as[Array[Byte]]),
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
