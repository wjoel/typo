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

/** Domain `public.Phone`
  * No constraint
  */
case class Phone(value: String) extends AnyVal
object Phone {
  implicit lazy val arrayColumn: Column[Array[Phone]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[Phone]] = implicitly[ToStatement[Array[String]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Phone, String] = Bijection[Phone, String](_.value)(Phone.apply)
  implicit lazy val column: Column[Phone] = implicitly[Column[String]].map(Phone.apply)
  implicit lazy val ordering: Ordering[Phone] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[Phone] = new ParameterMetaData[Phone] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }
  implicit lazy val reads: Reads[Phone] = Reads.StringReads.map(Phone.apply)
  implicit lazy val toStatement: ToStatement[Phone] = implicitly[ToStatement[String]].contramap(_.value)
  implicit lazy val writes: Writes[Phone] = Writes.StringWrites.contramap(_.value)
}
