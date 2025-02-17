/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import adventureworks.TypoOffsetDateTime
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `information_schema.time_stamp`
  * No constraint
  */
case class TimeStamp(value: TypoOffsetDateTime) extends AnyVal
object TimeStamp {
  implicit lazy val arrayColumn: Column[Array[TimeStamp]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[TimeStamp]] = implicitly[ToStatement[Array[TypoOffsetDateTime]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[TimeStamp, TypoOffsetDateTime] = Bijection[TimeStamp, TypoOffsetDateTime](_.value)(TimeStamp.apply)
  implicit lazy val column: Column[TimeStamp] = implicitly[Column[TypoOffsetDateTime]].map(TimeStamp.apply)
  implicit def ordering(implicit O0: Ordering[TypoOffsetDateTime]): Ordering[TimeStamp] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TimeStamp] = new ParameterMetaData[TimeStamp] {
    override def sqlType: String = implicitly[ParameterMetaData[TypoOffsetDateTime]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[TypoOffsetDateTime]].jdbcType
  }
  implicit lazy val reads: Reads[TimeStamp] = TypoOffsetDateTime.reads.map(TimeStamp.apply)
  implicit lazy val toStatement: ToStatement[TimeStamp] = implicitly[ToStatement[TypoOffsetDateTime]].contramap(_.value)
  implicit lazy val writes: Writes[TimeStamp] = TypoOffsetDateTime.writes.contramap(_.value)
}
