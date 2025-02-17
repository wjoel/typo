/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package i

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.production.illustration.IllustrationId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class IViewRow(
  id: Option[Int],
  /** Points to [[production.illustration.IllustrationRow.illustrationid]] */
  illustrationid: Option[IllustrationId],
  /** Points to [[production.illustration.IllustrationRow.diagram]] */
  diagram: Option[TypoXml],
  /** Points to [[production.illustration.IllustrationRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object IViewRow {
  implicit val decoder: Decoder[IViewRow] = Decoder.forProduct4[IViewRow, Option[Int], Option[IllustrationId], Option[TypoXml], Option[TypoLocalDateTime]]("id", "illustrationid", "diagram", "modifieddate")(IViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(IllustrationId.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[IViewRow] = Encoder.forProduct4[IViewRow, Option[Int], Option[IllustrationId], Option[TypoXml], Option[TypoLocalDateTime]]("id", "illustrationid", "diagram", "modifieddate")(x => (x.id, x.illustrationid, x.diagram, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(IllustrationId.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[IViewRow] = new Read[IViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (IllustrationId.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => IViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      illustrationid = IllustrationId.get.unsafeGetNullable(rs, i + 1),
      diagram = TypoXml.get.unsafeGetNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
