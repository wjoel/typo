/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.TypoLocalDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class TransactionhistoryarchiveRow(
  /** Primary key for TransactionHistoryArchive records. */
  transactionid: TransactionhistoryarchiveId,
  /** Product identification number. Foreign key to Product.ProductID. */
  productid: Int,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Int,
  /** Date and time of the transaction. */
  transactiondate: TypoLocalDateTime,
  /** W = Work Order, S = Sales Order, P = Purchase Order */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object TransactionhistoryarchiveRow {
  implicit val decoder: Decoder[TransactionhistoryarchiveRow] = Decoder.forProduct9[TransactionhistoryarchiveRow, TransactionhistoryarchiveId, Int, Int, Int, TypoLocalDateTime, /* bpchar */ String, Int, BigDecimal, TypoLocalDateTime]("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(TransactionhistoryarchiveRow.apply)(TransactionhistoryarchiveId.decoder, Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeInt, TypoLocalDateTime.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit val encoder: Encoder[TransactionhistoryarchiveRow] = Encoder.forProduct9[TransactionhistoryarchiveRow, TransactionhistoryarchiveId, Int, Int, Int, TypoLocalDateTime, /* bpchar */ String, Int, BigDecimal, TypoLocalDateTime]("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(x => (x.transactionid, x.productid, x.referenceorderid, x.referenceorderlineid, x.transactiondate, x.transactiontype, x.quantity, x.actualcost, x.modifieddate))(TransactionhistoryarchiveId.encoder, Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeInt, TypoLocalDateTime.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit val read: Read[TransactionhistoryarchiveRow] = new Read[TransactionhistoryarchiveRow](
    gets = List(
      (TransactionhistoryarchiveId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => TransactionhistoryarchiveRow(
      transactionid = TransactionhistoryarchiveId.get.unsafeGetNonNullable(rs, i + 0),
      productid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      referenceorderid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      referenceorderlineid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      transactiondate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4),
      transactiontype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      quantity = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      actualcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
