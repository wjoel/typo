/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_description

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `pg_catalog.pg_description` which has not been persisted yet */
case class PgDescriptionRowUnsaved(
  description: String
)
object PgDescriptionRowUnsaved {
  implicit val oFormat: OFormat[PgDescriptionRowUnsaved] = new OFormat[PgDescriptionRowUnsaved]{
    override def writes(o: PgDescriptionRowUnsaved): JsObject =
      Json.obj(
        "description" -> o.description
      )
  
    override def reads(json: JsValue): JsResult[PgDescriptionRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgDescriptionRowUnsaved(
            description = json.\("description").as[String]
          )
        )
      )
    }
  }
}
