/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package wr

import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class WrViewRow(
  id: Option[Int],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.workorderid]] */
  workorderid: Option[WorkorderId],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.productid]] */
  productid: Option[Int],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.operationsequence]] */
  operationsequence: Option[Int],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.scheduledstartdate]] */
  scheduledstartdate: Option[TypoLocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.scheduledenddate]] */
  scheduledenddate: Option[TypoLocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualstartdate]] */
  actualstartdate: Option[TypoLocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualenddate]] */
  actualenddate: Option[TypoLocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualresourcehrs]] */
  actualresourcehrs: Option[BigDecimal],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.plannedcost]] */
  plannedcost: Option[BigDecimal],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object WrViewRow {
  implicit lazy val reads: Reads[WrViewRow] = Reads[WrViewRow](json => JsResult.fromTry(
      Try(
        WrViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          workorderid = json.\("workorderid").toOption.map(_.as(WorkorderId.reads)),
          productid = json.\("productid").toOption.map(_.as(Reads.IntReads)),
          operationsequence = json.\("operationsequence").toOption.map(_.as(Reads.IntReads)),
          locationid = json.\("locationid").toOption.map(_.as(LocationId.reads)),
          scheduledstartdate = json.\("scheduledstartdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          scheduledenddate = json.\("scheduledenddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualstartdate = json.\("actualstartdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualenddate = json.\("actualenddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualresourcehrs = json.\("actualresourcehrs").toOption.map(_.as(Reads.bigDecReads)),
          plannedcost = json.\("plannedcost").toOption.map(_.as(Reads.bigDecReads)),
          actualcost = json.\("actualcost").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[WrViewRow] = RowParser[WrViewRow] { row =>
    Success(
      WrViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        workorderid = row(idx + 1)(Column.columnToOption(WorkorderId.column)),
        productid = row(idx + 2)(Column.columnToOption(Column.columnToInt)),
        operationsequence = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        locationid = row(idx + 4)(Column.columnToOption(LocationId.column)),
        scheduledstartdate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column)),
        scheduledenddate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column)),
        actualstartdate = row(idx + 7)(Column.columnToOption(TypoLocalDateTime.column)),
        actualenddate = row(idx + 8)(Column.columnToOption(TypoLocalDateTime.column)),
        actualresourcehrs = row(idx + 9)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        plannedcost = row(idx + 10)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        actualcost = row(idx + 11)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 12)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[WrViewRow] = OWrites[WrViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "workorderid" -> Writes.OptionWrites(WorkorderId.writes).writes(o.workorderid),
      "productid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.productid),
      "operationsequence" -> Writes.OptionWrites(Writes.IntWrites).writes(o.operationsequence),
      "locationid" -> Writes.OptionWrites(LocationId.writes).writes(o.locationid),
      "scheduledstartdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.scheduledstartdate),
      "scheduledenddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.scheduledenddate),
      "actualstartdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.actualstartdate),
      "actualenddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.actualenddate),
      "actualresourcehrs" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualresourcehrs),
      "plannedcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.plannedcost),
      "actualcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualcost),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
