/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `sales.currencyrate` */
case class CurrencyrateId(value: Int) extends AnyVal
object CurrencyrateId {
  implicit lazy val arrayToStatement: ToStatement[Array[CurrencyrateId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CurrencyrateId, Int] = Bijection[CurrencyrateId, Int](_.value)(CurrencyrateId.apply)
  implicit lazy val column: Column[CurrencyrateId] = implicitly[Column[Int]].map(CurrencyrateId.apply)
  implicit lazy val ordering: Ordering[CurrencyrateId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[CurrencyrateId] = new ParameterMetaData[CurrencyrateId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[CurrencyrateId] = Reads.IntReads.map(CurrencyrateId.apply)
  implicit lazy val toStatement: ToStatement[CurrencyrateId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[CurrencyrateId] = Writes.IntWrites.contramap(_.value)
}
