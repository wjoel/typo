/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shseclabel

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_shseclabel` */
case class PgShseclabelId(objoid: /* oid */ Long, classoid: /* oid */ Long, provider: String)
object PgShseclabelId {
  implicit val decoder: Decoder[PgShseclabelId] = Decoder.forProduct3[PgShseclabelId, /* oid */ Long, /* oid */ Long, String]("objoid", "classoid", "provider")(PgShseclabelId.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString)
  implicit val encoder: Encoder[PgShseclabelId] = Encoder.forProduct3[PgShseclabelId, /* oid */ Long, /* oid */ Long, String]("objoid", "classoid", "provider")(x => (x.objoid, x.classoid, x.provider))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString)
  implicit val ordering: Ordering[PgShseclabelId] = Ordering.by(x => (x.objoid, x.classoid, x.provider))
}