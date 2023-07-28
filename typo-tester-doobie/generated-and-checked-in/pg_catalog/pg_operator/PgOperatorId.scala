/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_operator` */
case class PgOperatorId(value: /* oid */ Long) extends AnyVal
object PgOperatorId {
  implicit val arrayGet: Get[Array[PgOperatorId]] = adventureworks.LongArrayMeta.get.map(_.map(PgOperatorId.apply))
  implicit val arrayPut: Put[Array[PgOperatorId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgOperatorId] = Decoder.decodeLong.map(PgOperatorId.apply)
  implicit val encoder: Encoder[PgOperatorId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgOperatorId] = Meta.LongMeta.get.map(PgOperatorId.apply)
  implicit val ordering: Ordering[PgOperatorId] = Ordering.by(_.value)
  implicit val put: Put[PgOperatorId] = Meta.LongMeta.put.contramap(_.value)
}
