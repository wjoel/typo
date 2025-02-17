/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import adventureworks.TypoLocalDateTime
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class UmViewRow(
  id: Option[/* bpchar */ String],
  /** Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.unitmeasure.UnitmeasureRow.name]] */
  name: Option[Name],
  /** Points to [[production.unitmeasure.UnitmeasureRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object UmViewRow {
  implicit val decoder: Decoder[UmViewRow] = Decoder.forProduct4[UmViewRow, Option[/* bpchar */ String], Option[UnitmeasureId], Option[Name], Option[TypoLocalDateTime]]("id", "unitmeasurecode", "name", "modifieddate")(UmViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(UnitmeasureId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[UmViewRow] = Encoder.forProduct4[UmViewRow, Option[/* bpchar */ String], Option[UnitmeasureId], Option[Name], Option[TypoLocalDateTime]]("id", "unitmeasurecode", "name", "modifieddate")(x => (x.id, x.unitmeasurecode, x.name, x.modifieddate))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(UnitmeasureId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[UmViewRow] = new Read[UmViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => UmViewRow(
      id = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      unitmeasurecode = UnitmeasureId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
