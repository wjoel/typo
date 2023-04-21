/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ERow(
  id: Option[Int],
  /** Points to [[person.emailaddress.EmailaddressRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]] */
  emailaddressid: Option[Int],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[String],
  /** Points to [[person.emailaddress.EmailaddressRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.emailaddress.EmailaddressRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object ERow {
  implicit val oFormat: OFormat[ERow] = new OFormat[ERow]{
    override def writes(o: ERow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "emailaddressid" -> o.emailaddressid,
        "emailaddress" -> o.emailaddress,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ERow] = {
      JsResult.fromTry(
        Try(
          ERow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            emailaddressid = json.\("emailaddressid").toOption.map(_.as[Int]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[String]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
