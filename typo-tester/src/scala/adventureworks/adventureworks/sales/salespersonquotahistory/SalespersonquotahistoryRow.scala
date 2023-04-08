/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

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

case class SalespersonquotahistoryRow(
  /** Sales person identification number. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salespersonquotahistory","column_name":"businessentityid","ordinal_position":1,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: BusinessentityId,
  /** Sales quota date.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salespersonquotahistory","column_name":"quotadate","ordinal_position":2,"is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  quotadate: LocalDateTime,
  /** Sales quota amount.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salespersonquotahistory","column_name":"salesquota","ordinal_position":3,"is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  salesquota: BigDecimal,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salespersonquotahistory","column_name":"rowguid","ordinal_position":4,"column_default":"uuid_generate_v1()","is_nullable":"NO","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: UUID,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salespersonquotahistory","column_name":"modifieddate","ordinal_position":5,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
){
   val compositeId: SalespersonquotahistoryId = SalespersonquotahistoryId(businessentityid, quotadate)
 }

object SalespersonquotahistoryRow {
  def rowParser(prefix: String): RowParser[SalespersonquotahistoryRow] = { row =>
    Success(
      SalespersonquotahistoryRow(
        businessentityid = row[BusinessentityId](prefix + "businessentityid"),
        quotadate = row[LocalDateTime](prefix + "quotadate"),
        salesquota = row[BigDecimal](prefix + "salesquota"),
        rowguid = row[UUID](prefix + "rowguid"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[SalespersonquotahistoryRow] = new OFormat[SalespersonquotahistoryRow]{
    override def writes(o: SalespersonquotahistoryRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "quotadate" -> o.quotadate,
        "salesquota" -> o.salesquota,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalespersonquotahistoryRow] = {
      JsResult.fromTry(
        Try(
          SalespersonquotahistoryRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            quotadate = json.\("quotadate").as[LocalDateTime],
            salesquota = json.\("salesquota").as[BigDecimal],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
