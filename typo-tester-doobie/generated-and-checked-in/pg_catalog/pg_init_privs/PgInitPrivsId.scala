/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_init_privs

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_init_privs` */
case class PgInitPrivsId(objoid: /* oid */ Long, classoid: /* oid */ Long, objsubid: Int)
object PgInitPrivsId {
  implicit val decoder: Decoder[PgInitPrivsId] = Decoder.forProduct3[PgInitPrivsId, /* oid */ Long, /* oid */ Long, Int]("objoid", "classoid", "objsubid")(PgInitPrivsId.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt)
  implicit val encoder: Encoder[PgInitPrivsId] = Encoder.forProduct3[PgInitPrivsId, /* oid */ Long, /* oid */ Long, Int]("objoid", "classoid", "objsubid")(x => (x.objoid, x.classoid, x.objsubid))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt)
  implicit val ordering: Ordering[PgInitPrivsId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid))
}
