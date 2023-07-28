/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgSeclabelRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  provider: String,
  label: String
){
   val compositeId: PgSeclabelId = PgSeclabelId(objoid, classoid, objsubid, provider)
 }

object PgSeclabelRow {
  implicit val decoder: Decoder[PgSeclabelRow] = Decoder.forProduct5[PgSeclabelRow, /* oid */ Long, /* oid */ Long, Int, String, String]("objoid", "classoid", "objsubid", "provider", "label")(PgSeclabelRow.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeString, Decoder.decodeString)
  implicit val encoder: Encoder[PgSeclabelRow] = Encoder.forProduct5[PgSeclabelRow, /* oid */ Long, /* oid */ Long, Int, String, String]("objoid", "classoid", "objsubid", "provider", "label")(x => (x.objoid, x.classoid, x.objsubid, x.provider, x.label))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeString, Encoder.encodeString)
  implicit val read: Read[PgSeclabelRow] = new Read[PgSeclabelRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgSeclabelRow(
      objoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      classoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      objsubid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      provider = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      label = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
