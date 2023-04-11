/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.time.LocalDate
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VemployeedepartmenthistoryRow(
  /** Points to [[person.person.PersonRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"businessentityid","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.title]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"title","ordinal_position":2,"is_nullable":"YES","data_type":"character varying","character_maximum_length":8,"character_octet_length":32,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  title: Option[String],
  /** Points to [[person.person.PersonRow.firstname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"firstname","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"middlename","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"lastname","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"suffix","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":10,"character_octet_length":40,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  suffix: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"shift","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  shift: Option[Name],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"department","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  department: Option[Name],
  /** Points to [[department.DepartmentRow.groupname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"groupname","ordinal_position":9,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  groupname: Option[Name],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"startdate","ordinal_position":10,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  startdate: Option[LocalDate],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.enddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"vemployeedepartmenthistory","column_name":"enddate","ordinal_position":11,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  enddate: Option[LocalDate]
)

object VemployeedepartmenthistoryRow {
  implicit val oFormat: OFormat[VemployeedepartmenthistoryRow] = new OFormat[VemployeedepartmenthistoryRow]{
    override def writes(o: VemployeedepartmenthistoryRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "title" -> o.title,
        "firstname" -> o.firstname,
        "middlename" -> o.middlename,
        "lastname" -> o.lastname,
        "suffix" -> o.suffix,
        "shift" -> o.shift,
        "department" -> o.department,
        "groupname" -> o.groupname,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate
      )
  
    override def reads(json: JsValue): JsResult[VemployeedepartmenthistoryRow] = {
      JsResult.fromTry(
        Try(
          VemployeedepartmenthistoryRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            title = json.\("title").toOption.map(_.as[String]),
            firstname = json.\("firstname").toOption.map(_.as[Name]),
            middlename = json.\("middlename").toOption.map(_.as[Name]),
            lastname = json.\("lastname").toOption.map(_.as[Name]),
            suffix = json.\("suffix").toOption.map(_.as[String]),
            shift = json.\("shift").toOption.map(_.as[Name]),
            department = json.\("department").toOption.map(_.as[Name]),
            groupname = json.\("groupname").toOption.map(_.as[Name]),
            startdate = json.\("startdate").toOption.map(_.as[LocalDate]),
            enddate = json.\("enddate").toOption.map(_.as[LocalDate])
          )
        )
      )
    }
  }
}