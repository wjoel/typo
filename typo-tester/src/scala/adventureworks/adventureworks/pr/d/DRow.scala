/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package d

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.document.DocumentId
import adventureworks.public.Flag
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

case class DRow(
  /** Points to [[production.document.DocumentRow.title]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"title","ordinal_position":1,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  title: Option[String],
  /** Points to [[production.document.DocumentRow.owner]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"owner","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  owner: Option[BusinessentityId],
  /** Points to [[production.document.DocumentRow.folderflag]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"folderflag","ordinal_position":3,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Flag","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  folderflag: Flag,
  /** Points to [[production.document.DocumentRow.filename]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"filename","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":400,"character_octet_length":1600,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  filename: Option[String],
  /** Points to [[production.document.DocumentRow.fileextension]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"fileextension","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":8,"character_octet_length":32,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  fileextension: Option[String],
  /** Points to [[production.document.DocumentRow.revision]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"revision","ordinal_position":6,"is_nullable":"YES","data_type":"character","character_maximum_length":5,"character_octet_length":20,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  revision: Option[/* bpchar */ String],
  /** Points to [[production.document.DocumentRow.changenumber]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"changenumber","ordinal_position":7,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  changenumber: Option[Int],
  /** Points to [[production.document.DocumentRow.status]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"status","ordinal_position":8,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  status: Option[Int],
  /** Points to [[production.document.DocumentRow.documentsummary]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"documentsummary","ordinal_position":9,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  documentsummary: Option[String],
  /** Points to [[production.document.DocumentRow.document]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"document","ordinal_position":10,"is_nullable":"YES","data_type":"bytea","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bytea","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  document: Option[Byte],
  /** Points to [[production.document.DocumentRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"rowguid","ordinal_position":11,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[production.document.DocumentRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"modifieddate","ordinal_position":12,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime],
  /** Points to [[production.document.DocumentRow.documentnode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"d","column_name":"documentnode","ordinal_position":13,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  documentnode: Option[DocumentId]
)

object DRow {
  def rowParser(prefix: String): RowParser[DRow] = { row =>
    Success(
      DRow(
        title = row[Option[String]](prefix + "title"),
        owner = row[Option[BusinessentityId]](prefix + "owner"),
        folderflag = row[Flag](prefix + "folderflag"),
        filename = row[Option[String]](prefix + "filename"),
        fileextension = row[Option[String]](prefix + "fileextension"),
        revision = row[Option[/* bpchar */ String]](prefix + "revision"),
        changenumber = row[Option[Int]](prefix + "changenumber"),
        status = row[Option[Int]](prefix + "status"),
        documentsummary = row[Option[String]](prefix + "documentsummary"),
        document = row[Option[Byte]](prefix + "document"),
        rowguid = row[Option[UUID]](prefix + "rowguid"),
        modifieddate = row[Option[LocalDateTime]](prefix + "modifieddate"),
        documentnode = row[Option[DocumentId]](prefix + "documentnode")
      )
    )
  }

  implicit val oFormat: OFormat[DRow] = new OFormat[DRow]{
    override def writes(o: DRow): JsObject =
      Json.obj(
        "title" -> o.title,
        "owner" -> o.owner,
        "folderflag" -> o.folderflag,
        "filename" -> o.filename,
        "fileextension" -> o.fileextension,
        "revision" -> o.revision,
        "changenumber" -> o.changenumber,
        "status" -> o.status,
        "documentsummary" -> o.documentsummary,
        "document" -> o.document,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate,
        "documentnode" -> o.documentnode
      )
  
    override def reads(json: JsValue): JsResult[DRow] = {
      JsResult.fromTry(
        Try(
          DRow(
            title = json.\("title").toOption.map(_.as[String]),
            owner = json.\("owner").toOption.map(_.as[BusinessentityId]),
            folderflag = json.\("folderflag").as[Flag],
            filename = json.\("filename").toOption.map(_.as[String]),
            fileextension = json.\("fileextension").toOption.map(_.as[String]),
            revision = json.\("revision").toOption.map(_.as[/* bpchar */ String]),
            changenumber = json.\("changenumber").toOption.map(_.as[Int]),
            status = json.\("status").toOption.map(_.as[Int]),
            documentsummary = json.\("documentsummary").toOption.map(_.as[String]),
            document = json.\("document").toOption.map(_.as[Byte]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime]),
            documentnode = json.\("documentnode").toOption.map(_.as[DocumentId])
          )
        )
      )
    }
  }
}
