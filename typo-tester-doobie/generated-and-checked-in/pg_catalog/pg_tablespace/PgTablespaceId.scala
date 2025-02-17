/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_tablespace` */
case class PgTablespaceId(value: /* oid */ Long) extends AnyVal
object PgTablespaceId {
  implicit val arrayGet: Get[Array[PgTablespaceId]] = adventureworks.LongArrayMeta.get.map(_.map(PgTablespaceId.apply))
  implicit val arrayPut: Put[Array[PgTablespaceId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgTablespaceId, /* oid */ Long] = Bijection[PgTablespaceId, /* oid */ Long](_.value)(PgTablespaceId.apply)
  implicit val decoder: Decoder[PgTablespaceId] = Decoder.decodeLong.map(PgTablespaceId.apply)
  implicit val encoder: Encoder[PgTablespaceId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgTablespaceId] = Meta.LongMeta.get.map(PgTablespaceId.apply)
  implicit val ordering: Ordering[PgTablespaceId] = Ordering.by(_.value)
  implicit val put: Put[PgTablespaceId] = Meta.LongMeta.put.contramap(_.value)
}
