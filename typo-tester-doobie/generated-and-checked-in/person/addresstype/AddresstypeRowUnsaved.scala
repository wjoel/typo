/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.addresstype` which has not been persisted yet */
case class AddresstypeRowUnsaved(
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  /** Default: nextval('person.addresstype_addresstypeid_seq'::regclass)
      Primary key for AddressType records. */
  addresstypeid: Defaulted[AddresstypeId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(addresstypeidDefault: => AddresstypeId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): AddresstypeRow =
    AddresstypeRow(
      name = name,
      addresstypeid = addresstypeid match {
                        case Defaulted.UseDefault => addresstypeidDefault
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
object AddresstypeRowUnsaved {
  implicit val decoder: Decoder[AddresstypeRowUnsaved] = Decoder.forProduct4[AddresstypeRowUnsaved, Name, Defaulted[AddresstypeId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("name", "addresstypeid", "rowguid", "modifieddate")(AddresstypeRowUnsaved.apply)(Name.decoder, Defaulted.decoder(AddresstypeId.decoder), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[AddresstypeRowUnsaved] = Encoder.forProduct4[AddresstypeRowUnsaved, Name, Defaulted[AddresstypeId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("name", "addresstypeid", "rowguid", "modifieddate")(x => (x.name, x.addresstypeid, x.rowguid, x.modifieddate))(Name.encoder, Defaulted.encoder(AddresstypeId.encoder), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
