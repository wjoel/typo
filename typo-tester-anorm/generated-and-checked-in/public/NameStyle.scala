/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `public.NameStyle`
  * No constraint
  */
case class NameStyle(value: Boolean) extends AnyVal
object NameStyle {
  implicit lazy val arrayColumn: Column[Array[NameStyle]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[NameStyle]] = implicitly[ToStatement[Array[Boolean]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[NameStyle, Boolean] = Bijection[NameStyle, Boolean](_.value)(NameStyle.apply)
  implicit lazy val column: Column[NameStyle] = implicitly[Column[Boolean]].map(NameStyle.apply)
  implicit lazy val ordering: Ordering[NameStyle] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[NameStyle] = new ParameterMetaData[NameStyle] {
    override def sqlType: String = implicitly[ParameterMetaData[Boolean]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Boolean]].jdbcType
  }
  implicit lazy val reads: Reads[NameStyle] = Reads.BooleanReads.map(NameStyle.apply)
  implicit lazy val toStatement: ToStatement[NameStyle] = implicitly[ToStatement[Boolean]].contramap(_.value)
  implicit lazy val writes: Writes[NameStyle] = Writes.BooleanWrites.contramap(_.value)
}
