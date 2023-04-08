/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.person.businessentity.BusinessentityId
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

case class ERow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"e","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[person.emailaddress.EmailaddressRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"e","column_name":"businessentityid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"e","column_name":"emailaddressid","ordinal_position":3,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  emailaddressid: Option[Int],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"e","column_name":"emailaddress","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  emailaddress: Option[String],
  /** Points to [[person.emailaddress.EmailaddressRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"e","column_name":"rowguid","ordinal_position":5,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[person.emailaddress.EmailaddressRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"e","column_name":"modifieddate","ordinal_position":6,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object ERow {
  def rowParser(prefix: String): RowParser[ERow] = { row =>
    Success(
      ERow(
        id = row[Option[Int]](prefix + "id"),
        businessentityid = row[Option[BusinessentityId]](prefix + "businessentityid"),
        emailaddressid = row[Option[Int]](prefix + "emailaddressid"),
        emailaddress = row[Option[String]](prefix + "emailaddress"),
        rowguid = row[Option[UUID]](prefix + "rowguid"),
        modifieddate = row[Option[LocalDateTime]](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[ERow] = new OFormat[ERow]{
    override def writes(o: ERow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "emailaddressid" -> o.emailaddressid,
        "emailaddress" -> o.emailaddress,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ERow] = {
      JsResult.fromTry(
        Try(
          ERow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            emailaddressid = json.\("emailaddressid").toOption.map(_.as[Int]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[String]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
