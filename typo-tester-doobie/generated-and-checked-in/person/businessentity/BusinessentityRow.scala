/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class BusinessentityRow(
  /** Primary key for all customers, vendors, and employees. */
  businessentityid: BusinessentityId,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object BusinessentityRow {
  implicit val decoder: Decoder[BusinessentityRow] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        rowguid <- c.downField("rowguid").as[UUID]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield BusinessentityRow(businessentityid, rowguid, modifieddate)
  implicit val encoder: Encoder[BusinessentityRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}