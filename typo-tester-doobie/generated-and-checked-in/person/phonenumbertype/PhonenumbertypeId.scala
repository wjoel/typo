/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `person.phonenumbertype` */
case class PhonenumbertypeId(value: Int) extends AnyVal
object PhonenumbertypeId {
  implicit val arrayGet: Get[Array[PhonenumbertypeId]] = adventureworks.IntegerArrayMeta.get.map(_.map(PhonenumbertypeId.apply))
  implicit val arrayPut: Put[Array[PhonenumbertypeId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PhonenumbertypeId] = Decoder.decodeInt.map(PhonenumbertypeId.apply)
  implicit val encoder: Encoder[PhonenumbertypeId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[PhonenumbertypeId] = Meta.IntMeta.get.map(PhonenumbertypeId.apply)
  implicit val ordering: Ordering[PhonenumbertypeId] = Ordering.by(_.value)
  implicit val put: Put[PhonenumbertypeId] = Meta.IntMeta.put.contramap(_.value)
}
