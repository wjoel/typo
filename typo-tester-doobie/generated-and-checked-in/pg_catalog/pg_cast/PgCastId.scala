/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_cast` */
case class PgCastId(value: /* oid */ Long) extends AnyVal
object PgCastId {
  implicit val arrayGet: Get[Array[PgCastId]] = adventureworks.LongArrayMeta.get.map(_.map(PgCastId.apply))
  implicit val arrayPut: Put[Array[PgCastId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgCastId, /* oid */ Long] = Bijection[PgCastId, /* oid */ Long](_.value)(PgCastId.apply)
  implicit val decoder: Decoder[PgCastId] = Decoder.decodeLong.map(PgCastId.apply)
  implicit val encoder: Encoder[PgCastId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgCastId] = Meta.LongMeta.get.map(PgCastId.apply)
  implicit val ordering: Ordering[PgCastId] = Ordering.by(_.value)
  implicit val put: Put[PgCastId] = Meta.LongMeta.put.contramap(_.value)
}
