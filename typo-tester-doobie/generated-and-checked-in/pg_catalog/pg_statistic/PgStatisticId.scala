/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_statistic` */
case class PgStatisticId(starelid: /* oid */ Long, staattnum: Int, stainherit: Boolean)
object PgStatisticId {
  implicit val decoder: Decoder[PgStatisticId] = Decoder.forProduct3[PgStatisticId, /* oid */ Long, Int, Boolean]("starelid", "staattnum", "stainherit")(PgStatisticId.apply)(Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeBoolean)
  implicit val encoder: Encoder[PgStatisticId] = Encoder.forProduct3[PgStatisticId, /* oid */ Long, Int, Boolean]("starelid", "staattnum", "stainherit")(x => (x.starelid, x.staattnum, x.stainherit))(Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeBoolean)
  implicit val ordering: Ordering[PgStatisticId] = Ordering.by(x => (x.starelid, x.staattnum, x.stainherit))
}
