/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package d

import adventureworks.humanresources.department.DepartmentId
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

case class DRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"d","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[humanresources.department.DepartmentRow.departmentid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"d","column_name":"departmentid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  departmentid: Option[DepartmentId],
  /** Points to [[humanresources.department.DepartmentRow.name]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"d","column_name":"name","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  name: Option[Name],
  /** Points to [[humanresources.department.DepartmentRow.groupname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"d","column_name":"groupname","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  groupname: Option[Name],
  /** Points to [[humanresources.department.DepartmentRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"d","column_name":"modifieddate","ordinal_position":5,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object DRow {
  def rowParser(prefix: String): RowParser[DRow] = { row =>
    Success(
      DRow(
        id = row[Option[Int]](prefix + "id"),
        departmentid = row[Option[DepartmentId]](prefix + "departmentid"),
        name = row[Option[Name]](prefix + "name"),
        groupname = row[Option[Name]](prefix + "groupname"),
        modifieddate = row[Option[LocalDateTime]](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[DRow] = new OFormat[DRow]{
    override def writes(o: DRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "departmentid" -> o.departmentid,
        "name" -> o.name,
        "groupname" -> o.groupname,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[DRow] = {
      JsResult.fromTry(
        Try(
          DRow(
            id = json.\("id").toOption.map(_.as[Int]),
            departmentid = json.\("departmentid").toOption.map(_.as[DepartmentId]),
            name = json.\("name").toOption.map(_.as[Name]),
            groupname = json.\("groupname").toOption.map(_.as[Name]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
