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

sealed abstract class PrViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PrViewFieldValue[T](name: String, value: T) extends PrViewFieldOrIdValue(name, value)

object PrViewFieldValue {
  case class id(override val value: Option[Int]) extends PrViewFieldValue("id", value)
  case class productreviewid(override val value: Option[ProductreviewId]) extends PrViewFieldValue("productreviewid", value)
  case class productid(override val value: Option[ProductId]) extends PrViewFieldValue("productid", value)
  case class reviewername(override val value: Option[Name]) extends PrViewFieldValue("reviewername", value)
  case class reviewdate(override val value: Option[LocalDateTime]) extends PrViewFieldValue("reviewdate", value)
  case class emailaddress(override val value: Option[String]) extends PrViewFieldValue("emailaddress", value)
  case class rating(override val value: Option[Int]) extends PrViewFieldValue("rating", value)
  case class comments(override val value: Option[String]) extends PrViewFieldValue("comments", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PrViewFieldValue("modifieddate", value)
}