/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PrRow(
  id: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.productreviewid]] */
  productreviewid: Option[ProductreviewId],
  /** Points to [[production.productreview.ProductreviewRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productreview.ProductreviewRow.reviewername]] */
  reviewername: Option[Name],
  /** Points to [[production.productreview.ProductreviewRow.reviewdate]] */
  reviewdate: Option[LocalDateTime],
  /** Points to [[production.productreview.ProductreviewRow.emailaddress]] */
  emailaddress: Option[String],
  /** Points to [[production.productreview.ProductreviewRow.rating]] */
  rating: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.comments]] */
  comments: Option[String],
  /** Points to [[production.productreview.ProductreviewRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PrRow {
  implicit val oFormat: OFormat[PrRow] = new OFormat[PrRow]{
    override def writes(o: PrRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productreviewid" -> o.productreviewid,
        "productid" -> o.productid,
        "reviewername" -> o.reviewername,
        "reviewdate" -> o.reviewdate,
        "emailaddress" -> o.emailaddress,
        "rating" -> o.rating,
        "comments" -> o.comments,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PrRow] = {
      JsResult.fromTry(
        Try(
          PrRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productreviewid = json.\("productreviewid").toOption.map(_.as[ProductreviewId]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            reviewername = json.\("reviewername").toOption.map(_.as[Name]),
            reviewdate = json.\("reviewdate").toOption.map(_.as[LocalDateTime]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[String]),
            rating = json.\("rating").toOption.map(_.as[Int]),
            comments = json.\("comments").toOption.map(_.as[String]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
