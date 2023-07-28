/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.shoppingcartitem` which has not been persisted yet */
case class ShoppingcartitemRowUnsaved(
  /** Shopping cart identification number. */
  shoppingcartid: /* max 50 chars */ String,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: nextval('sales.shoppingcartitem_shoppingcartitemid_seq'::regclass)
      Primary key for ShoppingCartItem records. */
  shoppingcartitemid: Defaulted[ShoppingcartitemId] = Defaulted.UseDefault,
  /** Default: 1
      Product quantity ordered. */
  quantity: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date the time the record was created. */
  datecreated: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shoppingcartitemidDefault: => ShoppingcartitemId, quantityDefault: => Int, datecreatedDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): ShoppingcartitemRow =
    ShoppingcartitemRow(
      shoppingcartid = shoppingcartid,
      productid = productid,
      shoppingcartitemid = shoppingcartitemid match {
                             case Defaulted.UseDefault => shoppingcartitemidDefault
                             case Defaulted.Provided(value) => value
                           },
      quantity = quantity match {
                   case Defaulted.UseDefault => quantityDefault
                   case Defaulted.Provided(value) => value
                 },
      datecreated = datecreated match {
                      case Defaulted.UseDefault => datecreatedDefault
                      case Defaulted.Provided(value) => value
                    },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ShoppingcartitemRowUnsaved {
  implicit val reads: Reads[ShoppingcartitemRowUnsaved] = Reads[ShoppingcartitemRowUnsaved](json => JsResult.fromTry(
      Try(
        ShoppingcartitemRowUnsaved(
          shoppingcartid = json.\("shoppingcartid").as(Reads.StringReads),
          productid = json.\("productid").as(ProductId.reads),
          shoppingcartitemid = json.\("shoppingcartitemid").as(Defaulted.reads(ShoppingcartitemId.reads)),
          quantity = json.\("quantity").as(Defaulted.reads(Reads.IntReads)),
          datecreated = json.\("datecreated").as(Defaulted.reads(TypoLocalDateTime.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit val writes: OWrites[ShoppingcartitemRowUnsaved] = OWrites[ShoppingcartitemRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "shoppingcartid" -> Writes.StringWrites.writes(o.shoppingcartid),
      "productid" -> ProductId.writes.writes(o.productid),
      "shoppingcartitemid" -> Defaulted.writes(ShoppingcartitemId.writes).writes(o.shoppingcartitemid),
      "quantity" -> Defaulted.writes(Writes.IntWrites).writes(o.quantity),
      "datecreated" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.datecreated),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
