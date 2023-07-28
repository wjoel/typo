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
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

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
  implicit val decoder: Decoder[ShipmethodRowUnsaved] = Decoder.forProduct6[ShipmethodRowUnsaved, Name, Defaulted[ShipmethodId], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("name", "shipmethodid", "shipbase", "shiprate", "rowguid", "modifieddate")(ShipmethodRowUnsaved.apply)(Name.decoder, Defaulted.decoder(ShipmethodId.decoder), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[ShipmethodRowUnsaved] = Encoder.forProduct6[ShipmethodRowUnsaved, Name, Defaulted[ShipmethodId], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("name", "shipmethodid", "shipbase", "shiprate", "rowguid", "modifieddate")(x => (x.name, x.shipmethodid, x.shipbase, x.shiprate, x.rowguid, x.modifieddate))(Name.encoder, Defaulted.encoder(ShipmethodId.encoder), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
