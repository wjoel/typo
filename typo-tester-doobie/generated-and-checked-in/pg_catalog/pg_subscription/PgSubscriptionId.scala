/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_subscription` */
case class PgSubscriptionId(value: /* oid */ Long) extends AnyVal
object PgSubscriptionId {
  implicit val arrayGet: Get[Array[PgSubscriptionId]] = adventureworks.LongArrayMeta.get.map(_.map(PgSubscriptionId.apply))
  implicit val arrayPut: Put[Array[PgSubscriptionId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgSubscriptionId, /* oid */ Long] = Bijection[PgSubscriptionId, /* oid */ Long](_.value)(PgSubscriptionId.apply)
  implicit val decoder: Decoder[PgSubscriptionId] = Decoder.decodeLong.map(PgSubscriptionId.apply)
  implicit val encoder: Encoder[PgSubscriptionId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgSubscriptionId] = Meta.LongMeta.get.map(PgSubscriptionId.apply)
  implicit val ordering: Ordering[PgSubscriptionId] = Ordering.by(_.value)
  implicit val put: Put[PgSubscriptionId] = Meta.LongMeta.put.contramap(_.value)
}