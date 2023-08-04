/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `production.productmodelproductdescriptionculture` */
case class ProductmodelproductdescriptioncultureId(productmodelid: ProductmodelId, productdescriptionid: ProductdescriptionId, cultureid: CultureId)
object ProductmodelproductdescriptioncultureId {
  implicit lazy val ordering: Ordering[ProductmodelproductdescriptioncultureId] = Ordering.by(x => (x.productmodelid, x.productdescriptionid, x.cultureid))
  implicit lazy val reads: Reads[ProductmodelproductdescriptioncultureId] = Reads[ProductmodelproductdescriptioncultureId](json => JsResult.fromTry(
      Try(
        ProductmodelproductdescriptioncultureId(
          productmodelid = json.\("productmodelid").as(ProductmodelId.reads),
          productdescriptionid = json.\("productdescriptionid").as(ProductdescriptionId.reads),
          cultureid = json.\("cultureid").as(CultureId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductmodelproductdescriptioncultureId] = OWrites[ProductmodelproductdescriptioncultureId](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),
      "productdescriptionid" -> ProductdescriptionId.writes.writes(o.productdescriptionid),
      "cultureid" -> CultureId.writes.writes(o.cultureid)
    ))
  )
}
