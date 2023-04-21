/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package s

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SRow(
  id: Option[Int],
  /** Points to [[sales.store.StoreRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.store.StoreRow.name]] */
  name: Option[Name],
  /** Points to [[sales.store.StoreRow.salespersonid]] */
  salespersonid: Option[BusinessentityId],
  /** Points to [[sales.store.StoreRow.demographics]] */
  demographics: Option[/* xml */ String],
  /** Points to [[sales.store.StoreRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.store.StoreRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SRow {
  implicit val oFormat: OFormat[SRow] = new OFormat[SRow]{
    override def writes(o: SRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "name" -> o.name,
        "salespersonid" -> o.salespersonid,
        "demographics" -> o.demographics,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SRow] = {
      JsResult.fromTry(
        Try(
          SRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            name = json.\("name").toOption.map(_.as[Name]),
            salespersonid = json.\("salespersonid").toOption.map(_.as[BusinessentityId]),
            demographics = json.\("demographics").toOption.map(_.as[/* xml */ String]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
