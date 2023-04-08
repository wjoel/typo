/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class WorkorderRow(
  /** Primary key for WorkOrder records.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"workorderid","ordinal_position":1,"column_default":"nextval('production.workorder_workorderid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  workorderid: WorkorderId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"productid","ordinal_position":2,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productid: ProductId,
  /** Product quantity to build.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"orderqty","ordinal_position":3,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  orderqty: Int,
  /** Quantity that failed inspection.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"scrappedqty","ordinal_position":5,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  scrappedqty: Int,
  /** Work order start date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"startdate","ordinal_position":6,"is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  startdate: LocalDateTime,
  /** Work order end date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"enddate","ordinal_position":7,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  enddate: Option[LocalDateTime],
  /** Work order due date.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"duedate","ordinal_position":8,"is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  duedate: LocalDateTime,
  /** Reason for inspection failure.
      Points to [[scrapreason.ScrapreasonRow.scrapreasonid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"scrapreasonid","ordinal_position":9,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  scrapreasonid: Option[ScrapreasonId],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"workorder","column_name":"modifieddate","ordinal_position":10,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object WorkorderRow {
  def rowParser(prefix: String): RowParser[WorkorderRow] = { row =>
    Success(
      WorkorderRow(
        workorderid = row[WorkorderId](prefix + "workorderid"),
        productid = row[ProductId](prefix + "productid"),
        orderqty = row[Int](prefix + "orderqty"),
        scrappedqty = row[Int](prefix + "scrappedqty"),
        startdate = row[LocalDateTime](prefix + "startdate"),
        enddate = row[Option[LocalDateTime]](prefix + "enddate"),
        duedate = row[LocalDateTime](prefix + "duedate"),
        scrapreasonid = row[Option[ScrapreasonId]](prefix + "scrapreasonid"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[WorkorderRow] = new OFormat[WorkorderRow]{
    override def writes(o: WorkorderRow): JsObject =
      Json.obj(
        "workorderid" -> o.workorderid,
        "productid" -> o.productid,
        "orderqty" -> o.orderqty,
        "scrappedqty" -> o.scrappedqty,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "duedate" -> o.duedate,
        "scrapreasonid" -> o.scrapreasonid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[WorkorderRow] = {
      JsResult.fromTry(
        Try(
          WorkorderRow(
            workorderid = json.\("workorderid").as[WorkorderId],
            productid = json.\("productid").as[ProductId],
            orderqty = json.\("orderqty").as[Int],
            scrappedqty = json.\("scrappedqty").as[Int],
            startdate = json.\("startdate").as[LocalDateTime],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            duedate = json.\("duedate").as[LocalDateTime],
            scrapreasonid = json.\("scrapreasonid").toOption.map(_.as[ScrapreasonId]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
