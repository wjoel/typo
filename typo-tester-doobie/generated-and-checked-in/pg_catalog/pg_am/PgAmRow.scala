/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

import adventureworks.TypoRegproc
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgAmRow(
  oid: PgAmId,
  amname: String,
  amhandler: TypoRegproc,
  amtype: String
)

object PgAmRow {
  implicit val decoder: Decoder[PgAmRow] = Decoder.forProduct4[PgAmRow, PgAmId, String, TypoRegproc, String]("oid", "amname", "amhandler", "amtype")(PgAmRow.apply)(PgAmId.decoder, Decoder.decodeString, TypoRegproc.decoder, Decoder.decodeString)
  implicit val encoder: Encoder[PgAmRow] = Encoder.forProduct4[PgAmRow, PgAmId, String, TypoRegproc, String]("oid", "amname", "amhandler", "amtype")(x => (x.oid, x.amname, x.amhandler, x.amtype))(PgAmId.encoder, Encoder.encodeString, TypoRegproc.encoder, Encoder.encodeString)
  implicit val read: Read[PgAmRow] = new Read[PgAmRow](
    gets = List(
      (PgAmId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoRegproc.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgAmRow(
      oid = PgAmId.get.unsafeGetNonNullable(rs, i + 0),
      amname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      amhandler = TypoRegproc.get.unsafeGetNonNullable(rs, i + 2),
      amtype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
