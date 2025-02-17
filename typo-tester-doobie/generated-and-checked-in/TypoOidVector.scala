/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.util.PGobject
import typo.dsl.Bijection

/** oidvector (via PGObject) */
case class TypoOidVector(value: String)

object TypoOidVector {
  implicit val arrayGet: Get[Array[TypoOidVector]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_oidvector"))
    .map(_.map(v => TypoOidVector(v.asInstanceOf[String])))
  implicit val arrayPut: Put[Array[TypoOidVector]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_oidvector"), "oidvector")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("oidvector")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit val bijection: Bijection[TypoOidVector, String] = Bijection[TypoOidVector, String](_.value)(TypoOidVector.apply)
  implicit val decoder: Decoder[TypoOidVector] = Decoder.decodeString.map(TypoOidVector.apply)
  implicit val encoder: Encoder[TypoOidVector] = Encoder.encodeString.contramap(_.value)
  implicit val get: Get[TypoOidVector] = Get.Advanced.other[PGobject](NonEmptyList.one("oidvector"))
    .map(v => TypoOidVector(v.getValue))
  implicit val ordering: Ordering[TypoOidVector] = Ordering.by(_.value)
  implicit val put: Put[TypoOidVector] = Put.Advanced.other[PGobject](NonEmptyList.one("oidvector")).contramap(v => {
                                                                               val obj = new PGobject
                                                                               obj.setType("oidvector")
                                                                               obj.setValue(v.value)
                                                                               obj
                                                                             })
}
