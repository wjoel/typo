/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
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
  reviewdate: TypoLocalDateTime,
  /** Reviewer's e-mail address. */
  emailaddress: /* max 50 chars */ String,
  /** Product rating given by the reviewer. Scale is 1 to 5 with 5 as the highest rating. */
  rating: Int,
  /** Reviewer's comments */
  comments: Option[/* max 3850 chars */ String],
  modifieddate: TypoLocalDateTime
)

object ProductreviewRow {
  implicit lazy val reads: Reads[ProductreviewRow] = Reads[ProductreviewRow](json => JsResult.fromTry(
      Try(
        ProductreviewRow(
          productreviewid = json.\("productreviewid").as(ProductreviewId.reads),
          productid = json.\("productid").as(ProductId.reads),
          reviewername = json.\("reviewername").as(Name.reads),
          reviewdate = json.\("reviewdate").as(TypoLocalDateTime.reads),
          emailaddress = json.\("emailaddress").as(Reads.StringReads),
          rating = json.\("rating").as(Reads.IntReads),
          comments = json.\("comments").toOption.map(_.as(Reads.StringReads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductreviewRow] = RowParser[ProductreviewRow] { row =>
    Success(
      ProductreviewRow(
        productreviewid = row(idx + 0)(ProductreviewId.column),
        productid = row(idx + 1)(ProductId.column),
        reviewername = row(idx + 2)(Name.column),
        reviewdate = row(idx + 3)(TypoLocalDateTime.column),
        emailaddress = row(idx + 4)(Column.columnToString),
        rating = row(idx + 5)(Column.columnToInt),
        comments = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        modifieddate = row(idx + 7)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ProductreviewRow] = OWrites[ProductreviewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productreviewid" -> ProductreviewId.writes.writes(o.productreviewid),
      "productid" -> ProductId.writes.writes(o.productid),
      "reviewername" -> Name.writes.writes(o.reviewername),
      "reviewdate" -> TypoLocalDateTime.writes.writes(o.reviewdate),
      "emailaddress" -> Writes.StringWrites.writes(o.emailaddress),
      "rating" -> Writes.IntWrites.writes(o.rating),
      "comments" -> Writes.OptionWrites(Writes.StringWrites).writes(o.comments),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
