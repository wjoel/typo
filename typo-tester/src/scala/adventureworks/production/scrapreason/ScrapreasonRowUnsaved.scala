/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.scrapreason` which has not been persisted yet */
case class ScrapreasonRowUnsaved(
  /** Failure description. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(scrapreasonid: ScrapreasonId): ScrapreasonRow =
    ScrapreasonRow(
      scrapreasonid = scrapreasonid,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ScrapreasonRowUnsaved {
  implicit val oFormat: OFormat[ScrapreasonRowUnsaved] = new OFormat[ScrapreasonRowUnsaved]{
    override def writes(o: ScrapreasonRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ScrapreasonRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ScrapreasonRowUnsaved(
            name = json.\("name").as[Name],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}