/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.production.product.ProductId
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ProductreviewRow(
  /** Primary key for ProductReview records. */
  productreviewid: ProductreviewId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Name of the reviewer. */
  reviewername: Name,
  /** Date review was submitted. */
  reviewdate: LocalDateTime,
  /** Reviewer's e-mail address. */
  emailaddress: String,
  /** Product rating given by the reviewer. Scale is 1 to 5 with 5 as the highest rating. */
  rating: Int,
  /** Reviewer's comments */
  comments: Option[String],
  modifieddate: LocalDateTime
)

object ProductreviewRow {
  implicit val oFormat: OFormat[ProductreviewRow] = new OFormat[ProductreviewRow]{
    override def writes(o: ProductreviewRow): JsObject =
      Json.obj(
        "productreviewid" -> o.productreviewid,
        "productid" -> o.productid,
        "reviewername" -> o.reviewername,
        "reviewdate" -> o.reviewdate,
        "emailaddress" -> o.emailaddress,
        "rating" -> o.rating,
        "comments" -> o.comments,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductreviewRow] = {
      JsResult.fromTry(
        Try(
          ProductreviewRow(
            productreviewid = json.\("productreviewid").as[ProductreviewId],
            productid = json.\("productid").as[ProductId],
            reviewername = json.\("reviewername").as[Name],
            reviewdate = json.\("reviewdate").as[LocalDateTime],
            emailaddress = json.\("emailaddress").as[String],
            rating = json.\("rating").as[Int],
            comments = json.\("comments").toOption.map(_.as[String]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
