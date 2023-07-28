/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.sales.salesreason.SalesreasonId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SrViewRow(
  id: Option[Int],
  /** Points to [[sales.salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: Option[SalesreasonId],
  /** Points to [[sales.salesreason.SalesreasonRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salesreason.SalesreasonRow.reasontype]] */
  reasontype: Option[Name],
  /** Points to [[sales.salesreason.SalesreasonRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SrViewRow {
  implicit val decoder: Decoder[SrViewRow] = Decoder.forProduct5[SrViewRow, Option[Int], Option[SalesreasonId], Option[Name], Option[Name], Option[TypoLocalDateTime]]("id", "salesreasonid", "name", "reasontype", "modifieddate")(SrViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(SalesreasonId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[SrViewRow] = Encoder.forProduct5[SrViewRow, Option[Int], Option[SalesreasonId], Option[Name], Option[Name], Option[TypoLocalDateTime]]("id", "salesreasonid", "name", "reasontype", "modifieddate")(x => (x.id, x.salesreasonid, x.name, x.reasontype, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(SalesreasonId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[SrViewRow] = new Read[SrViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (SalesreasonId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SrViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      salesreasonid = SalesreasonId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      reasontype = Name.get.unsafeGetNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
