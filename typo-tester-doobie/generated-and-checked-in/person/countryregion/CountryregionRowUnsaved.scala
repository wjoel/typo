/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `person.countryregion` which has not been persisted yet */
case class CountryregionRowUnsaved(
  /** ISO standard code for countries and regions. */
  countryregioncode: CountryregionId,
  /** Country or region name. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): CountryregionRow =
    CountryregionRow(
      countryregioncode = countryregioncode,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CountryregionRowUnsaved {
  implicit val decoder: Decoder[CountryregionRowUnsaved] = Decoder.forProduct3[CountryregionRowUnsaved, CountryregionId, Name, Defaulted[TypoLocalDateTime]]("countryregioncode", "name", "modifieddate")(CountryregionRowUnsaved.apply)(CountryregionId.decoder, Name.decoder, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[CountryregionRowUnsaved] = Encoder.forProduct3[CountryregionRowUnsaved, CountryregionId, Name, Defaulted[TypoLocalDateTime]]("countryregioncode", "name", "modifieddate")(x => (x.countryregioncode, x.name, x.modifieddate))(CountryregionId.encoder, Name.encoder, Defaulted.encoder(TypoLocalDateTime.encoder))
}
