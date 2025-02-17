/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VproductmodelinstructionsViewRow(
  /** Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[productmodel.ProductmodelRow.name]] */
  name: Option[Name],
  /** Points to [[productmodel.ProductmodelRow.instructions]] */
  instructions: Option[TypoXml],
  LocationID: Option[Int],
  SetupHours: Option[BigDecimal],
  MachineHours: Option[BigDecimal],
  LaborHours: Option[BigDecimal],
  LotSize: Option[Int],
  Step: Option[/* max 1024 chars */ String],
  /** Points to [[productmodel.ProductmodelRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object VproductmodelinstructionsViewRow {
  implicit lazy val reads: Reads[VproductmodelinstructionsViewRow] = Reads[VproductmodelinstructionsViewRow](json => JsResult.fromTry(
      Try(
        VproductmodelinstructionsViewRow(
          productmodelid = json.\("productmodelid").toOption.map(_.as(ProductmodelId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          instructions = json.\("instructions").toOption.map(_.as(TypoXml.reads)),
          LocationID = json.\("LocationID").toOption.map(_.as(Reads.IntReads)),
          SetupHours = json.\("SetupHours").toOption.map(_.as(Reads.bigDecReads)),
          MachineHours = json.\("MachineHours").toOption.map(_.as(Reads.bigDecReads)),
          LaborHours = json.\("LaborHours").toOption.map(_.as(Reads.bigDecReads)),
          LotSize = json.\("LotSize").toOption.map(_.as(Reads.IntReads)),
          Step = json.\("Step").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VproductmodelinstructionsViewRow] = RowParser[VproductmodelinstructionsViewRow] { row =>
    Success(
      VproductmodelinstructionsViewRow(
        productmodelid = row(idx + 0)(Column.columnToOption(ProductmodelId.column)),
        name = row(idx + 1)(Column.columnToOption(Name.column)),
        instructions = row(idx + 2)(Column.columnToOption(TypoXml.column)),
        LocationID = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        SetupHours = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        MachineHours = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        LaborHours = row(idx + 6)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        LotSize = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        Step = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 9)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 10)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[VproductmodelinstructionsViewRow] = OWrites[VproductmodelinstructionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> Writes.OptionWrites(ProductmodelId.writes).writes(o.productmodelid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "instructions" -> Writes.OptionWrites(TypoXml.writes).writes(o.instructions),
      "LocationID" -> Writes.OptionWrites(Writes.IntWrites).writes(o.LocationID),
      "SetupHours" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.SetupHours),
      "MachineHours" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.MachineHours),
      "LaborHours" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.LaborHours),
      "LotSize" -> Writes.OptionWrites(Writes.IntWrites).writes(o.LotSize),
      "Step" -> Writes.OptionWrites(Writes.StringWrites).writes(o.Step),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
