/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ShoppingcartitemRow(
  /** Primary key for ShoppingCartItem records. */
  shoppingcartitemid: ShoppingcartitemId,
  /** Shopping cart identification number. */
  shoppingcartid: String,
  /** Product quantity ordered. */
  quantity: Int,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Date the time the record was created. */
  datecreated: LocalDateTime,
  modifieddate: LocalDateTime
)

object ShoppingcartitemRow {
  implicit val oFormat: OFormat[ShoppingcartitemRow] = new OFormat[ShoppingcartitemRow]{
    override def writes(o: ShoppingcartitemRow): JsObject =
      Json.obj(
        "shoppingcartitemid" -> o.shoppingcartitemid,
        "shoppingcartid" -> o.shoppingcartid,
        "quantity" -> o.quantity,
        "productid" -> o.productid,
        "datecreated" -> o.datecreated,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ShoppingcartitemRow] = {
      JsResult.fromTry(
        Try(
          ShoppingcartitemRow(
            shoppingcartitemid = json.\("shoppingcartitemid").as[ShoppingcartitemId],
            shoppingcartid = json.\("shoppingcartid").as[String],
            quantity = json.\("quantity").as[Int],
            productid = json.\("productid").as[ProductId],
            datecreated = json.\("datecreated").as[LocalDateTime],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}