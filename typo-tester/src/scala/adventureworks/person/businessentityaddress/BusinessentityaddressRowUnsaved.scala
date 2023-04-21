/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.Defaulted
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `person.businessentityaddress` which has not been persisted yet */
case class BusinessentityaddressRowUnsaved(
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID],
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(compositeId: BusinessentityaddressId): BusinessentityaddressRow =
    BusinessentityaddressRow(
      businessentityid = compositeId.businessentityid,
      addressid = compositeId.addressid,
      addresstypeid = compositeId.addresstypeid,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BusinessentityaddressRowUnsaved {
  implicit val oFormat: OFormat[BusinessentityaddressRowUnsaved] = new OFormat[BusinessentityaddressRowUnsaved]{
    override def writes(o: BusinessentityaddressRowUnsaved): JsObject =
      Json.obj(
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BusinessentityaddressRowUnsaved] = {
      JsResult.fromTry(
        Try(
          BusinessentityaddressRowUnsaved(
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
