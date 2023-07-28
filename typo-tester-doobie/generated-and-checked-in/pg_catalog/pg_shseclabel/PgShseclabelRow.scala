/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shseclabel

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgShseclabelRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  provider: String,
  label: String
){
   val compositeId: PgShseclabelId = PgShseclabelId(objoid, classoid, provider)
 }

object PgShseclabelRow {
  implicit val decoder: Decoder[PgShseclabelRow] = Decoder.forProduct4[PgShseclabelRow, /* oid */ Long, /* oid */ Long, String, String]("objoid", "classoid", "provider", "label")(PgShseclabelRow.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString, Decoder.decodeString)
  implicit val encoder: Encoder[PgShseclabelRow] = Encoder.forProduct4[PgShseclabelRow, /* oid */ Long, /* oid */ Long, String, String]("objoid", "classoid", "provider", "label")(x => (x.objoid, x.classoid, x.provider, x.label))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString, Encoder.encodeString)
  implicit val read: Read[PgShseclabelRow] = new Read[PgShseclabelRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgShseclabelRow(
      objoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      classoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      provider = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      label = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
