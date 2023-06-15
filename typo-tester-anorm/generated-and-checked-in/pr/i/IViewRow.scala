/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package i

import adventureworks.TypoXml
import adventureworks.production.illustration.IllustrationId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class IViewRow(
  id: Option[Int],
  /** Points to [[production.illustration.IllustrationRow.illustrationid]] */
  illustrationid: Option[IllustrationId],
  /** Points to [[production.illustration.IllustrationRow.diagram]] */
  diagram: Option[TypoXml],
  /** Points to [[production.illustration.IllustrationRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object IViewRow {
  implicit val oFormat: OFormat[IViewRow] = new OFormat[IViewRow]{
    override def writes(o: IViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "illustrationid" -> o.illustrationid,
        "diagram" -> o.diagram,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[IViewRow] = {
      JsResult.fromTry(
        Try(
          IViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            illustrationid = json.\("illustrationid").toOption.map(_.as[IllustrationId]),
            diagram = json.\("diagram").toOption.map(_.as[TypoXml]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
