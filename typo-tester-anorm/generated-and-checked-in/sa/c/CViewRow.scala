/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.customer.CustomerId
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

case class CViewRow(
  id: Option[Int],
  /** Points to [[sales.customer.CustomerRow.customerid]] */
  customerid: Option[CustomerId],
  /** Points to [[sales.customer.CustomerRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.storeid]] */
  storeid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.customer.CustomerRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.customer.CustomerRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CViewRow {
  implicit val reads: Reads[CViewRow] = Reads[CViewRow](json => JsResult.fromTry(
      Try(
        CViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          customerid = json.\("customerid").toOption.map(_.as(CustomerId.reads)),
          personid = json.\("personid").toOption.map(_.as(BusinessentityId.reads)),
          storeid = json.\("storeid").toOption.map(_.as(BusinessentityId.reads)),
          territoryid = json.\("territoryid").toOption.map(_.as(SalesterritoryId.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CViewRow] = RowParser[CViewRow] { row =>
    Success(
      CViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        customerid = row(idx + 1)(Column.columnToOption(CustomerId.column)),
        personid = row(idx + 2)(Column.columnToOption(BusinessentityId.column)),
        storeid = row(idx + 3)(Column.columnToOption(BusinessentityId.column)),
        territoryid = row(idx + 4)(Column.columnToOption(SalesterritoryId.column)),
        rowguid = row(idx + 5)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit val writes: OWrites[CViewRow] = OWrites[CViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "customerid" -> Writes.OptionWrites(CustomerId.writes).writes(o.customerid),
      "personid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.personid),
      "storeid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.storeid),
      "territoryid" -> Writes.OptionWrites(SalesterritoryId.writes).writes(o.territoryid),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
