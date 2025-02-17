/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `humanresources.jobcandidate` */
case class JobcandidateId(value: Int) extends AnyVal
object JobcandidateId {
  implicit val arrayGet: Get[Array[JobcandidateId]] = adventureworks.IntegerArrayMeta.get.map(_.map(JobcandidateId.apply))
  implicit val arrayPut: Put[Array[JobcandidateId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[JobcandidateId, Int] = Bijection[JobcandidateId, Int](_.value)(JobcandidateId.apply)
  implicit val decoder: Decoder[JobcandidateId] = Decoder.decodeInt.map(JobcandidateId.apply)
  implicit val encoder: Encoder[JobcandidateId] = Encoder.encodeInt.contramap(_.value)
  implicit val get: Get[JobcandidateId] = Meta.IntMeta.get.map(JobcandidateId.apply)
  implicit val ordering: Ordering[JobcandidateId] = Ordering.by(_.value)
  implicit val put: Put[JobcandidateId] = Meta.IntMeta.put.contramap(_.value)
}
