/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import adventureworks.TypoLocalDateTime
import adventureworks.sales.creditcard.CreditcardId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CcViewRow(
  id: Option[Int],
  /** Points to [[sales.creditcard.CreditcardRow.creditcardid]] */
  creditcardid: Option[CreditcardId],
  /** Points to [[sales.creditcard.CreditcardRow.cardtype]] */
  cardtype: Option[/* max 50 chars */ String],
  /** Points to [[sales.creditcard.CreditcardRow.cardnumber]] */
  cardnumber: Option[/* max 25 chars */ String],
  /** Points to [[sales.creditcard.CreditcardRow.expmonth]] */
  expmonth: Option[Int],
  /** Points to [[sales.creditcard.CreditcardRow.expyear]] */
  expyear: Option[Int],
  /** Points to [[sales.creditcard.CreditcardRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CcViewRow {
  implicit val decoder: Decoder[CcViewRow] = Decoder.forProduct7[CcViewRow, Option[Int], Option[CreditcardId], Option[/* max 50 chars */ String], Option[/* max 25 chars */ String], Option[Int], Option[Int], Option[TypoLocalDateTime]]("id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(CcViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(CreditcardId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[CcViewRow] = Encoder.forProduct7[CcViewRow, Option[Int], Option[CreditcardId], Option[/* max 50 chars */ String], Option[/* max 25 chars */ String], Option[Int], Option[Int], Option[TypoLocalDateTime]]("id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(x => (x.id, x.creditcardid, x.cardtype, x.cardnumber, x.expmonth, x.expyear, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(CreditcardId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[CcViewRow] = new Read[CcViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (CreditcardId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CcViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      creditcardid = CreditcardId.get.unsafeGetNullable(rs, i + 1),
      cardtype = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      cardnumber = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      expmonth = Meta.IntMeta.get.unsafeGetNullable(rs, i + 4),
      expyear = Meta.IntMeta.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
