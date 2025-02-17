/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_seclabel` */
case class PgSeclabelId(objoid: /* oid */ Long, classoid: /* oid */ Long, objsubid: Int, provider: String)
object PgSeclabelId {
  implicit val decoder: Decoder[PgSeclabelId] = Decoder.forProduct4[PgSeclabelId, /* oid */ Long, /* oid */ Long, Int, String]("objoid", "classoid", "objsubid", "provider")(PgSeclabelId.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeString)
  implicit val encoder: Encoder[PgSeclabelId] = Encoder.forProduct4[PgSeclabelId, /* oid */ Long, /* oid */ Long, Int, String]("objoid", "classoid", "objsubid", "provider")(x => (x.objoid, x.classoid, x.objsubid, x.provider))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeString)
  implicit val ordering: Ordering[PgSeclabelId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid, x.provider))
}
