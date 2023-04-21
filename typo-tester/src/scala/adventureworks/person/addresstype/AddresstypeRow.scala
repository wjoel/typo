/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class AddresstypeRow(
  /** Primary key for AddressType records. */
  addresstypeid: AddresstypeId,
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object AddresstypeRow {
  implicit val oFormat: OFormat[AddresstypeRow] = new OFormat[AddresstypeRow]{
    override def writes(o: AddresstypeRow): JsObject =
      Json.obj(
        "addresstypeid" -> o.addresstypeid,
        "name" -> o.name,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[AddresstypeRow] = {
      JsResult.fromTry(
        Try(
          AddresstypeRow(
            addresstypeid = json.\("addresstypeid").as[AddresstypeId],
            name = json.\("name").as[Name],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
