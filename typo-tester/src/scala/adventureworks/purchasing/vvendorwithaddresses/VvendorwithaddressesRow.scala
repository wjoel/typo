/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VvendorwithaddressesRow(
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  name: Option[Name],
  addresstype: Option[Name],
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: Option[String],
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[String],
  /** Points to [[person.address.AddressRow.city]] */
  city: Option[String],
  stateprovincename: Option[Name],
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: Option[String],
  countryregionname: Option[Name]
)

object VvendorwithaddressesRow {
  implicit val oFormat: OFormat[VvendorwithaddressesRow] = new OFormat[VvendorwithaddressesRow]{
    override def writes(o: VvendorwithaddressesRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "name" -> o.name,
        "addresstype" -> o.addresstype,
        "addressline1" -> o.addressline1,
        "addressline2" -> o.addressline2,
        "city" -> o.city,
        "stateprovincename" -> o.stateprovincename,
        "postalcode" -> o.postalcode,
        "countryregionname" -> o.countryregionname
      )
  
    override def reads(json: JsValue): JsResult[VvendorwithaddressesRow] = {
      JsResult.fromTry(
        Try(
          VvendorwithaddressesRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            name = json.\("name").toOption.map(_.as[Name]),
            addresstype = json.\("addresstype").toOption.map(_.as[Name]),
            addressline1 = json.\("addressline1").toOption.map(_.as[String]),
            addressline2 = json.\("addressline2").toOption.map(_.as[String]),
            city = json.\("city").toOption.map(_.as[String]),
            stateprovincename = json.\("stateprovincename").toOption.map(_.as[Name]),
            postalcode = json.\("postalcode").toOption.map(_.as[String]),
            countryregionname = json.\("countryregionname").toOption.map(_.as[Name])
          )
        )
      )
    }
  }
}
