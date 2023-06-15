/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import adventureworks.Defaulted
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `production.unitmeasure` which has not been persisted yet */
case class UnitmeasureRowUnsaved(
  /** Primary key. */
  unitmeasurecode: UnitmeasureId,
  /** Unit of measure description. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): UnitmeasureRow =
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
  implicit val decoder: Decoder[UnitmeasureRowUnsaved] =
    (c: HCursor) =>
      for {
        unitmeasurecode <- c.downField("unitmeasurecode").as[UnitmeasureId]
        name <- c.downField("name").as[Name]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield UnitmeasureRowUnsaved(unitmeasurecode, name, modifieddate)
  implicit val encoder: Encoder[UnitmeasureRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "unitmeasurecode" := row.unitmeasurecode,
        "name" := row.name,
        "modifieddate" := row.modifieddate
      )}
}