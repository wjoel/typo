/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class WorkorderroutingRow(
  /** Primary key. Foreign key to WorkOrder.WorkOrderID.
      Points to [[workorder.WorkorderRow.workorderid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"workorderid","ordinal_position":1,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  workorderid: WorkorderId,
  /** Primary key. Foreign key to Product.ProductID.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"productid","ordinal_position":2,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productid: Int,
  /** Primary key. Indicates the manufacturing process sequence.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"operationsequence","ordinal_position":3,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  operationsequence: Int,
  /** Manufacturing location where the part is processed. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"locationid","ordinal_position":4,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  locationid: LocationId,
  /** Planned manufacturing start date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"scheduledstartdate","ordinal_position":5,"is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  scheduledstartdate: LocalDateTime,
  /** Planned manufacturing end date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"scheduledenddate","ordinal_position":6,"is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  scheduledenddate: LocalDateTime,
  /** Actual start date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"actualstartdate","ordinal_position":7,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  actualstartdate: Option[LocalDateTime],
  /** Actual end date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"actualenddate","ordinal_position":8,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  actualenddate: Option[LocalDateTime],
  /** Number of manufacturing hours used.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"actualresourcehrs","ordinal_position":9,"is_nullable":"YES","data_type":"numeric","numeric_precision":9,"numeric_precision_radix":10,"numeric_scale":4,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  actualresourcehrs: Option[BigDecimal],
  /** Estimated manufacturing cost.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"plannedcost","ordinal_position":10,"is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  plannedcost: BigDecimal,
  /** Actual manufacturing cost.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"actualcost","ordinal_position":11,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  actualcost: Option[BigDecimal],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorderrouting","column_name":"modifieddate","ordinal_position":12,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
){
   val compositeId: WorkorderroutingId = WorkorderroutingId(workorderid, productid, operationsequence)
 }

object WorkorderroutingRow {
  def rowParser(prefix: String): RowParser[WorkorderroutingRow] = { row =>
    Success(
      WorkorderroutingRow(
        workorderid = row[WorkorderId](prefix + "workorderid"),
        productid = row[Int](prefix + "productid"),
        operationsequence = row[Int](prefix + "operationsequence"),
        locationid = row[LocationId](prefix + "locationid"),
        scheduledstartdate = row[LocalDateTime](prefix + "scheduledstartdate"),
        scheduledenddate = row[LocalDateTime](prefix + "scheduledenddate"),
        actualstartdate = row[Option[LocalDateTime]](prefix + "actualstartdate"),
        actualenddate = row[Option[LocalDateTime]](prefix + "actualenddate"),
        actualresourcehrs = row[Option[BigDecimal]](prefix + "actualresourcehrs"),
        plannedcost = row[BigDecimal](prefix + "plannedcost"),
        actualcost = row[Option[BigDecimal]](prefix + "actualcost"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[WorkorderroutingRow] = new OFormat[WorkorderroutingRow]{
    override def writes(o: WorkorderroutingRow): JsObject =
      Json.obj(
        "workorderid" -> o.workorderid,
        "productid" -> o.productid,
        "operationsequence" -> o.operationsequence,
        "locationid" -> o.locationid,
        "scheduledstartdate" -> o.scheduledstartdate,
        "scheduledenddate" -> o.scheduledenddate,
        "actualstartdate" -> o.actualstartdate,
        "actualenddate" -> o.actualenddate,
        "actualresourcehrs" -> o.actualresourcehrs,
        "plannedcost" -> o.plannedcost,
        "actualcost" -> o.actualcost,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[WorkorderroutingRow] = {
      JsResult.fromTry(
        Try(
          WorkorderroutingRow(
            workorderid = json.\("workorderid").as[WorkorderId],
            productid = json.\("productid").as[Int],
            operationsequence = json.\("operationsequence").as[Int],
            locationid = json.\("locationid").as[LocationId],
            scheduledstartdate = json.\("scheduledstartdate").as[LocalDateTime],
            scheduledenddate = json.\("scheduledenddate").as[LocalDateTime],
            actualstartdate = json.\("actualstartdate").toOption.map(_.as[LocalDateTime]),
            actualenddate = json.\("actualenddate").toOption.map(_.as[LocalDateTime]),
            actualresourcehrs = json.\("actualresourcehrs").toOption.map(_.as[BigDecimal]),
            plannedcost = json.\("plannedcost").as[BigDecimal],
            actualcost = json.\("actualcost").toOption.map(_.as[BigDecimal]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
