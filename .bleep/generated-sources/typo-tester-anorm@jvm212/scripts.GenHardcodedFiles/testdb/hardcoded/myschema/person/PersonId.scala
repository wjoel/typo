/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `myschema.person` */
case class PersonId(value: Long) extends AnyVal
object PersonId {
  implicit lazy val arrayToStatement: ToStatement[Array[PersonId]] = implicitly[ToStatement[Array[Long]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PersonId, Long] = Bijection[PersonId, Long](_.value)(PersonId.apply)
  implicit lazy val column: Column[PersonId] = implicitly[Column[Long]].map(PersonId.apply)
  implicit lazy val ordering: Ordering[PersonId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PersonId] = new ParameterMetaData[PersonId] {
    override def sqlType: String = implicitly[ParameterMetaData[Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Long]].jdbcType
  }
  implicit lazy val reads: Reads[PersonId] = Reads.LongReads.map(PersonId.apply)
  implicit lazy val toStatement: ToStatement[PersonId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit lazy val writes: Writes[PersonId] = Writes.LongWrites.contramap(_.value)
}
