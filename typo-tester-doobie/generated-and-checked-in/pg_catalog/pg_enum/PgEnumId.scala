/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_enum` */
case class PgEnumId(value: /* oid */ Long) extends AnyVal
object PgEnumId {
  implicit val arrayGet: Get[Array[PgEnumId]] = adventureworks.LongArrayMeta.get.map(_.map(PgEnumId.apply))
  implicit val arrayPut: Put[Array[PgEnumId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgEnumId, /* oid */ Long] = Bijection[PgEnumId, /* oid */ Long](_.value)(PgEnumId.apply)
  implicit val decoder: Decoder[PgEnumId] = Decoder.decodeLong.map(PgEnumId.apply)
  implicit val encoder: Encoder[PgEnumId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgEnumId] = Meta.LongMeta.get.map(PgEnumId.apply)
  implicit val ordering: Ordering[PgEnumId] = Ordering.by(_.value)
  implicit val put: Put[PgEnumId] = Meta.LongMeta.put.contramap(_.value)
}
