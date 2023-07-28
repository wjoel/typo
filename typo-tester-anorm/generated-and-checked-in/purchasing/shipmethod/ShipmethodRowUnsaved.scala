/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `purchasing.shipmethod` which has not been persisted yet */
case class ShipmethodRowUnsaved(
  /** Shipping company name. */
  name: Name,
  /** Default: nextval('purchasing.shipmethod_shipmethodid_seq'::regclass)
      Primary key for ShipMethod records. */
  shipmethodid: Defaulted[ShipmethodId] = Defaulted.UseDefault,
  /** Default: 0.00
      Minimum shipping charge. */
  shipbase: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Shipping charge per pound. */
  shiprate: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shipmethodidDefault: => ShipmethodId, shipbaseDefault: => BigDecimal, shiprateDefault: => BigDecimal, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): ShipmethodRow =
    ShipmethodRow(
      name = name,
      shipmethodid = shipmethodid match {
                       case Defaulted.UseDefault => shipmethodidDefault
                       case Defaulted.Provided(value) => value
                     },
      shipbase = shipbase match {
                   case Defaulted.UseDefault => shipbaseDefault
                   case Defaulted.Provided(value) => value
                 },
      shiprate = shiprate match {
                   case Defaulted.UseDefault => shiprateDefault
                   case Defaulted.Provided(value) => value
                 },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ShipmethodRowUnsaved {
  implicit val reads: Reads[ShipmethodRowUnsaved] = Reads[ShipmethodRowUnsaved](json => JsResult.fromTry(
      Try(
        ShipmethodRowUnsaved(
          name = json.\("name").as(Name.reads),
          shipmethodid = json.\("shipmethodid").as(Defaulted.reads(ShipmethodId.reads)),
          shipbase = json.\("shipbase").as(Defaulted.reads(Reads.bigDecReads)),
          shiprate = json.\("shiprate").as(Defaulted.reads(Reads.bigDecReads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit val writes: OWrites[ShipmethodRowUnsaved] = OWrites[ShipmethodRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Name.writes.writes(o.name),
      "shipmethodid" -> Defaulted.writes(ShipmethodId.writes).writes(o.shipmethodid),
      "shipbase" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.shipbase),
      "shiprate" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.shiprate),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
