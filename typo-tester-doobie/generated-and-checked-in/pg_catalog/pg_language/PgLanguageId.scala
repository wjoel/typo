/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_language` */
case class PgLanguageId(value: /* oid */ Long) extends AnyVal
object PgLanguageId {
  implicit val arrayGet: Get[Array[PgLanguageId]] = adventureworks.LongArrayMeta.get.map(_.map(PgLanguageId.apply))
  implicit val arrayPut: Put[Array[PgLanguageId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgLanguageId] = Decoder.decodeLong.map(PgLanguageId.apply)
  implicit val encoder: Encoder[PgLanguageId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgLanguageId] = Meta.LongMeta.get.map(PgLanguageId.apply)
  implicit val ordering: Ordering[PgLanguageId] = Ordering.by(_.value)
  implicit val put: Put[PgLanguageId] = Meta.LongMeta.put.contramap(_.value)
}
