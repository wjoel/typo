/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.person.businessentity.BusinessentityId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class EmployeepayhistoryRow(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeepayhistory","column_name":"businessentityid","ordinal_position":1,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: BusinessentityId,
  /** Date the change in pay is effective
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeepayhistory","column_name":"ratechangedate","ordinal_position":2,"is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  ratechangedate: LocalDateTime,
  /** Salary hourly rate.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeepayhistory","column_name":"rate","ordinal_position":3,"is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rate: BigDecimal,
  /** 1 = Salary received monthly, 2 = Salary received biweekly
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeepayhistory","column_name":"payfrequency","ordinal_position":4,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  payfrequency: Int,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeepayhistory","column_name":"modifieddate","ordinal_position":5,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
){
   val compositeId: EmployeepayhistoryId = EmployeepayhistoryId(businessentityid, ratechangedate)
 }

object EmployeepayhistoryRow {
  def rowParser(prefix: String): RowParser[EmployeepayhistoryRow] = { row =>
    Success(
      EmployeepayhistoryRow(
        businessentityid = row[BusinessentityId](prefix + "businessentityid"),
        ratechangedate = row[LocalDateTime](prefix + "ratechangedate"),
        rate = row[BigDecimal](prefix + "rate"),
        payfrequency = row[Int](prefix + "payfrequency"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[EmployeepayhistoryRow] = new OFormat[EmployeepayhistoryRow]{
    override def writes(o: EmployeepayhistoryRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "ratechangedate" -> o.ratechangedate,
        "rate" -> o.rate,
        "payfrequency" -> o.payfrequency,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[EmployeepayhistoryRow] = {
      JsResult.fromTry(
        Try(
          EmployeepayhistoryRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            ratechangedate = json.\("ratechangedate").as[LocalDateTime],
            rate = json.\("rate").as[BigDecimal],
            payfrequency = json.\("payfrequency").as[Int],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
