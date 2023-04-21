/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VendorRow(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average */
  creditrating: Int,
  /** 0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product. */
  preferredvendorstatus: Flag,
  /** 0 = Vendor no longer used. 1 = Vendor is actively used. */
  activeflag: Flag,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[String],
  modifieddate: LocalDateTime
)

object VendorRow {
  implicit val oFormat: OFormat[VendorRow] = new OFormat[VendorRow]{
    override def writes(o: VendorRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "accountnumber" -> o.accountnumber,
        "name" -> o.name,
        "creditrating" -> o.creditrating,
        "preferredvendorstatus" -> o.preferredvendorstatus,
        "activeflag" -> o.activeflag,
        "purchasingwebserviceurl" -> o.purchasingwebserviceurl,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[VendorRow] = {
      JsResult.fromTry(
        Try(
          VendorRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            accountnumber = json.\("accountnumber").as[AccountNumber],
            name = json.\("name").as[Name],
            creditrating = json.\("creditrating").as[Int],
            preferredvendorstatus = json.\("preferredvendorstatus").as[Flag],
            activeflag = json.\("activeflag").as[Flag],
            purchasingwebserviceurl = json.\("purchasingwebserviceurl").toOption.map(_.as[String]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
