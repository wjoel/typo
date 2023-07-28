/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_largeobject_metadata` */
case class PgLargeobjectMetadataId(value: /* oid */ Long) extends AnyVal
object PgLargeobjectMetadataId {
  implicit val arrayGet: Get[Array[PgLargeobjectMetadataId]] = adventureworks.LongArrayMeta.get.map(_.map(PgLargeobjectMetadataId.apply))
  implicit val arrayPut: Put[Array[PgLargeobjectMetadataId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgLargeobjectMetadataId] = Decoder.decodeLong.map(PgLargeobjectMetadataId.apply)
  implicit val encoder: Encoder[PgLargeobjectMetadataId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgLargeobjectMetadataId] = Meta.LongMeta.get.map(PgLargeobjectMetadataId.apply)
  implicit val ordering: Ordering[PgLargeobjectMetadataId] = Ordering.by(_.value)
  implicit val put: Put[PgLargeobjectMetadataId] = Meta.LongMeta.put.contramap(_.value)
}
