/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.product` */
case class ProductId(value: Int) extends AnyVal
object ProductId {
  implicit val arrayGet: Get[Array[ProductId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ProductId.apply))
  implicit val arrayPut: Put[Array[ProductId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[ProductId, Int] = Bijection[ProductId, Int](_.value)(ProductId.apply)
  implicit val decoder: Decoder[ProductId] = Decoder.decodeInt.map(ProductId.apply)
  implicit val encoder: Encoder[ProductId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[ProductId] = Meta.IntMeta.get.map(ProductId.apply)
  implicit val ordering: Ordering[ProductId] = Ordering.by(_.value)
  implicit val put: Put[ProductId] = Meta.IntMeta.put.contramap(_.value)
}
