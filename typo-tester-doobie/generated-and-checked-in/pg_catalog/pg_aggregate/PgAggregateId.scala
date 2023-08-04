/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import adventureworks.TypoRegproc
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_aggregate` */
case class PgAggregateId(value: TypoRegproc) extends AnyVal
object PgAggregateId {
  implicit val arrayGet: Get[Array[PgAggregateId]] = TypoRegproc.arrayGet.map(_.map(PgAggregateId.apply))
  implicit val arrayPut: Put[Array[PgAggregateId]] = TypoRegproc.arrayPut.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgAggregateId, TypoRegproc] = Bijection[PgAggregateId, TypoRegproc](_.value)(PgAggregateId.apply)
  implicit val decoder: Decoder[PgAggregateId] = TypoRegproc.decoder.map(PgAggregateId.apply)
  implicit val encoder: Encoder[PgAggregateId] = TypoRegproc.encoder.contramap(_.value)
  implicit val get: Get[PgAggregateId] = TypoRegproc.get.map(PgAggregateId.apply)
  implicit def ordering(implicit O0: Ordering[TypoRegproc]): Ordering[PgAggregateId] = Ordering.by(_.value)
  implicit val put: Put[PgAggregateId] = TypoRegproc.put.contramap(_.value)
}