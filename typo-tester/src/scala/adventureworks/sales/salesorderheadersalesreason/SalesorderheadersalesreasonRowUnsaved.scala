/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.Defaulted
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.salesorderheadersalesreason` which has not been persisted yet */
case class SalesorderheadersalesreasonRowUnsaved(
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(compositeId: SalesorderheadersalesreasonId): SalesorderheadersalesreasonRow =
    SalesorderheadersalesreasonRow(
      salesorderid = compositeId.salesorderid,
      salesreasonid = compositeId.salesreasonid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesorderheadersalesreasonRowUnsaved {
  implicit val oFormat: OFormat[SalesorderheadersalesreasonRowUnsaved] = new OFormat[SalesorderheadersalesreasonRowUnsaved]{
    override def writes(o: SalesorderheadersalesreasonRowUnsaved): JsObject =
      Json.obj(
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesorderheadersalesreasonRowUnsaved] = {
      JsResult.fromTry(
        Try(
          SalesorderheadersalesreasonRowUnsaved(
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
