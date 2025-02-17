/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sp

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
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

case class SpViewRow(
  id: Option[Int],
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.salesperson.SalespersonRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.salesperson.SalespersonRow.salesquota]] */
  salesquota: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.bonus]] */
  bonus: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.commissionpct]] */
  commissionpct: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.salesytd]] */
  salesytd: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.saleslastyear]] */
  saleslastyear: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salesperson.SalespersonRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SpViewRow {
  implicit lazy val reads: Reads[SpViewRow] = Reads[SpViewRow](json => JsResult.fromTry(
      Try(
        SpViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          territoryid = json.\("territoryid").toOption.map(_.as(SalesterritoryId.reads)),
          salesquota = json.\("salesquota").toOption.map(_.as(Reads.bigDecReads)),
          bonus = json.\("bonus").toOption.map(_.as(Reads.bigDecReads)),
          commissionpct = json.\("commissionpct").toOption.map(_.as(Reads.bigDecReads)),
          salesytd = json.\("salesytd").toOption.map(_.as(Reads.bigDecReads)),
          saleslastyear = json.\("saleslastyear").toOption.map(_.as(Reads.bigDecReads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SpViewRow] = RowParser[SpViewRow] { row =>
    Success(
      SpViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        territoryid = row(idx + 2)(Column.columnToOption(SalesterritoryId.column)),
        salesquota = row(idx + 3)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        bonus = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        commissionpct = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        salesytd = row(idx + 6)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        saleslastyear = row(idx + 7)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        rowguid = row(idx + 8)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 9)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[SpViewRow] = OWrites[SpViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "territoryid" -> Writes.OptionWrites(SalesterritoryId.writes).writes(o.territoryid),
      "salesquota" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.salesquota),
      "bonus" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.bonus),
      "commissionpct" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.commissionpct),
      "salesytd" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.salesytd),
      "saleslastyear" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.saleslastyear),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
