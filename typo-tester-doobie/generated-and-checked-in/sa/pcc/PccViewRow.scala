/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package pcc

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.creditcard.CreditcardId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class PccViewRow(
  id: Option[Int],
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.creditcardid]] */
  creditcardid: Option[CreditcardId],
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PccViewRow {
  implicit val decoder: Decoder[PccViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        creditcardid <- c.downField("creditcardid").as[Option[CreditcardId]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PccViewRow(id, businessentityid, creditcardid, modifieddate)
  implicit val encoder: Encoder[PccViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "businessentityid" := row.businessentityid,
        "creditcardid" := row.creditcardid,
        "modifieddate" := row.modifieddate
      )}
}