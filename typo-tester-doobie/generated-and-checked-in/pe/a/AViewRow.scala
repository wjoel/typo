/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import adventureworks.person.address.AddressId
import adventureworks.person.stateprovince.StateprovinceId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class AViewRow(
  id: Option[Int],
  /** Points to [[person.address.AddressRow.addressid]] */
  addressid: Option[AddressId],
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: Option[String],
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[String],
  /** Points to [[person.address.AddressRow.city]] */
  city: Option[String],
  /** Points to [[person.address.AddressRow.stateprovinceid]] */
  stateprovinceid: Option[StateprovinceId],
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: Option[String],
  /** Points to [[person.address.AddressRow.spatiallocation]] */
  spatiallocation: Option[Byte],
  /** Points to [[person.address.AddressRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.address.AddressRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object AViewRow {
  implicit val decoder: Decoder[AViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        addressid <- c.downField("addressid").as[Option[AddressId]]
        addressline1 <- c.downField("addressline1").as[Option[String]]
        addressline2 <- c.downField("addressline2").as[Option[String]]
        city <- c.downField("city").as[Option[String]]
        stateprovinceid <- c.downField("stateprovinceid").as[Option[StateprovinceId]]
        postalcode <- c.downField("postalcode").as[Option[String]]
        spatiallocation <- c.downField("spatiallocation").as[Option[Byte]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield AViewRow(id, addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
  implicit val encoder: Encoder[AViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "addressid" := row.addressid,
        "addressline1" := row.addressline1,
        "addressline2" := row.addressline2,
        "city" := row.city,
        "stateprovinceid" := row.stateprovinceid,
        "postalcode" := row.postalcode,
        "spatiallocation" := row.spatiallocation,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}