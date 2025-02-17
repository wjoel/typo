/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_trigger

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_trigger` */
case class PgTriggerId(value: /* oid */ Long) extends AnyVal
object PgTriggerId {
  implicit val arrayGet: Get[Array[PgTriggerId]] = adventureworks.LongArrayMeta.get.map(_.map(PgTriggerId.apply))
  implicit val arrayPut: Put[Array[PgTriggerId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgTriggerId, /* oid */ Long] = Bijection[PgTriggerId, /* oid */ Long](_.value)(PgTriggerId.apply)
  implicit val decoder: Decoder[PgTriggerId] = Decoder.decodeLong.map(PgTriggerId.apply)
  implicit val encoder: Encoder[PgTriggerId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgTriggerId] = Meta.LongMeta.get.map(PgTriggerId.apply)
  implicit val ordering: Ordering[PgTriggerId] = Ordering.by(_.value)
  implicit val put: Put[PgTriggerId] = Meta.LongMeta.put.contramap(_.value)
}
