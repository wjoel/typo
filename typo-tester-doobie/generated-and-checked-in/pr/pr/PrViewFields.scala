/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import typo.dsl.SqlExpr.OptField

trait PrViewFields[Row] {
  val id: OptField[Int, Row]
  val productreviewid: OptField[ProductreviewId, Row]
  val productid: OptField[ProductId, Row]
  val reviewername: OptField[Name, Row]
  val reviewdate: OptField[TypoLocalDateTime, Row]
  val emailaddress: OptField[/* max 50 chars */ String, Row]
  val rating: OptField[Int, Row]
  val comments: OptField[/* max 3850 chars */ String, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object PrViewFields extends PrViewStructure[PrViewRow](None, identity, (_, x) => x)

