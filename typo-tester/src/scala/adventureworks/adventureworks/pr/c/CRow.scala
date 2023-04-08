/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import adventureworks.production.culture.CultureId
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

case class CRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"c","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"character","character_maximum_length":6,"character_octet_length":24,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[/* bpchar */ String],
  /** Points to [[production.culture.CultureRow.cultureid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"c","column_name":"cultureid","ordinal_position":2,"is_nullable":"YES","data_type":"character","character_maximum_length":6,"character_octet_length":24,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  cultureid: Option[CultureId],
  /** Points to [[production.culture.CultureRow.name]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"c","column_name":"name","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  name: Option[Name],
  /** Points to [[production.culture.CultureRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"c","column_name":"modifieddate","ordinal_position":4,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object CRow {
  def rowParser(prefix: String): RowParser[CRow] = { row =>
    Success(
      CRow(
        id = row[Option[/* bpchar */ String]](prefix + "id"),
        cultureid = row[Option[CultureId]](prefix + "cultureid"),
        name = row[Option[Name]](prefix + "name"),
        modifieddate = row[Option[LocalDateTime]](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[CRow] = new OFormat[CRow]{
    override def writes(o: CRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "cultureid" -> o.cultureid,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CRow] = {
      JsResult.fromTry(
        Try(
          CRow(
            id = json.\("id").toOption.map(_.as[/* bpchar */ String]),
            cultureid = json.\("cultureid").toOption.map(_.as[CultureId]),
            name = json.\("name").toOption.map(_.as[Name]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
