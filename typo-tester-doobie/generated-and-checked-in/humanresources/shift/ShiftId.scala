/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `humanresources.shift` */
case class ShiftId(value: Int) extends AnyVal
object ShiftId {
  implicit val arrayGet: Get[Array[ShiftId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ShiftId.apply))
  implicit val arrayPut: Put[Array[ShiftId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[ShiftId, Int] = Bijection[ShiftId, Int](_.value)(ShiftId.apply)
  implicit val decoder: Decoder[ShiftId] = Decoder.decodeInt.map(ShiftId.apply)
  implicit val encoder: Encoder[ShiftId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[ShiftId] = Meta.IntMeta.get.map(ShiftId.apply)
  implicit val ordering: Ordering[ShiftId] = Ordering.by(_.value)
  implicit val put: Put[ShiftId] = Meta.IntMeta.put.contramap(_.value)
}
