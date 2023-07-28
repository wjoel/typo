/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `person.contacttype` */
case class ContacttypeId(value: Int) extends AnyVal
object ContacttypeId {
  implicit val arrayGet: Get[Array[ContacttypeId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ContacttypeId.apply))
  implicit val arrayPut: Put[Array[ContacttypeId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[ContacttypeId] = Decoder.decodeInt.map(ContacttypeId.apply)
  implicit val encoder: Encoder[ContacttypeId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[ContacttypeId] = Meta.IntMeta.get.map(ContacttypeId.apply)
  implicit val ordering: Ordering[ContacttypeId] = Ordering.by(_.value)
  implicit val put: Put[ContacttypeId] = Meta.IntMeta.put.contramap(_.value)
}
