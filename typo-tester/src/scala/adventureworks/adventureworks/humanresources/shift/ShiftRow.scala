/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.time.LocalTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ShiftRow(
  /** Primary key for Shift records.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"shift","column_name":"shiftid","ordinal_position":1,"column_default":"nextval('humanresources.shift_shiftid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  shiftid: ShiftId,
  /** Shift description.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"shift","column_name":"name","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  name: Name,
  /** Shift start time.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"shift","column_name":"starttime","ordinal_position":3,"is_nullable":"NO","data_type":"time without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"time","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  starttime: LocalTime,
  /** Shift end time.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"shift","column_name":"endtime","ordinal_position":4,"is_nullable":"NO","data_type":"time without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"time","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  endtime: LocalTime,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"shift","column_name":"modifieddate","ordinal_position":5,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object ShiftRow {
  def rowParser(prefix: String): RowParser[ShiftRow] = { row =>
    Success(
      ShiftRow(
        shiftid = row[ShiftId](prefix + "shiftid"),
        name = row[Name](prefix + "name"),
        starttime = row[LocalTime](prefix + "starttime"),
        endtime = row[LocalTime](prefix + "endtime"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[ShiftRow] = new OFormat[ShiftRow]{
    override def writes(o: ShiftRow): JsObject =
      Json.obj(
        "shiftid" -> o.shiftid,
        "name" -> o.name,
        "starttime" -> o.starttime,
        "endtime" -> o.endtime,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ShiftRow] = {
      JsResult.fromTry(
        Try(
          ShiftRow(
            shiftid = json.\("shiftid").as[ShiftId],
            name = json.\("name").as[Name],
            starttime = json.\("starttime").as[LocalTime],
            endtime = json.\("endtime").as[LocalTime],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
