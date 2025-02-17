/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.scrapreason` */
case class ScrapreasonId(value: Int) extends AnyVal
object ScrapreasonId {
  implicit val arrayGet: Get[Array[ScrapreasonId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ScrapreasonId.apply))
  implicit val arrayPut: Put[Array[ScrapreasonId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[ScrapreasonId, Int] = Bijection[ScrapreasonId, Int](_.value)(ScrapreasonId.apply)
  implicit val decoder: Decoder[ScrapreasonId] = Decoder.decodeInt.map(ScrapreasonId.apply)
  implicit val encoder: Encoder[ScrapreasonId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[ScrapreasonId] = Meta.IntMeta.get.map(ScrapreasonId.apply)
  implicit val ordering: Ordering[ScrapreasonId] = Ordering.by(_.value)
  implicit val put: Put[ScrapreasonId] = Meta.IntMeta.put.contramap(_.value)
}
