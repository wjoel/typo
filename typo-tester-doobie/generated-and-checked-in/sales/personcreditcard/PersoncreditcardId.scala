/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.creditcard.CreditcardId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

/** Type for the composite primary key of table `sales.personcreditcard` */
case class PersoncreditcardId(businessentityid: BusinessentityId, creditcardid: CreditcardId)
object PersoncreditcardId {
  implicit def ordering: Ordering[PersoncreditcardId] = Ordering.by(x => (x.businessentityid, x.creditcardid))
  implicit val decoder: Decoder[PersoncreditcardId] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        creditcardid <- c.downField("creditcardid").as[CreditcardId]
      } yield PersoncreditcardId(businessentityid, creditcardid)
  implicit val encoder: Encoder[PersoncreditcardId] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "creditcardid" := row.creditcardid
      )}
}