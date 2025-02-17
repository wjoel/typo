/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `sales.salesreason` */
case class SalesreasonId(value: Int) extends AnyVal
object SalesreasonId {
  implicit lazy val arrayColumn: Column[Array[SalesreasonId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[SalesreasonId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalesreasonId, Int] = Bijection[SalesreasonId, Int](_.value)(SalesreasonId.apply)
  implicit lazy val column: Column[SalesreasonId] = implicitly[Column[Int]].map(SalesreasonId.apply)
  implicit lazy val ordering: Ordering[SalesreasonId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[SalesreasonId] = new ParameterMetaData[SalesreasonId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[SalesreasonId] = Reads.IntReads.map(SalesreasonId.apply)
  implicit lazy val toStatement: ToStatement[SalesreasonId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[SalesreasonId] = Writes.IntWrites.contramap(_.value)
}
