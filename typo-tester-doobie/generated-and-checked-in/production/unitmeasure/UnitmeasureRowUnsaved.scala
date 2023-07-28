/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.unitmeasure` which has not been persisted yet */
case class UnitmeasureRowUnsaved(
  /** Primary key. */
  unitmeasurecode: UnitmeasureId,
  /** Unit of measure description. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): UnitmeasureRow =
    UnitmeasureRow(
      unitmeasurecode = unitmeasurecode,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object UnitmeasureRowUnsaved {
  implicit val decoder: Decoder[UnitmeasureRowUnsaved] = Decoder.forProduct3[UnitmeasureRowUnsaved, UnitmeasureId, Name, Defaulted[TypoLocalDateTime]]("unitmeasurecode", "name", "modifieddate")(UnitmeasureRowUnsaved.apply)(UnitmeasureId.decoder, Name.decoder, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[UnitmeasureRowUnsaved] = Encoder.forProduct3[UnitmeasureRowUnsaved, UnitmeasureId, Name, Defaulted[TypoLocalDateTime]]("unitmeasurecode", "name", "modifieddate")(x => (x.unitmeasurecode, x.name, x.modifieddate))(UnitmeasureId.encoder, Name.encoder, Defaulted.encoder(TypoLocalDateTime.encoder))
}
