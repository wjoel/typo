/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Domain `public.Flag`
  * No constraint
  */
case class Flag(value: Boolean) extends AnyVal
object Flag {
  implicit val arrayGet: Get[Array[Flag]] = adventureworks.BooleanArrayMeta.get.map(_.map(Flag.apply))
  implicit val arrayPut: Put[Array[Flag]] = adventureworks.BooleanArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[Flag] = Decoder.decodeBoolean.map(Flag.apply)
  implicit val encoder: Encoder[Flag] = Encoder.encodeBoolean.contramap(_.value)
  implicit val get: Get[Flag] = Meta.BooleanMeta.get.map(Flag.apply)
  implicit val ordering: Ordering[Flag] = Ordering.by(_.value)
  implicit val put: Put[Flag] = Meta.BooleanMeta.put.contramap(_.value)
}
