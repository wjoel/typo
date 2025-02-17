/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
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

case class BecViewRow(
  id: Option[Int],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.contacttypeid]] */
  contacttypeid: Option[ContacttypeId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object BecViewRow {
  implicit lazy val reads: Reads[BecViewRow] = Reads[BecViewRow](json => JsResult.fromTry(
      Try(
        BecViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          personid = json.\("personid").toOption.map(_.as(BusinessentityId.reads)),
          contacttypeid = json.\("contacttypeid").toOption.map(_.as(ContacttypeId.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BecViewRow] = RowParser[BecViewRow] { row =>
    Success(
      BecViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        personid = row(idx + 2)(Column.columnToOption(BusinessentityId.column)),
        contacttypeid = row(idx + 3)(Column.columnToOption(ContacttypeId.column)),
        rowguid = row(idx + 4)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[BecViewRow] = OWrites[BecViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "personid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.personid),
      "contacttypeid" -> Writes.OptionWrites(ContacttypeId.writes).writes(o.contacttypeid),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
