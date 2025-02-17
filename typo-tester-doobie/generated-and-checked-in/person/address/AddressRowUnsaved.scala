/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.address` which has not been persisted yet */
case class AddressRowUnsaved(
  /** First street address line. */
  addressline1: /* max 60 chars */ String,
  /** Second street address line. */
  addressline2: Option[/* max 60 chars */ String],
  /** Name of the city. */
  city: /* max 30 chars */ String,
  /** Unique identification number for the state or province. Foreign key to StateProvince table.
      Points to [[stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Postal code for the street address. */
  postalcode: /* max 15 chars */ String,
  /** Latitude and longitude of this address. */
  spatiallocation: Option[Array[Byte]],
  /** Default: nextval('person.address_addressid_seq'::regclass)
      Primary key for Address records. */
  addressid: Defaulted[AddressId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(addressidDefault: => AddressId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): AddressRow =
    AddressRow(
      addressline1 = addressline1,
      addressline2 = addressline2,
      city = city,
      stateprovinceid = stateprovinceid,
      postalcode = postalcode,
      spatiallocation = spatiallocation,
      addressid = addressid match {
                    case Defaulted.UseDefault => addressidDefault
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
object AddressRowUnsaved {
  implicit val decoder: Decoder[AddressRowUnsaved] = Decoder.forProduct9[AddressRowUnsaved, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[Array[Byte]], Defaulted[AddressId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "addressid", "rowguid", "modifieddate")(AddressRowUnsaved.apply)(Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, StateprovinceId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeArray[Byte](Decoder.decodeByte, implicitly)), Defaulted.decoder(AddressId.decoder), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[AddressRowUnsaved] = Encoder.forProduct9[AddressRowUnsaved, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[Array[Byte]], Defaulted[AddressId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "addressid", "rowguid", "modifieddate")(x => (x.addressline1, x.addressline2, x.city, x.stateprovinceid, x.postalcode, x.spatiallocation, x.addressid, x.rowguid, x.modifieddate))(Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, StateprovinceId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeIterable[Byte, Array](Encoder.encodeByte, implicitly)), Defaulted.encoder(AddressId.encoder), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
