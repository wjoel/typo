/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `sales.salesterritory` */
case class SalesterritoryId(value: Int) extends AnyVal
object SalesterritoryId {
  implicit val arrayGet: Get[Array[SalesterritoryId]] = adventureworks.IntegerArrayMeta.get.map(_.map(SalesterritoryId.apply))
  implicit val arrayPut: Put[Array[SalesterritoryId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[SalesterritoryId] = Decoder.decodeInt.map(SalesterritoryId.apply)
  implicit val encoder: Encoder[SalesterritoryId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[SalesterritoryId] = Meta.IntMeta.get.map(SalesterritoryId.apply)
  implicit val ordering: Ordering[SalesterritoryId] = Ordering.by(_.value)
  implicit val put: Put[SalesterritoryId] = Meta.IntMeta.put.contramap(_.value)
}
