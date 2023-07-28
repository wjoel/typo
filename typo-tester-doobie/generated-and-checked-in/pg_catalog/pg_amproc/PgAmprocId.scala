/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_amproc` */
case class PgAmprocId(value: /* oid */ Long) extends AnyVal
object PgAmprocId {
  implicit val arrayGet: Get[Array[PgAmprocId]] = adventureworks.LongArrayMeta.get.map(_.map(PgAmprocId.apply))
  implicit val arrayPut: Put[Array[PgAmprocId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgAmprocId] = Decoder.decodeLong.map(PgAmprocId.apply)
  implicit val encoder: Encoder[PgAmprocId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgAmprocId] = Meta.LongMeta.get.map(PgAmprocId.apply)
  implicit val ordering: Ordering[PgAmprocId] = Ordering.by(_.value)
  implicit val put: Put[PgAmprocId] = Meta.LongMeta.put.contramap(_.value)
}
