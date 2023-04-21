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
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class WorkorderroutingRow(
  /** Primary key. Foreign key to WorkOrder.WorkOrderID.
      Points to [[workorder.WorkorderRow.workorderid]] */
  workorderid: WorkorderId,
  /** Primary key. Foreign key to Product.ProductID. */
  productid: Int,
  /** Primary key. Indicates the manufacturing process sequence. */
  operationsequence: Int,
  /** Manufacturing location where the part is processed. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Planned manufacturing start date. */
  scheduledstartdate: LocalDateTime,
  /** Planned manufacturing end date. */
  scheduledenddate: LocalDateTime,
  /** Actual start date. */
  actualstartdate: Option[LocalDateTime],
  /** Actual end date. */
  actualenddate: Option[LocalDateTime],
  /** Number of manufacturing hours used. */
  actualresourcehrs: Option[BigDecimal],
  /** Estimated manufacturing cost. */
  plannedcost: BigDecimal,
  /** Actual manufacturing cost. */
  actualcost: Option[BigDecimal],
  modifieddate: LocalDateTime
){
   val compositeId: WorkorderroutingId = WorkorderroutingId(workorderid, productid, operationsequence)
 }

object WorkorderroutingRow {
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
