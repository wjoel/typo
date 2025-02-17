/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `person.contacttype` which has not been persisted yet */
case class ContacttypeRowUnsaved(
  /** Contact type description. */
  name: Name,
  /** Default: nextval('person.contacttype_contacttypeid_seq'::regclass)
      Primary key for ContactType records. */
  contacttypeid: Defaulted[ContacttypeId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(contacttypeidDefault: => ContacttypeId, modifieddateDefault: => TypoLocalDateTime): ContacttypeRow =
    ContacttypeRow(
      name = name,
      contacttypeid = contacttypeid match {
                        case Defaulted.UseDefault => contacttypeidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ContacttypeRowUnsaved {
  implicit val decoder: Decoder[ContacttypeRowUnsaved] = Decoder.forProduct3[ContacttypeRowUnsaved, Name, Defaulted[ContacttypeId], Defaulted[TypoLocalDateTime]]("name", "contacttypeid", "modifieddate")(ContacttypeRowUnsaved.apply)(Name.decoder, Defaulted.decoder(ContacttypeId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[ContacttypeRowUnsaved] = Encoder.forProduct3[ContacttypeRowUnsaved, Name, Defaulted[ContacttypeId], Defaulted[TypoLocalDateTime]]("name", "contacttypeid", "modifieddate")(x => (x.name, x.contacttypeid, x.modifieddate))(Name.encoder, Defaulted.encoder(ContacttypeId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
}
