/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bea

import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class BeaRow(
  id: Option[Int],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.addressid]] */
  addressid: Option[AddressId],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.addresstypeid]] */
  addresstypeid: Option[AddresstypeId],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object BeaRow {
  implicit val oFormat: OFormat[BeaRow] = new OFormat[BeaRow]{
    override def writes(o: BeaRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "addressid" -> o.addressid,
        "addresstypeid" -> o.addresstypeid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BeaRow] = {
      JsResult.fromTry(
        Try(
          BeaRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            addressid = json.\("addressid").toOption.map(_.as[AddressId]),
            addresstypeid = json.\("addresstypeid").toOption.map(_.as[AddresstypeId]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
