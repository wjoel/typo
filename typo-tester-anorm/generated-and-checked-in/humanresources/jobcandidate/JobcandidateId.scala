/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `humanresources.jobcandidate` */
case class JobcandidateId(value: Int) extends AnyVal
object JobcandidateId {
  implicit lazy val arrayColumn: Column[Array[JobcandidateId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[JobcandidateId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[JobcandidateId, Int] = Bijection[JobcandidateId, Int](_.value)(JobcandidateId.apply)
  implicit lazy val column: Column[JobcandidateId] = implicitly[Column[Int]].map(JobcandidateId.apply)
  implicit lazy val ordering: Ordering[JobcandidateId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[JobcandidateId] = new ParameterMetaData[JobcandidateId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[JobcandidateId] = Reads.IntReads.map(JobcandidateId.apply)
  implicit lazy val toStatement: ToStatement[JobcandidateId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[JobcandidateId] = Writes.IntWrites.contramap(_.value)
}
