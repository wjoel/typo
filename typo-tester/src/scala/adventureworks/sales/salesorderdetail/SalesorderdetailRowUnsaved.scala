/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.salesorderdetail` which has not been persisted yet */
case class SalesorderdetailRowUnsaved(
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[String],
  /** Quantity ordered per product. */
  orderqty: Int,
  /** Product sold to customer. Foreign key to Product.ProductID.
      Points to [[specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
      Points to [[specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Selling price of a single product. */
  unitprice: BigDecimal,
  /** Default: 0.0
      Discount amount. */
  unitpricediscount: Defaulted[BigDecimal],
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID],
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(compositeId: SalesorderdetailId): SalesorderdetailRow =
    SalesorderdetailRow(
      salesorderid = compositeId.salesorderid,
      salesorderdetailid = compositeId.salesorderdetailid,
      carriertrackingnumber = carriertrackingnumber,
      orderqty = orderqty,
      productid = productid,
      specialofferid = specialofferid,
      unitprice = unitprice,
      unitpricediscount = unitpricediscount match {
                            case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                            case Defaulted.Provided(value) => value
                          },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesorderdetailRowUnsaved {
  implicit val oFormat: OFormat[SalesorderdetailRowUnsaved] = new OFormat[SalesorderdetailRowUnsaved]{
    override def writes(o: SalesorderdetailRowUnsaved): JsObject =
      Json.obj(
        "carriertrackingnumber" -> o.carriertrackingnumber,
        "orderqty" -> o.orderqty,
        "productid" -> o.productid,
        "specialofferid" -> o.specialofferid,
        "unitprice" -> o.unitprice,
        "unitpricediscount" -> o.unitpricediscount,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesorderdetailRowUnsaved] = {
      JsResult.fromTry(
        Try(
          SalesorderdetailRowUnsaved(
            carriertrackingnumber = json.\("carriertrackingnumber").toOption.map(_.as[String]),
            orderqty = json.\("orderqty").as[Int],
            productid = json.\("productid").as[ProductId],
            specialofferid = json.\("specialofferid").as[SpecialofferId],
            unitprice = json.\("unitprice").as[BigDecimal],
            unitpricediscount = json.\("unitpricediscount").as[Defaulted[BigDecimal]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}