/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `person.addresstype` */
case class AddresstypeId(value: Int) extends AnyVal
object AddresstypeId {
  implicit val arrayGet: Get[Array[AddresstypeId]] = adventureworks.IntegerArrayMeta.get.map(_.map(AddresstypeId.apply))
  implicit val arrayPut: Put[Array[AddresstypeId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[AddresstypeId, Int] = Bijection[AddresstypeId, Int](_.value)(AddresstypeId.apply)
  implicit val decoder: Decoder[AddresstypeId] = Decoder.decodeInt.map(AddresstypeId.apply)
  implicit val encoder: Encoder[AddresstypeId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[AddresstypeId] = Meta.IntMeta.get.map(AddresstypeId.apply)
  implicit val ordering: Ordering[AddresstypeId] = Ordering.by(_.value)
  implicit val put: Put[AddresstypeId] = Meta.IntMeta.put.contramap(_.value)
}
