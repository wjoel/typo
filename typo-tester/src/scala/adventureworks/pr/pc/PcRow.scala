/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PcRow(
  id: Option[Int],
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: Option[ProductcategoryId],
  /** Points to [[production.productcategory.ProductcategoryRow.name]] */
  name: Option[Name],
  /** Points to [[production.productcategory.ProductcategoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productcategory.ProductcategoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PcRow {
  implicit val oFormat: OFormat[PcRow] = new OFormat[PcRow]{
    override def writes(o: PcRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productcategoryid" -> o.productcategoryid,
        "name" -> o.name,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PcRow] = {
      JsResult.fromTry(
        Try(
          PcRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productcategoryid = json.\("productcategoryid").toOption.map(_.as[ProductcategoryId]),
            name = json.\("name").toOption.map(_.as[Name]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
