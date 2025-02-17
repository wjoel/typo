/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config_map

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_ts_config_map` */
case class PgTsConfigMapId(mapcfg: /* oid */ Long, maptokentype: Int, mapseqno: Int)
object PgTsConfigMapId {
  implicit val decoder: Decoder[PgTsConfigMapId] = Decoder.forProduct3[PgTsConfigMapId, /* oid */ Long, Int, Int]("mapcfg", "maptokentype", "mapseqno")(PgTsConfigMapId.apply)(Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeInt)
  implicit val encoder: Encoder[PgTsConfigMapId] = Encoder.forProduct3[PgTsConfigMapId, /* oid */ Long, Int, Int]("mapcfg", "maptokentype", "mapseqno")(x => (x.mapcfg, x.maptokentype, x.mapseqno))(Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeInt)
  implicit val ordering: Ordering[PgTsConfigMapId] = Ordering.by(x => (x.mapcfg, x.maptokentype, x.mapseqno))
}
