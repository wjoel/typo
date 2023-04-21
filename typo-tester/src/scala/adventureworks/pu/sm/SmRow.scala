/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SmRow(
  id: Option[Int],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: Option[ShipmethodId],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.name]] */
  name: Option[Name],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipbase]] */
  shipbase: Option[BigDecimal],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shiprate]] */
  shiprate: Option[BigDecimal],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[purchasing.shipmethod.ShipmethodRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SmRow {
  implicit val oFormat: OFormat[SmRow] = new OFormat[SmRow]{
    override def writes(o: SmRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "shipmethodid" -> o.shipmethodid,
        "name" -> o.name,
        "shipbase" -> o.shipbase,
        "shiprate" -> o.shiprate,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SmRow] = {
      JsResult.fromTry(
        Try(
          SmRow(
            id = json.\("id").toOption.map(_.as[Int]),
            shipmethodid = json.\("shipmethodid").toOption.map(_.as[ShipmethodId]),
            name = json.\("name").toOption.map(_.as[Name]),
            shipbase = json.\("shipbase").toOption.map(_.as[BigDecimal]),
            shiprate = json.\("shiprate").toOption.map(_.as[BigDecimal]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
