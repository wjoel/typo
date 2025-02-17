/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.illustration` */
case class IllustrationId(value: Int) extends AnyVal
object IllustrationId {
  implicit val arrayGet: Get[Array[IllustrationId]] = adventureworks.IntegerArrayMeta.get.map(_.map(IllustrationId.apply))
  implicit val arrayPut: Put[Array[IllustrationId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[IllustrationId, Int] = Bijection[IllustrationId, Int](_.value)(IllustrationId.apply)
  implicit val decoder: Decoder[IllustrationId] = Decoder.decodeInt.map(IllustrationId.apply)
  implicit val encoder: Encoder[IllustrationId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[IllustrationId] = Meta.IntMeta.get.map(IllustrationId.apply)
  implicit val ordering: Ordering[IllustrationId] = Ordering.by(_.value)
  implicit val put: Put[IllustrationId] = Meta.IntMeta.put.contramap(_.value)
}
