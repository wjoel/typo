/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_database` */
case class PgDatabaseId(value: /* oid */ Long) extends AnyVal
object PgDatabaseId {
  implicit val arrayGet: Get[Array[PgDatabaseId]] = adventureworks.LongArrayMeta.get.map(_.map(PgDatabaseId.apply))
  implicit val arrayPut: Put[Array[PgDatabaseId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgDatabaseId] = Decoder.decodeLong.map(PgDatabaseId.apply)
  implicit val encoder: Encoder[PgDatabaseId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgDatabaseId] = Meta.LongMeta.get.map(PgDatabaseId.apply)
  implicit val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit val put: Put[PgDatabaseId] = Meta.LongMeta.put.contramap(_.value)
}
